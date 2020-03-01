package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.BasStandartime;
import com.xr.bos.model.SyMenus;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.BasStandartimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.*;

@Controller
public class BasStandartimeController {
    @Autowired
    private BasStandartimeService basStandartimeService;

    /**
     * 收派时间管理ALL
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/finddeliveryTimeAll")
    public void finddeliveryTimeAll(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入finddeliveryTimeAll方法。。。");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> list = basStandartimeService.findstandartimeAll();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : list) {
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
            //PrintWriter out 必须要写在方法里在HttpServletResponse之后出现 否则会出现乱码
            System.out.println(sb);
            PrintWriter out = responses.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 下拉框菜单查询
     * @param responses
     */
    @RequestMapping(value = "/selectedFindUnitsName")
    public void selectedFindUnitsName(HttpServletResponse responses){
        List<SyUnits> list = basStandartimeService.selectedFindUnitsName();
        StringBuffer sb=new StringBuffer("[");
        for (SyUnits s : list) {
            sb.append("{\"ID\":\"" +s.getID()+ "\", \"Name\":\"" +s.getName() + "\"},");
        }
        // 去掉最后一个,号
        sb.append("]");
        sb.deleteCharAt(sb.lastIndexOf(","));
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=utf-8");
        try {
            //PrintWriter out 必须要写在方法里在HttpServletResponse之后出现 否则会出现乱码
            System.out.println(sb);
            PrintWriter out = responses.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 多条件查询
     * @param standartime
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findstandartimeByTimeNameAndSubordinateUnit")
    public void findstandartimeByTimeNameAndSubordinateUnit(BasStandartime standartime, HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findstandartimeByTimeNameAndSubordinateUnit方法。。。");
       /* standartime.setSubordinateunit(1);
        System.out.println(standartime.getSubordinateunit());*/

    /*   standartime.setTimename("day1");*/
        System.out.println(standartime.getSubordinateunit()+"    "+standartime.getTimename());
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> list = basStandartimeService.findstandartimeByTimeNameAndSubordinateUnit(standartime);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : list) {
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
            //PrintWriter out 必须要写在方法里在HttpServletResponse之后出现 否则会出现乱码
            System.out.println(sb);
            PrintWriter out = responses.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 添加收派时间管理
     * @param workingtime
     * @param closingtime
     * @param sundayworkingtime
     * @param sundayclosingtime
     * @param saturdayworkingtime
     * @param saturdayclosingtime
     * @return
     */
    @RequestMapping(value = "/addBastandartime",method = RequestMethod.GET)
    public  ModelAndView addBastandartime(BasStandartime  basStandartime,String workingtime, String closingtime , String sundayworkingtime, String sundayclosingtime, String saturdayworkingtime, String saturdayclosingtime){
        System.out.println("进入addBastandartime方法。。。。。");
        System.out.println(workingtime);
        basStandartimeService.addBastandartime(basStandartime);

        return new ModelAndView("/basicData/deliveryTime");
    }

    /**
     * 打开编辑页面 并传递id;
     */
    @RequestMapping(value = "/openBastandartime_edit")
    public ModelAndView openBastandartime_edit(String ID){
        ModelAndView mv=new ModelAndView();
        mv.addObject("ID",ID);
        mv.setViewName("/basicData/deliveryTime_edit");
        return mv;
    }

    /**
     * 修改页面赋值
     * @param standartime
     * @param responses
     */
    @RequestMapping(value = "/finddeliverytimeByID")
    public void finddeliverytimeByID(BasStandartime standartime,HttpServletResponse responses){
        System.out.println("修改赋值。。。。。。。。。。。");
        List<Map<String, Object>> list = basStandartimeService.finddeliverytimeByID(standartime);
        StringBuffer sb=new StringBuffer();
        //多表查询
        for (Map<String, Object> map : list) {
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            sb.append("{");
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object o = map.get(key);
                sb.append("\"" + key + "\":\"" + o + "\",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("}");

        }
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=utf-8");
        System.out.println(sb);
        try {
            //PrintWriter out 必须要写在方法里在HttpServletResponse之后出现 否则会出现乱码
            System.out.println(sb);
            PrintWriter out = responses.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 修改
     * @param standartime
     * @return
     */
    @RequestMapping(value = "/updateBastandartime")
    public ModelAndView updateBastandartime(BasStandartime standartime){

        basStandartimeService.updateBasStandartime(standartime);
        return  new ModelAndView("/basicData/deliveryTime");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteBastandartime")
    public ModelAndView deleteBastandartime(String id){
        basStandartimeService.deleteBasStandartime(Integer.parseInt(id));
        return new ModelAndView("/basicData/deliveryTime");
    }
}
