package com.allen.transactionmessageservice.service.impl;

import com.allen.transactionmessageservice.domain.Msg;
import com.allen.transactionmessageservice.mapper.MsgDao;
import com.allen.transactionmessageservice.mapper.MsgExample;
import com.allen.transactionmessageservice.service.MsgService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Queue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class MsgServiceImpl implements MsgService {

    @Resource
    private MsgDao msgDao;

    @Resource
    private AmqpTemplate amqpTemplate;

    @Resource
    private AmqpAdmin amqpAdmin;

    @Resource
    private RestTemplate restTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 发送单个消息
     *
     * @param id
     */
    @Override
    public void sendMsg(Long id) {

        Msg msg = msgDao.selectByPrimaryKey(id);

        msg.setMsgState(1);

        if (msg.getRetryCount() == null) {
            msg.setRetryCount(1);
        } else {
            msg.setRetryCount(msg.getRetryCount() + 1);
        }

        if (msg.getRetryCount() >= msg.getMaxRetryCount()) {
            msg.setIsDead(true);
        }

        Date now = new Date();

        msg.setSendTime(now);

        Instant instant = now.toInstant();
        instant.plusSeconds(msg.getTimeoutDelay());

        msg.setTimeoutTime(Date.from(instant));

        //更新消息状态为已发送
        msgDao.updateByPrimaryKeySelective(msg);

        //发送消息到队列中
        Queue queue = new Queue(msg.getQueueName());
        amqpAdmin.declareQueue(queue);

        String msgJson = "";

        try {
            msgJson = objectMapper.writeValueAsString(msg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        MessageProperties messageProperties = MessagePropertiesBuilder.newInstance().setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setExpiration("3000")//设置消息存活时间，防止消费方down掉时间太久后消息在队列积压
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).build();

        Message message = new Message(msgJson.getBytes(), messageProperties);


        amqpTemplate.send("", msg.getQueueName(), message);
    }

    /**
     * 保存待发送消息
     *
     * @param msg
     * @return
     */
    @Override
    public Long saveWaitingSendMsg(@RequestBody Msg msg) {

        msg.setMsgState(0);

        Instant now = Instant.now();
        now.atZone(ZoneOffset.systemDefault());

        msg.setCreateTime(Date.from(now));

        now.plusSeconds(msg.getTimeoutDelay());

        msg.setTimeoutTime(Date.from(now));

        int insert = msgDao.insert(msg);

        return msg.getId();
    }

    /**
     * 确认消息状态并重新投递或者删除
     *
     * @param msgIds
     */
    @Override
    public void confirmMsgsState(List<Long> msgIds) {

        for (Long id : msgIds) {

            Msg msg = msgDao.selectByPrimaryKey(id);

            String uri = "http://" + msg.getSourceService() + msg.getSourceStatesUri() + "/" + msg.getMsgKey();

            ResponseEntity<Boolean> forEntity = restTemplate.getForEntity(uri, Boolean.class);
            if (forEntity.getBody()) {
                sendMsg(id);
            } else {
                msgDao.deleteByPrimaryKey(msg.getId());
            }
        }
    }

    /**
     * 重新投递消息给消费方
     *
     * @param msgIds
     */
    @Override
    public void sendMsgs(List<Long> msgIds) {

        Date date = new Date();

        for (Long id : msgIds) {

            Msg msg = msgDao.selectByPrimaryKey(id);

            int retryCount = msg.getRetryCount();

            msg.setRetryCount(retryCount);

            Instant instant = date.toInstant();

            instant.plusSeconds(retryCount * msg.getTimeoutDelay());

            msg.setTimeoutTime(Date.from(instant));

            msgDao.updateByPrimaryKeySelective(msg);

            sendMsg(id);
        }

    }

    /**
     * 根据消息状态和是否超时获取未死亡的消息
     *
     * @param size
     * @param isTimeOut
     * @param msgState
     * @return
     */
    @Override
    public Map<String,Object> getMsgByStateAndIsDeadAndIsTimeout(int page, int size, Boolean isTimeOut, Integer msgState, Boolean isDead) {

        Date now = new Date();

        MsgExample msgExample = new MsgExample();
        MsgExample.Criteria criteria = msgExample.createCriteria();

        if (isTimeOut != null) {
            if (isTimeOut) {
                criteria.andTimeoutTimeLessThan(now);
            } else {
                criteria.andTimeoutTimeGreaterThan(now);
            }
        }

        if (msgState != null) {
            criteria.andMsgStateEqualTo(msgState);
        }

        if (isDead != null) {
            criteria.andIsDeadEqualTo(isDead);
        }

        long total = msgDao.countByExample(msgExample);

        msgExample.setOffset(Long.valueOf((page-1) * size));
        msgExample.setLimit(size);
        msgExample.setOrderByClause(" id asc");

        List<Msg> msgs = msgDao.selectByExample(msgExample);

        Map<String,Object> result = new HashMap<>();
        result.put("total", total);
        result.put("page", page);
        result.put("size", size);
        result.put("body", msgs);

        return result;
    }

}
































