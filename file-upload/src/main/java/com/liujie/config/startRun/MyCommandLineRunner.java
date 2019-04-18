package com.liujie.config.startRun;

import org.springframework.boot.CommandLineRunner;

/**
 * Springboot给我们提供了两种“开机启动”某些方法的方式：ApplicationRunner和CommandLineRunner。

 这两种方法提供的目的是为了满足，在项目启动的时候立刻执行某些方法。我们可以通过实现ApplicationRunner和CommandLineRunner，来实现，他们都是在SpringApplication 执行之后开始执行的。

 CommandLineRunner接口可以用来接收字符串数组的命令行参数，ApplicationRunner 是使用ApplicationArguments 用来接收参数的，貌似后者更牛逼一些。
 */
//@Component
//@Order(value = 1)
public class MyCommandLineRunner implements CommandLineRunner{

    @Override
    public void run(String... var1) throws Exception{
        System.out.println("This will be execute when the project was started!");
    }
}
