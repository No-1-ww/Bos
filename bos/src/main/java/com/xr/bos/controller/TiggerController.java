package com.xr.bos.controller;

import com.xr.bos.service.TiggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TiggerController {

    @Autowired
    private TiggerService tiggerService;

    @RequestMapping("/ss")
    public String testQuartz(){
        tiggerService.refreshTrigger();
        return "a";
    }

}
