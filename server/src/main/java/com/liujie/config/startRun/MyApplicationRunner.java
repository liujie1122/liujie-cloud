package com.liujie.config.startRun;


import com.liujie.thread.ProducerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Springboot给我们提供了两种“开机启动”某些方法的方式：ApplicationRunner和CommandLineRunner。

 这两种方法提供的目的是为了满足，在项目启动的时候立刻执行某些方法。
 我们可以通过实现ApplicationRunner和CommandLineRunner，来实现，
 他们都是在SpringApplication 执行之后开始执行的。
 CommandLineRunner接口可以用来接收字符串数组的命令行参数，
 ApplicationRunner 是使用ApplicationArguments 用来接收参数的，貌似后者更牛逼一些。
 */

@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {
    private final Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);
    @Autowired
    private ProducerThread producerThread;
    @Override
    public void run(ApplicationArguments var1) throws Exception{
        logger.info("项目启动后执行该方法。。。。");
        new Thread(producerThread).start();
    }

}