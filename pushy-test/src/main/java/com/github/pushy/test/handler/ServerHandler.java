package com.github.pushy.test.handler;/**
 * Description : ServerHandler
 * Created by YangZH on 2016/3/16 0016
 *  14:23
 */

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Description : ServerHandler
 * Created by YangZH on 2016/3/16 0016
 * 14:23
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {


    /**
     * 新客户端接入
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        ctx.channel().writeAndFlush("这是服务端回写消息");
    }

    /**
     * 客户端断开
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
    }

    /**
     * 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//
//    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println("客户端消息："+s);
        ctx.channel().writeAndFlush("hi");
    }
}
