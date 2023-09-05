package com.vdc.mmcs.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    private static final int POOL_SIZE = 10;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler Scheduler = new ThreadPoolTaskScheduler();
        Scheduler.setPoolSize(POOL_SIZE);
        Scheduler.setThreadNamePrefix("scheduled-task-pool-");
        Scheduler.initialize();

        scheduledTaskRegistrar.setTaskScheduler(Scheduler);
    }

}
