package com.xr.bos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.bos.dao.BasDeliverystandardMapper;
import com.xr.bos.model.BasDeliverystandard;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyMenus;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.BasDeliverystandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BasDeliverystandardController {
    @Autowired
    private BasDeliverystandardService deliverystandardService;

    /**
     * 收派标准所有数据
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findDeliverystandardAll")
    public void findDeliverystandardAll(HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        System.out.println("进入findDeliverystandardAll方法。。。。");
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(limit));
        List<Map<String, Object>> list =deliverystandardService.findBasDeliverystandardAll();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
        StringBuffer sb=new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : list) {
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

    }

    /**
     * 打开增加页面
     * @param session
     * @return
     */
    @RequestMapping(value = "/deliveryStandard_add")
    public ModelAndView deliveryStandard_add( HttpSession session){
        SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
        List<Map<String, Object>> maps = deliverystandardService.findEmpNameAndUntisNameByID(syEmp.getID());
        ModelAndView mv=new ModelAndView();
        Date date=new Date();
        DateFormat df2 = DateFormat.getDateInstance();//可以精确到时分秒
        System.out.println(df2.format(date));
        mv.addObject("date",df2.format(date));
        mv.addObject("mps",maps);
        mv.setViewName("/basicData/deliveryStandard_add");
        return mv;


    }


    /**
     * 增加收派标准
     * @param minweight
     * @param maxweight
     * @param operationtime
     * @param session
     * @return
     */
    @RequestMapping(value = "/addBasDeliverystandard")
    public ModelAndView addBasDeliverystandard(String name,String invalidatemark,String minweight,String maxweight,String operationtime,HttpSession session){
    SyEmp syEmp =(SyEmp) session.getAttribute("SyEmp");
    BigDecimal min=new BigDecimal(minweight);
    BigDecimal max=new BigDecimal(maxweight);
        BasDeliverystandard deliverystandard =new BasDeliverystandard();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=sdf.parse(operationtime);
            deliverystandard.setOperationtime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    deliverystandard.setOperatorid(syEmp.getID());
    deliverystandard.setOperationunitid(syEmp.getEmpUnit());
    deliverystandard.setMinweight(min);
    deliverystandard.setMaxweight(max);
    deliverystandard.setName(name);
    deliverystandard.setInvalidatemark(invalidatemark);
    deliverystandardService.addBasDeliverystandard(deliverystandard);

        return new ModelAndView("/basicData/deliveryStandard");
    }


    /**
     * 打开编辑页面
     * @param ID
     * @return
     */
    @RequestMapping(value = "/opendeliveryStandard_update")
    public ModelAndView opendeliveryStandard_update(String ID){
        System.out.println(ID+"/////////////////");
        ModelAndView mv=new ModelAndView();
        mv.addObject("ID",ID);
        mv.setViewName("/basicData/deliveryStandard_update");

        return mv;
    }

    /**
     * 编辑页赋值
     * @param ID
     * @param responses
     */
    @RequestMapping(value = "/finddeliveryStandardByid")
    public void finddeliveryStandardByid(Integer ID,HttpServletResponse responses){
        System.out.println("finddeliveryStandardByid进入。。。");
        List<Map<String, Object>> list = deliverystandardService.findBasDeliverystanrdByID(ID);
        StringBuffer sb=new StringBuffer();
        //多表查询
        for (Map<String, Object> map : list) {
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            sb.append("{");
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object o = map.get(key);
                sb.append("\"" + key + "\":\"" + o + "\",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("}");

        }
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
    }


    /**
     * 修改
     * @param ID
     * @param name
     * @param invalidatemark
     * @param minweight
     * @param maxweight
     * @param operationtime
     * @return
     */
    @RequestMapping(value = "/updateBasDeliverstanrd")
    public ModelAndView updateBasDeliverstanrd(String ID,String name,String invalidatemark,String minweight,String maxweight,String operationtime){
        System.out.println(invalidatemark+".././././././.");
        BigDecimal min=new BigDecimal(minweight);
        BigDecimal max=new BigDecimal(maxweight);
        BasDeliverystandard deliverystandard =new BasDeliverystandard();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=sdf.parse(operationtime);
            deliverystandard.setOperationtime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        deliverystandard.setId(Integer.parseInt(ID));
        deliverystandard.setMinweight(min);
        deliverystandard.setMaxweight(max);
        deliverystandard.setName(name);
        deliverystandard.setInvalidatemark(invalidatemark);
        deliverystandardService.updateBasDeliverstanrd(deliverystandard);
        return new ModelAndView("/basicData/deliveryStandard");
    }

    /**
     * 作废
     * @param ID
     * @return
     */
    @RequestMapping(value = "/deleteBasDeliverstanrd")
    public ModelAndView deleteBasDeliverstanrd(String ID){
        System.out.println("作废。。。。"+ID+"........");
        //String invalidatemark="true";
        BasDeliverystandard bs=new BasDeliverystandard();

        bs.setId(Integer.parseInt(ID));
        deliverystandardService.deleteBasDeliverstanrd(bs);
        return new ModelAndView("/basicData/deliveryStandard");
    }


    //查询操作人
    @RequestMapping(value = "/findOperatorID")
    public void  findOperatorID(HttpServletResponse responses){
        System.out.println("进入findOperatorID。。。。。。。。");
        List<SyEmp> list = deliverystandardService.findOperatorID();
        StringBuffer  sb=new StringBuffer("[");
        for (SyEmp s : list) {
            sb.append("{\"ID\":\"" +s.getID()+ "\", \"EmpName\":\"" +s.getEmpName() + "\"},");
        }
        // 去掉最后一个,号
        sb.append("]");
        sb.deleteCharAt(sb.lastIndexOf(","));
        responses.setCharacterEncoding("utf-8");
        responses.setContentType("text/html;charset=utf-8");
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
    }


    /**
     * 多条件查询
     * @param operatorid
     * @param name
     * @param maxweight
     * @param minweight
     * @param operationtime
     * @param invalidatemark
     * @param responses
     * @param page
     * @param limit
     */
    @RequestMapping(value = "/findBasDeliverystandardByNameAndInvalidateMark")
    public void findBasDeliverystandardByNameAndInvalidateMark( String operatorid,String name,String maxweight,String minweight,String operationtime,String invalidatemark,HttpServletResponse responses, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "limit", required = false) String limit){
        BasDeliverystandard deliverystandard =new BasDeliverystandard();
        BigDecimal min=null;
        if(minweight !=null && minweight !=""){
             min=new BigDecimal(minweight);
            deliverystandard.setMinweight(min);
        }
        BigDecimal max=null;
        if(maxweight !=null && maxweight !=""){
            max=new BigDecimal(maxweight);
            deliverystandard.setMaxweight(max);
        }

        if(operationtime !=null&&operationtime!=""){
            System.out.println(operationtime+"////");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            //DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                System.out.println("字符串即将转换为Date");
                Date date=sdf.parse(operationtime);
                System.out.println("字符串已转换为Date");
                deliverystandard.setOperationtime(date);
                System.out.println("set方法顺利");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("字符串转Date异常");
            }



            System.out.println(deliverystandard.getOperationtime());

        }

        if (operatorid !=null && operatorid!=""){
            deliverystandard.setOperatorid(Integer.parseInt(operatorid));
        }



        deliverystandard.setName(name);
        deliverystandard.setInvalidatemark(invalidatemark);
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(limit));
        List<Map<String, Object>> list = deliverystandardService.findBasDeliverystandardByNameAndInvalidateMark(deliverystandard);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
        StringBuffer sb=new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":" + pageInfo.getTotal() + ",\"data\":[");
        for (Map<String, Object> map : list) {
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

    }

}
