package com.github.pushy.server.handler;/**
 * Description : ChildHandler
 * Created by YangZH on 2016/3/8 0008
 *  22:48
 */

import com.github.pushy.codec.PMessageDecoder;
import com.github.pushy.codec.PMessageEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Description : ChildHandler
 * Created by YangZH on 2016/3/8 0008
 * 22:48
 */

public class ServerChildChannelHandler extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel e) throws Exception {
        // 解码转 String
        e.pipeline().addLast(new StringDecoder());
        // 编码器 String
        e.pipeline().addLast(new StringEncoder());
        e.pipeline().addLast(new PMessageDecoder());
        e.pipeline().addLast(new PMessageEncoder());
        // 在管道中添加我们自己的接收数据实现方法
        e.pipeline().addLast(new ServerSocketHandler());
    }

}
