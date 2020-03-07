package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.BasBasicarchivesentry;
import com.xr.bos.model.SyEmp;
import com.xr.bos.service.BasBasicarchivesentryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.*;

@Controller
public class BasBasicarchivesentryController {
    @Autowired
    private BasBasicarchivesentryService basicarchivesentryService;

    /**
     * 打开条目列表
     * @param parentid
     * @return
     */
    @RequestMapping(value = "/basicArchives_list")
    public ModelAndView basicArchives_list(String parentid, String BasicFileNumber){
        System.out.println(parentid+"=====parentid");
        ModelAndView mv=new ModelAndView();
        mv.addObject("parentid",parentid);
        mv.addObject("BasicFileNumber",BasicFileNumber);
        mv.setViewName("/basicData/basicArchives_list");
        return mv;
    }
    /**
     * 查询所有详情
     * @param parentid
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findBasicarchivesentryAll")
    public void findBasicarchivesentryAll(String parentid,HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> list = basicarchivesentryService.findBasicarchivesentryAll(Integer.parseInt(parentid));
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

    /**
     * 打开add页面
     * @return
     */
    @RequestMapping(value = "/basicArchives_detail_add")
    public ModelAndView basicArchives_detail_add(Integer parentid,String BasicFileNumber,HttpSession session){
        System.out.println("sssssss"+parentid+"========="+BasicFileNumber);
        ModelAndView mv=new ModelAndView();
        SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
        List<Map<String, Object>> maps = basicarchivesentryService.findEmpNameAndUntisNameByID(syEmp.getID());
        Date date=new Date();
        DateFormat df2 = DateFormat.getDateInstance();//可以精确到时分秒
        System.out.println(df2.format(date));
        mv.addObject("date",df2.format(date));
        mv.addObject("mps",maps);
        mv.addObject("BasicFileNumber",BasicFileNumber);
        mv.addObject("parentid",parentid);
        mv.setViewName("/basicData/basicArchives_detail_add");
        return mv;
    }

    @RequestMapping("/addBasicarchivesentry")
    public ModelAndView addBasicarchivesentry(BasBasicarchivesentry basicarchivesentry,HttpSession session){

        SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
        basicarchivesentry.setOperatorid(syEmp.getID());
        basicarchivesentry.setOperationunitid(syEmp.getEmpUnit());
        Date date =new Date();
        basicarchivesentry.setOperationtime(date);
        System.out.println("输出"+basicarchivesentry);
        basicarchivesentryService.addBasicarchivesentry(basicarchivesentry);
        return new ModelAndView("/basicData/basicArchives_list");
    }

}
