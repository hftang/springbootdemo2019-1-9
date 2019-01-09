package com.itcast.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hftang
 * @date 2019-01-09 10:32
 * @desc prefix 前缀
 * propertySource 引用外面的配置文件
 *
 * @PropertySource("classpath:jdbc.properties") 这个注解也可以不要 但是在resources 下 必须定义为 application.properties
 * 这样就可以默认去加载
 *
 * springboot的注入方式
 */
@ConfigurationProperties(prefix = "jdbc")
@PropertySource("classpath:jdbc.properties")
public class JdbcProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    //生成这些属性的getter setter


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
