package com.itcast.controller;

import com.itcast.pojo.User;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hftang
 * @date 2019-01-09 13:01
 * @desc
 */

@Controller
@RequestMapping
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hello(Model model) {
        User user = this.userService.queryById(1);
        List<User> users=new ArrayList<>();
        users.add(user);
        model.addAttribute("users",users);
        return "users";
    }


    @RequestMapping("/all")
    public String all(Model model) {

        List<User> users = this.userService.queryAll();
        model.addAttribute("users", users);
        return "users";
    }
}
