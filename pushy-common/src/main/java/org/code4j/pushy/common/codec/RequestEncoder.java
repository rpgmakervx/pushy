package org.code4j.pushy.common.codec;

import org.code4j.pushy.common.pojo.request.Request;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Description : PMessageEncoder
 * Created by code4j on 2016/3/11 0011
 * 22:57
 * 请求数据包格式：
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+
 * |  数据长度      |  请求类型   |  请求业务  |     数据     |
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+
 *  数据长度：4
 *  请求类型：1
 *  请求业务：1
 */

public class RequestEncoder extends MessageToByteEncoder<Request> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext,
                          Request request, ByteBuf byteBuf) throws Exception {
        System.out.println("进入编码阶段：");
        byte[] bytes = request.getData();
        System.out.println("封装消息："+bytes.length);
        int len = bytes.length;
        if(len>=0){
            byteBuf.writeInt(len);
            byteBuf.writeByte(request.getType());
            byteBuf.writeByte(request.getAction());
            byteBuf.writeBytes(bytes);
        }else{
            byteBuf.writeInt(0);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("RequestEncode 出现异常！！！");
        cause.printStackTrace();
    }
}
