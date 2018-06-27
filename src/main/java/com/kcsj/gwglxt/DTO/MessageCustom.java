package com.kcsj.gwglxt.DTO;

import com.kcsj.gwglxt.entity.Message;
import com.kcsj.gwglxt.entity.Mobject;

public class MessageCustom {
    private Mobject mobject;

    private Message message;


    public Mobject getMobject() {
        return mobject;
    }

    public void setMobject(Mobject mobject) {
        this.mobject = mobject;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
