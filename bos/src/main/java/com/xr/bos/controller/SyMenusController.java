package com.xr.bos.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hazelcast.internal.json.Json;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyMenus;
import com.xr.bos.service.SyMenusService;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

}
