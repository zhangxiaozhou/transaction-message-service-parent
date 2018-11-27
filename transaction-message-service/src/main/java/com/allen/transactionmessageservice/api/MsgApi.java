package com.allen.transactionmessageservice.api;

import com.allen.transactionmessageservice.domain.Msg;
import com.allen.transactionmessageservice.mapper.MsgDao;
import com.allen.transactionmessageservice.service.MsgService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/api")
public class MsgApi {

    @Resource
    private MsgService msgService;

    @Resource
    private MsgDao msgDao;

    @RequestMapping("/saveWaitingSendMsg")
    public Long saveWaitingSendMsg(@RequestBody Msg msg){

        Long aLong = msgService.saveWaitingSendMsg(msg);

        return aLong;
    }

    @RequestMapping("/sendMsg")
    public void completeMsgBySysAndKey(Long id){

        msgService.sendMsg(id);
    }

    @RequestMapping("/deleteMsg")
    public void deleteMsg(Long id){

        msgDao.deleteByPrimaryKey(id);
    }

    @RequestMapping("/getMsgByStateAndIsDeadAndIsTimeout")
    public Map<String,Object> getMsgByStateAndIsDeadAndIsTimeout(@RequestBody Map<String,Object> paramMap){

        int page = (int) paramMap.get("page");
        int size = (int) paramMap.get("size");

        Boolean isTimeOut = null;
        if(paramMap.get("isTimeOut")!=null && !"null".equals(paramMap.get("isTimeOut"))){
            isTimeOut = Boolean.valueOf(paramMap.get("isTimeOut").toString());
        }

        Integer msgState=null;
        if( !"null".equals(paramMap.get("msgState")) && paramMap.get("msgState")!=null){
            msgState = Integer.valueOf((String) paramMap.get("msgState"));
        }

        Boolean isDead = null;
        if(!"null".equals(paramMap.get("isDead")) && paramMap.get("isDead")!=null){
            isDead = Boolean.valueOf(paramMap.get("isDead").toString());
        }

        Map<String, Object> msgByStateAndIsDeadAndIsTimeout = msgService.getMsgByStateAndIsDeadAndIsTimeout(page, size, isTimeOut, msgState, isDead);

        return msgByStateAndIsDeadAndIsTimeout;
    }

    @RequestMapping("/confirmMsgsState")
    public void confirmMsgsState(@RequestBody Long[] ids){

        msgService.confirmMsgsState(Arrays.asList(ids));
    }

    @RequestMapping("/sendMsgs")
    public void sendMsgs(@RequestBody Long[] ids){

        msgService.sendMsgs(Arrays.asList(ids));
    }
}
