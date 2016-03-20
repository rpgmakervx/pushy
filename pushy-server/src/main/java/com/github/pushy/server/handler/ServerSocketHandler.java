package com.github.pushy.server.handler;/**
 * Description : ServerChannelHandler
 * Created by YangZH on 2016/3/2 0002
 *  22:56
 */

import com.github.pushy.common.pojo.Connection;
import com.github.pushy.common.pojo.message.TransMessage;
import com.github.pushy.common.util.Constants;
import com.github.pushy.server.chache.ChannelCache;
import com.github.pushy.server.chache.UserCache;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.net.InetSocketAddress;

/**
 * Description : ServerChannelHandler
 * Created by YangZH on 2016/3/2 0002
 * 22:56
 */

public class ServerSocketHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("某一链接触发异常");
        cause.printStackTrace();
//        ChannelCache.cachedChannels.remove(ctx.channel().id().toString());
//        ChannelCache.cachedChannelGroup.remove(ctx.channel());
//        ctx.channel().close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //客户端地址信息
        System.out.println("新建连接" + ctx.channel().id());
        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        Connection connection = new Connection();
        connection.setChannel(ctx.channel());
        connection.setIp(inetSocketAddress.getAddress().getHostAddress());
        connection.setPort(inetSocketAddress.getPort());
        connection.setTimestamp(System.currentTimeMillis());
        ChannelCache.cachedChannels.put(ctx.channel().id().toString(), connection);
        ChannelCache.cachedChannelGroup.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ChannelCache.cachedChannels.remove(ctx.channel().id().toString());
        ChannelCache.cachedChannelGroup.remove(ctx.channel());
        UserCache.cachedUsers.remove(ctx.channel().id().toString());
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TransMessage transMessage = (TransMessage)msg;
        System.out.println("读到一条消息  "+transMessage.getContent());
        String senderChannelId = UserCache.cachedUsers.get(transMessage.getTransHeader().getSenderId());
        if(senderChannelId == null){
            UserCache.cachedUsers.put(transMessage.getTransHeader().getSenderId(),ctx.channel().id().toString());
        }
        sendMessage(transMessage);
    }

    private void sendMessage(TransMessage message){
        byte messageType = message.getTransHeader().getMessageType();
        switch (messageType){
            case Constants.MessageType.GROUP:
                System.out.println("群发");
                ChannelCache.cachedChannelGroup.writeAndFlush(message);
                break;
            case Constants.MessageType.SINGLE:
                System.out.println("单发");
                String toChannelId = UserCache.cachedUsers.get(message.getTransHeader().getToId());
                System.out.println("转成channelId是："+toChannelId);
                if (toChannelId == null){
//                    message.setContent("查无此人");
//                    toChannelId = UserCache.cachedUsers.get(message.getTransHeader().getSenderId());
//                    ChannelCache.cachedChannels.get(toChannelId)
//                            .getChannel().writeAndFlush(message);
                    return;
                }
                ChannelCache.cachedChannels.get(toChannelId)
                        .getChannel().writeAndFlush(message);
                break;
        }
    }

}
