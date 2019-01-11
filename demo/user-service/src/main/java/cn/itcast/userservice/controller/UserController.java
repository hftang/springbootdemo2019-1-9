package cn.itcast.userservice.controller;

import cn.itcast.userservice.pojo.User;
import cn.itcast.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

/**
 * @author hftang
 * @date 2019-01-10 10:08
 * @desc
 */

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Integer id) {
        System.out.println("id:"+id);
        return this.userService.queryById(id);
    }
}
