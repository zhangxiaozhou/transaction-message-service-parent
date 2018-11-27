package com.allen.app1.service;

public interface OrderService {

    /**
     * 模拟订单支付的场景，订单状态支付完成后，调用积分服务，完成积分增加
     */
    void payment(Long id);
}
