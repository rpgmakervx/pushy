package org.code4j.pushy.common.codec;

import org.code4j.pushy.common.pojo.request.Request;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Description : PMessageDecoder
 * Created by code4j on 2016/3/14 0014
 * 16:07
 *
 * 请求数据包格式：
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+
 * |  数据长度      |  请求类型   |  请求业务  |     数据     |
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+
 *  数据长度：4
 *  请求类型：1
 *  请求业务：1
 */

public class RequestDecoder extends ByteToMessageDecoder{

    @Override
    protected void decode(ChannelHandlerContext ctx,ByteBuf byteBuf,
                          List<Object> list) throws Exception {
        int len = byteBuf.readableBytes();
        System.out.println("进入解码器，可读数据长度："+len);
        //有数据的条件是 可读数据大于4，因为长度用int 4字节表示
        if(len>4){
            int dataLength = byteBuf.readInt();
            if(dataLength>=0){
                Request request = new Request();
                byte[] bytes = new byte[dataLength];
                request.setType(byteBuf.readByte());
                request.setAction(byteBuf.readByte());
                byteBuf.readBytes(bytes);
                request.setData(bytes);
                System.out.println("解码器解析出的对象："+request);
                list.add(request);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("RequestDecoder出现异常！！！");
        cause.printStackTrace();
    }
}
