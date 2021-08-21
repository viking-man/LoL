package com.viking.domain.base.config;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Configuration
@EnableAsync
public class SpringBeanConfig {

    @Bean
    public ThreadPoolTaskExecutor eventBusExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("device-bind-executor");
        threadPoolTaskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        threadPoolTaskExecutor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 4);
        threadPoolTaskExecutor.setKeepAliveSeconds(300);
        threadPoolTaskExecutor.setQueueCapacity(512);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean
    public AsyncEventBus asyncEventBus(@Qualifier(value = "eventBusExecutor") ThreadPoolTaskExecutor taskExecutor) {
        AsyncEventBus asyncEventBus = new AsyncEventBus("lol-event-bus", taskExecutor);
        return asyncEventBus;
    }

    @Bean
    public EventBus eventBus(@Qualifier(value = "eventBusExecutor") ThreadPoolTaskExecutor taskExecutor) {
        EventBus eventBus = new EventBus();
        return eventBus;
    }
}
