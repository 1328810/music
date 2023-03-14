package com.javaclimb.music.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

public class FileUploadConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个数据大小 KB，MB 大写
        factory.setMaxFileSize(DataSize.parse("20MB"));
        //总上传数据大小
        factory.setMaxFileSize(DataSize.parse("50MB"));
        return factory.createMultipartConfig();
    }
}
