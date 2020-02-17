package com.xr.bos.controller;

import com.alibaba.fastjson.JSONArray;
import com.xr.bos.model.*;
import com.xr.bos.service.*;
import com.xr.bos.util.DateFormat;
import com.xr.bos.util.RedisTemplateUtil;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class SorStorageController {

    @Autowired
    private SyUnitsService syUnitsService;

    @Autowired
    private SorStorageService sorStorageService;

    @Autowired
    private SyEmpService syEmpService;

    @Autowired
    private  RedisTemplateUtil redisTemplateUtil;
    //自动装配redis工具类
    @Autowired
    private SorStorageDetailsService sorStorageDetailsService;
    //自动装配订单详情的service

    /**
     * 查询所有入库信息
     * @return
     */
    @RequestMapping(value = "/sortingManagement/storage")
    public ModelAndView queryAll(){
        /*
        java.net.ConnectException: Connection refused: no further information
        连接异常
        String key = "com.xr.bos.controller.SorStorageController.queryAll";
        Object list = redisTemplateUtil.getList(key);
        ModelAndView mv = new ModelAndView();
        List<Map<String,Object>> sorStorages = null;
        if(list==null||list.equals("")){
             sorStorages =  sorStorageService.queryAll();
            List<Map<String, Object>> acceptDate = DateFormat.formatMap(sorStorages, "acceptDate");
            redisTemplateUtil.setList(key,acceptDate);
        }else{
             sorStorages = (List)list;
        }*/
        /*String key = "com.xr.bos.controller.SorStorageController.queryAll";
        Object list = redisTemplateUtil.getList(key);*/
        ModelAndView mv = new ModelAndView();
        List<Map<String,Object>>  sorStorages =  sorStorageService.queryAll();
        List<Map<String, Object>> acceptDate = DateFormat.formatMap(sorStorages, "acceptDate");
        mv.addObject("sorStorages",sorStorages);
        mv.setViewName("/sortingManagement/storage");
        String s = JSONArray.toJSONString(acceptDate);
        return mv;
    }


    /**
     * 查询所有，ajax方式
     * @return
     */
    @RequestMapping(value = "/sortingManagement/query",produces = "text/String;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String query(){
        List<Map<String,Object>>  sorStorages =  sorStorageService.queryAll();
        List<Map<String, Object>> acceptDate = DateFormat.formatMap(sorStorages, "acceptDate");
        String s = JSONArray.toJSONString(acceptDate);
        return s;
    }

    /**
     *新增入库页面
     */
    @GetMapping("/storage_add")
    public ModelAndView addstoAge( HttpSession session){
        //业务流程：登录的用户就是默认的收货人并且不能修改，发货人自由选择

        ModelAndView mv =new ModelAndView();
        mv.setViewName("/sortingManagement/storage_add");
        //得到该数据库最大单号+1绑定至前台
        String stoID = sorStorageService.queryMaxID();
        int sto = Integer.parseInt(stoID) + 1;
        //得到当前登录的用户
        SyEmp syEmp = (SyEmp)session.getAttribute("SyEmp");

        //订单号
        mv.addObject("stoID",sto);
        //收货人：当前登录用户
        mv.addObject("shouHuo",syEmp.getEmpName());

        //查询出当前登录的用户的所在公司信息

        SyUnits syUnits = syUnitsService.findID(syEmp.getEmpUnit());
        //再获得公司的名字，绑定至前台
        mv.addObject("SyUnitsName",syUnits.getName());

        String now = DateFormat.getNow();

        //当前的系统时间
        mv.addObject("now",now);

        //订单号
        /**
         * 注意订单ID和订单详情ID为同一个ID
         */
        Integer dDNumber = sto;

        mv.addObject("dDNumber",dDNumber);

        //查询所有的员工
        List<SyEmp> select = syEmpService.querySyEmp(syEmp.getID());
        mv.addObject("SyEmps",select);
        return mv;
    }

    /**
     * 新增入库信息：
     * 如果包裹属于初始入库状态
     * 那么不需要填写合包号以及一些东西
     * @return
     */
    @RequestMapping("/addStorage")
    @ResponseBody
    public ModelAndView addStorage(SorStorage sorStorage, SorStorageDetails sorStorageDetails, HttpSession session){
        SyEmp syEmp = (SyEmp) session.getAttribute("SyEmp");
        //得到当前登录的用户来设置收货人id
        Integer id = syEmp.getID();
        sorStorage.setAcceptPerson(id);
        //新增入库单和详情单
        sorStorageDetailsService.addSorStorageDetails(sorStorageDetails);
        sorStorageService.addStorage(sorStorage);
        ModelAndView mv = queryAll();
        return mv;
    }

    /**
     * 根据值改变去数据库取得对应的公司名称
     */
    @RequestMapping(value = "/queryUnitsName",produces = "text/String;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String queryUnitsName(Integer EmpUnitID){
        //传进来的
        if(EmpUnitID==null){
            return "";
        }
        /*
            redis
          java.net.ConnectException: Connection refused: no further information

        String key = "com.xr.bos.controller.SorStorageController.queryUnitsName"+EmpUnitID;
        Object str = redisTemplateUtil.getString(key);
        if(str==null||str==""){
            //跟据单位ID查询
            SyUnits syUnits = syUnitsService.findID(EmpUnitID);
            String name = syUnits.getName();
            redisTemplateUtil.setString(key,str);
            return name;
        }else{
            return str.toString();
        }*/
        SyUnits syUnits = syUnitsService.findID(EmpUnitID);
        String name = syUnits.getName();
        return name;
    }






    @Autowired
    private ExceptionRecordService exceptionRecordService;



    /**
     * 新增异常记录
     * @return
     */
    @RequestMapping("/ExceptionRecord_add")
    public ModelAndView exctionRecord(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sortingManagement/ExceptionRecord_add");


        //得到新增页面需要的页面数据

        String now = DateFormat.getNow();
        //当前的系统时间
        mv.addObject("now",now);

        //得到当前登录的用户
        SyEmp syEmp = (SyEmp)session.getAttribute("SyEmp");
        mv.addObject("SyEmpName",syEmp.getEmpName());
        return mv;
    }

    @RequestMapping("/addExceptionRecord")
    @ResponseBody
    public String addExceptionRecord(ExceptionRecord exceptionRecord,HttpSession session){
        //得到当前登录的用户和公司信息
        SyEmp syEmp = (SyEmp)session.getAttribute("SyEmp");
        SyUnits syUnits = syUnitsService.findID(syEmp.getEmpUnit());

        exceptionRecord.setHandleDate(exceptionRecord.getLaunchDate());

        exceptionRecord.setLaunchCompany(syUnits.getName());
        int exceID = exceptionRecordService.addExceptionRecord(exceptionRecord);
        if(exceID!=0){
            return "ok";
        }else{
            return "no";
        }

    }


    /**
     * 修改
     */
    @RequestMapping("/invoiceComparisonTable_add")
    public ModelAndView queryByID(Integer upDateStoID,HttpSession session){
         ModelAndView mv = new ModelAndView();
        mv.setViewName("/sortingManagement/invoiceComparisonTable_add");
        Map<String,Object> map = sorStorageService.queryByIDStorage(upDateStoID);

        Map<String, Object> storage = DateFormat.format(map, "acceptDate");
        mv.addObject("stoID",storage.get("id"));
        mv.addObject("acceptDate",storage.get("acceptDate"));
        mv.addObject("acceptPerson",storage.get("acceptPerson"));
        mv.addObject("acceptCompany",storage.get("acceptCompany"));
        //发货人，发货单位
        mv.addObject("deliveryPerson",storage.get("deliveryPerson"));
        mv.addObject("deliveryCompany",storage.get("deliveryCompany"));

        return mv;
    }

    /**
     *
     * @param name 员工姓名
     * @param SyUnitsName 员工所在公司名称
     * @return
     */
    @RequestMapping(value = "/invoiceComparisonTable_add/check",method = RequestMethod.POST,produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String check(String name,String SyUnitsName){
        SyEmp check = syEmpService.check(name);
        if(check==null){
            return "输入的姓名不存在";
        }
        System.out.println("111111111111111111111111111111111111111111111111111"+check.getEmpUnit());
        //姓名存在，那么把公司名字绑定到前台

        SyUnits syUnits = syUnitsService.findID(check.getEmpUnit());
        //如果该员工没有公司也是查询不到的
        return syUnits.getName();
    }

    /**
     * 修改
     * @param aPerson
     * @param dPerson
     * @param sorStorage
     * @param session
     * @return
     */
    @RequestMapping("/upDateSorStoage")
    public ModelAndView updateSorStoage(String aPerson,String dPerson,SorStorage sorStorage,HttpSession session){
        System.out.println("收货人"+aPerson);
        System.out.println("发货人："+dPerson);

        ModelAndView mv = new ModelAndView();
        //根据员工姓名查询ID
        SyEmp check = syEmpService.check(aPerson);
        SyEmp check1 = syEmpService.check(dPerson);
        sorStorage.setAcceptPerson(check.getID());
        sorStorage.setDeliveryPerson(check1.getID());
        System.out.println("更改后的对象：：：：：：：：：：：：：：：：：："+sorStorage);
        //调用修改方法
        sorStorageService.updateStorage(sorStorage);
        mv.setViewName("/sortingManagement/invoiceComparisonTable_add");
        return mv;
    }


    /**
     * 删除
     */
    @RequestMapping(value = "/deleteSorStoage",method = RequestMethod.POST,produces = "text/String;charset=UTF-8")
    @ResponseBody
    public String  deleteSorStorage(Integer ID){
        //由于query方法就是查询所有的直接返回query方法就是返回了前台所有的数据

        sorStorageService.deleteSorStorage(ID);
        sorStorageDetailsService.deleteSorStorageDetails(ID);
        return query();
    }







}
