package com.github.pushy.common.pojo.agreement;/**
 * Description : Body
 * Created by YangZH on 2016/3/10 0010
 *  15:22
 */

import com.github.pushy.common.serial.Serializer;

/**
 * Description : Body
 * Created by YangZH on 2016/3/10 0010
 * 15:22
 */

//public class Body extends Serializer{
public class Body extends Serializer{

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Body{" +
                "content='" + content + '\'' +
                '}';
    }

    @Override
    public void write() {
        writeString(content);
    }

    @Override
    public void read() {
        this.content = readString();
    }
}