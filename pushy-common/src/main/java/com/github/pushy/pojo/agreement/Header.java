package com.github.pushy.pojo.agreement;/**
 * Description : Header
 * Created by YangZH on 2016/3/10 0010
 *  15:22
 */

import com.github.pushy.serial.Serializer;

/**
 * Description : Header
 * Created by YangZH on 2016/3/10 0010
 * 15:22
 */

public class Header extends Serializer{

    //消息的channel id
    private String senderId;

    private Integer statusCode;

    private Integer typeCode;

    private String toId;

    public String getChannelId() {
        return senderId;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setSenderlId(String senderId) {
        this.senderId = senderId;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }


    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public String toString() {
        return "Header{" +
                "senderId='" + senderId + '\'' +
                ", statusCode=" + statusCode +
                ", typeCode=" + typeCode +
                ", toId='" + toId + '\'' +
                '}';
    }

    @Override
    public void write() {
        writeString(senderId);
        writeInt(statusCode);
        writeInt(typeCode);
        writeString(toId);
    }

    @Override
    public void read() {
        this.senderId = readString();
        this.statusCode = readInt();
        this.typeCode = readInt();
        this.toId = readString();
    }
}
