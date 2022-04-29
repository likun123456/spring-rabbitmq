package com.bruce.springrabbitmq.work.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 14:53
 */
@RabbitListener(queues = "work.hello")
@Slf4j
public class WorkReceiver {

    private final int instance;

    public WorkReceiver(int i) {
        this.instance = i;
    }

    @RabbitHandler
    public void receive(String in) {
        log.info("received:{}", in);
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance {} [x] Received '{}'", this.instance, in);
        doWork(in);
        watch.stop();
        log.info("instance {} [x] Done in {}s", this.instance, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
