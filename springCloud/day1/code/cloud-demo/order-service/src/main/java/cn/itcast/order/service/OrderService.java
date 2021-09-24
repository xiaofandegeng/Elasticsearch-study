package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import ct.itcast.feign.client.UserClient;
import ct.itcast.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

    private final String url = "http://userservice/user/";

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.远程查询user
        User user = userClient.findById(order.getUserId());
        // 3.存入order中
        order.setUser(user);
        // 4.返回
        return order;
    }
}
