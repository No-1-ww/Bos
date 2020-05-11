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
import java.util.*;

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
     * 工作单查询
     *
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping("/query_work")
    public void select(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
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


    //新增——工作单快速录入
    @RequestMapping(value = "/sheet/add", method = RequestMethod.POST, produces = "text/String;charset=UTF-8")
    @ResponseBody
    public ModelAndView insert(Acc_worksheet acc_worksheet) {
        System.out.println("进入了");
        System.out.println("***************" + acc_worksheet);
        ModelAndView mv = new ModelAndView();
        acc_worksheetService.add_worksheet(acc_worksheet);
        //原理：先新增如果新增后的单号和oudID(第一次进入该页面绑定的ID不相等，那么证明新增失败，告诉他系统异常！)
        String s = acc_worksheetService.querywork_ID();
        String yuanlai = s.substring(0, 3);//截取后面的数字
        String now = s.substring(3);
        int i = Integer.parseInt(now) + 1;
        System.out.println(yuanlai + i);
        String newID = yuanlai + i;
        if (newID.equals(oudID)) {
            mv.addObject("workSheetNo", newID);
            mv.addObject("error", "error");
            mv.setViewName("/acceptance/worksheetQuickInput");
        } else {

            mv.addObject("workSheetNo", newID);
            //通过该方法进入worksheetQuickinput页面
            mv.setViewName("/acceptance/worksheetQuickInput");
        }
        return mv;

    }

    String oudID;

    //显示出最大的工作单号----这是快速录入页面的
    @RequestMapping(value = "/acceptance/worksheetQuickInput")
    public ModelAndView query_ID() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ModelAndView mv = new ModelAndView();
        String s = acc_worksheetService.querywork_ID();
        String yuanlai = s.substring(0, 3);//截取后面的数字
        String now = s.substring(3);
        int i = Integer.parseInt(now) + 1;
        oudID = yuanlai + i;
        System.out.println(oudID);
        mv.addObject("workSheetNo", oudID);
        //通过该方法进入worksheetQuickinput页面
        mv.setViewName("/acceptance/worksheetQuickInput");
        return mv;
    }

    /**
     * 条件查询
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/work_querywhere", produces = "text/String;charset=UTF-8")
    public void select_wehere(String workSheetNo,String workGenerationTime, HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入方法.....");
        System.out.println(workSheetNo);
        System.out.println("page的值为" + page + ",limit的值为" + limit);
        //传入参数
        Map<String,Object> map = new HashMap<>();
        map.put("workSheetNo",workSheetNo);
        map.put("workGenerationTime",workGenerationTime);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> mapList = acc_worksheetService.querywhere_work(map);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(mapList);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map2 : mapList) {
            Set<String> set = map2.keySet();
            Iterator<String> iterator = set.iterator();
            sb.append("{");
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object o = map2.get(key);
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

    /**
     * 根据id查询
     * @param workSheetNo
     * @return
     */
    @RequestMapping(value = "/queryById_Work")
    public ModelAndView select_ByID(String workSheetNo) {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> p = acc_worksheetService.queryByid_work(workSheetNo);
        /*for (Map<String, Object> map : mapList) {
            for (String k:map.keySet()){
                System.out.println(k+":"+map.get(k));
            }
        }*/
        /* Map<String, Object> p = DateFormat.format(map, "pickupTime");*/
        mv.addObject("workSheetNo", p.get("workSheetNo"));
        mv.addObject("customCode", p.get("customCode"));
        mv.addObject("importantHints", p.get("importantHints"));
        mv.addObject("destination", p.get("destination"));
        mv.addObject("businessNoticeNo", p.get("businessNoticeNo"));
        mv.addObject("empNo", p.get("empNo"));
        mv.addObject("empName", p.get("empName"));
        mv.addObject("pickupTime", p.get("pickupTime"));
        mv.addObject("customName", p.get("customName"));
        mv.addObject("linKman", p.get("linKman"));

        mv.setViewName("/acceptance/dispatchingPersonnelSet_update");
        return mv;
    }


    /**
     * 修改
     *
     * @param workSheetNo
     * @param businessNoticeNo
     * @param destination
     * @param importantHints
     * @return
     */
    @RequestMapping(value = "/disPerson_update")
    @ResponseBody
    public ModelAndView updateAccworksheet(String workSheetNo, String businessNoticeNo, String destination, String importantHints) {
        //写三个修改每一张表的字段都又ID,三张不同表的ID作为条件修改
        //就可以了
        System.out.println("根据" + workSheetNo + "传值第一个" + destination);
        System.out.println("根据" + businessNoticeNo + "传值第二个" + importantHints);
        ModelAndView mv = new ModelAndView();
        Map<String, Object> map = new HashMap<>();
        map.put("workSheetNo", workSheetNo);
        map.put("destination", destination);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("businessNoticeNo", businessNoticeNo);
        map2.put("importantHints", importantHints);
        int i = acc_worksheetService.updateDestination(map);
        int n = acc_worksheetService.updateimportantHints(map2);
        mv.setViewName("/acceptance/worksheetQuery");
        return mv;
    }
}

