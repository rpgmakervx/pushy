package com.github.pushy.test.handler;/**
 * Description : MessageDecoder
 * Created by YangZH on 2016/3/17 0017
 *  17:37
 */

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Description : MessageDecoder
 * Created by YangZH on 2016/3/17 0017
 * 17:37
 */

public class MessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext,
                          ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println("消息解码");
        int len = byteBuf.readInt();
        System.out.println("收到的消息长度："+len);
        if(byteBuf.array().length>4){
            if(len>0){
                byte[] bytes = new byte[len];
                byteBuf.readBytes(bytes);
                list.add(new String(bytes));
            }else{
                System.out.println("没有数据");
            }
        }else{
            System.out.println("消息头都没有。。。");
        }

    }
}
