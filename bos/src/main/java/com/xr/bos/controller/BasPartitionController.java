package com.xr.bos.controller;

import com.xr.bos.service.BasPartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BasPartitionController {

    @Autowired
    private BasPartitionService basPartitionService;

    @RequestMapping(value = "/basicData/partition")
    public ModelAndView findpartitionAll(){
        System.out.println("进入findpartitionAll方法。。。。。");
        List<Map<String, Object>> list = basPartitionService.findpartitionAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("partition",list);
        mv.setViewName("/basicData/partition");
        return mv;
    }
}
