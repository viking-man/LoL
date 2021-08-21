package com.viking.domain.base.eventbus.listener;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.google.gson.Gson;
import com.viking.domain.base.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Slf4j
@Component
public class DefaultListener implements IEventListener {

    @Subscribe
    @AllowConcurrentEvents
    public void handleLanRecover(BaseEvent event) {
        log.info("DefaultListener receive event->{}", new Gson().toJson(event));

    }
}
