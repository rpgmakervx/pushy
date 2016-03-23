package com.github.pushy.common.pojo.request;/**
 * Description : Request
 * Created by YangZH on 2016/3/21 0021
 *  23:09
 */

import java.util.Arrays;

/**
 * Description : Request
 * Created by YangZH on 2016/3/21 0021
 * 23:09
 */

public class Request {

    /**
     * 请求中的消息类型（详见com.github.pushy.common.pojo.message.Type）
     */
    private byte type;

    /**
     * 请求的业务（详见com.github.pushy.common.pojo.message.StatusCode）
     */
    private byte action;

    /**
     * 请求数据（Serializer子类序列化或json字符串序列化）
     */
    private byte[] data;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", action=" + action +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
