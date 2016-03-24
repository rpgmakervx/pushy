package org.code4j.pushy.common.pojo.message;/**
 * Description : AbstractMessage
 * Created by YangZH on 2016/3/19 0019
 *  14:04
 */

import org.code4j.pushy.common.serial.Serializer;

/**
 * Description : AbstractMessage
 * Created by code4j on 2016/3/19 0019
 * 14:04
 *
 * 仅仅定义一个抽象消息，为Builder构造消息准备
 * 消息包括消息内容（content）还有消息头（header）
 *
 * 消息在1.0.0版只分为：传输消息和用户消息
 * 传输消息不暴露给用户，只用来在netty搭建的网络传输部分。
 * 用户消息用来给客户端调用
 */

public class RequestMessage extends Serializer{
    private String message;

    private long targetId;

    private short action;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTargetId() {
        return targetId;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
    }

    public short getAction() {
        return action;
    }

    public void setAction(short action) {
        this.action = action;
    }

    public static RequestMessage valueOf(byte[] data){
        RequestMessage message = new RequestMessage();
        message.writeToTargetBuffer(data);
        return message;
    }
    @Override
    public void write() {
        writeString(message);
        writeLong(targetId);
        writeShort(action);
    }

    @Override
    public void read() {
        message = readString();
        targetId = readLong();
        action = readByte();
    }
}
