package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.SyUnitsService;
import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class SyUnitsController {

    @Autowired
    private SyUnitsService syUnitsService;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    /**
     * 单位管理所有数据
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findUnitsAll")
    public void findUnitsAll(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
        System.out.println("进入findUntisAll22222.....");

        //String key="com.xr.bos.controller.SyUnitsController.findUnitsAll";
        //Object list = redisTemplateUtil.getSet(key);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> findUntisAll = null;

        // if(list==null||list.equals("")){
        //System.out.println("从数据库获取untis。。。。");
        findUntisAll = syUnitsService.findUntisAll();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(findUntisAll);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : findUntisAll) {
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


    // redisTemplateUtil.setList(key,findUntisAll);
    // }else {
    // System.out.println("从缓存中获取utis。。。。");
    // findUntisAll=(List<Map<String,Object>>) list;
    //}

}
    @RequestMapping(value = "/findsysUnitwhereAsname",method = RequestMethod.GET)
    public void findsysUnitwhereAsname(String name, HttpServletResponse responses, HttpServletRequest request, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findsysUnitwhereAsname。。。。。。。"+"  "+"name==="+name);
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> list = syUnitsService.findUntiswhereAsname(name);
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
     * 添加单位
     * @param syUnits
     * @param session
     * @return
     */
    @RequestMapping(value = "/addUntis")
    @ResponseBody
    public ModelAndView addUntis(SyUnits syUnits, HttpSession session){
        SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
        syUnits.setOperAtorID(syEmp.getID());
        Date date =new Date();
        syUnits.setOperationTime(date);
        syUnitsService.addUnits(syUnits);
        return new ModelAndView("/systemManagement/sysUnit");
    }

    /**
     * 打开编辑页传ID
     * @param ID
     * @return
     */
    @RequestMapping(value = "/openUpdate")
    public ModelAndView openUpdate(String ID){
        System.out.println(ID+".........");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/systemManagement/sysUnit_edit");
        mv.addObject("ID",ID);
        return mv;
    }


    /**
     * 根据id查询编辑页赋值
     * @param syUnits
     * @param responses
     */
    @RequestMapping(value = "/findUntisUpdateByID")
    public void findUntisUpdateByID(SyUnits syUnits,HttpServletResponse responses){
        System.out.println(syUnits+"========");
        List<Map<String, Object>> list = syUnitsService.findUntisUpdateByID(syUnits);
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

    @RequestMapping(value = "/updateSyUntis")
    @ResponseBody
    public ModelAndView updateSyUntis(SyUnits syUnits,HttpSession session){
        SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
        syUnits.setOperAtorID(syEmp.getID());
        Date date =new Date();
        syUnits.setOperationTime(date);
        int i = syUnitsService.updateSyUntisByID(syUnits);
        ModelAndView mv=new ModelAndView();
        if(i>0){
            System.out.println("修改成功");
            mv.setViewName("/systemManagement/sysUnit");
        }else{
            System.out.println("修改失败");
            mv.setViewName("/systemManagement/sysUnit_edit");
        }
        return mv;
    }

    /**
     * 删除单位
     * @param ID
     * @return
     */
    @RequestMapping(value = "/delSyUntisByID")
    public ModelAndView delSyUntisByID(String ID){
        System.out.println("ID====="+ID);
        int i = syUnitsService.delSyUntisByID(Integer.parseInt(ID));
        return new ModelAndView("/systemManagement/sysUnit");
    }

}
