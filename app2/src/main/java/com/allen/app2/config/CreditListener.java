package com.allen.app2.config;

import com.allen.app2.client.TransactionMsgServiceClient;
import com.allen.app2.domain.Credit;
import com.allen.app2.dto.Msg;
import com.allen.app2.dto.Orders;
import com.allen.app2.mapper.CreditDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Component
public class CreditListener {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Resource
    private CreditDao creditDao;

    @Resource
    private TransactionMsgServiceClient transactionMsgServiceClient;

    @RabbitListener(queuesToDeclare = @Queue(name = "order_credit_queue", durable = "true"))
    public void processMessage(byte[] msgBody) {

        try{
            String msgJson = new String(msgBody);
            Msg msg = objectMapper.readValue(msgJson, Msg.class);

            Orders orders = objectMapper.readValue(msg.getMsgBody(), Orders.class);

            Credit credit = new Credit();
            credit.setOrderNo(orders.getOrderNo());

            List<Credit> query = creditDao.query(credit);
            if(query.isEmpty()){

                credit.setScore(orders.getAmount().multiply(new BigDecimal("10")));
                creditDao.insert(credit);
            }

            transactionMsgServiceClient.deleteMsg(msg.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
