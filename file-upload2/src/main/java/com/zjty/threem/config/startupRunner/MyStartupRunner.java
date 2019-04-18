package com.zjty.threem.config.startupRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 *   项目启动的时候将会执行该类
 */
//@Configuration
@Component
public class MyStartupRunner implements CommandLineRunner {
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);
    @Value("${upload.location}")
    private String uploadPath;
    @Override
    public void run(String... strings) throws Exception {
        logger.info("项目启动后执行该方法");
        logger.info("检查文件上传路径是否存在");
        File file1 =new File(uploadPath);
        if  (!file1 .exists()) {
            logger.info("系统检查到文件上传路径不存在，系统自动创建");
            file1 .mkdirs();
        } else {
            logger.info("系统检查到文件上传路径已经存在:"+uploadPath.toString());
        }
    }
}