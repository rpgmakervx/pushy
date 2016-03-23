package com.github.pushy.client.handler;/**
 * Description : ClientSocketHandler
 * Created by YangZH on 2016/3/14 0014
 *  22:24
 */

import com.github.pushy.client.manager.MessageManager;
import com.github.pushy.common.pojo.response.Response;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Description : ClientSocketHandler
 * Created by YangZH on 2016/3/14 0014
 * 22:24
 */

public class ClientSocketHandler extends ChannelHandlerAdapter {

    private MessageManager messageManager;

    public ClientSocketHandler(MessageManager messageManager){
        this.messageManager = messageManager;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Response response = (Response) msg;
        System.out.println("客户端收到消息 "+response);

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
