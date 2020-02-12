package com.xr.bos.controller;

import com.xr.bos.model.Acc_worksheet;
import com.xr.bos.service.Acc_worksheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    //新增
    @RequestMapping("/worksheetAdd")
    @ResponseBody
    public ModelAndView insert(Acc_worksheet acc_worksheet){
        System.out.println("进入了");
        System.out.println("***************"+acc_worksheet);
        ModelAndView mv=new ModelAndView();
        int i = acc_worksheetService.add_worksheet(acc_worksheet);
        if(i>0){
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }
        return mv;
    }

    //显示出最大的工作单号
    @RequestMapping(value = "/acceptance/worksheetQuickInput")
    public ModelAndView query_ID(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ModelAndView mv=new ModelAndView();
        String s = acc_worksheetService.querywork_ID();
        String yuanlai = s.substring(0, 3);//截取后面的数字
        String now = s.substring(3);
        int i = Integer.parseInt(now) + 1;
        System.out.println(yuanlai+i);
        mv.addObject("workSheetNo",yuanlai+i);
        return mv;
    }
}
