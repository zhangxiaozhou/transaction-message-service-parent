package com.allen.app1.client;

import com.allen.app1.dto.Msg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "transaction-message-service")
public interface TransactionMsgServiceClient {

    @RequestMapping(value = "/api/saveWaitingSendMsg", method = RequestMethod.POST)
    Long saveWaitingSendMsg(Msg msg);

    @RequestMapping(value = "/api/sendMsg", method = RequestMethod.POST)
    void sendMsg(@RequestParam("id") Long id);
}
