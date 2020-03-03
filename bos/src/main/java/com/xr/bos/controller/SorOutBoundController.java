package com.xr.bos.controller;

import com.xr.bos.model.SorOutBound;
import com.xr.bos.model.SorOutBoundDetails;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.SorOutBoundDetailsService;
import com.xr.bos.service.SorOutBoundService;
import com.xr.bos.service.SyEmpService;
import com.xr.bos.service.SyUnitsService;
import com.xr.bos.util.DateFormat;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SorOutBoundController {
    @Autowired
    private SorOutBoundService sorOutBoundService;

    @Autowired
    private SyUnitsService syUnitsService;

    @Autowired
    private SyEmpService syEmpService;

    /**
     * layui绑定数据表格
     * @param page
     * @param limit
     * @param response
     */
    @RequestMapping(value = "/queryAllOutBound",produces = "text/String;charset=UTF-8")
    public void queryAll(int page, int limit, HttpServletResponse response){
        //如果加上了
        //传入map集合暂时代替pageHelper
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");

        Map<String,Integer> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        List<Map<String, Object>> list = sorOutBoundService.queryAll(map);
        //格式化时间
        List<Map<String, Object>> list1 = DateFormat.formatMap(list, "EnterDate");
        //工具类原因只能格式化一个时间
        List<Map<String, Object>> list2 = DateFormat.formatMap(list1, "DeliveryDate");
        Integer count = sorOutBoundService.queryOutBoundCount();
        StringBuffer sb = new StringBuffer("{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":[");
        for (Map<String, Object> stringObjectMap : list2) {
            sb.append("{\"OutBoundID\":\""+stringObjectMap.get("OutBoundID")+
                    "\",\"HandoverType\":\""+stringObjectMap.get("HandoverType")+
                    "\",\"Line\":\""+stringObjectMap.get("Line")+
                    "\",\"Direction\":\""+stringObjectMap.get("Direction")+
                    "\",\"AcceptPerson\":\""+stringObjectMap.get("AcceptPerson")+
                    "\",\"Carriers\":\""+stringObjectMap.get("Carriers")+
                    "\",\"DeliveryPerson\":\""+stringObjectMap.get("DeliveryPerson")+
                    "\",\"DeliveryDate\":\""+stringObjectMap.get("DeliveryDate")+
                    "\",\"DeliveryCompany\":\""+stringObjectMap.get("DeliveryCompany")+
                    "\",\"EnterPerson\":\""+stringObjectMap.get("EnterPerson")+
                    "\",\"EnterDate\":\""+stringObjectMap.get("EnterDate")+"\"},");
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

    @GetMapping("/sortingManagement/theLibrary")
    public String theLibrary(){
        return "/sortingManagement/theLibrary";
    }
    @RequestMapping("/sortingManagement/theLibrary_add")
    public ModelAndView goAddSorOutBound(HttpSession session){
        //进入新增页面进行绑定数据
        SyEmp syEmp1 = (SyEmp)session.getAttribute("SyEmp");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sortingManagement/theLibrary_add");
        SyUnits syUnits = syUnitsService.findID(syEmp1.getEmpUnit());
        String name = syUnits.getName();
        //交货人的公司名称
        mv.addObject("syUnitName",name);
        mv.addObject("SyEmpName",syEmp1.getEmpName());
        //查询当前登录用户外的所有用户（交货人）
        List<SyEmp> syEmps = syEmpService.querySyEmp(syEmp1.getID());
        mv.addObject("SyEmps",syEmps);
        String now = DateFormat.getNow();
        List<SyEmp> select = syEmpService.select();
        //绑定线路资源
        mv.addObject("xianLu",select);
        //得到系统当前时间绑定至前台（交货时间）
        mv.addObject("Now",now);
        return mv;
    }

    @Autowired
    private SorOutBoundDetails sorOutBoundDetails;

    @Autowired
    private SorOutBoundDetailsService sorOutBoundDetailsService;

    @RequestMapping(value = "/addSorOutBound",produces = "text/String;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String addSorOutBound(SorOutBound sorOutBound,String packageID,String weight,String volume,String isScan,
                                 String isNextStorage,String isDoubleStorage,HttpSession session){
        SyEmp syEmp1 = (SyEmp)session.getAttribute("SyEmp");
        //新增出库交接单以及出库详情
        sorOutBound.setAcceptPerson(syEmp1.getID());
        sorOutBound.setEnterPerson(syEmp1.getID());
        sorOutBound.setEnterDate(Date.valueOf(DateFormat.getNow()));
        sorOutBound.setDirection(syEmp1.getEmpUnit());
        //先查询到最大的出库交接单
        String s = sorOutBoundService.queryMaxOutBoundID();
        String d = s.substring(s.indexOf("D")+1);
        int outID = Integer.parseInt(d);
        outID++;
        String outBoundID = "CKJJD"+outID;
        //+1后绑定给出库交接单
        sorOutBound.setOutBoundID(outBoundID);
        //新增出库交接单
        sorOutBoundService.addOutBound(sorOutBound);


        //得到订单的数据以后用split进行分割
        String[] packageIDs = packageID.split(",");
        String[] weights = weight.split(",");
        String[] volumes = volume.split(",");
        String[] isScans = isScan.split(",");
        String[] isNextStorages = isNextStorage.split(",");
        String[] isDoubleStorages = isDoubleStorage.split(",");
        System.out.println(Date.valueOf(DateFormat.getNow()));
        //新增订单详情
        for (int i=0;i<packageIDs.length;i++){
            sorOutBoundDetails.setPackageID(packageIDs[i]);
            sorOutBoundDetails.setWeight(Integer.parseInt(weights[i]));
            sorOutBoundDetails.setVolume(Integer.parseInt(volumes[i]));
            sorOutBoundDetails.setIsScan(Integer.parseInt(isScans[i]));
            sorOutBoundDetails.setIsNextStorage(Integer.parseInt(isNextStorages[i]));
            sorOutBoundDetails.setIsDoubleStorage(Integer.parseInt(isDoubleStorages[i]));
            if(Integer.parseInt(isScans[i])==1){
                sorOutBoundDetails.setScanDate(Date.valueOf(DateFormat.getNow()));
            }
            sorOutBoundDetails.setOutBoundID(outBoundID);
            sorOutBoundDetailsService.addSorOutBoundDetails(sorOutBoundDetails);
        }


        return "ok";
    }



}
