package com.github.pushy.client.handler;/**
 * Description : ClientSocketHandler
 * Created by YangZH on 2016/3/14 0014
 *  22:24
 */

import com.github.pushy.pojo.agreement.PMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Description : ClientSocketHandler
 * Created by YangZH on 2016/3/14 0014
 * 22:24
 */

public class ClientSocketHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        PMessage pMessage = (PMessage) msg;
        System.out.println("收到服务器的消息：" + pMessage.getBody().getContent());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("创建客户端 "+ctx.channel().id().toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }
}
