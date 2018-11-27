package com.allen.app1.service.impl;

import com.allen.app1.client.TransactionMsgServiceClient;
import com.allen.app1.domain.Orders;
import com.allen.app1.dto.Msg;
import com.allen.app1.mapper.OrdersDao;
import com.allen.app1.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private TransactionMsgServiceClient transactionMsgServiceClient;

    @Resource
    private OrdersDao ordersDao;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void payment(Long id) {

        Orders orders = ordersDao.selectByPrimaryKey(id);
        orders.setOrderState(1);//设置订单状态为2，完成支付

        Msg msg = new Msg();
        msg.setSourceService("app1");
        msg.setSourceStatesUri("/api/order/queryOrderState");
        msg.setMsgKey(orders.getOrderNo());
        msg.setQueueName("order_credit_queue");
        msg.setMaxRetryCount(30);
        msg.setTimeoutDelay(120);
        msg.setIsDead(false);

        String orderJson = null;
        try {
            orderJson = objectMapper.writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        msg.setMsgBody(orderJson);

        //预发送消息
        Long returnId = transactionMsgServiceClient.saveWaitingSendMsg(msg);

        if(returnId!=null){

            //执行业务逻辑
            ordersDao.updateByPrimaryKey(orders);

            //可靠消息服务发送消息
            transactionMsgServiceClient.sendMsg(returnId);
        }
    }
}
