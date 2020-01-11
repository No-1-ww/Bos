package com.xr.bos.controller;

import com.xr.bos.model.SorStorage;
import com.xr.bos.service.SorStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class SorStorageController {

    @Autowired
    private SorStorageService sorStorageService;
    /**
     * 查询所有入库信息
     * @return
     */
    @RequestMapping("/sortingManagement/storage")
    public ModelAndView queryAll(){
        List<Map<String,Object>> sorStorages = sorStorageService.queryAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sorStorages",sorStorages);
        mv.setViewName("/sortingManagement/storage");
        return  mv;
    }
}
