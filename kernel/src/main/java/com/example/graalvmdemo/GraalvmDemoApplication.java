package com.example.graalvmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.graalvmdemo.config.OpenApiProperties;

//@SpringBootApplication(scanBasePackages = "com.example.graalvmdemo")
//@EnableConfigurationProperties(OpenApiProperties.class)
public class GraalvmDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraalvmDemoApplication.class, args);
    }
}
