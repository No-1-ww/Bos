package com.xr.bos.controller;

import com.xr.bos.service.SorCheckBoundService;
import com.xr.bos.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SorCheckBoundController {
    @Autowired
    private SorCheckBoundService sorCheckBoundService;

    /*
    * layUI绑定数据
    * */
    @RequestMapping(value = "/queryAllCheckBound",produces = "text/String;charset=UTF-8")
    public void queryAll(int page, int limit, HttpServletResponse response){
        //如果加上了
        //传入map集合暂时代替pageHelper
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");

        Map<String,Integer> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        List<Map<String, Object>> list = sorCheckBoundService.queryAllSorCheckBound(map);
        //格式化时间
        List<Map<String, Object>> list1 = DateFormat.formatMap(list, "CheckDate");
        Integer count = sorCheckBoundService.querySorCheckBoundCount();
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":[");
        for (Map<String, Object> stringObjectMap : list1) {
            sb.append("{\"ID\":\""+stringObjectMap.get("ID")+
                    "\",\"ScanID\":\""+stringObjectMap.get("ScanID")+
                    "\",\"CargoSum\":\""+stringObjectMap.get("CargoSum")+
                    "\",\"CheckPerson\":\""+stringObjectMap.get("CheckPerson")+
                    "\",\"CheckDate\":\""+stringObjectMap.get("CheckDate")+
                    "\",\"CheckCompany\":\""+stringObjectMap.get("CheckCompany")+ "\"},");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]}");
        System.out.println(sb);
        try {
            PrintWriter out = response.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增盘库
     */
    @RequestMapping("/sortingManagement/Check_add")
    public String goToCheckAdd(){
        return "/sortingManagement/check_add";
    }
    @RequestMapping(value = "/addCheckBound",produces = "text/String;charset=UTF-8")
    public String addCheckBound(/*盘库单，盘库详情单，盘库详情单没有model*/){

        return "";
    }

}
