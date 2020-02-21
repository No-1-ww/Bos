package com.xr.bos.controller;

import com.alibaba.fastjson.JSONArray;
import com.xr.bos.model.Acc_worksheet;
import com.xr.bos.service.Acc_worksheetService;
import com.xr.bos.util.DateFormat;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 工作单查询
 */
@Controller
public class acc_worksheetController {

    @Autowired
    private Acc_worksheetService acc_worksheetService;

    //查询
    @RequestMapping(value = "/acceptance/worksheetQueryaAjax",method = RequestMethod.POST,produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String queryWor(){
        System.out.println("进入查询方法....");
        List<Map<String, Object>> worlist = acc_worksheetService.queryAcc_worksheetMapper();
        String s = JSONArray.toJSONString(worlist);
        return s;
    }

    @GetMapping("/acceptance/worksheetQuery")
    public String work(){return "/acceptance/worksheetQuery";}


    //新增
    @RequestMapping("/worksheetAdd")
    @ResponseBody
    public ModelAndView insert(Acc_worksheet acc_worksheet){
        System.out.println("进入了");
        System.out.println("***************"+acc_worksheet);
        ModelAndView mv=new ModelAndView();
        int i = acc_worksheetService.add_worksheet(acc_worksheet);
        if(i>0){
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }
        return mv;
    }

    //显示出最大的工作单号----这是快速录入页面的
    @RequestMapping(value = "/acceptance/worksheetQuickInput")
    public ModelAndView query_ID(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ModelAndView mv=new ModelAndView();
        String s = acc_worksheetService.querywork_ID();
        String yuanlai = s.substring(0, 3);//截取后面的数字
        String now = s.substring(3);
        int i = Integer.parseInt(now) + 1;
        System.out.println(yuanlai+i);
        mv.addObject("workSheetNo",yuanlai+i);
        return mv;
    }

    //条件查询
    @RequestMapping(value = "/work_querywhere",produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String select_wehere(Acc_worksheet acc_worksheet){
        System.out.println("进去。。。。。");
        List<Acc_worksheet> lists = acc_worksheetService.querywhere_work(acc_worksheet);
        for (Acc_worksheet list : lists) {

            System.out.println(list);
        }
        String s = JSONArray.toJSONString(lists);
        return s;
    }

    //根据id查询
    @RequestMapping("/dispatchingPersonnelSet_update")
    public ModelAndView select_ByID(String busID){
        System.out.println("根据"+busID+"查询........");
        ModelAndView mv=new ModelAndView();
        Map<String, Object> p = acc_worksheetService.queryByid_work(busID);
        /*for (Map<String, Object> map : mapList) {
            for (String k:map.keySet()){
                System.out.println(k+":"+map.get(k));
            }
        }*/
       /* Map<String, Object> p = DateFormat.format(map, "pickupTime");*/


        mv.addObject("workSheetNo",p.get("workSheetNo"));
        mv.addObject("customCode",p.get("customCode"));
        mv.addObject("importantHints",p.get("importantHints"));
        mv.addObject("destination",p.get("destination"));
        mv.addObject("businessNoticeNo",p.get("businessNoticeNo"));
        mv.addObject("empNo",p.get("empNo"));
        mv.addObject("empName",p.get("empName"));
        mv.addObject("pickupTime",p.get("pickupTime"));
        mv.addObject("customName",p.get("customName"));
        mv.addObject("linKman",p.get("linKman"));

        mv.setViewName("/acceptance/dispatchingPersonnelSet_update");
        return mv;
    }
}
