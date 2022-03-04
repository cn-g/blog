package com.example.blog.configure;

import com.example.blog.util.QCloudCosUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QCloudCosUtilsConfig {

    @ConfigurationProperties(prefix = "spring.qcloud")
    @Bean
    public QCloudCosUtils qcloudCosUtils() {
        return new QCloudCosUtils();
    }

}
