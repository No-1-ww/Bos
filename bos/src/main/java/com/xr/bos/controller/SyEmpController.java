package com.xr.bos.controller;

import com.xr.bos.model.SyEmp;
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

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    //查询所有员工
    //aa
    @RequestMapping(value = "/systemManagement/sysEmp")
    public ModelAndView findEmpAll(){
        System.out.println("进入查询员工放法findEmpAll.......");
        List<Map<String, Object>> mapList = syEmpService.findEmpAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("emps",mapList);
        mv.setViewName("/systemManagement/sysEmp");
        return mv;
    }

}
