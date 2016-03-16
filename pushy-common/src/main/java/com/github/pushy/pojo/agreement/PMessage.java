package com.github.pushy.pojo.agreement;/**
 * Description : PMessage
 * Created by YangZH on 2016/3/10 0010
 *  16:00
 */

import com.github.pushy.serial.Serializer;

/**
 * Description : PMessage
 * Created by YangZH on 2016/3/10 0010
 * 16:00
 */

public class PMessage extends Serializer{

    //消息头
    private Header header;
    //消息体
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "PMessage{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }

    @Override
    public void write() {
        write(header);
        write(body);
    }

    @Override
    public void read() {
        read(Header.class);
        read(Body.class);
    }
}
