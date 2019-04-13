package com.liujie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 http://localhost:8881/test可以访问到配置中心config-server，
 通过配置中心访问到远程git地址下的"config-client-dev.properties"（详见bootstrap.properties配置）
 再config-server的Application类注释里,说到，若有"a-b.properties",访问起来是localhost:8888/a/b
 而"localhost:8888/a/b"的 a 值对应bootstrap.properties里的spring.application.name（即"config-client"）
 所以bootstrap.properties文件指定读取的文件为：
 “【spring.application.name】- 【spring.cloud.config.profile】.properties”
 即config-client-dev.properties
 */

@RestController
public class TestController {
    @Value("${name}")
    String name;
    @Value("${age}")
    String age;

    @RequestMapping(value = "/test")
    public String test(){
        return "我的名字是："+name+",年龄是"+age;
    }
}
