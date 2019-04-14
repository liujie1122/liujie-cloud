package com.liujie.thread;

import com.liujie.rabbit.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *   生产者线程，每隔10秒钟产生一条消息
 */

@Component
public class ProducerThread implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(ProducerThread.class);
    @Autowired
    private Producer producer;
    @Override
    public void run() {
        while (true){
            try {
                producer.production();
                logger.info("生产线生产了一条消息");
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
