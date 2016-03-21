package com.github.pushy.common.pojo.agreement;/**
 * Description : Body
 * Created by YangZH on 2016/3/20 0020
 *  23:48
 */

import com.github.pushy.common.serial.Serializer;

/**
 * Description : Body
 * Created by YangZH on 2016/3/20 0020
 * 23:48
 */

public class Body extends Serializer{

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Body{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public void write() {
        writeString(message);
    }

    @Override
    public void read() {
        this.message = readString();
    }
}
