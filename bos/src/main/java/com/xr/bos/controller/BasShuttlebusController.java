package com.xr.bos.controller;

import com.xr.bos.service.BasShuttlebusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BasShuttlebusController {
    @Autowired
    private BasShuttlebusService shuttlebusService;

    @RequestMapping(value = "/basicData/shuttleBusSet")
    public ModelAndView findShuttlebusAll(){
        System.out.println("进入findShuttlebusAll方法。。。。。。");
        List<Map<String, Object>> list = shuttlebusService.findBasShuttlebusAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("shuttlebus",list);
        mv.setViewName("/basicData/shuttleBusSet");
        return mv;

    }


}
