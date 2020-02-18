package com.xr.bos.controller;

import com.xr.bos.service.SyUnitsService;
import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class SyUnitsController {

    @Autowired
    private SyUnitsService syUnitsService;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @RequestMapping(value = "/systemManagement/sysUnit")
    public ModelAndView findUnitsAll(){
        System.out.println("进入findUntisAll22222.....");

        //String key="com.xr.bos.controller.SyUnitsController.findUnitsAll";
        //Object list = redisTemplateUtil.getSet(key);
        ModelAndView mv=new ModelAndView();
        List<Map<String,Object>> findUntisAll=null;

       // if(list==null||list.equals("")){
            //System.out.println("从数据库获取untis。。。。");
           findUntisAll= syUnitsService.findUntisAll();
          // redisTemplateUtil.setList(key,findUntisAll);
       // }else {
           // System.out.println("从缓存中获取utis。。。。");
           // findUntisAll=(List<Map<String,Object>>) list;
        //}
        mv.addObject("syunits",findUntisAll);
        mv.setViewName("/systemManagement/sysUnit");
        return mv;
    }

    @RequestMapping(value = "/findsysUnitwhereAsname")
    public void findsysUnitwhereAsname(){

    }

}
