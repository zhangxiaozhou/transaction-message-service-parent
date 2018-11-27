package com.allen.app1.service.impl;

import com.allen.app1.domain.Orders;
import com.allen.app1.mapper.OrdersDao;
import com.allen.app1.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceImplTest {

    @Resource
    private OrderService orderService;

    @Resource
    private OrdersDao ordersDao;

    @Test
    public void payment() {

        for(int i=1; i<=500; i++){
            try{
                orderService.payment(new Long(i));

                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Test
    public void createOrder(){

        Random random = new Random();

        for(int i=0; i<500; i++){
            Orders orders = new Orders();
            orders.setOrderNo(UUID.randomUUID().toString());
            orders.setAmount(new BigDecimal(random.nextInt(1000)));
            orders.setOrderState(0);

            ordersDao.insert(orders);
        }
    }
}