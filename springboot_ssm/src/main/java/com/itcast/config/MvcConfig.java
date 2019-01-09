package com.itcast.config;

import com.itcast.intercepter.MyIntercepter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hftang
 * @date 2019-01-09 14:05
 * @desc 配置一些 自定义的拦截器 intercepter
 * <p>
 * 高级配置都可以在 webmvcConfigurer中配置
 * 一般配置在配置文件中配置就可以了
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public MyIntercepter getIntercepter() {
        MyIntercepter myIntercepter = new MyIntercepter();
        return myIntercepter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        Logger logger = LoggerFactory.getLogger(this.getClass().toString());

        /*new HandlerInterceptor() {


            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

                logger.info("preHandle");
                return true;//返回true 是放行
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                logger.info("postHandle");
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                logger.info("afterCompletion");
            }
            //添加上要拦截的路径 是一个链式操作
        }*/


        //注册拦截器
        registry.addInterceptor(this.getIntercepter()).addPathPatterns("/**");
    }
}
