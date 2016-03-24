package org.code4j.pushy.common.pojo.user;/**
 * Description : User
 * Created by YangZH on 2016/3/21 0021
 *  12:05
 */

import org.code4j.pushy.common.serial.Serializer;

/**
 * Description : User
 * Created by YangZH on 2016/3/21 0021
 * 12:05
 */

public class User extends Serializer{

    private long clientId;
    private String password;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
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
        writeLong(clientId);
        writeString(password);
    }

    @Override
    public void read() {
        clientId = readLong();
        password = readString();
    }
}
