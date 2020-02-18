package com.xr.bos.controller;

import com.xr.bos.service.BasAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BasAreaController {

    @Autowired
    private BasAreaService basAreaService;

    @RequestMapping(value = "/basicData/areaSet")
    public ModelAndView findbasareaAll(){
        System.out.println("进入findbasareaAll方法。。。。");
        List<Map<String, Object>> list =basAreaService.findBasAreaAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("basArea",list);
        mv.setViewName("basicData/areaSet");
        return mv;
    }


}
