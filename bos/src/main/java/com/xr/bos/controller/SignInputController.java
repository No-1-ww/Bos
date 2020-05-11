package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.model.Dis_workordersign;
import com.xr.bos.service.SignInputService;
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
public class SignInputController {
    @Autowired
    private SignInputService signInputService;

    @RequestMapping(value = "/query_SigInput")
    public void select(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入方法.....");
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<Map<String, Object>> queryall = signInputService.queryall();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(queryall);
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : queryall) {

            /*Object signType = map.get("signType");
            System.out.println(signType+"%%%%%%%%%%%%%%%%%%%%%%%%%%");
            if(signType == true)){
                map.put("signType","正常签收");
            }else if(signType==2=)){
                map.put("signType","反向签收");
            }*/
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

    /**
     * 新增前的显示
     * @return
     */
    @RequestMapping(value = "/signInput_add")
    public ModelAndView query_work(){
        String s1 = signInputService.query_gzd();
        String yuanlai1 = s1.substring(0, 3);
        String now2 = s1.substring(3);
        int i1 = Integer.parseInt(now2) + 1;
        System.out.println(yuanlai1+i1);
        ModelAndView mv=new ModelAndView();
        mv.addObject("workSheetNo",yuanlai1+i1);
        mv.setViewName("/dispatch/signInput_add");
        return mv;
    }

    /**
     * 新增
     * @param dis_workordersign
     * @return
     */
    @RequestMapping(value = "/sig_add",method = RequestMethod.POST)
    @ResponseBody
    public String inseeretbus(String workSheetNo, Dis_workordersign dis_workordersign){
        System.out.println("新增的workSheetNo为"+workSheetNo);
        System.out.println("进入！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
        System.out.println("对象"+dis_workordersign);
        ModelAndView mv=new ModelAndView();
        int i = signInputService.addSig(dis_workordersign);
        if(i!=0){
            return "ok";
        }else{
            return "no";
        }
    }

    /**
     * 根据id查询
     * @param workSheetNo
     * @return
     */
    @RequestMapping(value = "/queryBy_id")
    public ModelAndView selectByID(String workSheetNo){
        System.out.println("根据id查询为"+workSheetNo);
        ModelAndView mv=new ModelAndView();
        Dis_workordersign acc = signInputService.queryById(workSheetNo);
        System.out.println("值在这里有"+acc);
        mv.addObject("workOrderID",acc.getWorkOrderID());
        mv.addObject("workSheetNo",acc.getWorkSheetNo());
        mv.addObject("workOrderType",acc.getWorkOrderType());
        mv.addObject("signType",acc.getSignType());
        mv.addObject("inputID",acc.getInputID());
        mv.addObject("inputPersonCode",acc.getInputPersonCode());
        mv.addObject("inputPersonID",acc.getInputPersonID());
        mv.addObject("recipient",acc.getRecipient());
        mv.addObject("courierName",acc.getCourierName());
        mv.setViewName("/dispatch/signlnput_update");
        return  mv;
    }


    @RequestMapping(value = "/update_Sign",method = RequestMethod.POST)
    public ModelAndView update(String workSheetNo,Dis_workordersign dis_workordersign){
        System.out.println("************************"+dis_workordersign);
        System.out.println("************************"+workSheetNo);
        ModelAndView mv=new ModelAndView();
        int i = signInputService.update_Sig(dis_workordersign);
        System.out.println("看一下修改后的值"+i);
        if(i>0){
            mv.setViewName("/dispatch/signInput");
            return mv;
        }else{
            mv.setViewName("/dispatch/signlnput_update");
            return mv;
        }
    }
}
