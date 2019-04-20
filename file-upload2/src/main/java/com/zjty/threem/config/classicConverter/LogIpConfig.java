package com.zjty.threem.config.classicConverter;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Data
@Component
public class LogIpConfig extends ClassicConverter {
    private static final Logger logger = LoggerFactory.getLogger(LogIpConfig .class);

    private String host = null;

    @Override
    public String convert(ILoggingEvent event) {
        try {
            host = InetAddress.getLocalHost().getHostAddress();
            return host;
        } catch (Exception e) {
            logger.error("获取服务器Ip异常", e);
        }
        return host;
    }
}
