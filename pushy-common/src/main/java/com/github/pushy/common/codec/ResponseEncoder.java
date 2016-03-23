package com.github.pushy.common.codec;/**
 * Description : ResponseEncoder
 * Created by YangZH on 2016/3/22 0022
 *  15:28
 */

import com.github.pushy.common.pojo.response.Response;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Description : ResponseEncoder
 * Created by YangZH on 2016/3/22 0022
 * 15:28
 */

public class ResponseEncoder extends MessageToByteEncoder<Response> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext,
                          Response response, ByteBuf byteBuf) throws Exception {
        byte[] bytes = response.getData();
        if(bytes.length>=0){
            byteBuf.writeInt(bytes.length);
            byteBuf.writeByte(response.getType());
            byteBuf.writeByte(response.getStatusCode());
            byteBuf.writeBytes(bytes);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("ResponseEncode 出现异常！！！");
        cause.printStackTrace();
    }
}
