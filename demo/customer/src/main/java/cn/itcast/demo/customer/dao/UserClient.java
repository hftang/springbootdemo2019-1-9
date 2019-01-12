package cn.itcast.demo.customer.dao;

import cn.itcast.demo.customer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hftang
 * @date 2019-01-11 17:17
 * @desc 使用接口的方式  底层是动态代理 feign已帮完成
 */

@FeignClient(value = "user-service", path = "user", fallback = UserFeignClientFallBack.class) //主机名
//@RequestMapping("user")     //请求路径
public interface UserClient {

    @GetMapping("/{id}")
        //请求参数
    User queryById(@PathVariable("id") Integer id);
}
