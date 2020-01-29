package com.xr.bos.controller;

import com.xr.bos.service.Acc_worksheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 工作单查询
 */
@Controller
public class acc_worksheetController {

    @Autowired
    private Acc_worksheetService acc_worksheetService;

    //查询
    @RequestMapping("/acceptance/worksheetQuery")
    public ModelAndView queryWor(){
        System.out.println("进入查询方法。。。。。。");
        List<Map<String, Object>> worlist = acc_worksheetService.queryAcc_worksheetMapper();
        /*for (Map<String, Object> map : worlist) {
            for (String s : map.keySet()) {
                System.out.println(map.get(s)+" ");
            }
        }*/
        ModelAndView mv=new ModelAndView();
        mv.addObject("worlist",worlist);
        mv.setViewName("/acceptance/worksheetQuery");
        return mv;
    }

}
