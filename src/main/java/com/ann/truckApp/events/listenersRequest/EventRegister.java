package com.ann.truckApp.events.listenersRequest;

import com.ann.truckApp.domain.model.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class EventRegister extends ApplicationEvent {
    private final String otp;
    public EventRegister(Users source,String otp) {
        super(source);
        this.otp=otp;
    }
}
