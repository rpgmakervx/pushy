package com.github.pushy.test.handler;/**
 * Description : MessageEncoder
 * Created by YangZH on 2016/3/17 0017
 *  17:31
 */

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Description : MessageEncoder
 * Created by YangZH on 2016/3/17 0017
 * 17:31
 */

public class MessageEncoder extends MessageToByteEncoder<String> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext,
                          String s, ByteBuf byteBuf) throws Exception {
        System.out.println("进入编码"+s);
        int len = s.length();
        System.out.println("消息长度："+len);
        byteBuf.writeInt(len);
        byteBuf.writeBytes(s.getBytes());
    }
}
