package com.xr.bos.controller;

import com.xr.bos.service.BasBasicarchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BasBasicarchivesController {
    @Autowired
    private BasBasicarchivesService basicarchivesService;

    @RequestMapping(value = "/basicData/basicArchives")
    public ModelAndView  findasDeliverystandarAll(){
        System.out.println("进入findasDeliverystandarAll方法。。。。。。");
        List<Map<String, Object>> list = basicarchivesService.findBasBasicarchivesAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("basicarchives",list);
        mv.setViewName("/basicData/basicArchives");
        return mv;
    }
}
