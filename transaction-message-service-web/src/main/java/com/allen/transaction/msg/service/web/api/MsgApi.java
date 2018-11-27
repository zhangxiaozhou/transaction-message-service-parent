package com.allen.transaction.msg.service.web.api;

import com.allen.transaction.msg.service.web.client.TransactionMsgServiceClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class MsgApi {

    @Resource
    private TransactionMsgServiceClient transactionMsgServiceClient;

    @RequestMapping("/getMsgByStateAndIsDeadAndIsTimeout")
    public Map<String,Object> getMsgByStateAndIsDeadAndIsTimeout(@RequestBody Map<String,Object> param){

        return transactionMsgServiceClient.getMsgByStateAndIsDeadAndIsTimeout(param);
    }
}
