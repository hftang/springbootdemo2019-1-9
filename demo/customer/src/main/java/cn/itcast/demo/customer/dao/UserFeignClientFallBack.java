package cn.itcast.demo.customer.dao;

import cn.itcast.demo.customer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author hftang
 * @date 2019-01-12 14:02
 * @desc
 */
@Component
public class UserFeignClientFallBack implements UserClient {
    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setNamee("数据查询有误，哈哈");


        return user;
    }
}
