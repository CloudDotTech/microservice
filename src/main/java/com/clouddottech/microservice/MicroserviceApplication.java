package com.clouddottech.microservice;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MicroserviceApplication   {
    @Autowired
    private MicroserviceApplicationService service;

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(Application.class).bannerMode(Banner.Mode.OFF);
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "Hello Microservice Spring boot with gradle!";
    }

    @RequestMapping("/greeting")
    public @ResponseBody
    String greeting() {
        return service.greet();
    }

    @Service
    public class MicroserviceApplicationService {
        public String greet() {
            return null;
        }
    }
}
