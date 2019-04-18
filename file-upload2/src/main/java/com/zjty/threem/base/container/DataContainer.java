package com.zjty.threem.base.container;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Data//自动生成get  set  toString方法
public class DataContainer {
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(DataContainer.class);

}