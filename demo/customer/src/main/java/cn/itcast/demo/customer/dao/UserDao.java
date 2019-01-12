package cn.itcast.demo.customer.dao;

import cn.itcast.demo.customer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author hftang
 * @date 2019-01-10 11:20
 * @desc
 */

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

//    添加熔断注解 hystrixCommand 和 失败时 返回的方案  默认超时时1s

    @HystrixCommand(fallbackMethod = "queryUserByIdFallBack")
    public User queryUserById(Integer id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = instances.get(0);
//        //这个地方可以负载均衡 轮序算法
//
//
//        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;

        String url = "http://user-service/user/" + id;
        Long starttime = System.currentTimeMillis();
        User user = this.restTemplate.getForObject(url, User.class);
        Long endtime = System.currentTimeMillis();
        Long total = endtime - starttime;
        System.out.println("用了多少时间：total：" + total);

        return user;
    }

    public User queryUserByIdFallBack(Integer id) {
        User user = new User();
        user.setId(id);
        user.setNamee("用户查询出现了异常！");

        System.out.println("熔断被调用了");

        return user;
    }


}
