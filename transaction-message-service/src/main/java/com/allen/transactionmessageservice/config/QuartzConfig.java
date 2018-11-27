package com.allen.transactionmessageservice.config;

import com.allen.transactionmessageservice.domain.Msg;
import com.allen.transactionmessageservice.service.MsgService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@EnableScheduling
@Configuration
public class QuartzConfig {

    @Resource
    private MsgService msgService;

    /**
     * 对于预发送但是超时未进行发送的消息，调用接口进行状态确认
     */
    @Scheduled(cron = "0/30 * * * * ? ")
    public void confirmMsgState(){

        int confirmSize = 20;

        //获取待发送但已超时的消息
        Map<String, Object> msgByStateAndIsDeadAndIsTimeout  = msgService.getMsgByStateAndIsDeadAndIsTimeout(1, confirmSize, true, 0, false);
        List<Msg> msgs = (List<Msg>) msgByStateAndIsDeadAndIsTimeout.get("body");

        List<Long> collect = msgs.stream().map(msg -> msg.getId()).collect(Collectors.toList());

        msgService.confirmMsgsState(collect);
    }


    @Scheduled(cron = "0/30 * * * * ? ")
    public void sendTimeOutMsg(){

        int confirmSize = 20;

        //获取已发送但超时未被删除的消息
        Map<String, Object> msgByStateAndIsDeadAndIsTimeout = msgService.getMsgByStateAndIsDeadAndIsTimeout(1, confirmSize, true, 1, false);
        List<Msg> msgs = (List<Msg>) msgByStateAndIsDeadAndIsTimeout.get("body");

        List<Long> collect = msgs.stream().map(msg -> msg.getId()).collect(Collectors.toList());

        msgService.sendMsgs(collect);

    }
}
