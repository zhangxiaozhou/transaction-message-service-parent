package com.allen.transaction.msg.service.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/msg")
public class MsgMannger {

    @RequestMapping("/manage")
    public String manage(){

        return "manage";
    }
}
