package com.github.pushy.client.handler;/**
 * Description : ClientSocketHandler
 * Created by YangZH on 2016/3/14 0014
 *  22:24
 */

import com.github.pushy.client.listener.MessageListener;
import com.github.pushy.client.manager.MessageManager;
import com.github.pushy.common.pojo.message.TransMessage;
import com.github.pushy.common.util.Constants;
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
        TransMessage transMessage = (TransMessage) msg;
        System.out.println("客户端收到消息 "+msg);
        MessageListener listener = messageManager.getMessageListener();
        byte msgType = transMessage.getTransHeader().getMessageType();
        switch(msgType){
            case Constants.MessageType.GROUP:
                listener.onGroupMessageReceived(transMessage);
                break;
            case Constants.MessageType.SINGLE:
                listener.onSingleMessageReceived(transMessage);
                break;
            case Constants.MessageType.CMD:
                listener.onCMDMessage(transMessage);
                break;
        }

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
