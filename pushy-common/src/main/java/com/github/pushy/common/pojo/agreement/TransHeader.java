package com.github.pushy.common.pojo.agreement;/**
 * Description : Header
 * Created by YangZH on 2016/3/10 0010
 *  15:22
 */

import com.github.pushy.common.serial.Serializer;
import com.github.pushy.common.util.TimeUtil;

import java.util.Date;

/**
 * Description : Header
 * Created by YangZH on 2016/3/10 0010
 * 15:22
 */

public class TransHeader extends Serializer implements IHeader{

    //消息的channel id
    private String senderId;

    private byte statusCode;

    private byte messageType;

    private String toId;

    private String timestamp = TimeUtil.getFormatString(new Date());

    public byte getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(byte statusCode) {
        this.statusCode = statusCode;
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

    public byte getMessageType() {
        return messageType;
    }

    public void setMessageType(byte messageType) {
        this.messageType = messageType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Header{" +
                "senderId='" + senderId + '\'' +
                ", statusCode=" + statusCode +
                ", messageType=" + messageType +
                ", toId='" + toId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    @Override
    public void write() {
        writeString(senderId);
        writeByte(statusCode);
        writeByte(messageType);
        writeString(toId);
        writeString(timestamp);
    }

    @Override
    public void read() {
        this.senderId = readString();
        this.statusCode = readByte();
        this.messageType = readByte();
        this.toId = readString();
        this.timestamp = readString();
    }
}
