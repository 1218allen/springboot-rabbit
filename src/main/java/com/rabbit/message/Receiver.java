package com.rabbit.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Component
@RabbitListener(queues = "fanout.messages")
public class Receiver {
    @Autowired
    HttpClient httpClient;
    @RabbitHandler
    public void process(Map<String, Object> msg) {
        String uid = msg.get("uid").toString();
        String msgId = msg.get("msgid").toString();
        int type = Integer.parseInt(msg.get("type").toString());
        int env = Integer.parseInt(msg.get("env").toString());
        int msgType = Integer.parseInt(msg.get("msgtype").toString());

        System.out.println("fanoutMessageReceiver  : " + uid + ", msgid:" + msgId + ", type:" + type + ", env:" + env + ", msgtype:" + msgType);

        //
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

        String result = httpClient.client("", HttpMethod.POST, params);

        System.out.println(result);
    }
}
