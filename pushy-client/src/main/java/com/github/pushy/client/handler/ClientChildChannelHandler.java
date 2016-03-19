package com.github.pushy.client.handler;/**
 * Description : ClientChildChannelHandler
 * Created by YangZH on 2016/3/14 0014
 *  22:21
 */

import com.github.pushy.client.manager.MessageManager;
import com.github.pushy.common.codec.PMessageDecoder;
import com.github.pushy.common.codec.PMessageEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * Description : ClientChildChannelHandler
 * Created by YangZH on 2016/3/14 0014
 * 22:21
 */

public class ClientChildChannelHandler extends ChannelInitializer<Channel> {

    private MessageManager messageManager;

    public ClientChildChannelHandler(MessageManager messageManager){
        this.messageManager = messageManager;
    }
    @Override
    protected void initChannel(Channel e) throws Exception {
//        // 解码转 String
//        e.pipeline().addLast(new StringDecoder(Constants.CharsetClass.UTF8));
//        // 编码器 String
//        e.pipeline().addLast(new StringEncoder(Constants.CharsetClass.UTF8));
        e.pipeline().addLast(new PMessageDecoder());
        e.pipeline().addLast(new PMessageEncoder());
        e.pipeline().addLast(new ClientSocketHandler(messageManager));
        // 在管道中添加我们自己的接收数据实现方法
    }
}
