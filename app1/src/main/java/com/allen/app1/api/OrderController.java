package com.allen.app1.api;

import com.allen.app1.domain.Orders;
import com.allen.app1.mapper.OrdersDao;
import com.allen.app1.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrdersDao ordersDao;

    @RequestMapping("/payment")
    public Boolean payment(@PathVariable Long id){

        orderService.payment(id);

        return true;
    }

    @RequestMapping("/queryOrderState/{id}")
    public Boolean queryOrderState(@PathVariable(name = "id") String orderNo){

        Boolean result = new Boolean(false);

        Orders param = new Orders();
        param.setOrderNo(orderNo);

        List<Orders> queryList = ordersDao.query(param);

        if(queryList.isEmpty()){
            return false;
        }else{
            Orders orders = queryList.get(0);

            if(orders.getOrderState().equals(0)){
                result = false;
            }else if(orders.getOrderState().equals(1)){
                result = true;
            }
        }

        return result;
    }
}