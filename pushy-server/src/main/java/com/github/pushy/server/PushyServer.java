package com.github.pushy.server;/**
 * Description : Launcher
 * Created by YangZH on 2016/3/8 0008
 *  22:40
 */

import com.github.pushy.server.handler.ServerChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Description : Launcher
 * Created by YangZH on 2016/3/8 0008
 * 22:40
 */

public final class PushyServer implements Runnable{

    private ChannelFuture f;
    private int port;

    public PushyServer(int port){
        this.port = port;
    }
    /**
     * 客户端填写启动端口
     */
    private void startup(){
        System.out.println("服务已启动");
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.childHandler(new ServerChildChannelHandler());
            // 端口可配
            f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
//
//    public static void main(String[] args) {
//        Header header = new Header();
//        header.setChannelId("123456");
//        header.setRemoteIp("192.168.1.1");
//        header.setStatusCode(0);
//        header.setToId("0000000");
//        header.setTypeCode(1);
//        Body body = new Body();
//        body.setContent("aloha!");
//        PMessage pMessage = new PMessage();
//        pMessage.setBody(body);
//        pMessage.setHeader(header);
//        System.out.println("serialize: "+pMessage.getBytes().length);
//    }

    @Override
    public void run() {
        startup();
    }
}
