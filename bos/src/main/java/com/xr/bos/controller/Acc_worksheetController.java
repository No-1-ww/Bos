package com.xr.bos.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.Acc_worksheet;
import com.xr.bos.service.Acc_worksheetService;
import com.xr.bos.util.DateFormat;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 工作单查询
 */
@Controller
public class Acc_worksheetController {

    @Autowired
    private Acc_worksheetService acc_worksheetService;

    //查询
   /* @RequestMapping(value = "/acceptance/worksheetQueryaAjax",method = RequestMethod.POST,produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String queryWor(){
        System.out.println("进入查询方法....");
        List<Map<String, Object>> worlist = acc_worksheetService.queryAcc_worksheetMapper();
        String s = JSONArray.toJSONString(worlist);
        return s;
    }

    @GetMapping("/acceptance/worksheetQuery")
    public String work(){return "/acceptance/worksheetQuery";}*/

    /**
     *
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping("/query_work")
    public void select(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入方法.....");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> queryall1 = acc_worksheetService.queryall();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(queryall1);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : queryall1) {
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            sb.append("{");
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object o = map.get(key);
                sb.append("\"" + key + "\":\"" + o + "\",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("},");

        }
        sb.append("]}");
        sb.deleteCharAt(sb.lastIndexOf(","));
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=utf-8");
        System.out.println(sb);
        try {
            System.out.println(sb);
            PrintWriter out = responses.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (Exception e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



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
