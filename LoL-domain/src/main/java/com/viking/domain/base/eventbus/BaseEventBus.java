package com.viking.domain.base.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.viking.domain.base.BaseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Component
public class BaseEventBus {
    private static final Logger log = LoggerFactory.getLogger(BaseEventBus.class);

    private final AsyncEventBus asyncEventBus;

    private final EventBus eventBus;

    public BaseEventBus(AsyncEventBus asyncEventBus, EventBus eventBus) {
        this.asyncEventBus = asyncEventBus;
        this.eventBus = eventBus;
    }

    public void register(Object handler) {
        asyncEventBus.register(handler);
        eventBus.register(handler);
    }

    public void post(BaseEvent event) {
        log.info("同步发送事件:{}", event.toString());
        eventBus.post(event);
    }

    public void asyncPost(BaseEvent event) {
        log.info("异步发送事件:{}", event.toString());
        asyncEventBus.post(event);
    }
}
