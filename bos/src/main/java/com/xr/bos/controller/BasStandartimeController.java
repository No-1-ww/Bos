package com.xr.bos.controller;

import com.xr.bos.service.BasStandartimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BasStandartimeController {
    @Autowired
    private BasStandartimeService basStandartimeService;

    @RequestMapping(value = "/basicData/deliveryTime")
    public ModelAndView finddeliveryTimeAll(){
        System.out.println("进入finddeliveryTimeAll方法。。。");
        List<Map<String, Object>> list = basStandartimeService.findstandartimeAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("Standartime",list);
        mv.setViewName("/basicData/deliveryTime");
        return mv;
    }
}
