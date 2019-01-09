package com.itcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author hftang
 * @date 2019-01-09 9:51
 * @desc
 */

@RestController
@RequestMapping
public class HelloController {


    //注入datasource
    @Autowired
    private DataSource dataSource;


    @GetMapping("hello")
    public String helloSpring() {

        return "hello springboot 汤化峰来了 dataSource:"+dataSource;
    }
}
