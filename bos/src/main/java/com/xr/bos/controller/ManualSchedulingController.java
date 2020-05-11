package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.service.ManualSchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class ManualSchedulingController {

    @Autowired
    private ManualSchedulingService manualSchedulingService;


    @RequestMapping(value = "/query_Man")
    public void select(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
        System.out.println("进入方法.....");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> queryall = manualSchedulingService.queryall();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(queryall);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : queryall) {
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

    /**
     * 条件查询
     * @param jobNo
     * @param sendAddress
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/manu_querywhere", produces = "text/String;charset=UTF-8")
    public void select_wehere(String jobNo,String sendAddress, HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入方法.....");
        System.out.println(jobNo);
        System.out.println("page的值为" + page + ",limit的值为" + limit);
        //传入参数
        Map<String,Object> map = new HashMap<>();
        map.put("jobNo",jobNo);
        map.put("sendAddress",sendAddress);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> mapList = manualSchedulingService.querywhere_manua(map);
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

    @RequestMapping(value = "/find_ByManid")
    public ModelAndView selectid(String jObNo){
        System.out.println("有了&&"+jObNo);
        List<Map<String, Object>> mapList = manualSchedulingService.query_ById(jObNo);

        ModelAndView mv=new ModelAndView();
        mv.setViewName("/dispatch/distribution");
        return mv;
    }

    @RequestMapping(value = "/delet_manu")
    public ModelAndView del(String jObNo){
        System.out.println("进入方法值为"+"\n"+jObNo);
        ModelAndView mv=new ModelAndView();
        int i = manualSchedulingService.del_manu(jObNo);
        mv.setViewName("/dispatch/manualScheduling");
        return mv;
    }
}
