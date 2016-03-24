package org.code4j.pushy.client.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import org.code4j.pushy.client.manager.MessageManager;
import org.code4j.pushy.common.codec.RequestEncoder;
import org.code4j.pushy.common.codec.ResponseDecoder;

/**
 * Description : ClientChildChannelHandler
 * Created by code4j on 2016/3/14 0014
 * 22:21
 */

public class ClientChildChannelHandler extends ChannelInitializer<Channel> {

    private MessageManager messageManager;

    public ClientChildChannelHandler(MessageManager messageManager){
        this.messageManager = messageManager;
    }
    @Override
    protected void initChannel(Channel e) throws Exception {
        e.pipeline().addLast(new ResponseDecoder());
        e.pipeline().addLast(new RequestEncoder());
        e.pipeline().addLast(new ClientSocketHandler(messageManager));
        // 在管道中添加我们自己的接收数据实现方法
    }
}
