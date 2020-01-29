package com.xr.bos.controller;

import com.xr.bos.model.Acc_businessadmissibility;
import com.xr.bos.service.Acc_businessadmissibilityService;

import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 业务处理
 */
@Controller
public class Acc_businessadmissibilityController {

    @Autowired
    private Acc_businessadmissibilityService acc_businessadmissibilityService;

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    /*
        业务受理的查询
     */
    @RequestMapping(value = "/acceptance/businessAcceptance",method = RequestMethod.GET)
    public ModelAndView queryBus(){
        System.out.println("234567");
        List<Map<String,Object>> list=null;
        //String key="com.xr.bos.controller.Acc_businessadmissibilityController.queryBus";
        //Object value = redisTemplateUtil.getList(key);
        ModelAndView mv=new ModelAndView();
       // if(value==null||value.equals("")){
            //System.out.println("从数据库中读取");
            list = acc_businessadmissibilityService.queryAcc_businessadmissibility();
            //redisTemplateUtil.setList(key,list);
        //}else{
            //System.out.println("从缓存中读取");
            //list = (List<Map<String, Object>>) value;
        //}
        mv.addObject("busList",list);
        mv.setViewName("/acceptance/businessAcceptance");
        return mv;
    }

    /*
        两个字段的前端显示查询
     */
    @RequestMapping(value = "/businessAcceptance_add")
    public ModelAndView queryAccBusin_ID(){
        System.out.println("147852369");
        ModelAndView mv=new ModelAndView();
        String s = acc_businessadmissibilityService.querybusinNo_ID();
        String yuanlai = s.substring(0, 3);
        //后面数字
        String nowv = s.substring(3);
        //+1
        int i = Integer.parseInt(nowv) + 1;
        System.out.println(yuanlai+i);
        mv.addObject("businessNoticeNo",yuanlai+i);

        List<Acc_businessadmissibility> importantList = acc_businessadmissibilityService.query_importantHints();
        mv.addObject("importantList",importantList);
        mv.setViewName("/acceptance/businessAcceptance_add");
        return mv;
    }

    /*
        业务受理的新增
     */
   @RequestMapping(value = "/busin_add",method = RequestMethod.POST)
    public ModelAndView inseeretbus(String businessNoticeNo,Acc_businessadmissibility acc_businessadmissibility){
       System.out.println("新增的businessNoticeNo为"+businessNoticeNo);
       System.out.println("进入！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
       System.out.println("对象"+acc_businessadmissibility);
       ModelAndView mv=new ModelAndView();
       int i = acc_businessadmissibilityService.addBusin(acc_businessadmissibility);
       if(i>0){
           mv.setViewName("/acceptance/businessAcceptance");
           return mv;
       }else{
           mv.setViewName("/acceptance/businessAcceptance_add");
           return mv;
       }
    }

    /*
        根据id查询
     */
    @RequestMapping("/businessAcceptance_update")
    public ModelAndView selectqueryByID(String businessNoticeNo){
        System.out.println("根据id查询为"+businessNoticeNo);
       ModelAndView mv=new ModelAndView();
       Acc_businessadmissibility acc = acc_businessadmissibilityService.queryByIDbusinessNoticeNo(businessNoticeNo);
       System.out.println(acc+"aaaaaaaaaaaaaaa");
       mv.addObject("acc",acc.getBusinessNoticeNo());
       mv.setViewName("/acceptance/businessAcceptance_update");
       return  mv;
    }

    /*
        条件查询
     */
    @RequestMapping("/busin_querywhere")
    public ModelAndView selectWhere(String businessNoticeNo,String customCode){
        List<Acc_businessadmissibility> acc = acc_businessadmissibilityService.query_whereAcc(businessNoticeNo, customCode);
        for (Acc_businessadmissibility accb : acc) {
            System.out.println(accb+",");
        }
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/acceptance/businessAcceptance");
        return mv;
    }
}
