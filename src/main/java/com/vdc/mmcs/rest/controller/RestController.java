package com.vdc.mmcs.rest.controller;

import com.google.gson.Gson;
import com.vdc.mmcs.common.resolver.CommandMap;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class RestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${task.freeswitch_request_url}")
    private String freeswitch_request_url;

    @Value("${task.conference_person_cmd}")
    private String conference_person_cmd;

    // 수동 참석자 호출
    @RequestMapping(value="/attendant/call")
    @ResponseBody
    public Map<String, Object> attendant_call(CommandMap commandMap)  {

        Gson gson = new Gson();
        Map<String,Object> response_map = new HashMap<>();
        List<NameValuePair> nameValuePairs = new ArrayList<>(1);


        String SendCmd = conference_person_cmd + " "+ commandMap.getMap().get("cfrm_tel_no") +" "+ commandMap.getMap().get("atdt_tel_no");
        nameValuePairs.add(new BasicNameValuePair("cmd", SendCmd));
//        nameValuePairs.add(new BasicNameValuePair("seq", commandMap.getMap().get("seq").toString()));

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
            logger.info("----- [ERROR] Attendant Call FreeSwitch Send -----");
            logger.info("----- "+ e.getMessage() +" -----");
            logger.info("----- [ERROR] Attendant Call FreeSwitch Send -----");

            response_map.put("success", "false");
            response_map.put("msg", e.getMessage());
        }

        return response_map;

    }

}
