package com.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author hftang
 * @date 2019-01-09 10:32
 * @desc java             配置的第二种方式：springboot的注入方式
 * @configuration 配置文件
 */
@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig2 {

    @Bean
    public DataSource dataSource(JdbcProperties props) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(props.getDriverClassName());
        dataSource.setUrl(props.getUrl());
        dataSource.setUsername(props.getUsername());
        dataSource.setPassword(props.getPassword());
        return dataSource;
    }


}
