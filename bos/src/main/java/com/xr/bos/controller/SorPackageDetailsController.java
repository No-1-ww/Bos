package com.xr.bos.controller;

import com.xr.bos.service.SorPackageDetailsService;
import com.xr.bos.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class SorPackageDetailsController {

    @Autowired
    private SorPackageDetailsService sorPackageDetailsService;

    //根据合包号查询合包明细
    @RequestMapping(value = "/sorPackageController/queryPackageDetailsByID",produces = "text/String;charset=UTF-8")
    public ModelAndView gotoSorPackageDetails(String ID){
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> list = sorPackageDetailsService.queryPackageDetailsByID(ID);
        //格式化时间
        List<Map<String, Object>> formatMap = DateFormat.formatMap(list, "Service");
        for (Map<String, Object> map : formatMap) {
            Integer wareName = Integer.parseInt(map.get("WareName").toString());
            String stringWareName="";
            Integer ask = Integer.parseInt(map.get("Ask").toString());
            String stringAsk = "";
            if(wareName==0) stringWareName="电子产品";
            else if(wareName==1) stringWareName="日常用品";
            else if(wareName==2) stringWareName="婴幼儿用品";
            else if(wareName==3) stringWareName="衣服,裤子";
            else if(wareName==4) stringWareName="厨房用品";
            else stringWareName="其他用品";

            map.put("WareName",stringWareName);

            if(ask==0) stringAsk="无要求";
            else if(ask==1) stringAsk="禁航空";
            else if(ask==2) stringAsk="禁铁路";
            else stringAsk="禁航空，铁路";

            map.put("Ask",stringAsk);
        }
        mv.addObject("sorPackage",formatMap);
        mv.setViewName("/sortingManagement/package_list");
        return mv;
    }
}
