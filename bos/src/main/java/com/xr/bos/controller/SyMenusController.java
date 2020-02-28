package com.xr.bos.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hazelcast.internal.json.Json;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyMenus;
import com.xr.bos.model.SyRoles;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.SyMenusService;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SyMenusController {

    @Autowired
    private SyMenusService syMenusService;


    @RequestMapping(value = "/createMenu",produces = "text/String;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody()
    public String createMenu(HttpSession session){
        SyEmp syEmp = (SyEmp) session.getAttribute("SyEmp");
        List<SyMenus> daMoKuai = syMenusService.queryDaMoKuai(syEmp.getID());
        StringBuffer sb = new StringBuffer("[");
        int i =0;
        //大模块
        for (SyMenus da : daMoKuai) {
            sb.append("{");
            sb.append("title: '"+da.getText()+"',icon:'"+da.getIcon()+"',");
            if(i==0){
                sb.append("isCurrent:true,");
            }
            i++;
            //只需要第一个大模块被默认选中
            sb.append("menu:[");
            //一级菜单
            Map<String,Object> yiJiMap = new HashMap<>();
            yiJiMap.put("syEmpID",syEmp.getID());
            yiJiMap.put("parentID",da.getID());
            List<SyMenus> yiJiChild = syMenusService.queryChild(yiJiMap);
            int j = 0;
            int k = 0;
            for (SyMenus yi : yiJiChild) {
                sb.append("{");
                sb.append("title:'"+yi.getText()+"',");
                sb.append("icon:'"+yi.getIcon()+"',");
                if(j==0){
                    sb.append("isCurrent:true,");
                }
                //每一个大模块的第一个一级菜单需要被选中
                j++;
                sb.append("children:[");

                //二级菜单
                Map<String,Object> erJiMap = new HashMap<>();
                erJiMap.put("syEmpID",syEmp.getID());
                erJiMap.put("parentID",yi.getID());
                List<SyMenus> erJiChild = syMenusService.queryChild(erJiMap);

                for (SyMenus er : erJiChild) {
                    sb.append("{");
                    sb.append("title:'"+er.getText()+"',");
                    sb.append("href:'"+er.getUrl()+"',");
                    if(k ==0){
                        sb.append("isCurrent:true");
                    }else{
                        //去掉href后面的逗号,第一次执行不需要
                        sb.deleteCharAt(sb.lastIndexOf(","));
                    }
                    sb.append("},");

                    //被选中的一级菜单的第一个二级菜单被选中
                    k++;
                }
                //删除二级菜单最后多余的，再拼接上]
                sb.deleteCharAt(sb.lastIndexOf(","));
                sb.append("]");
                sb.append("},");
                //所有二级菜单加载完毕进行加载下一个大模块，把变量k归零


            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("]");
            sb.append("},");
            //所有一级菜单加载完毕进行加载下一个大模块，把变量j归零


        }
        System.out.println(sb);
        //所有大模块加载完毕删除多余的,
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        String s = JSON.toJSONString(sb);
        System.out.println(s);
        return s;



    }

    /**
     * 查询所有的菜单
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findMenusAll")
    public void findMenusAll(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findMenusAll方法。。。。");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<SyMenus> menusList = syMenusService.findMenusAll();
        PageInfo pageInfo = new PageInfo(menusList);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+pageInfo.getTotal()+",\"data\":[");
        for (SyMenus s : menusList) {
            sb.append("{\"ID\":" + "\"" + s.getID() + "\",\"parentID\":" + "\"" + s.getParentID() + "\",\"type\":" + "\"" +s.getType() + "\",\"text\":" + "\"" +s.getText()+"\",\"url\":"+"\""+s.getUrl()+"\",\"tip\":"+"\""+s.getTip()+"\"},");

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
     * 查询上级菜单下拉框
     * @param responses
     */
    @RequestMapping(value = "/selectedparent")
    @ResponseBody
    public void selectedparent(HttpServletResponse responses){
        System.out.println("进入selectedparent方法");
        List<SyMenus> list = syMenusService.selectedparent();
        StringBuffer  sb=new StringBuffer("[");
        for (SyMenus s : list) {
            sb.append("{\"ID\":\"" +s.getID()+ "\", \"text\":\"" +s.getText() + "\"},");
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
     * @param syMenus
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findMenusByparentIDAandText")
    public void findMenusByparentIDAandText(SyMenus syMenus,HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findMenusByparentIDAandText方法。。。。");
        System.out.println("paretID==="+syMenus.getParentID());
        System.out.println(syMenus);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<SyMenus> menusList = syMenusService.findMenusByparentIDAandText(syMenus);

        PageInfo pageInfo = new PageInfo(menusList);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+pageInfo.getTotal()+",\"data\":[");
        for (SyMenus s : menusList) {
            sb.append("{\"ID\":" + "\"" + s.getID() + "\",\"parentID\":" + "\"" + s.getParentID() + "\",\"type\":" + "\"" +s.getType() + "\",\"text\":" + "\"" +s.getText()+"\",\"url\":"+"\""+s.getUrl()+"\",\"tip\":"+"\""+s.getTip()+"\"},");

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
     * 添加菜单
     * @param syMenus
     * @return
     */
    @RequestMapping(value = "/addMenus")
    public ModelAndView addMenus(SyMenus syMenus){
        System.out.println("进入addMenus.......");
        syMenusService.addMenus(syMenus);
        return new ModelAndView("/systemManagement/sysMenu");
    }

    /**
     * 打开编辑页面 传递id
     * @param ID
     * @return
     */
    @RequestMapping(value ="/openMenusedit")
    public ModelAndView openMenusedit(String ID){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/systemManagement/sysMenu_edit");
        mv.addObject("ID",ID);
        return mv;
    }

    /**
     * 编辑页赋值
     * @param syMenus
     * @param responses
     */
    @RequestMapping(value = "/findMenusByid")
    public void findMenusByid(SyMenus syMenus,HttpServletResponse responses){
        List<SyMenus> menusList = syMenusService.findMenusByID(syMenus);
        StringBuffer sb = new StringBuffer();
        for (SyMenus b : menusList) {
            sb.append("{\"ID\":" + "\"" + b.getID() + "\",\"parentID\":" + "\"" + b.getParentID() + "\",\"type\":"+"\""+b.getType()+"\",\"text\":" + "\"" + b.getText() + "\",\"url\":" + "\"" +b.getUrl()+"\",\"tip\":"+"\""+b.getTip()+"\"},");
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
     * 修改菜单
     * @param syMenus
     * @return
     */
    @RequestMapping(value = "/updateMenus")
    public ModelAndView updateMenus(SyMenus syMenus){
        syMenusService.updateMenus(syMenus);
        return new ModelAndView("/systemManagement/sysMenu");
    }

    /**
     * 删除菜单
     * @param ID
     * @return
     */
    @RequestMapping(value = "/deleteMenusByid")
    public ModelAndView deleteMenusByid(String ID){
        syMenusService.deleteMenus(Integer.parseInt(ID));
        return new ModelAndView("/systemManagement/sysMenu");
    }
}
