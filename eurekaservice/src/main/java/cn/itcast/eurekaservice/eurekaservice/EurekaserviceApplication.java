package cn.itcast.eurekaservice.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //开启eureka的服务
public class EurekaserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaserviceApplication.class, args);
    }

}

