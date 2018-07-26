package com.rabbit.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MQController {
    @Autowired
    private Sender sender;

    @RequestMapping(value = "/send/{id}", method = RequestMethod.GET)
    public String sendMQ(@PathVariable String id){
        System.out.println("准备发送消息。。。" + id);
        sender.send(id);
        return "success";
    }
}
