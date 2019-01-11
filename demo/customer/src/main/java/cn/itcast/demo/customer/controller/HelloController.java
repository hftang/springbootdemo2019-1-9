package cn.itcast.demo.customer.controller;

import cn.itcast.demo.customer.pojo.User;
import cn.itcast.demo.customer.service.UserService;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hftang
 * @date 2019-01-10 11:33
 * @desc
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private UserService userService;


    @GetMapping("list")
    public List<User> queryUserByIds(@RequestParam("ids") List<Integer> ids) {
        System.out.println("请求来了------》");
        return this.userService.queryUsersByIds(ids);

    }
}
