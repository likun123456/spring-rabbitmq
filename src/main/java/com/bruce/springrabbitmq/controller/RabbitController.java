package com.bruce.springrabbitmq.controller;

import com.bruce.springrabbitmq.simple.mq.SimpleSender;
import com.bruce.springrabbitmq.work.mq.WorkSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 13:54
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Resource
    private SimpleSender simpleSender;

    @Resource
    private WorkSender workSender;

    @GetMapping("/simple")
    public String simpleTest() {
        simpleSender.send();
        return null;
    }

    @GetMapping("/work")
    public String workTest() throws InterruptedException {
        for(int i=0;i<10;i++){
            workSender.send(i);
            Thread.sleep(1000);
        }
        return null;
    }


}
