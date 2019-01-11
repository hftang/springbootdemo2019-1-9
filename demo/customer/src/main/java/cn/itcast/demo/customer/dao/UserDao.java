package cn.itcast.demo.customer.dao;

import cn.itcast.demo.customer.pojo.User;
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

    public User queryUserById(Integer id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance instance = instances.get(0);
        //这个地方可以负载均衡 轮序算法


        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
        return this.restTemplate.getForObject(url, User.class);
    }


}
