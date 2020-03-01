package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.dao.SyRolesMapper;
import com.xr.bos.model.Bigloglogisticscontroltable;
import com.xr.bos.model.SyRoles;
import com.xr.bos.service.SyRolesService;
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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class SyRolesController {
    @Autowired
    private SyRolesService syRolesService;

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @Autowired
    private SyRolesMapper syRolesMapper;

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
    @RequestMapping(value = "/findRolesWhereRolesNameAndDisabled",method = RequestMethod.GET)
    public void findRolesWhereRolesNameAndDisabled(SyRoles syRoles, HttpServletResponse responses, HttpServletRequest request, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findRolesWhereRolesNameAndDisabled.....");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

       /* if (Integer.toString(syRoles.getDisabled())==""){
           syRoles.setDisabled(1);
        }*/
        //System.out.println(syRoles.getDisabled());
        //syRoles.setDisabled(Integer.parseInt(disabled));

        System.out.println("角色名为"+syRoles.getRoleName()+"状态为"+syRoles.getDisabled());
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<SyRoles> rolesList = syRolesService.findRolesWhereRolesNameAndDisabled(syRoles);
        for (SyRoles roles : rolesList) {
            System.out.println(roles);
        }
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

    /**
     * 添加角色
     * @return
     */
    @RequestMapping(value = "/addSysRoles",method = RequestMethod.GET)
    @ResponseBody
    public  ModelAndView addSysRoles(SyRoles syRoles){
        System.out.println(syRoles.getRoleName()+"   "+syRoles.getRoleDesc()+"  "+syRoles.getDisabled());

        syRolesService.addSysRoles(syRoles);
        System.out.println("添加成功");
        return new ModelAndView("/systemManagement/sysRole");
    }

    /**
     * 打开编辑页面传值
     * @param id
     * @return
     */
    @RequestMapping(value = "/findOpenById")
    public ModelAndView findOpenById(String id){
        System.out.println(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/systemManagement/sysRole_edit");
        mv.addObject("id",id);
        return mv;

    }


    /**
     * 编辑页面的赋值
     * @param syRoles
     * @param responses
     */
    @RequestMapping(value = "/findRolesWhereUpdateById")
    public void findRolesWhereUpdateById(SyRoles syRoles, HttpServletResponse responses){
        System.out.println("=========="+syRoles);
        List<SyRoles> rolesWhereUpdateById = syRolesService.findRolesWhereUpdateById(syRoles);
        StringBuffer sb = new StringBuffer();
        for (SyRoles b : rolesWhereUpdateById) {
            sb.append("{\"id\":" + "\"" + b.getId() + "\",\"roleName\":" + "\"" + b.getRoleName() + "\",\"roleDesc\":" + "\"" + b.getRoleDesc() + "\",\"disabled\":" + "\"" +b.getDisabled()+"\"},");
        }
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
     * 修改保存
     * @param syRoles
     * @return
     */
    @RequestMapping(value = "/updateSysRoles",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateSysRoles(SyRoles syRoles) {
        System.out.println("进入修改方法。。。。。");
        int i = syRolesService.updateSysRolesByid(syRoles);
        ModelAndView mv=new ModelAndView();

        if (i > 0) {
            System.out.println("修改成功");
             mv.setViewName("/systemManagement/sysRole");
        }else{
            System.out.println("修改失败");
            mv.setViewName("/systemManagement/sysRole_edit");
        }
        System.out.println("查看i的值======" + i);
        System.out.println(syRoles.getRoleName() + "======" + syRoles.getRoleDesc() + "=====" + syRoles.getDisabled());
        return mv;
    }

    /**
     * 删除单位
     * @param id
     * @return
     */
    @RequestMapping(value = "/delSysRolesByid")
    public ModelAndView delSysRolesByid(String id){
        System.out.println("rid===="+id);
        syRolesService.delSysRolesByid(Integer.parseInt(id));
        return new ModelAndView("/systemManagement/sysRole");
    }
}
