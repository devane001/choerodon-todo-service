package io.choerodon.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;

@SpringBootApplication
// 是否允许注册到注册中心
@EnableEurekaClient
@RestController
@EnableChoerodonResourceServer
public class TodoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoServiceApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}