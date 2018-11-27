package com.allen.transactionmessageservice.service;

import com.allen.transactionmessageservice.domain.Msg;

import java.util.List;
import java.util.Map;

public interface MsgService {

    /**
     * 根据服务名和消息key发送消息
     */
    void sendMsg(Long id);

    Long saveWaitingSendMsg(Msg msg);

    void confirmMsgsState(List<Long> msgIds);

    void sendMsgs(List<Long> msgIds);

    Map<String,Object> getMsgByStateAndIsDeadAndIsTimeout(int page, int size, Boolean isTimeOut, Integer msgState, Boolean isDead);

}
