package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.Bigloglogisticscontroltable;
import com.xr.bos.model.SyRoles;
import com.xr.bos.service.SyRolesService;
import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class SyRolesController {
    @Autowired
    private SyRolesService syRolesService;

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    /**
     * 角色管理所有数据
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findsysRoleAll")
    public void findRolesAll(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findRolesAll.....");
        //String key = "com.xr.bos.controller.SyRolesController.findRolesAll";
        //1.先从缓存中获取
       // Object list = redisTemplateUtil.getList(key);
       //ModelAndView mv = new ModelAndView();
        //List<SyRoles> rolesList=null;
        //if (list==null||list.equals("")){
           // System.out.println("从数据库获取。。。");
            //从数据库获取
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<SyRoles> rolesList=syRolesService.findRolesAll();
        PageInfo pageInfo = new PageInfo(rolesList);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+pageInfo.getTotal()+",\"data\":[");
        for (SyRoles b : rolesList) {
            sb.append("{\"id\":" + "\"" + b.getId() + "\",\"roleName\":" + "\"" + b.getRoleName() + "\",\"roleDesc\":" + "\"" + b.getRoleDesc() + "\",\"disabled\":" + "\"" +b.getDisabled()+"\"},");
             }
        sb.append("]}");
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


        //redisTemplateUtil.setList(key,rolesList);
       // }else{
            //从缓存中获取
           // System.out.println("从缓存中获取。。。1111");
            //rolesList = (List)list;
      //  }
      //  mv.addObject("roles",rolesList);
        //mv.setViewName("/systemManagement/sysRole");
             // return mv;
    }

    /**
     * 根据条件查询
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findRolesWhereRolesNameAndDisabled")
    public void findRolesWhereRolesNameAndDisabled(SyRoles syRoles,HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findRolesWhereRolesNameAndDisabled.....");
        String a=null;
        if (syRoles.getRoleName()==""){
            a=syRoles.getRoleName();
        }
        if(syRoles.getDisabled()+" "==""){
            a=String.valueOf(syRoles.getDisabled());
        }


        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<SyRoles> rolesList = syRolesService.findRolesWhereRolesNameAndDisabled(syRoles);
        PageInfo pageInfo = new PageInfo(rolesList);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+pageInfo.getTotal()+",\"data\":[");
        for (SyRoles b : rolesList) {
            sb.append("{\"id\":" + "\"" + b.getId() + "\",\"roleName\":" + "\"" + b.getRoleName() + "\",\"roleDesc\":" + "\"" + b.getRoleDesc() + "\",\"disabled\":" + "\"" +b.getDisabled()+"\"},");
        }
        sb.append("]}");
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

}
