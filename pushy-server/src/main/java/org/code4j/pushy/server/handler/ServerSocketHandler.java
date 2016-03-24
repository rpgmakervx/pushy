package org.code4j.pushy.server.handler;/**
 * Description : ServerChannelHandler
 * Created by YangZH on 2016/3/2 0002
 *  22:56
 */

import org.code4j.pushy.common.pojo.Connection;
import org.code4j.pushy.common.pojo.message.RequestMessage;
import org.code4j.pushy.common.pojo.message.Type;
import org.code4j.pushy.common.pojo.request.Request;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.code4j.pushy.server.session.Session;
import org.code4j.pushy.server.session.SessionImpl;

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
//        ChatRoomManager.cachedChannels.put(ctx.channel().id().toString(), connection);
//        ChatRoomManager.cachedChannelGroup.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        ChatRoomManager.cachedChannels.remove(ctx.channel().id().toString());
//        ChatRoomManager.cachedChannelGroup.remove(ctx.channel());
//        UserCache.cachedUsers.remove(ctx.channel().id().toString());
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Request request = (Request)msg;
        Session session = new SessionImpl(ctx.channel());
    }

    private void sendData(Request request){
        switch(request.getType()){
            case Type.USER:
                RequestMessage message =
                        RequestMessage.valueOf(request.getData());
                break;
            case Type.GROUP:
                break;
            case Type.CMD:
                break;
            case Type.PUSH:
                break;
            case Type.ALL:
                break;
        }
    }

}
