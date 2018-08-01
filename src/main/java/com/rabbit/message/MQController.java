package com.rabbit.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MQController {
    @Autowired
    private Sender sender;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendMQ(@RequestParam("uid") String uid, @RequestParam("msgid") String msgId, @RequestParam("os") String os, @RequestParam("env") String env, @RequestParam("msgtype") String msgType){
        System.out.println("准备发送消息。。。uid:" + uid + ", msgid:" + msgId + ", type:" + os + ", env:" + env + ", msgtype:" + msgType);
        Map<String, Object> params = new HashMap();
        params.put("uid", uid);
        params.put("msgid", msgId);
        params.put("type", os);
        params.put("env", env);
        params.put("msgtype", msgType);

        //sender.send(params);

        return "success";
    }
}
