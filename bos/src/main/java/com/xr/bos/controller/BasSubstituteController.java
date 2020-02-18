package com.xr.bos.controller;

import com.xr.bos.service.BasSubstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BasSubstituteController {
    @Autowired
    private BasSubstituteService substituteService;

    //查询所有的取派设置数据
    @RequestMapping(value = "/basicData/dispatchingPersonnelSet")
    public ModelAndView findBasSubstituteAll(){
        System.out.println("进入findBasSubstituteAll。。。方法");
        List<Map<String, Object>> list = substituteService.findBasSubstituteAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("substitute",list);
        mv.setViewName("/basicData/dispatchingPersonnelSet");
        return mv;
    }
}
