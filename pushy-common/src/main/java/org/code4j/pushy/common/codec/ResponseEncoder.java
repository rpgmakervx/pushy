package org.code4j.pushy.common.codec;

import org.code4j.pushy.common.pojo.response.Response;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Description : ResponseEncoder
 * Created by code4j on 2016/3/22 0022
 * 15:28
 * 响应数据包格式：
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+——-----——+
 * |  数据长度     |  请求类型   |  请求业务   |  响应状态码  |    数据    |
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+——-----——+
 *  数据长度：4
 *  请求类型：1
 *  请求业务：1
 *  响应状态码：1
 */

public class ResponseEncoder extends MessageToByteEncoder<Response> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext,
                          Response response, ByteBuf byteBuf) throws Exception {
        byte[] bytes = response.getData();
        if(bytes.length>=0){
            byteBuf.writeInt(bytes.length);
            byteBuf.writeByte(response.getType());
            byteBuf.writeByte(response.getAction());
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
