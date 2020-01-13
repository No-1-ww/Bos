package com.xr.bos.controller;

import com.xr.bos.service.Acc_businessadmissibilityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class Acc_businessadmissibilityController {
    //sssssssssssssssssss
    //bbbbbbbbbbbbbbbbbbbbb
    //会不会被顶替

    @Autowired
    private Acc_businessadmissibilityService acc_businessadmissibilityService;


    @RequestMapping(value = "/aabbcc",method = RequestMethod.GET)
    public ModelAndView queryBus(){
        System.out.println("234567");
        List<Map<String,Object>> list = acc_businessadmissibilityService.queryAcc_businessadmissibility();
        for (Map<String, Object> map : list) {
            for (String s : map.keySet()) {
                System.out.println(map.get(s));
            }
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("busList",list);
        mv.setViewName("index");
        return mv;
    }
}
