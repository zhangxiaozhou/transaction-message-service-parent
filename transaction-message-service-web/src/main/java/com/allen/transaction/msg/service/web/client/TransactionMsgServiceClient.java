package com.allen.transaction.msg.service.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@FeignClient(value = "transaction-message-service")
public interface TransactionMsgServiceClient {

    @RequestMapping("/api/getMsgByStateAndIsDeadAndIsTimeout")
    Map<String, Object> getMsgByStateAndIsDeadAndIsTimeout(Map<String,Object> param);

}
