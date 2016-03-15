package com.github.pushy.client.handler;/**
 * Description : ClientSocketHandler
 * Created by YangZH on 2016/3/14 0014
 *  22:24
 */

import com.github.pushy.pojo.agreement.PMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Description : ClientSocketHandler
 * Created by YangZH on 2016/3/14 0014
 * 22:24
 */

public class ClientSocketHandler extends SimpleChannelInboundHandler<PMessage> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, PMessage pMessage) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }
}
