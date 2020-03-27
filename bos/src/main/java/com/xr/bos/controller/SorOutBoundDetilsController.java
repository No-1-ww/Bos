package com.xr.bos.controller;

import com.xr.bos.service.SorOutBoundDetailsService;
import com.xr.bos.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class SorOutBoundDetilsController {

    @Autowired
    private SorOutBoundDetailsService sorOutBoundDetailsService;


    //查看明细页面

    @RequestMapping("/sortingManagement/theLibrary_list")
    public ModelAndView goToTheLibraryList(String OutBoundID){
        System.out.println(OutBoundID);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sortingManagement/theLibrary_list");
        List<Map<String, Object>> list = sorOutBoundDetailsService.queryByOutBoundID(OutBoundID);
        for (Map<String, Object> map : list) {
            int isScan = (Integer.parseInt(map.get("IsScan").toString()));
            int isNextStorage = (Integer.parseInt(map.get("IsNextStorage").toString()));
            int isDoubleStorage = (Integer.parseInt(map.get("IsDoubleStorage").toString()));
            if(isScan==0){
                map.put("ScanDate","未扫描");
                map.put("IsScan","否");
            }else{
                String scanDate = map.get("ScanDate").toString();
                String substring = scanDate.substring(0,scanDate.indexOf(" "));
                map.put("ScanDate",substring);
                    map.put("IsScan","是");


            }

            if(isNextStorage==0){
                map.put("IsNextStorage","否");
            }else{
                map.put("IsNextStorage","是");
            }

            if(isDoubleStorage==0){
                map.put("IsDoubleStorage","否");
            }else{
                map.put("IsDoubleStorage","是");
            }

        }

        mv.addObject("sorOutBoundDetails",list);
        return mv;
    }
}
