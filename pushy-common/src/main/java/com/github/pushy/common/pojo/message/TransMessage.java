package com.github.pushy.common.pojo.message;/**
 * Description : PMessage
 * Created by YangZH on 2016/3/10 0010
 *  16:00
 */

import com.github.pushy.common.pojo.agreement.TransHeader;
import com.github.pushy.common.serial.Serializer;

/**
 * Description : PMessage
 * Created by YangZH on 2016/3/10 0010
 * 16:00
 *
 * 传输过过程中的消息，并不暴露给客户端
 */

public class TransMessage extends Serializer implements IMessage{

    //消息头
    private TransHeader transHeader;
    //消息体
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TransHeader getTransHeader() {
        return transHeader;
    }

    public void setTransHeader(TransHeader transHeader) {
        this.transHeader = transHeader;
    }


    @Override
    public String toString() {
        return "PMessage{" +
                "header=" + transHeader +
                ", content=" + content +
                '}';
    }

    @Override
    public void write() {
        write(transHeader);
        writeString(content);
    }

    @Override
    public void read() {
        transHeader = read(TransHeader.class);
        content = readString();
    }
}
