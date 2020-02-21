package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.service.SyUnitsService;
import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class SyUnitsController {

    @Autowired
    private SyUnitsService syUnitsService;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    /**
     * 单位管理所有数据
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findUnitsAll")
    public void findUnitsAll(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
        System.out.println("进入findUntisAll22222.....");

        //String key="com.xr.bos.controller.SyUnitsController.findUnitsAll";
        //Object list = redisTemplateUtil.getSet(key);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> findUntisAll = null;

        // if(list==null||list.equals("")){
        //System.out.println("从数据库获取untis。。。。");
        findUntisAll = syUnitsService.findUntisAll();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(findUntisAll);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : findUntisAll) {
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            sb.append("{");
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object o = map.get(key);
                sb.append("\"" + key + "\":\"" + o + "\",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("},");

        }
        sb.append("]}");
        sb.deleteCharAt(sb.lastIndexOf(","));
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=utf-8");
        System.out.println(sb);
        try {
            //PrintWriter out 必须要写在方法里在HttpServletResponse之后出现 否则会出现乱码
            System.out.println(sb);
            PrintWriter out = responses.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    // redisTemplateUtil.setList(key,findUntisAll);
    // }else {
    // System.out.println("从缓存中获取utis。。。。");
    // findUntisAll=(List<Map<String,Object>>) list;
    //}

}
    @RequestMapping(value = "/findsysUnitwhereAsname")
    public void findsysUnitwhereAsname(){

    }

}
