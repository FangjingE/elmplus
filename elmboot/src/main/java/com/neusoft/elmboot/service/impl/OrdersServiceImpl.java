package com.neusoft.elmboot.service.impl;

import com.neusoft.elmboot.mapper.CartMapper;
import com.neusoft.elmboot.mapper.OrderDetailetMapper;
import com.neusoft.elmboot.mapper.OrdersMapper;
import com.neusoft.elmboot.po.Cart;
import com.neusoft.elmboot.po.OrderDetailet;
import com.neusoft.elmboot.po.Orders;

import com.neusoft.elmboot.service.OrdersService;

import com.neusoft.elmboot.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrdersMapper orderMapper;
    @Autowired
    private OrderDetailetMapper orderDetailMapper;
    @Override
    public int createOrders(Orders orders) {
        //查询购物车信息
        Cart cart = new Cart();
        cart.setUserId(orders.getUserId());
        cart.setBusinessId(orders.getBusinessId());
        List<Cart> listCart = cartMapper.listCart(cart);

        //创建订单
        orders.setOrderDate(CommonUtil.getCurrentDate());
        System.out.println("这是创建的日期-----"+orders.getOrderDate());
        orderMapper.createOrders(orders);
        int orderId = orders.getOrderId();

        //批量添加订单明细
        List<OrderDetailet> orderDetailetList = new ArrayList<>();

        for (Cart c:listCart) {
            OrderDetailet od = new OrderDetailet();
            od.setOrderId(orderId);
            od.setFoodId(c.getFoodId());
            od.setQuantity(c.getQuantity());
            orderDetailetList.add(od);
        }
        orderDetailMapper.saveOrderDetailetBatch(orderDetailetList);
        //移除购物车
        cartMapper.removeCart(cart);
        return orderId;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return orderMapper.getOrdersById(orderId);
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return orderMapper.listOrdersByUserId(userId);
    }
}
