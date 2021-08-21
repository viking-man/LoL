package com.viking.domain.base.eventbus.handler;

import com.google.common.eventbus.AsyncEventBus;
import com.viking.domain.base.eventbus.BaseEventBus;
import com.viking.domain.base.eventbus.listener.IEventListener;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Component
public class ListenerHandler {

    @Resource
    private BaseEventBus baseEventBus;

    @Autowired
    private List<IEventListener> listeners;

    @PostConstruct
    public void init() {
        if (CollectionUtils.isNotEmpty(listeners)) {
            for (IEventListener listener : listeners) {
                baseEventBus.register(listener);
            }
        }
    }
}
