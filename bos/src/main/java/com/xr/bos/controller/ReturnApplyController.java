package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.Acc_businessadmissibility;
import com.xr.bos.model.Ret_returnlist;
import com.xr.bos.model.SyEmp;
import com.xr.bos.service.ReturnApplyService;
import com.xr.bos.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 返货
 * 返货申请
 * 分货申请确认
 */
@Controller
public class ReturnApplyController {

    @Autowired
    private ReturnApplyService returnApplyService;

    //返货申请查询
    @RequestMapping(value = "/queryRet")
    public void select(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
        System.out.println("进入方法.....");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> queryall = returnApplyService.queryall();
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

    /*
       业务受理的新增
    */
    @RequestMapping(value = "/add_retaaply",method = RequestMethod.POST)
    @ResponseBody
    public String inseeretbus(Ret_returnlist ret_returnlist){
        System.out.println("进入！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
        System.out.println("对象"+ret_returnlist);
        ModelAndView mv=new ModelAndView();
        int i = returnApplyService.add_Apply(ret_returnlist);
        if(i!=0){
            return "ok";
        }else{
            return "no";
        }

    }

    /*
        两个字段的前端显示查询
        新增页面是通过这个方法进入的然后再返货新增页面进行新增
     */
    @RequestMapping(value = "/returnApply_add")
    public ModelAndView query_ById(HttpSession session){
        System.out.println("147852369");
        ModelAndView mv=new ModelAndView();
        String s = returnApplyService.query_ApplicationNo();
        String yuanlai = s.substring(0, 3);
        //后面数字
        String nowv = s.substring(3);
        //+1
        int i = Integer.parseInt(nowv) + 1;
        System.out.println(yuanlai+i);
        mv.addObject("applicationNo",yuanlai+i);

        String s1 = returnApplyService.query_WorkSheetNo();
        String yuanlai1 = s1.substring(0, 3);
        String now2 = s1.substring(3);
        int i1 = Integer.parseInt(now2) + 1;
        System.out.println(yuanlai1+i1);
        mv.addObject("workSheetNo",yuanlai1+i1);
        mv.setViewName("/return/returnApply_add");

        //查询所有人--
        List<Ret_returnlist> empName = returnApplyService.query_empName();
        //查询所有公司--
        List<Ret_returnlist> Name = returnApplyService.query_Name();
        mv.addObject("empName",empName);
        mv.addObject("Name",Name);
        //得到新增页面需要的页面数据
        //录入当前系统事件
        String now = DateFormat.getNow();
        //当前的系统时间
        mv.addObject("now",now);

        //得到当前登录的用户--录入人（登录人
        SyEmp syEmp = (SyEmp)session.getAttribute("SyEmp");
        mv.addObject("SyEmpName",syEmp.getEmpName());

        return mv;
    }

    @RequestMapping(value = "/queryByid_Ret")
    public ModelAndView queryBYId(String workSheetNo){
        System.out.println("进入方法值为----"+workSheetNo);
        ModelAndView mv=new ModelAndView();
        Map<String, Object> m = returnApplyService.queryByid(workSheetNo);
        mv.addObject("applicationNo",m.get("applicationNo"));
        mv.addObject("workSheetNo",m.get("workSheetNo"));
        mv.addObject("returnType",m.get("returnType"));
        mv.addObject("apLoss",m.get("apLoss"));
        mv.addObject("entryTime",m.get("entryTime"));
        mv.addObject("Name",m.get("Name"));
        mv.addObject("invalidateSign",m.get("invalidateSign"));
        mv.addObject("Name",m.get("Name"));
        mv.addObject("Name",m.get("Name"));
        mv.addObject("personName",m.get("personName"));
        mv.setViewName("/return/returnApply_update");
        return mv;
    }


    /**
     * 删除
     * @param applicationNo
     * @return
     */
    @RequestMapping(value = "/delte_retu")
    public ModelAndView deltet(String applicationNo){
        System.out.println("值为——————"+applicationNo);
        ModelAndView mv=new ModelAndView();
        int i = returnApplyService.del_retu(applicationNo);
        mv.setViewName("/return/returnApply");
        return mv;
    }

/*****************************************************/
    //返货申请确认查询
    @RequestMapping(value = "/queryRetComfim")
    public void selectConfirm(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
        System.out.println("进入方法.....");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> queryall = returnApplyService.queryaConfim();
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

/*******************************************************/
    //生成返货确认
    @RequestMapping(value = "/queryProduce")
    public void selectProduce(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
        System.out.println("进入方法.....");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> queryall = returnApplyService.queryProduce();
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
}
