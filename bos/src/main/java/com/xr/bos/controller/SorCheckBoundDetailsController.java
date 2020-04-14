package com.xr.bos.controller;

import com.xr.bos.service.SorCheckBoundDetailsService;
import com.xr.bos.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class SorCheckBoundDetailsController {

    @Autowired
    private SorCheckBoundDetailsService sorCheckBoundDetailsService;

    @RequestMapping("/sortingManagement/check_list")
    public ModelAndView goToCheckList(String ID){
        System.out.println("111111111111111111111111111111111111111"+ID);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sortingManagement/check_list");
        List<Map<String, Object>> list = sorCheckBoundDetailsService.querySorCheckBoundDetailsByID(ID);
        List<Map<String, Object>> list1 = DateFormat.formatMap(list, "StorageDate");
        for (Map<String, Object> map : list1) {
            if (map.get("CargoType").toString().equals("0")){
                map.put("CargoType","电子产品");
            }else if(map.get("CargoType").toString().equals("1")){
                map.put("CargoType","日常用品");
            }else if(map.get("CargoType").toString().equals("2")){
                map.put("CargoType","婴幼儿用品");
            }else if(map.get("CargoType").toString().equals("3")){
                map.put("CargoType","衣服,裤子");
            }else if(map.get("CargoType").toString().equals("4")){
                map.put("CargoType","厨房用品");
            }else{
                map.put("CargoType","其他用品");
            }
        }
        //绑定至前台的详情页面
        mv.addObject("SorCheckBounds",list1);
        return mv;
    }
}
