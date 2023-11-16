package com.vdc.mmcs.task;

import com.vdc.mmcs.rest.dao.TaskDao;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

import static com.vdc.mmcs.common.util.DateUtil.getNow;

@Component
public class Schedule {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${task.channel_url}")
    private String channel_url;

    @Value("${task.freeswitch_request_url}")
    private String freeswitch_request_url;

    @Value("${task.conference_cmd}")
    private String conference_cmd;

    @Value("${task.record_file_delete}")
    private boolean record_file_delete;


    @Resource(name="taskDao")
    private TaskDao taskDao;

    // 채널 모니터링
    @Scheduled(cron = "0 0/5 * * * *", zone = "Asia/Seoul") // 매 5분마다 // fixedDelay = 1000 * 60 * 5
    public void Channel() {

        Gson gson = new Gson();

        try {

            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(
                    SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build(),
                    NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(scsf).build();

            URIBuilder builder = new URIBuilder(channel_url);
            HttpPost method = new HttpPost(builder.build());

            CloseableHttpResponse httpResponse = client.execute(method);
            String response = EntityUtils.toString(httpResponse.getEntity());

            Map<String,Object> response_map = new HashMap<>();
            response_map = (Map<String,Object>) gson.fromJson(response, response_map.getClass());

            taskDao.channel(response_map);

        } catch (Exception e) {
            logger.info("----- [ERROR] Channel Monitoring Schedule -----");
            logger.info("----- "+ e.getMessage() +" -----");
            logger.info("----- [ERROR] Channel Monitoring Schedule -----");
        }

    }

    //예약건에 대해 참석자 호출
    @Scheduled(cron = "0 0/10 * * * *", zone = "Asia/Seoul") // 매 10분마다
    public void ConferenceReserve() {

        try {

            //1. 예약대상 조회
            Map<String,Object> map = new HashMap<>();
            String TodayNow = getNow("yyyyMMddHHmm");
            map.put("now", TodayNow);
            List<Map<String, Object>> reserveMap = taskDao.conference(map);

            for (Map<String, Object> ObjectMap : reserveMap) {

                //2. 정기회의 호출
                List<NameValuePair> nameValuePairs = new ArrayList<>(1);
                String SendCmd = conference_cmd + " "+ ObjectMap.get("cfrm_tel_no") +" "+ ObjectMap.get("ownr_user_id");

                logger.info("SEND CMD : "+SendCmd);

                nameValuePairs.add(new BasicNameValuePair("cmd", SendCmd));
                nameValuePairs.add(new BasicNameValuePair("seq", ObjectMap.get("seq").toString()));

                Map<String,Object> SendRstMap = FreeSwitchSend(nameValuePairs);

                if ("false".equals(SendRstMap.get("success").toString())) {
                    logger.info("----- [ERROR] Freeswitch Send ERROR -----");
                    logger.info("----- CMD : "+ SendCmd +" -----");
                    logger.info("----- ERROR MSG : "+ SendRstMap.get("msg").toString() +" -----");
                }

                Map<String,Object> updateParmMap = new HashMap<>();
                updateParmMap.put("seq", ObjectMap.get("seq"));

                //3. 호출 성공시 다음 예약일자 업데이트
                taskDao.conference_reserve_next_dt(updateParmMap);
            }


        } catch (Exception e) {
            logger.info("----- [ERROR] ConferenceReserve Task -----");
            logger.info("----- "+ e.getMessage() +" -----");
            logger.info("----- [ERROR] ConferenceReserve Task -----");
        }
    }

    public Map<String,Object> FreeSwitchSend(List<NameValuePair> nameValuePairs) {
        Gson gson = new Gson();
        Map<String,Object> response_map = new HashMap<>();

        try {

            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(
                    SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build(),
                    NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(scsf).build();

            URIBuilder builder = new URIBuilder(freeswitch_request_url);
            HttpPost method = new HttpPost(builder.build());
            method.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

            CloseableHttpResponse httpResponse = client.execute(method);
            String response = EntityUtils.toString(httpResponse.getEntity());

            response_map = (Map<String,Object>) gson.fromJson(response, response_map.getClass());
            response_map.put("success", "true");

        } catch (Exception e) {
            logger.info("----- [ERROR] Conference Reserve FreeSwitch Send -----");
            logger.info("----- "+ e.getMessage() +" -----");
            logger.info("----- [ERROR] Conference Reserve FreeSwitch Send -----");

            response_map.put("success", "false");
            response_map.put("msg", e.getMessage());
        }

        return response_map;
    }

    // 녹취파일 삭제
    @Scheduled(cron = "0 0 1 * * *", zone = "Asia/Seoul") // 매일 01시
    public void RecFileDelete() {

        if(record_file_delete) {
            logger.info("----- Record File Delete Task START -----");
            // 1. 삭제 조건으로 삭제 대상 조회
            List<Map<String, Object>> pathsMap = taskDao.getdeletefilepath();

            try {
                int index = 1;
                long file_cnt;

                // 2. 파일 삭제 처리
                for (Map<String, Object> ObjectMap : pathsMap) {
                    Path filePath = Paths.get(ObjectMap.get("conference_record_path").toString());
                    Files.deleteIfExists(filePath);

                    // 3. DB 이력삭제

                    // 4. 삭제 대상 폴더에 파일 없으면 해당 폴더 제거, 파일 없는지 체크로직 부하가 있음...
                    if (index == pathsMap.size()) {
                        file_cnt = folderFileCount(String.valueOf(filePath.getParent()));
                        if (file_cnt == 0) Files.deleteIfExists(filePath.getParent());
                    }
                    index++;
                }
            } catch (Exception e) {
                logger.info("----- [ERROR] Record File Delete Task -----");
                logger.info("----- "+ e.getMessage() +" -----");
                logger.info("----- [ERROR] Record File Delete Task -----");
            }

            logger.info("----- Record File Delete Task END -----");
        }

    }

    // 폴더내 파일 갯수
    public static long folderFileCount(String directory) {
        long length = 0;
        Path folder = Paths.get(directory);
        try {
            length = Files.walk(folder).filter(p -> p.toFile().isFile())
                    .mapToLong(p -> 1).sum();
        } catch (IOException ignored) {  }
        return length;
    }

}
