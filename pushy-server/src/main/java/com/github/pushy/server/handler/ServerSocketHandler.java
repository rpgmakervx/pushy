package com.github.pushy.server.handler;/**
 * Description : ServerChannelHandler
 * Created by YangZH on 2016/3/2 0002
 *  22:56
 */

import com.github.pushy.common.pojo.Connection;
import com.github.pushy.common.pojo.agreement.Body;
import com.github.pushy.common.pojo.agreement.Header;
import com.github.pushy.common.pojo.message.TransMessage;
import com.github.pushy.server.chache.ChannelCache;
import com.github.pushy.common.util.Constants;
import io.netty.channel.Channel;
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
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("读到一条消息");
        sendMessage((TransMessage)msg);
    }

    private void sendMessage(TransMessage message){
        byte statusCode = message.getHeader().getStatusCode();
        switch (statusCode){
            case Constants.MessageType.GROUP:
                System.out.println("群发");
                ChannelCache.cachedChannelGroup.writeAndFlush(message);
                break;
            case Constants.MessageType.POINT:
                System.out.println("单发");
                ChannelCache.cachedChannels.get(message.getHeader().getChannelId())
                        .getChannel().writeAndFlush(message);
                break;
        }
    }

    private void aloha(Channel channel){
        Header header = new Header();
        header.setStatusCode(Constants.StatusCode.SUCCESS);
        header.setToId(channel.id().toString());
        header.setMessageType(Constants.MessageType.POINT);
        Body body = new Body();
        body.setContent("hello I am server!!");
        TransMessage transMessage = new TransMessage();
        transMessage.setBody(body);
        transMessage.setHeader(header);
        System.out.println("回写给客户端");
        channel.writeAndFlush(transMessage);
    }
}
