package com.github.pushy.codec;/**
 * Description : PMessageEncoder
 * Created by YangZH on 2016/3/11 0011
 *  22:57
 */

import com.github.pushy.serial.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Description : PMessageEncoder
 * Created by YangZH on 2016/3/11 0011
 * 22:57
 */

public class PMessageEncoder extends MessageToByteEncoder<Serializer> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext,
                          Serializer serializer, ByteBuf byteBuf) throws Exception {
        System.out.println("进入编码阶段："+serializer);
//        System.out.println("进入编码阶段："+serializer.getBytes());
        byte[] bytes = serializer.getBytes();
        System.out.println("封装消息："+bytes.length);
        int len = bytes.length;
        byteBuf.writeInt(len);
        if(len>0){
            byteBuf.writeBytes(bytes);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("encode 出现异常！！！");
        cause.printStackTrace();
    }
}
