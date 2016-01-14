package ru.hlink.quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzManager {
    public static void main(String args[]) throws SchedulerException, ParseException {
    	QuartzManager qm = new QuartzManager();
    	qm.excuteQuartz();
    }
    
    public void excuteQuartz(){
    	 // 通过过JobDetail封装TestJob，同时指定Job在Scheduler中所属组及名称
    	//  这里，组名为group_1，而名称为job_1。  
        JobDetail jobDetail= JobBuilder.newJob(TestJob.class)
                .withIdentity("job_1","group_1")
                .build();
        // 创建一个SimpleTrigger实例，指定该Trigger在Scheduler中所属组及名称。  
        // 接着设置调度的时间规则.当前时间运行  
/*        Trigger trigger= TriggerBuilder
                .newTrigger()
                .withIdentity("trigger_1","group_1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10) //时间间隔
                        .withRepeatCount(5)        //重复次数(将执行6次)
                        )
                .build();*/
        Trigger trigger= TriggerBuilder
                .newTrigger()
                .withIdentity("trigger_1","group_1")
                .startAt(new Date())
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10) //时间间隔
                        .withRepeatCount(5)        //重复次数(将执行6次)
                        )
                .build();
        
        try {
			// 通过SchedulerFactory获取一个调度器实例  
			Scheduler sched = new StdSchedulerFactory().getScheduler();
			// 注册并进行调度  
			sched.scheduleJob(jobDetail,trigger);
			
			sched.start();
			
//			sched.shutdown(false);
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}