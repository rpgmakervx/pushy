package org.code4j.pushy.server.handler;/**
 * Description : ChildHandler
 * Created by YangZH on 2016/3/8 0008
 *  22:48
 */

import org.code4j.pushy.common.codec.RequestDecoder;
import org.code4j.pushy.common.codec.ResponseEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * Description : ChildHandler
 * Created by YangZH on 2016/3/8 0008
 * 22:48
 */

public class ServerChildChannelHandler extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel e) throws Exception {
//        // 解码转 String
//        e.pipeline().addLast(new StringDecoder(Constants.CharsetClass.UTF8));
//        // 编码器 String
//        e.pipeline().addLast(new StringEncoder(Constants.CharsetClass.UTF8));
        e.pipeline().addLast(new RequestDecoder());
        e.pipeline().addLast(new ResponseEncoder());
        // 在管道中添加我们自己的接收数据实现方法
        e.pipeline().addLast(new ServerSocketHandler());
    }

}
