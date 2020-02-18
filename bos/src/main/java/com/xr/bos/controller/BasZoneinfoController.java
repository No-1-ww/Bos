package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.service.BasZoneinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class BasZoneinfoController {
    @Autowired
    private BasZoneinfoService zoneinfoService;

    @RequestMapping(value = "/basicData/zone")
    public StringBuffer  findZoneinfoAll(@RequestParam(value="page",required=false) String page,@RequestParam(value="limit",required=false) String limit){
        System.out.println("进入findZoneinfoAll方法。。。。");


        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> list = zoneinfoService.findZoneinfoAll();
        System.out.println(list.size());
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        StringBuffer baszos = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : list) {
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            baszos.append("{");
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object o = map.get(key);
                baszos.append("\"" + key + "\":\"" + o + "\",");
            }
            baszos.deleteCharAt(baszos.lastIndexOf(","));
            baszos.append("},");

        }
        baszos.append("]}");
        baszos.deleteCharAt(baszos.lastIndexOf(","));

        return baszos;



       // ModelAndView mv=new ModelAndView();
      //  mv.addObject("zoneinfo",list);
       // mv.setViewName("/basicData/zone");
       // return mv;
    }
}
