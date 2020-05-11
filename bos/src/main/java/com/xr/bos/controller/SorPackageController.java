package com.xr.bos.controller;

import com.xr.bos.service.SorPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SorPackageController {

    @Autowired
    private SorPackageService sorPackageService;

    @RequestMapping(value = "/queryAllPackage",produces = "text/String;charset=UTF-8")
    public void queryAll(int page, int limit, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");

        Map<String,Integer> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);

        List<Map<String, Object>> list = sorPackageService.queryAllSorPackage(map);
        Integer count = sorPackageService.queryAllCount();
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":[");
        for (Map<String, Object> stringObjectMap : list) {
            sb.append("{\"ID\":\""+stringObjectMap.get("ID")+
                    "\",\"PackagePerson\":\""+stringObjectMap.get("PackagePerson")+
                    "\",\"SealInt\":\""+stringObjectMap.get("SealInt")+
                    "\",\"Destination\":\""+stringObjectMap.get("Destination")+
                    "\",\"ReckonDes\":\""+stringObjectMap.get("ReckonDes")+
                    "\",\"TimeLimit\":\""+stringObjectMap.get("TimeLimit")+
                    "\",\"TicketSum\":\""+stringObjectMap.get("TicketSum")+
                    "\",\"CargoSum\":\""+stringObjectMap.get("CargoSum")+
                    "\",\"WeightSum\":\""+stringObjectMap.get("WeightSum")+
                    "\",\"VolumeSum\":\""+stringObjectMap.get("VolumeSum")+
                    "\",\"State\":\""+stringObjectMap.get("State")+
                    "\",\"Ask\":\""+stringObjectMap.get("Ask")+ "\"},");
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

}
