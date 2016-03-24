package org.code4j.pushy.common.pojo;

import io.netty.channel.Channel;

/**
 * Description : Connection
 * Created by code4j on 2016/3/11 0011
 * 21:54
 * 包装了channel对象，用来抽象一个长连接
 */

public class Connection {

    //一个长连接对应的channel
    private Channel channel;

    //发起方的ip地址
    private String ip;

    //发起方端口号
    private Integer port;

    //发起长连接时间戳
    private Long timestamp;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
