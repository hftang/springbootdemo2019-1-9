package com.itcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

/**
 * @author hftang
 * @date 2019-01-09 9:44
 * @desc
 */

@SpringBootApplication
public class Application {



    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
