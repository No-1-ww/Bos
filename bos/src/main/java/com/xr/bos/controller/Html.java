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
    //收派标准的添加
    @GetMapping("/deliveryStandard_add")
    public String deliveryStandard_add(){
        return "/basicData/deliveryStandard_add";
    }
    //收派标准的编辑
    @GetMapping("/deliveryStandard_update")
    public String deliveryStandard_update(){
        return "/basicData/deliveryStandard_update";
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
        return "/basicData/dispatchingPersonnelSet";
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

   //增加定区管理
   @GetMapping("/zone_add")
   public String zone_add(){
       return "/basicData/zone_add";
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
    //单位管理增加
    @GetMapping("sysUnit_add")
    public String sysUnit_add(){
        return
                "/systemManagement/sysUnit_add";
    }



    //员工管理
    @GetMapping("/systemManagement/sysEmp")
    public String sysEmp(){
        return "/systemManagement/sysEmp";
    }

    //添加员工
    @GetMapping("/sysEmp_add")
    public String sysEmp_add(){
        return "/systemManagement/sysEmp_add";
    }


       //栏目管理
    @GetMapping("/systemManagement/sysMenu")
    public String sysMenu(){
        return "/systemManagement/sysMenu";
    }
//  添加栏目
       @GetMapping("/sysMenu_add")
       public String sysMenu_add(){
           return
                   "/systemManagement/sysMenu_add";
       }

    //  修改栏目
    @GetMapping("/sysMenu_edit")
    public String sysMenu_edit(){
        return
                "/systemManagement/sysMenu_edit";
    }
    //角色管理
    @GetMapping("/systemManagement/sysRole")
    public String sysRole(){
        return "/systemManagement/sysRole";
    }
    //分配角色
    @GetMapping("/sysRole_distribution")
    public String sysRole_distribution(){
        return "/systemManagement/sysRole_distribution";
    }

    //添加角色
    @GetMapping("/sysRole_add")
    public String sysRole_add(){
        return "/systemManagement/sysRole_add";
    }
    //修改角色
  /*  @GetMapping("/sysRole_edit")
    public String sysRole_edit(){
        return "/systemManagement/sysRole_edit";
    }
*/
    //业务受理查询
    /*@GetMapping("/acceptance/businessAcceptance")
    public String businessAcceptance(){
        return "/acceptance/businessAcceptance";
    }*/

    //业务受理新增businessAcceptance_add
    /*@GetMapping("/businessAcceptance_add")
    public String businessAcceptance_add(){return "acceptance/businessAcceptance_add"; }
   */
    //业务受理修改
   /* @GetMapping("/businessAcceptance_update")
    public String businessAcceptance_update(){
        return "/acceptance/businessAcceptance_update";
    }
*/
    //工作单快速录入
   /* @GetMapping("/acceptance/worksheetQuickInput")
    public String worksheetQuickInput(){
        return "/acceptance/worksheetQuickInput";
    }
*/
    //工作单快速录入里面的新增businessAcceptance_add
   /* @GetMapping("/businessAcceptance_add")
    public String businessAcceptance_add1(){return "/acceptance/businessAcceptance_add";}
*/
    //工作单查询
   /* @GetMapping("/acceptance/worksheetQuery")
    public String worksheetQuery(){
        return "/acceptance/worksheetQuery";
    }
*/
    //工作单查询修改dispatchingPersonnelSet_update
    /*@GetMapping("/dispatchingPersonnelSet_update")
    public String dispatchingPersonnelSet_update(){
        return "/acceptance/dispatchingPersonnelSet_update";
    }
*/

    //查台转单
    @GetMapping("/dispatch/checkTable")
    public String checkTable(){
        return "/dispatch/checkTable";
    }

    //查台转单的转单singleTurn
    @GetMapping("/singleTurn")
    public String singleTurn(){return "/dispatch/singleTurn"; }

    //人工调度
    @GetMapping("/dispatch/manualScheduling")
    public String manualScheduling(){
        return "/dispatch/manualScheduling";
    }

    //人工调度distribution
    @GetMapping("/distribution")
    public String distribution(){return "/dispatch/distribution"; }

    //人工详情manualScheduling_detail
    @GetMapping("/manualScheduling_detail")
    public String manualScheduling_detail(){return "/dispatch/manualScheduling_detail"; }

    //签收录入
    @GetMapping("/dispatch/signInput")
    public String signInput(){
        return "/dispatch/signInput";
    }

    //签收录入新增signInput_add
    @GetMapping("/signInput_add")
    public String signInput_add(){ return "/dispatch/signInput_add"; }

    //签收录入的修改signlnput_update
    @GetMapping("/signlnput_update")
    public String signlnput_update(){return "/dispatch/signlnput_update";}

    //签收录入的详情
    @GetMapping("/signInput_detail")
    public String signInput_detail(){return "/dispatch/signInput_detail"; }

    //取消签收申请确认
    @GetMapping("/dispatch/cancelSignApplicationConfirmation")
    public String cancelSignApplicationConfirmation(){
        return "/dispatch/cancelSignApplicationConfirmation";
    }

    //取消签收申请确认 新增 cancelSignApplicationConfirmation_add
    @GetMapping("/cancelSignApplicationConfirmation_add")
    public String cancelSignApplicationConfirmation_add(){return "/dispatch/cancelSignApplicationConfirmation_add"; }

    //取消签收申请确认 详情 cancelSignApplicationConfirmation_detail
    @GetMapping("/cancelSignApplicationConfirmation_detail")
    public String cancelSignApplicationConfirmation_detail(){return "/dispatch/cancelSignApplicationConfirmation_detail"; }

    //宣传任务
    @GetMapping("/dispatch/propagandaTask")
    public String propagandaTask(){
        return "/dispatch/propagandaTask";
    }

    //宣传任务的 新增+修改 propagandaTask_add
    @GetMapping("/propagandaTask_add")
    public String propagandaTask_add(){return "/dispatch/propagandaTask_add"; }

    //宣传任务的 详情propagandaTask_detail
    @GetMapping("/propagandaTask_detail")
    public String propagandaTask_detail(){return "/dispatch/propagandaTask_detail"; }

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

    //返货申请确认的新增returnApply_add
    @GetMapping("/returnApply_add")
    public String returnApply_add(){return "/return/returnApply_add"; }

    //返货申请确认的详情returnApply_detail
    @GetMapping("/returnApply_detail")
    public String returnApply_detail(){return "/return/returnApply_detail"; }

    //成生返货单
    @GetMapping("/return/returnInvoiceProduce")
    public String returnInvoiceProduce(){
        return "/return/returnInvoiceProduce";
    }

    //生成返货单的成生返货单returnInvoiceProduce_add
    @GetMapping("/returnInvoiceProduce_add")
    public String returnInvoiceProduce_add(){return "/return/returnInvoiceProduce_add"; }

    //生成返货单的详情returnInvoiceProduce_detail
    public String returnInvoiceProduce_detail(){return "/return/returnInvoiceProduce_detail"; }

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
  /*  @GetMapping("/sortingManagement/storage")
    public String storage(){
        return "/sortingManagement/storage";
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
