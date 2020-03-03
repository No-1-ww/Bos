package com.xr.bos.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.Bigloglogisticscontroltable;
import com.xr.bos.service.Bigloglogisticscontroltableservice;
import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class BigloglogisticscontroltableController {
    @Autowired
    private Bigloglogisticscontroltableservice bts;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;



    @RequestMapping("/selectBL")
    public void select1(ModelAndView mv, HttpServletResponse responses,String page,String limit) {
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html:charset=utf-8");
        System.out.println("page的值为"+page+"limit的值为"+limit);
        Page p = PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Bigloglogisticscontroltable> list = bts.select();
        PageInfo<Map<String,Object>> pageInfo = new PageInfo(list);
        /*
        StringBuffer sb = new StringBuffer("{\"code\":\"0\",\"msg\":\"\",\"count\":1000,\"data\":[");*/
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+ pageInfo.getTotal() +",\"data\":[");
        for (Bigloglogisticscontroltable b : list) {
            sb.append("{\"ID\":" + "\"" + b.getId() + "\",\"WorkSheetNo\":" + "\"" + b.getWorkSheetNo() + "\",\"Corporation\":" + "\"" + b.getCorporation() + "\",\"WaybillID\":" + "\"" + b.getWaybillID() + "\",\"InputPerson\":" + "\"" + b.getInputPerson() + "\",\"InputDate\":" + "\"" + b.getInputDate() + "\",\"Remarks\":" + "\"" + b.getRemarks() + "\"},");
            System.out.println(b.getId() + b.getWorkSheetNo() + b.getCorporation() + b.getWaybillID() + b.getInputPerson() + b.getInputDate() + b.getRemarks());
        }
        sb.append("]}");
        sb.deleteCharAt(sb.lastIndexOf(","));
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
    @RequestMapping("/largeLogisticsManagement/invoiceComparisonTable_add")
    public ModelAndView openadd(ModelAndView mv, HttpServletResponse responses) {
        System.out.println("进入add");
        Map<String, Object> selectmax = bts.selectmax();
        System.out.println(selectmax.get("max(WorkSheetNo)"));
        mv.addObject("maxw",selectmax.get("max(WorkSheetNo)"));
        mv.setViewName("/largeLogisticsManagement/invoiceComparisonTable_add");
        return mv;
    }
    @RequestMapping("/largeLogisticsManagement/invoiceComparisonTable")
    public ModelAndView select(ModelAndView mv, HttpServletResponse responses) {

       /* String key = "com.xr.bos.controller.BigloglogisticscontroltableController.select";
        Object list = redisTemplateUtil.getList(key);
        List<Bigloglogisticscontroltable> sorStorages = null;
        if(list==null||list.equals("")){
            *//*sorStorages =  sorStorageService.queryAll();*//*
            Page<Bigloglogisticscontroltable> objects = PageHelper.startPage(1, 6);
            sorStorages =bts.select();
            redisTemplateUtil.setList(key,sorStorages);
           // Object list1 = redisTemplateUtil.getList("com.xr.bos.controller.BigloglogisticscontroltableController.select");

           // System.out.println(list1);
        }else{
            System.out.println("缓存中。。。");
            sorStorages = (List)list;
        }

        mv.addObject("list",sorStorages);
        mv.setViewName("/largeLogisticsManagement/invoiceComparisonTable");
        return  mv;*/
        System.out.println("进入查询");
        /*age<Bigloglogisticscontroltable> objects = PageHelper.startPage(1, 6);
        List<Bigloglogisticscontroltable> list = bts.select();
        mv.addObject("list",list);*/
        mv.setViewName("/largeLogisticsManagement/invoiceComparisonTable");
        return mv;
        /*Page<Bigloglogisticscontroltable> objects = PageHelper.startPage(1, 6);
        List<Bigloglogisticscontroltable> list = bts.select();
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":[");
        for (Bigloglogisticscontroltable b : list) {
            sb.append("{\"ID\":" + "\"" + b.getId() + "\",\"WorkSheetNo\":" + "\"" + b.getWorkSheetNo() + "\",\"Corporation\":" + "\"" + b.getCorporation() + "\",\"WaybillID\":" + "\"" + b.getWaybillID() + "\",\"InputPerson\":" + "\"" + b.getInputPerson() + "\",\"InputDate\":" + "\"" + b.getInputDate() + "\",\"Remarks\":" + "\"" + b.getRemarks() + "\"},");
            System.out.println(b.getId() + b.getWorkSheetNo() + b.getCorporation() + b.getWaybillID() + b.getInputPerson() + b.getInputDate() + b.getRemarks());
        }
        sb.append("]}");
        sb.deleteCharAt(sb.lastIndexOf(","));
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
        }*/
    }

    @RequestMapping("selectBLwhere")
    public void selectwhere(ModelAndView mv, HttpServletResponse responses,String page,String limit,String WorkSheetNo,String Corporation){
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html:charset=utf-8");
        System.out.println("page的值为"+page+"limit的值为"+limit);
        Page p = PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        if(WorkSheetNo=="null"){
            WorkSheetNo=null;
        }if (Corporation==""){
            Corporation=null;
        }
        List<Bigloglogisticscontroltable> list = bts.selectwhere(WorkSheetNo,Corporation);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo(list);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+ pageInfo.getTotal() +",\"data\":[");
        for (Bigloglogisticscontroltable b : list) {
            sb.append("{\"ID\":" + "\"" + b.getId() + "\",\"WorkSheetNo\":" + "\"" + b.getWorkSheetNo() + "\",\"Corporation\":" + "\"" + b.getCorporation() + "\",\"WaybillID\":" + "\"" + b.getWaybillID() + "\",\"InputPerson\":" + "\"" + b.getInputPerson() + "\",\"InputDate\":" + "\"" + b.getInputDate() + "\",\"Remarks\":" + "\"" + b.getRemarks() + "\"},");
            System.out.println(b.getId() + b.getWorkSheetNo() + b.getCorporation() + b.getWaybillID() + b.getInputPerson() + b.getInputDate() + b.getRemarks());
        }
        sb.append("]}");
        sb.deleteCharAt(sb.lastIndexOf(","));
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
    @RequestMapping("insertBL")
    public int insertBL(Bigloglogisticscontroltable blt){
        System.out.println(blt.getWorkSheetNo()+blt.getInputDate());
        int i = bts.insertBL(blt);
        if(i>0){
            return i;
        }
        return 0;

    }
    @RequestMapping("max")
    public void selectmax(HttpServletResponse responses){
        Map<String, Object> map = bts.selectmax();
        System.out.println(map.get("max(WorkSheetNo)"));
        System.out.println(map.get("max(WaybillID)"));
        String a = map.get("max(WorkSheetNo)").toString();
        String b = a.substring(3);
        System.out.println(b);
        int i = Integer.parseInt(b);
        i= i+1;
        String s = a.substring(0, 3);
        a = s+String.valueOf(i);

        try {
            PrintWriter out = responses.getWriter();
            out.print(a);
        }catch (Exception e){

        }

    }
}
