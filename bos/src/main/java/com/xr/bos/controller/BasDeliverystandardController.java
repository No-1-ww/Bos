package com.xr.bos.controller;

import com.xr.bos.dao.BasDeliverystandardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BasDeliverystandardController {
    @Autowired
    private BasDeliverystandardMapper deliverystandardMapper;

    @RequestMapping(value = "/basicData/deliveryStandard")
    public ModelAndView findDeliverystandardAll(){
        System.out.println("进入findDeliverystandardAll方法。。。。");
        List<Map<String, Object>> list =deliverystandardMapper.findBasDeliverystandardAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("deliverystandard",list);
        mv.setViewName("/basicData/deliveryStandard");
        return mv;
    }
}
