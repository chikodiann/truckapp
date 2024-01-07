package com.ann.truckApp.events.listenersEvents;

import com.ann.truckApp.events.listenersRequest.EventRegister;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventRegisterListener implements ApplicationListener<EventRegister> {
    @Override
    public void onApplicationEvent(EventRegister event) {

    }
}
