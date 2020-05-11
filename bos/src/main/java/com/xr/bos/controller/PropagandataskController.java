package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.Acc_businessadmissibility;
import com.xr.bos.model.Dis_propagandatask;
import com.xr.bos.service.PropagandataskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class PropagandataskController {

        @Autowired
        private PropagandataskService propagandataskService;

        @RequestMapping(value = "/query_Pro")
        public void select(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit) {
            System.out.println("进入方法.....");
            PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
            List<Map<String, Object>> queryall = propagandataskService.queryall();
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(queryall);
            StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
            for (Map<String, Object> map : queryall) {
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
                System.out.println(sb);
                PrintWriter out = responses.getWriter();
                out.print(sb);
                out.flush();
                out.close();
            } catch (Exception e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

         /*
            宣传的新增
         */
        @RequestMapping(value = "/Pro_add",method = RequestMethod.POST)
        @ResponseBody
        public String inseeretbus(Dis_propagandatask dis_propagandatask){
            System.out.println("新增的dis_propagandatask为"+dis_propagandatask);
            System.out.println("进入！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            System.out.println("对象"+dis_propagandatask);
            ModelAndView mv=new ModelAndView();
            int i = propagandataskService.add_Pro(dis_propagandatask);
            if(i!=0){
                return "ok";
            }else{
                return "no";
            }

        }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/fingBy_Proid")
    public ModelAndView selectqueryByID(int id){
        System.out.println("根据id查询为"+id);
        ModelAndView mv=new ModelAndView();
        Dis_propagandatask dis = propagandataskService.query_ById(id);
        System.out.println("值在这里有"+dis);
        mv.addObject("outline",dis.getOutline());
        mv.addObject("releaseTime",dis.getReleaseTime());
        mv.addObject("failureTime",dis.getFailureTime());
        mv.addObject("status",dis.getStatus());
        mv.addObject("content",dis.getContent());
        mv.setViewName("/dispatch/propagandaTask_detail.html");
        return  mv;
    }

    /*
       修改
    */
    @RequestMapping(value = "/update_pro", method = RequestMethod.POST)
    public ModelAndView update(Dis_propagandatask dis_propagandatask){
        System.out.println("************************"+dis_propagandatask);
        ModelAndView mv=new ModelAndView();
        int i = propagandataskService.update_Pro(dis_propagandatask);
        if(i>0){
            System.out.println("1111111111111111111111111111");
            mv.setViewName("/dispatch/propagandaTask.html");
            return mv;
        }else{
            mv.setViewName("/dispatch/propagandaTask_detail.html");
            return mv;
        }
    }
}
