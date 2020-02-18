package com.xr.bos.controller;

import com.xr.bos.model.SyRoles;
import com.xr.bos.service.SyRolesService;
import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SyRolesController {
    @Autowired
    private SyRolesService syRolesService;

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @RequestMapping(value = "/systemManagement/sysRole")
    public ModelAndView findRolesAll(){
        System.out.println("进入findRolesAll.....");
        //String key = "com.xr.bos.controller.SyRolesController.findRolesAll";
        //1.先从缓存中获取
       // Object list = redisTemplateUtil.getList(key);
        ModelAndView mv = new ModelAndView();
        List<SyRoles> rolesList=null;
     // null;
        //if (list==null||list.equals("")){
           // System.out.println("从数据库获取。。。");
            //从数据库获取
        rolesList=syRolesService.findRolesAll();
            //redisTemplateUtil.setList(key,rolesList);
       // }else{
            //从缓存中获取
            System.out.println("从缓存中获取。。。1111");
            //rolesList = (List)list;
      //  }
        mv.addObject("roles",rolesList);
        mv.setViewName("/systemManagement/sysRole");
              return mv;
    }



}
