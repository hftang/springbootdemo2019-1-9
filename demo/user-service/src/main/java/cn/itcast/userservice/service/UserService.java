package cn.itcast.userservice.service;

import cn.itcast.userservice.mapper.UserMapper;

import cn.itcast.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hftang
 * @date 2019-01-10 10:05
 * @desc
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Integer id) {

        return this.userMapper.selectByPrimaryKey(id);
    }


}
