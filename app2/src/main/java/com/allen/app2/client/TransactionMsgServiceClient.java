package com.allen.app2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "transaction-message-service")
public interface TransactionMsgServiceClient {

    @RequestMapping(value = "/api/deleteMsg", method = RequestMethod.POST)
    void deleteMsg(@RequestParam(name = "id") Long id);
}
