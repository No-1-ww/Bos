package com.xr.bos.controller;

import com.xr.bos.model.SorCheckBound;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.*;
import com.xr.bos.util.DateFormat;
import org.apache.shiro.web.session.HttpServletSession;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SorCheckBoundController {
    @Autowired
    private SorCheckBoundService sorCheckBoundService;

    @Autowired
    private SyUnitsService syUnitsService;

    @Autowired
    private SorCheckBoundDetailsService sorCheckBoundDetailsService;
    /*
    * layUI绑定数据
    * */
    @RequestMapping(value = "/queryAllCheckBound",produces = "text/String;charset=UTF-8")
    public void queryAll(int page, int limit, HttpServletResponse response){
        //如果加上了
        //传入map集合暂时代替pageHelper
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");

        Map<String,Integer> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        List<Map<String, Object>> list = sorCheckBoundService.queryAllSorCheckBound(map);
        //格式化时间
        List<Map<String, Object>> list1 = DateFormat.formatMap(list, "CheckDate");
        Integer count = sorCheckBoundService.querySorCheckBoundCount();
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":[");
        for (Map<String, Object> stringObjectMap : list1) {
            sb.append("{\"ID\":\""+stringObjectMap.get("ID")+
                    "\",\"ScanID\":\""+stringObjectMap.get("ScanID")+
                    "\",\"CargoSum\":\""+stringObjectMap.get("CargoSum")+
                    "\",\"CheckPerson\":\""+stringObjectMap.get("CheckPerson")+
                    "\",\"CheckDate\":\""+stringObjectMap.get("CheckDate")+
                    "\",\"CheckCompany\":\""+stringObjectMap.get("CheckCompany")+ "\"},");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]}");
        System.out.println(sb);
        try {
            PrintWriter out = response.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增盘库
     */
    @RequestMapping("/SorCheckBound/Check_add")
    public ModelAndView goToCheckAdd(HttpSession session){
        ModelAndView mv = new ModelAndView();
        String s = sorCheckBoundService.queryMaxID();
        //截取包前不包后
        String first = s.substring(0,s.lastIndexOf("D")+1);
        String last = s.substring(s.lastIndexOf("D")+1);
        Integer lastInt = Integer.parseInt(last);
        lastInt+=1;
        mv.addObject("CheckID",first+lastInt);

        //得到所有的扫描设备绑定至前台
        List<Map<String, Object>> list = sorCheckBoundService.queryScan();
        mv.addObject("Scan",list);


        mv.setViewName("/sortingManagement/check_add");


        SyEmp syEmp = (SyEmp)session.getAttribute("SyEmp");
        SyUnits syUnits = syUnitsService.findID(syEmp.getEmpUnit());
        //得到盘库人和盘库单位绑定之前太
        mv.addObject("CheckPerson",syEmp.getEmpName());
        mv.addObject("CheckCompany",syUnits.getName());
        String now = DateFormat.getNow();
        //系统当前时间绑定至前台
        mv.addObject("Now",now);



        return mv;
    }


    @Autowired
    private SyEmpService syEmpService;

    @RequestMapping(value = "/SorCheckBound/addCheckBound",produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String addCheckBound(SorCheckBound  sorCheckBound,String cargoCount,String weight,String volume,String cargoType,String storagePerson
    ,String direction,HttpSession session){
        System.out.println(sorCheckBound);
        System.out.println(cargoCount);
        System.out.println(weight);
        System.out.println(volume);
        System.out.println(storagePerson);
        System.out.println(direction);
        String checkID = sorCheckBound.getID();
        //得到盘库人ID和盘库单位
        SyEmp syEmp1 = (SyEmp)session.getAttribute("SyEmp");
        sorCheckBound.setCheckPerson(syEmp1.getID());

        SyUnits syUnits = syUnitsService.findID(syEmp1.getEmpUnit());
        sorCheckBound.setCheckCompany(syUnits.getName());

        //新增盘库单

        //分解得到的所有前台详情数据进行解析
        sorCheckBoundService.addSorCheckBound(sorCheckBound);
        String[] cargoCounts = cargoCount.split(",");
        String[] weights = weight.split(",");
        String[] volumes = volume.split(",");
        String[] cargoTypes = cargoType.split(",");
        String[] storagePersons = storagePerson.split(",");
        String[] directions = direction.split(",");
        //新增详情
        for (int i=0;i<cargoCounts.length;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("CheckID", sorCheckBound.getID());
            map.put("CargoCount",cargoCounts[i]);
            map.put("Weight",weights[i]);
            map.put("Volume",volumes[i]);
            map.put("CargoType",cargoTypes[i]);
            //把
            SyEmp check = syEmpService.check(storagePersons[i]);
            map.put("Direction",directions[i]);
            map.put("StoragePerson",check.getID());
            map.put("StorageDate",DateFormat.getNow());

            sorCheckBoundDetailsService.addSorCheckBoundDetails(map);

        }
        return "ok";
    }


    //goto修改页面
    @RequestMapping(value = "/SorCheckBound/goUpDateCheckBound",produces = "text/String;charset=UTF-8")
    @ResponseBody
    public ModelAndView goToUpdateCheckBound(String checkID){
        ModelAndView mv = new ModelAndView();
        System.out.println(checkID);
        Map<String, Object> list = sorCheckBoundService.queryByID(checkID);

        mv.setViewName("/sortingManagement/check_update");

        //格式化时间
        Map<String, Object> map = DateFormat.format(list, "CheckDate");
        //将所需要的数据绑定至前台便于修改
        String id = map.get("ID").toString();
        String ScanID = map.get("ScanID").toString();
        String CargoSum = map.get("CargoSum").toString();
        String CheckPerson = map.get("CheckPerson").toString();
        String CheckDate = map.get("CheckDate").toString();
        String CheckCompany = map.get("CheckCompany").toString();
        mv.addObject("ID",id);
        mv.addObject("ScanID",ScanID);
        mv.addObject("CargoSum",CargoSum);
        mv.addObject("CheckPerson",CheckPerson);
        mv.addObject("CheckDate",CheckDate);
        mv.addObject("CheckCompany",CheckCompany);
        return mv;
    }


    //修改
    @RequestMapping(value = "/SorCheckBound/upDateCheckBound",produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String updateCheckBound(String ID,String cargoSum,String cPerson,String cCompany){
        SyEmp check = syEmpService.check(cPerson);
        Integer syEmpID = check.getID();
        Map<String,Object> map = new HashMap<>();
        map.put("checkID",ID);
        map.put("CheckPerson",syEmpID);
        map.put("CheckCompany",cCompany);
        map.put("CargoSum",cargoSum);

        //执行修改
        sorCheckBoundService.updateCheckBound(map);
        return "ok";
    }


    //删除
    @RequestMapping(value = "/SorCheckBound/deleteCheckBound",produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String deleteCheckBound(String ID){

        sorCheckBoundDetailsService.deleteCheckBoundDetails(ID);

        //执行删除
        sorCheckBoundService.deleteCheckBound(ID);
        return "ok";
    }

    //按条件进行查询
    @RequestMapping(value = "/SorCheckBound/queryWhereSorCheckBound",produces = "text/String;charset=UTF-8")
    public void queryWhere(String ID,String CheckCompany,String CheckPerson,String CheckDate,int page, int limit,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");

        System.out.println(ID);
        System.out.println(CheckCompany);
        System.out.println(CheckPerson);
        System.out.println(CheckDate);
        Map<String,Object> map = new HashMap<>();
        map.put("ID",ID);
        map.put("CheckCompany",CheckCompany);
        map.put("CheckPerson",CheckPerson);
        map.put("CheckDate",CheckDate);
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        List<Map<String, Object>> list = sorCheckBoundService.queryWhereSorCheckBound(map);
        Integer count = sorCheckBoundService.queryWhereSorCheckBoundCount(map);
        //格式化时间
        List<Map<String, Object>> list1 = DateFormat.formatMap(list,"CheckDate");
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":[");
        for (Map<String, Object> stringObjectMap : list1) {
            sb.append("{\"ID\":\""+stringObjectMap.get("ID")+
                    "\",\"ScanID\":\""+stringObjectMap.get("ScanID")+
                    "\",\"CargoSum\":\""+stringObjectMap.get("CargoSum")+
                    "\",\"CheckPerson\":\""+stringObjectMap.get("CheckPerson")+
                    "\",\"CheckDate\":\""+stringObjectMap.get("CheckDate")+
                    "\",\"CheckCompany\":\""+stringObjectMap.get("CheckCompany")+ "\"},");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]}");
        System.out.println(sb);
        try {
            PrintWriter out = response.getWriter();
            out.print(sb);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
