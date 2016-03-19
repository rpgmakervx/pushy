package com.github.pushy.common.pojo.message;/**
 * Description : PMessage
 * Created by YangZH on 2016/3/10 0010
 *  16:00
 */

import com.github.pushy.common.pojo.agreement.Body;
import com.github.pushy.common.pojo.agreement.Header;
import com.github.pushy.common.serial.Serializer;

/**
 * Description : PMessage
 * Created by YangZH on 2016/3/10 0010
 * 16:00
 *
 * 传输过过程中的消息，并不暴露给客户端
 */

public class TransMessage extends Serializer{

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
    }

    @Override
    public void read() {
    }
}
