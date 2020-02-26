package com.xr.bos.controller;

import com.xr.bos.service.SorOutBoundService;
import com.xr.bos.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SorOutBoundController {
    @Autowired
    private SorOutBoundService sorOutBoundService;

    @RequestMapping(value = "/queryAllOutBound",produces = "text/String;charset=UTF-8")
    public void queryAll(int page, int limit, HttpServletResponse response){
        //如果加上了
        //传入map集合暂时代替pageHelper
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        Map<String,Integer> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        List<Map<String, Object>> list = sorOutBoundService.queryAll(map);
        //格式化时间
        List<Map<String, Object>> list1 = DateFormat.formatMap(list, "EnterDate");
        //工具类原因只能格式化一个时间
        List<Map<String, Object>> list2 = DateFormat.formatMap(list1, "DeliveryDate");
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":[");
        for (Map<String, Object> stringObjectMap : list2) {
            sb.append("{\"OutBoundID\":\""+stringObjectMap.get("OutBoundID")+
                    "\",\"HandoverType\":\""+stringObjectMap.get("HandoverType")+
                    "\",\"Line\":\""+stringObjectMap.get("Line")+
                    "\",\"Direction\":\""+stringObjectMap.get("Direction")+
                    "\",\"AcceptPerson\":\""+stringObjectMap.get("AcceptPerson")+
                    "\",\"Carriers\":\""+stringObjectMap.get("Carriers")+
                    "\",\"DeliveryPerson\":\""+stringObjectMap.get("DeliveryPerson")+
                    "\",\"DeliveryDate\":\""+stringObjectMap.get("DeliveryDate")+
                    "\",\"DeliveryCompany\":\""+stringObjectMap.get("DeliveryCompany")+
                    "\",\"EnterPerson\":\""+stringObjectMap.get("EnterPerson")+
                    "\",\"EnterDate\":\""+stringObjectMap.get("EnterDate")+"\"},");
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

    @GetMapping("/sortingManagement/theLibrary")
    public String theLibrary(){
        return "/sortingManagement/theLibrary";
    }


}
