package com.xr.bos.controller;

import com.alibaba.fastjson.JSONArray;
import com.xr.bos.model.Acc_businessadmissibility;
import com.xr.bos.service.Acc_businessadmissibilityService;

import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @RequestMapping(value = "/acceptance/businessAcceptanceAjax",method = RequestMethod.POST,produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String queryBus(){
        System.out.println("进入查询后台。。。");
        List<Map<String,Object>> list = acc_businessadmissibilityService.queryAcc_businessadmissibility();
        String s = JSONArray.toJSONString(list);
        return s;
    }
    @GetMapping("/acceptance/businessAcceptance")
    public String businessAcceptance(){
        return "/acceptance/businessAcceptance";
    }

    /*
        条件查询
     */
    @RequestMapping(value = "/busin_querywhere",produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String selectWhere(Acc_businessadmissibility acc_businessadmissibility){
        List<Acc_businessadmissibility> acc = acc_businessadmissibilityService.query_whereAcc(acc_businessadmissibility);
        for (Acc_businessadmissibility accb : acc) {
            System.out.println(accb+",");
        }
        String s = JSONArray.toJSONString(acc);

        return s;
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

        String s1 = acc_businessadmissibilityService.query_customCode();
        String yuanlai1 = s1.substring(0, 3);
        String now2 = s1.substring(3);
        int i1 = Integer.parseInt(now2) + 1;
        System.out.println(yuanlai1+i1);
        mv.addObject("customCode",yuanlai1+i1);

        List<Acc_businessadmissibility> importantList = acc_businessadmissibilityService.query_importantHints();
        mv.addObject("importantList",importantList);
        mv.setViewName("/acceptance/businessAcceptance_add");
        return mv;
    }

    /*
        业务受理的新增
     */
   @RequestMapping(value = "/busin_add",method = RequestMethod.POST)
   @ResponseBody
    public String inseeretbus(String businessNoticeNo,Acc_businessadmissibility acc_businessadmissibility){
       System.out.println("新增的businessNoticeNo为"+businessNoticeNo);
       System.out.println("进入！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
       System.out.println("对象"+acc_businessadmissibility);
       ModelAndView mv=new ModelAndView();
       int i = acc_businessadmissibilityService.addBusin(acc_businessadmissibility);
        if(i!=0){
            return "ok";
        }else{
            return "no";
        }

    }

    /*
        根据id查询
     */
    @RequestMapping("/businessAcceptance_update")
    public ModelAndView selectqueryByID(String busID){
        System.out.println("根据id查询为"+busID);
       ModelAndView mv=new ModelAndView();
       Acc_businessadmissibility acc = acc_businessadmissibilityService.queryByIDbusinessNoticeNo(busID);
       System.out.println("值在这里有"+acc);
       mv.addObject("businessNoticeNo",acc.getBusinessNoticeNo());
       mv.addObject("customCode",acc.getCustomCode());
       mv.addObject("customName",acc.getCustomName());
       mv.addObject("linkman",acc.getLinkman());
        mv.addObject("linkman",acc.getLinkman());
       mv.addObject("telPhone",acc.getTelPhone());
       mv.addObject("pickupAddress",acc.getPickupAddress());
        mv.addObject("sendAddress",acc.getSendAddress());
        mv.addObject("arriveCity",acc.getArriveCity());
        mv.addObject("importantHints",acc.getImportantHints());
        mv.addObject("reservationTime",acc.getReservationTime());
        mv.setViewName("/acceptance/businessAcceptance_update");
       return  mv;
    }



    /*
        修改
     */
    @RequestMapping(value = "/busin_update", method = RequestMethod.POST)
    public ModelAndView update(Acc_businessadmissibility acc_businessadmissibility){
        System.out.println("************************"+acc_businessadmissibility);
        ModelAndView mv=new ModelAndView();
        int i = acc_businessadmissibilityService.updateAcc(acc_businessadmissibility);
        System.out.println("看一下修改后的值"+i);
        if(i>0){
            mv.setViewName("/acceptance/businessAcceptance");
            return mv;
        }else{
            mv.setViewName("/acceptance/businessAcceptance_update");
            return mv;
        }
    }

    /*
        追单
     */
    @RequestMapping(value = "/zhuidan",method = RequestMethod.POST)
    public ModelAndView ZD(String busID){
        System.out.println("~~~~~~~~~~~~"+busID);
        int i = acc_businessadmissibilityService.update_afterSingleNum(busID);
        if(i>0){
            System.out.println("追单成功");
        }else{
            System.out.println("追单失败");
        }
        return null;
    }
}
