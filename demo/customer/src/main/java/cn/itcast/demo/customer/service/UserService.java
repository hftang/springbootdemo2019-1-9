package cn.itcast.demo.customer.service;

import cn.itcast.demo.customer.dao.UserDao;
import cn.itcast.demo.customer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hftang
 * @date 2019-01-10 11:29
 * @desc
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryUsersByIds(List<Integer> ids) {
        List<User> users = new ArrayList<>();
        for (Integer id : ids) {
            User user = this.userDao.queryUserById(id);
            users.add(user);
        }
        return users;
    }

}
