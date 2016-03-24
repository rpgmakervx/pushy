package org.code4j.pushy.common.serial;

import io.netty.buffer.*;

import java.nio.ByteOrder;

/**
 * Description : BufferFactory
 * Created by code4j on 2016/3/13 0013
 * 09:33
 */

public class BufferFactory {

    private static ByteBufAllocator byteBufAllocator = PooledByteBufAllocator.DEFAULT;

    public static ByteOrder BYTE_ORDER = ByteOrder.BIG_ENDIAN;

    public static ByteBuf getBuffer(){
        ByteBuf bytebuf = byteBufAllocator.heapBuffer().order(BYTE_ORDER);
        return bytebuf;
    }

    public static ByteBuf getBuffer(byte[] bytes){
        ByteBuf bytebuf = byteBufAllocator.heapBuffer().order(BYTE_ORDER);
        bytebuf.writeBytes(bytes);
        return bytebuf;
    }
}
