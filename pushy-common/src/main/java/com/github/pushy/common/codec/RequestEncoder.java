package com.github.pushy.common.codec;/**
 * Description : PMessageEncoder
 * Created by YangZH on 2016/3/11 0011
 *  22:57
 */

import com.github.pushy.common.pojo.request.Request;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Description : PMessageEncoder
 * Created by YangZH on 2016/3/11 0011
 * 22:57
 */

public class RequestEncoder extends MessageToByteEncoder<Request> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext,
                          Request request, ByteBuf byteBuf) throws Exception {
        System.out.println("进入编码阶段：");
//        System.out.println("进入编码阶段："+serializer.getBytes());
        byte[] bytes = request.getData();
        System.out.println("封装消息："+bytes.length);
        int len = bytes.length;
        if(len>=0){
            byteBuf.writeInt(len);
            byteBuf.writeByte(request.getType());
            byteBuf.writeBytes(bytes);
        }else{
            byteBuf.writeInt(0);
        }
        System.out.println("消息编码后总长度："+byteBuf.writerIndex());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("RequestEncode 出现异常！！！");
        cause.printStackTrace();
    }
}
