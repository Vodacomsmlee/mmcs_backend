package com.vdc.mmcs.task;

import com.vdc.mmcs.rest.dao.TaskDao;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

@Component
public class Schedule {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${task.channel_url}")
    private String channel_url;


    @Resource(name="taskDao")
    private TaskDao taskDao;

    @Scheduled(cron = "0 0/5 * * * *", zone = "Asia/Seoul") // fixedDelay = 1000 * 60 * 5
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
}
