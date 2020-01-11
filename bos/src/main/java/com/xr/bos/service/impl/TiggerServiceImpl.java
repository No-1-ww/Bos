package com.xr.bos.service.impl;


import com.xr.bos.dao.TiggerMapper;
import com.xr.bos.model.Tigger;
import com.xr.bos.service.TiggerService;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TiggerServiceImpl implements TiggerService {

    //自动装配QuartzConfigration配置类中的Scheduler
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private TiggerMapper tiggerMapper;


  /*  @Override
    public void add(Tigger tigger) {
        tiggerMapper.add(tigger);
    }*/

    @Override
    @Scheduled(cron = "*/5 * * * * ?")
    public void refreshTrigger() {
        //定时更新任务这里是测试五分钟更新一次
        List<Tigger> jobList = tiggerMapper.getTriggers();
        System.out.println("jobList长度："+jobList.size());
        for (Tigger tigger:jobList){
            System.out.println(tigger);
        }
        if(jobList!=null||jobList.size()!=0){
            for (Tigger tigger :jobList){
                try{
                    CronScheduleBuilder scheduleBuilder =CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
                    //创建jobDetail(数据空中job_name村的任务全路径名，这里就可以动态的把任务注入到JobDetail中了)
                    JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>)Class.forName(tigger.getJobClass()) )
                            .withIdentity(tigger.getJobName(),tigger.getJobGroup())
                            .build();
                    //按照新的cronExpresession表达式构建一个新的triiger
                    CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                            .withIdentity(tigger.getTriggerName(),tigger.getTriggerGroup())
                            .withSchedule(scheduleBuilder)
                            .build();
                    //把trigger和job Detail 注入到调度器
                    scheduler.scheduleJob(jobDetail,cronTrigger);
                    scheduler.start();

                    Thread.sleep(2000);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Tigger> getTriggers() {
        return tiggerMapper.getTriggers();
    }
}
