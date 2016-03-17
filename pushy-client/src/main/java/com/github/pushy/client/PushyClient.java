package com.github.pushy.client;/**
 * Description : PushyClient
 * Created by YangZH on 2016/3/14 0014
 *  21:56
 */

import com.github.pushy.client.handler.ClientChildChannelHandler;
import com.github.pushy.pojo.agreement.PMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * Description : PushyClient
 * Created by YangZH on 2016/3/14 0014
 * 21:56
 */

public final class PushyClient {
    Bootstrap bootstrap = new Bootstrap();

    private Channel channel;

    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    private int port;

    private String remoteIp;

    public PushyClient(String remoteIp,int port){
        this.remoteIp = remoteIp;
        this.port = port;
    }
    /**
     * 初始化
     */
    private void init() {
        // 设置循环线程组事例
        bootstrap.group(workerGroup);
        // 设置channel工厂
        bootstrap.channel(NioSocketChannel.class);
        // 设置管道
        bootstrap.handler(new ClientChildChannelHandler());
    }

    /**
     * 连接
     * @throws InterruptedException
     */
    public void connect(){
        // 连接服务端
        init();
        ChannelFuture f = bootstrap.connect(new InetSocketAddress(this.remoteIp, this.port));
        try {
            f.sync();
            channel = f.channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("connect  channel状态："+channel.isActive());
    }

    /**
     * 关闭
     */
    public void shutdown() {
        workerGroup.shutdownGracefully();
    }

    /**
     * 获取会话
     *
     * @return
     */
    public Channel getChannel() {
        return channel;
    }

    /**
     * 发送消息
     * @param pMessage
     * @throws InterruptedException
     */
    public void sendMessage(PMessage pMessage){
        if(channel == null || !channel.isActive()){
            connect();
        }
        channel.writeAndFlush(pMessage);
    }
}
