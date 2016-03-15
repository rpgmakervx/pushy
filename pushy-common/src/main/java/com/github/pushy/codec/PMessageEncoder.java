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
        byte[] bytes = serializer.getBytes();
        int len = bytes.length;
        byteBuf.writeInt(len);
        if(len>0){
            byteBuf.writeBytes(bytes);
        }
    }
}
