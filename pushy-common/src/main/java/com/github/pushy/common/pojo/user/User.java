package com.github.pushy.common.pojo.user;/**
 * Description : User
 * Created by YangZH on 2016/3/21 0021
 *  12:05
 */

import com.github.pushy.common.serial.Serializer;

/**
 * Description : User
 * Created by YangZH on 2016/3/21 0021
 * 12:05
 */

public class User extends Serializer{

    private String clientId;
    private String password;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void write() {
        writeString(clientId);
        writeString(password);
    }

    @Override
    public void read() {
        clientId = readString();
        password = readString();
    }
}
