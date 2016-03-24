package org.code4j.pushy.common.pojo.response;

import org.code4j.pushy.common.pojo.request.Request;

import java.util.Arrays;

/**
 * Description : Response
 * Created by code4j on 2016/3/21 0021
 * 23:10
 */

public class Response {

    /**
     * 请求中的消息类型（详见详见org.code4j.pushy.common.pojo.message.Type）
     */
    private byte type;

    /**
     * 请求的业务（详见详见org.code4j.pushy.common.pojo.message.StatusCode）
     */
    private byte action;
    /**
     * 状态码（详见详见org.code4j.pushy.common.pojo.message.Action）
     */
    private byte statusCode;

    /**
     * 请求数据（Serializer子类序列化或json字符串序列化）
     */
    private byte[] data;

    public Response(){}
    public Response(Request request){
        this.setAction(request.getAction());
        this.setType(request.getType());
    }
    public Response(byte type, byte action, byte statusCode, byte[] data) {
        this.type = type;
        this.action = action;
        this.statusCode = statusCode;
        this.data = data;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(byte statusCode) {
        this.statusCode = statusCode;
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
        return "Response{" +
                "type=" + type +
                ", action=" + action +
                ", statusCode=" + statusCode +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
