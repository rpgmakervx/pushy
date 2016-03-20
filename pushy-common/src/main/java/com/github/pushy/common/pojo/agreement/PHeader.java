package com.github.pushy.common.pojo.agreement;/**
 * Description : PHeader
 * Created by YangZH on 2016/3/19 0019
 *  22:38
 */

import com.github.pushy.common.pojo.message.MessageType;

/**
 * Description : PHeader
 * Created by YangZH on 2016/3/19 0019
 * 22:38
 */

public class PHeader implements IHeader{

    private MessageType messageType;

    private String toId;

    private String senderId;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
}
