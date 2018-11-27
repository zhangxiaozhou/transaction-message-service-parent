package com.allen.transactionmessageservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/msg")
public class MsgController {

    @GetMapping("/manage")
    public String manager(){

        return "msg_manage";
    }
}
