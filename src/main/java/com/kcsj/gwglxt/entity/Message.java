package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-10
 */
public class Message {
    private String messageId;

    private String messageContent;

    private String messageTime;

    private Integer messageIsdelete;

    private Integer messageType;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }
    
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime == null ? null : messageTime.trim();
    }

    public Integer getMessageIsdelete() {
        return messageIsdelete;
    }

    public void setMessageIsdelete(Integer messageIsdelete) {
        this.messageIsdelete = messageIsdelete;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }
}