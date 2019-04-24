package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.jk"})
@EnableEurekaClient
public class SpringcloudProviderCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderCommentApplication.class, args);
    }

}
