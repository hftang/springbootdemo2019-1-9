package com.itcast.service;

import com.itcast.mapper.UserMapper;
import com.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hftang
 * @date 2019-01-09 15:06
 * @desc
 */

//设置事物
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Integer id) {

        return this.userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void deleteById(Long id) {
        this.userMapper.deleteByPrimaryKey(id);
    }


    public List<User> queryAll() {
        return this.userMapper.selectAll();
    }
}
