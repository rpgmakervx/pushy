package com.github.pushy.codec;/**
 * Description : PMessageDecoder
 * Created by YangZH on 2016/3/14 0014
 *  16:07
 */

import com.github.pushy.pojo.agreement.PMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Description : PMessageDecoder
 * Created by YangZH on 2016/3/14 0014
 * 16:07
 */

public class PMessageDecoder extends ByteToMessageDecoder{

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext,
                          ByteBuf byteBuf, List<Object> list) throws Exception {
        PMessage pMessage = new PMessage();
        int len = byteBuf.readableBytes();
        //有数据的条件是 可读数据大于4，因为长度用int 4字节表示
        while(true){
            if(len>4){
                int dataLength = byteBuf.readInt();
                if(dataLength>0){
                    byte[] bytes = new byte[dataLength];
                    byteBuf.readBytes(bytes);
                    pMessage.readFromBytes(bytes);
                    list.add(pMessage);
                }else break;
            }else return;
        }
        return ;
    }
}
