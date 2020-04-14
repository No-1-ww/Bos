package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.BasBasicarchives;
import com.xr.bos.model.BasBasicarchivesentry;
import com.xr.bos.model.SyEmp;
import com.xr.bos.service.BasBasicarchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BasBasicarchivesController {
    @Autowired
    private BasBasicarchivesService basicarchivesService;

    /**
     * 基础档案所有数据
     * @return
     */
    @RequestMapping(value = "/findasbasicArchivesAll")
    public void  findasbasicArchivesAll(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        //System.out.println("进入findasDeliverystandarAll方法。。。。。。");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> list = basicarchivesService.findBasBasicarchivesAll();
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
           // System.out.println(sb);
            PrintWriter out = responses.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //查询操作人
    @RequestMapping(value = "/findOperatorIDs")
    public void  findOperatorIDs(HttpServletResponse responses){
     //   System.out.println("进入findOperatorID。。。。。。。。");
        List<SyEmp> list = basicarchivesService.findOperatorID();
        StringBuffer  sb=new StringBuffer("[");
        for (SyEmp s : list) {
            sb.append("{\"ID\":\"" +s.getID()+ "\", \"EmpName\":\"" +s.getEmpName() + "\"},");
        }
        // 去掉最后一个,号
        sb.append("]");
        sb.deleteCharAt(sb.lastIndexOf(","));
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=utf-8");
        try {
            //PrintWriter out 必须要写在方法里在HttpServletResponse之后出现 否则会出现乱码
          //  System.out.println(sb);
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
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findBasBasicarchivesByBasicFileNumberAndName")
    public void findBasBasicarchivesByBasicFileNumberAndName( String operatorid,String name,String operationtime,String basicfilenumber,HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        //System.out.println("ssssssss");
        BasBasicarchives basicarchives =new BasBasicarchives();
        basicarchives.setName(name);
        if (operatorid !=null && operatorid!=""){
            basicarchives.setOperatorid(Integer.parseInt(operatorid));

        }
        basicarchives.setBasicfilenumber(basicfilenumber);
        if(operationtime !=null&&operationtime!=""){
            //System.out.println(operationtime+"////");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            try {
               // System.out.println("字符串即将转换为Date");
                Date date=sdf.parse(operationtime);
               // System.out.println("字符串已转换为Date");
                basicarchives.setOperationtime(date);
               // System.out.println("set方法顺利");
            }catch (Exception e){
                e.printStackTrace();
               // System.out.println("字符串转Date异常");
            }
            //System.out.println(basicarchives.getOperationtime());

        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> list = basicarchivesService.findBasBasicarchivesByBasicFileNumberAndName(basicarchives);
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
        //System.out.println(sb);
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
     *查看可以不可无一打开详情页面
     */
    @RequestMapping(value = "/findBasicarchivesentryByOperatorId")
    public void findBasicarchivesentryByOperatorId(BasBasicarchives basicarchives,HttpServletResponse responses){
       // System.out.println(basicarchives.getId()+".....sdsdsdsds");
        String Grade = basicarchivesService.findBasicarchivesentryByOperatorId(basicarchives);
        //System.out.println(Grade+"..............");
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=utf-8");
        System.out.println(Grade);
        try {
            //PrintWriter out 必须要写在方法里在HttpServletResponse之后出现 否则会出现乱码
            System.out.println(Grade);
            PrintWriter out = responses.getWriter();
            out.print(Grade);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 打开增加页面
     * @param session
     * @return
     */
    @RequestMapping(value = "/basicArchives_add")
    public ModelAndView basicArchives_add( HttpSession session){
        System.out.println("进入basicArchives_add");
        SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
        List<Map<String, Object>> maps = basicarchivesService.findEmpNameAndUntisNameByID(syEmp.getID());
        ModelAndView mv=new ModelAndView();
        Date date=new Date();
        DateFormat df2 = DateFormat.getDateInstance();//可以精确到时分秒
        System.out.println(df2.format(date));
        mv.addObject("date",df2.format(date));
        mv.addObject("mps",maps);
        mv.setViewName("/basicData/basicArchives_add");
        return mv;


    }

    /**
     * 添加
     * @param basicarchives
     * @return
     */
    @RequestMapping(value = "/addbasicArchives")
    public ModelAndView addbasicArchives(BasBasicarchives basicarchives,HttpSession session){
        String number = basicarchivesService.findMaxBasicFileNumber();
        String DA=number.substring(0,2);
        String num=number.substring(2);
        int max=Integer.parseInt(num)+1;
        String basicfilenumber=DA+max;
        SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
        basicarchives.setOperationunitid(syEmp.getEmpUnit());
        basicarchives.setOperatorid(syEmp.getID());
        Date date=new Date();
        basicarchives.setOperationtime(date);
        basicarchives.setBasicfilenumber(basicfilenumber);
        basicarchivesService.addbasicArchives(basicarchives);
        return new ModelAndView("/basicData/basicArchives");
    }

    /**
     * 打开编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/openbasicArchives_edit")
    public ModelAndView openbasicArchives_edit(String id){
        System.out.println("修改传过来的id"+id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("id",id);
        mv.setViewName("/basicData/basicArchives_edit");

        return mv;
    }


    /**
     * 编辑页面赋值
     * @param id
     */
    @RequestMapping(value = "/findBasicarchivesById")
    public void findBasicarchivesById(Integer id,HttpServletResponse responses){
        List<Map<String, Object>> list = basicarchivesService.findBasicarchivesById(id);
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
     * @param basicarchives
     * @return
     */
    @RequestMapping(value = "/updateBasicarchivesById")
    public ModelAndView updateBasicarchivesById(BasBasicarchives basicarchives){
        basicarchivesService.updateBasicarchivesById(basicarchives);
        return new ModelAndView("/basicData/basicArchives");

    }

    /**
     * 查询主表下有没有条目信息
     * @param id
     * @param responses
     */
    @RequestMapping(value = "/findbas_basicarchivesentryByParent")
    public void findbas_basicarchivesentryByParent(Integer id,HttpServletResponse responses){
        String count = basicarchivesService.findbas_basicarchivesentryByParent(id);
        System.out.println(count+"....count");
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=utf-8");
        System.out.println(count);
        try {
            //PrintWriter out 必须要写在方法里在HttpServletResponse之后出现 否则会出现乱码
            System.out.println(count);
            PrintWriter out = responses.getWriter();
            out.print(count);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 删除档案
     * @param id
     * @return
     */
    @RequestMapping(value = "/deletebasicarchivesByID")
    public ModelAndView deletebasicarchivesByID(Integer id){
        basicarchivesService.deletebasicarchivesByID(id);
        return new  ModelAndView("/basicData/basicArchives");
    }
}
