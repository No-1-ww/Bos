package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.Acc_businessadmissibility;
import com.xr.bos.model.Acc_workorder;
import com.xr.bos.model.CheckTable;
import com.xr.bos.service.CheckTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class CheckTableController {

    @Autowired
    private CheckTableService checkTableService;

    /**
     * 调度，查台转单
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/queryCheckTable")
    public void select(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
        System.out.println("进入方法.....");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> queryall = checkTableService.queryall();
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
     * @param businessNoticeNo
     * @param telPhone
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/check_querywhere", produces = "text/String;charset=UTF-8")
    public void select_wehere(String businessNoticeNo,String telPhone, HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入方法.....");
        System.out.println(businessNoticeNo);
        //传入参数
        Map<String,Object> map = new HashMap<>();
        map.put("businessNoticeNo",businessNoticeNo);
        map.put("telPhone",telPhone);
        System.out.println("page的值为" + page + ",limit的值为" + limit);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> mapList = checkTableService.querywhere(map);
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

    @RequestMapping(value = "findByID")
    public ModelAndView selectById(String jObNo){
        System.out.println("进入方法。。。。");
        System.out.println("根据查询为··················"+jObNo+"欧克");
        ModelAndView mv=new ModelAndView();
        CheckTable c = checkTableService.query_ById(jObNo);//根据id查询方法
        /*mv.addObject("sortingCode",c.getSortingCode());
        mv.addObject("smallMemberNum",c.getSmallMemberNum());
        mv.addObject("pickupUnit",c.getPickupUnit());*/

        /*List<CheckTable> empNo = checkTableService.query_xjy();//小件员下拉框
        System.out.println("111111111111111111111111111"+empNo);
        mv.addObject("empNo",empNo);
        List<CheckTable> name = checkTableService.query_dw();//单位下拉框
        mv.addObject("name",name);
*/
        mv.setViewName("/dispatch/singleTurn");
        return mv;
    }

    @RequestMapping(value = "/update_Chek",method = RequestMethod.POST)
    public ModelAndView update(String smallMemberNum,String pickupUnit,String jobNo){
        System.out.println("进入方法");
        System.out.println(jobNo);
        System.out.println(smallMemberNum);
        ModelAndView mv=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        map.put("smallMemberNum",smallMemberNum);
        map.put("pickupUnit",pickupUnit);
        int i = checkTableService.update_Sign(map);
        if(i>0){
            mv.setViewName("/dispatch/checkTable");
            return mv;
        }else{
            mv.setViewName("/dispatch/singleTurn");
            return mv;
        }
    }
}