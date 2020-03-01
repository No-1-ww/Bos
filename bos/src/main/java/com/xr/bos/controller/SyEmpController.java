package com.xr.bos.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyRoles;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.SyEmpService;
import com.xr.bos.util.DuanxinPhone;
import com.xr.bos.util.RedisTemplateUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class SyEmpController {

    @Autowired
    private SyEmpService syEmpService;

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @RequestMapping("/")
    public ModelAndView query(){
        ModelAndView mv = new ModelAndView();
        String key = "com.xr.bos.controller.SyEmpController.query";
        Object list = redisTemplateUtil.getList(key);
        System.out.println("sssssssssssssssssssssssssss"+list);
        if(list==null){
            System.out.println("去数据库取！！！！！！！！！！！！");
            List<SyEmp> select = syEmpService.select();
            redisTemplateUtil.setList(key,select);
            mv.addObject("emps",select);
            mv.setViewName("index");
        }else {
            System.out.println("去缓存取！");
            System.out.println(list);
            List<SyEmp> list2 = (List<SyEmp>) list;
            mv.addObject("emps",list2);
            mv.setViewName("index");
        }
        return mv;
    }



    @PostMapping("/logIn")
    public ModelAndView login(String username, String password, HttpSession session){
        ModelAndView mv = new ModelAndView();
        System.out.println(username + "\t" + password);

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        System.out.println(token);
        Subject subject = SecurityUtils.getSubject();
        try {
            //主体提交登录请求到SecurityManager
            subject.login(token);
        }catch (IncorrectCredentialsException ice){
            mv.addObject("msg","密码不正确");
        }catch(UnknownAccountException uae){
            mv.addObject("msg","账号不存在");
        }catch(AuthenticationException ae){
            mv.addObject("msg","状态不正常");
        }
//认证成功
        if(subject.isAuthenticated()){
            System.out.println("认证成功");
            mv.addObject("username",username);
            //得到用户所有信息绑定至session
            SyEmp syEmp = (SyEmp) subject.getPrincipal();
            session.setAttribute("SyEmp",syEmp);
            mv.setViewName("main");
            return mv ;
        }else{  //认证失败
            System.out.println("认证失败");
            token.clear();
            mv.setViewName("login");
            return mv; //跳转登录页面
        }
    }
    //ajax使用
    @PostMapping("queryExit")
    @ResponseBody
    public String queryExit(String Phone){
        int exitPhone = syEmpService.queryExitPhone(Phone);
        ModelAndView mv = new ModelAndView();
        if(exitPhone>0){
            Integer code = DuanxinPhone.fdx(Phone);
            return code.toString();
        }

       return "no";


    }
    @PostMapping("/logInDx")
    public ModelAndView logInDx(String Phone, HttpSession session){
        System.out.println("进入了短信登录的方法");
        SyEmp syEmp = syEmpService.logInDx(Phone);
        ModelAndView mv = login(syEmp.getEmpNo(), syEmp.getPwd(), session);
        return mv;
    }

    /**
     * 查询所有员工
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findEmpAll")
    public void  findEmpAll(HttpSession session,HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入查询员工放法findEmpAll.......");
        SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
        int id=syEmp.getID();
        System.out.println("id======"+id);
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(limit));
        List<Map<String, Object>> mapList = syEmpService.findEmpAll(id);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(mapList);
        StringBuffer sb=new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : mapList) {
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
     * 多条件查询
     * @param syEmp
     * @param session
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findEmpByNameOrDisabled")
    public void findEmpByNameOrDisabled(SyEmp syEmp,HttpSession session,HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findEmpByNameOrDisabled。。。。。。。。");
        SyEmp syEmps =(SyEmp) session.getAttribute("SyEmp");
        int id=syEmps.getID();
        syEmp.setID(id);
        System.out.println("id======"+id);
        System.out.println(syEmp.getEmpName()+"========  "+syEmp.getDisabled());
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(limit));
        List<Map<String, Object>> mapList =syEmpService.findEmpByNameOrDisabled(syEmp);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(mapList);
        StringBuffer sb=new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : mapList) {
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
     * 下拉框查询 角色名
     * @return
     */
    @RequestMapping(value = "/selectedRolesByRolesName",method = RequestMethod.GET)
    @ResponseBody
    public void selectedRolesByRolesName(HttpServletResponse responses){
        List<SyRoles> syRoles = syEmpService.selectedRolesByRolesName();
        StringBuffer  sb=new StringBuffer("[");
        for (SyRoles s : syRoles) {
            sb.append("{\"id\":\"" +s.getId()+ "\", \"roleName\":\"" + s.getRoleName() + "\"},");
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
     * 单位下拉框查询
     * @param responses
     */
    @RequestMapping(value = "/selectedUntisByName",method = RequestMethod.GET)
    @ResponseBody
    public void selectedUntisByName(HttpServletResponse responses){
        List<SyUnits> syUnits = syEmpService.selectedUntisByName();
        StringBuffer  sb=new StringBuffer("[");
        for (SyUnits s : syUnits) {
            sb.append("{\"ID\":\"" +s.getID()+ "\", \"name\":\"" + s.getName() + "\"},");
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
     * 打开新增页面 并查询最大工号加1
     * @return
     */
    @RequestMapping(value = "/sysEmp_add")
    public ModelAndView opensysEmp_add(){
        ModelAndView mv=new ModelAndView();
        String empNo = syEmpService.findMaxByEmpNo();
        String e=empNo.substring(0,1);
        String num=empNo.substring(1);
        int empno=Integer.parseInt(num)+1;
        System.out.println("e==="+e+"   num===="+num+"  empno==="+empno+"===="+(e+empno));
        mv.addObject("empno",e+empno);
        mv.setViewName("/systemManagement/sysEmp_add");
        return  mv;
    }

    /**
     * 新增员工
     * @param syEmp
     * @return
     */
    @RequestMapping(value = "/addEmp")
    public ModelAndView addEmp(SyEmp syEmp){
        System.out.println("进入addEmp。。。。");
        System.out.println("syEmp==============="+syEmp);
        syEmpService.addEmp(syEmp);
        return new  ModelAndView("/systemManagement/sysEmp");
    }

    /**
     * 打开编辑页面
     * @param ID
     * @return
     */
    @RequestMapping(value = "/findOpensysEmpeditById")
    public ModelAndView findOpensysEmpeditById(String ID){
        System.out.println(ID);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/systemManagement/sysEmp_edit");
        mv.addObject("ID",ID);
        return mv;
    }

    /**
     * 编辑页赋值
     * @param syEmp
     * @param responses
     */
    @RequestMapping(value = "/findEmpByid")
    public void findEmpByid(SyEmp syEmp,HttpServletResponse responses){
        System.out.println("semp+==="+syEmp);
        List<Map<String, Object>> list = syEmpService.findEmpByid(syEmp);
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
     * 修改员工
     * @param syEmp
     * @return
     */
    @RequestMapping(value = "/updateEmp")
    @ResponseBody
    public ModelAndView updateEmp(SyEmp syEmp){
        System.out.println("进入updateEmp方法。。。。。");
        syEmpService.updateEmp(syEmp);
        return new  ModelAndView("/systemManagement/sysEmp");
    }

    /**
     * 删除员工
     * @param ID
     * @return
     */
    @RequestMapping(value = "/deleteEmpByid")
    public  ModelAndView deleteEmpByid(String ID){
        syEmpService.deleteEmpByid(Integer.parseInt(ID));
        return new  ModelAndView("/systemManagement/sysEmp");
    }
}
