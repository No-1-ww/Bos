package com.xr.bos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Html {

    @GetMapping("/login")
    public String login(){
        return "/login.html";
    }

    //首页
    @GetMapping("/workbench")
    public String workbench(){
        return "workbench";
    }

    //收派标准
    @GetMapping("/basicData/deliveryStandard")
    public String deliveryStandard(){
        return "/basicData/deliveryStandard";
    }

    //基础档案
    @GetMapping("/basicData/basicArchives")
    public String basicArchives(){
        return "/basicData/basicArchives";
    }

    //班车设置
    @GetMapping("/basicData/shuttleBusSet")
    public String shuttleBusSet(){
        return "/basicData/shuttleBusSet";
    }

    //取派员设置
    @GetMapping("/basicData/dispatchingPersonnelSet")
    public String dispatchingPersonnelSet(){
        return "/basicData/shuttleBusSet";
    }

    //区域设置
    @GetMapping("/basicData/areaSet")
    public String areaSet(){
        return "/basicData/areaSet";
    }

    //管理分区
    @GetMapping("/basicData/partition")
    public String partition(){
        return "/basicData/partition";
    }

    //管理定区
    @GetMapping("/basicData/zone")
    public String zone(){
        return "/basicData/zone";
    }

    //收派时间管理
    @GetMapping("/basicData/deliveryTime")
    public String deliveryTime(){
        return "/basicData/deliveryTime";
    }

    //单位管理
    @GetMapping("/systemManagement/sysUnit")
    public String sysUnit(){
        return "/systemManagement/sysUnit";
    }

    //员工管理
    @GetMapping("/systemManagement/sysEmp")
    public String sysEmp(){
        return "/systemManagement/sysEmp";
    }


    //栏目管理
    @GetMapping("/systemManagement/sysMenu")
    public String sysMenu(){
        return "/systemManagement/sysMenu";
    }

    //角色管理
    @GetMapping("/systemManagement/sysRole")
    public String sysRole(){
        return "/systemManagement/sysRole";
    }

    //业务受理
    @GetMapping("/acceptance/businessAcceptance")
    public String businessAcceptance(){
        return "/acceptance/businessAcceptance";
    }

    //工作单快速录入
    @GetMapping("/acceptance/worksheetQuickInput")
    public String worksheetQuickInput(){
        return "/acceptance/worksheetQuickInput";
    }

    //工作单查询
    @GetMapping("/acceptance/worksheetQuery")
    public String worksheetQuery(){
        return "/acceptance/worksheetQuery";
    }

    //查台转单
    @GetMapping("/dispatch/checkTable")
    public String checkTable(){
        return "/dispatch/checkTable";
    }

    //人工调度
    @GetMapping("/dispatch/manualScheduling")
    public String manualScheduling(){
        return "/dispatch/manualScheduling";
    }

    //签收录入
    @GetMapping("/dispatch/signInput")
    public String signInput(){
        return "/dispatch/signInput";
    }

    //取消签收申请确认
    @GetMapping("/dispatch/cancelSignApplicationConfirmation")
    public String cancelSignApplicationConfirmation(){
        return "/dispatch/cancelSignApplicationConfirmation";
    }

    //宣传任务
    @GetMapping("/dispatch/propagandaTask")
    public String propagandaTask(){
        return "/dispatch/propagandaTask";
    }

    //返货申请
    @GetMapping("/return/returnApply")
    public String returnApply(){
        return "/return/returnApply";
    }

    //返货申请确认
    @GetMapping("/return/returnApplyConfirm")
    public String returnApplyConfirm(){
        return "/return/returnApplyConfirm";
    }
    //成生返货单
    @GetMapping("/return/returnInvoiceProduce")
    public String returnInvoiceProduce(){
        return "/return/returnInvoiceProduce";
    }

    //包装材料物品管理
    @GetMapping("/packagingMaterialManagement/packagingMaterialManagement")
    public String packagingMaterialManagement(){
        return "/packagingMaterialManagement/packagingMaterialManagement";
    }

    //入库管理
    @GetMapping("/packagingMaterialManagement/warehousingManagement")
    public String warehousingManagement(){
        return "/packagingMaterialManagement/warehousingManagement";
    }
    //出库管理
    @GetMapping("/packagingMaterialManagement/outboundManagement")
    public String outboundManagement(){
        return "/packagingMaterialManagement/outboundManagement";
    }
    //库存管理
    @GetMapping("/packagingMaterialManagement/inventoryManagement")
    public String inventoryManagement(){
        return "/packagingMaterialManagement/inventoryManagement";
    }
    //包装信息录入
    @GetMapping("/packing/packagingInformationInput")
    public String packagingInformationInput(){
        return "/packing/packagingInformationInput";
    }
    //包装信息查询
    @GetMapping("/packing/packagingInformationQuery")
    public String packagingInformationQuery(){
        return "/packing/packagingInformationQuery";
    }
    //大物流发货对照表
    @GetMapping("/largeLogisticsManagement/invoiceComparisonTable")
    public String invoiceComparisonTable(){
        return "/largeLogisticsManagement/invoiceComparisonTable";
    }


    //入库
    /*@GetMapping("")
    public String storage(){
        return "";
    }*/
    //出库
    @GetMapping("/sortingManagement/theLibrary")
    public String theLibrary(){
        return "/sortingManagement/theLibrary";
    }

    //盘库
    @GetMapping("/sortingManagement/check")
    public String check(){
        return "/sortingManagement/check";
    }
    //合包
    @GetMapping("/sortingManagement/package")
    public String packages(){
        return "/sortingManagement/package";
    }

    //拆包
    @GetMapping("/sortingManagement/unpacking")
    public String unpacking(){
        return "/sortingManagement/unpacking";
    }

    //出入库查询
    @GetMapping("/sortingManagement/outOfStorageQuery")
    public String outOfStorageQuery(){
        return "/sortingManagement/outOfStorageQuery";
    }
    //库存查询
    @GetMapping("/sortingManagement/stockQuery")
    public String stockQuery(){
        return "/sortingManagement/stockQuery";
    }

    //单货异常监控
    @GetMapping("/sortingManagement/singleCargoExceptionMonitoring")
    public String singleCargoExceptionMonitoring(){
        return "/sortingManagement/singleCargoExceptionMonitoring";
    }

    //合包查询
    @GetMapping("/sortingManagement/packageQuery")
    public String packageQuery(){
        return "/sortingManagement/packageQuery";
    }

    //出港配载
    @GetMapping("/portEntryManagement/departureStowage")
    public String departureStowage(){
        return "/portEntryManagement/departureStowage";
    }

    //进港分单
    @GetMapping("/portEntryManagement/entryOrder")
    public String entryOrder(){
        return "/portEntryManagement/entryOrder";
    }

    //提货管理
    @GetMapping("/portEntryManagement/deliveryManagement")
    public String deliveryManagement(){
        return "/portEntryManagement/deliveryManagement";
    }

    //出港配载查询
    @GetMapping("/portEntryManagement/departureStowageQuery")
    public String departureStowageQuery(){
        return "/portEntryManagement/departureStowageQuery";
    }

    //到达时间录入
    @GetMapping("/portEntryManagement/arrivalTimeInput")
    public String arrivalTimeInput(){
        return "/portEntryManagement/arrivalTimeInput";
    }
    //跟踪表登记
    @GetMapping("/physicalDistributionManagement/traceTableRegister")
    public String traceTableRegister(){
        return "/physicalDistributionManagement/traceTableRegister";
    }
    //跟踪表查询
    @GetMapping("/physicalDistributionManagement/traceTableQuery")
    public String traceTableQuery(){
        return "/physicalDistributionManagement/traceTableQuery";
    }
    //物流交接单查询
    @GetMapping("/physicalDistributionManagement/logisticsQuery")
    public String logisticsQuery(){
        return "/physicalDistributionManagement/logisticsQuery";
    }
    //时间统计
    @GetMapping("/physicalDistributionManagement/timeStatistics")
    public String timeStatistics(){
        return "/physicalDistributionManagement/timeStatistics";
    }
    //货量统计
    @GetMapping("/physicalDistributionManagement/volumeStatistics")
    public String volumeStatistics(){
        return "/physicalDistributionManagement/volumeStatistics";
    }

}
