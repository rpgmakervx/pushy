package com.github.pushy.client.handler;/**
 * Description : ClientChildChannelHandler
 * Created by YangZH on 2016/3/14 0014
 *  22:21
 */

import com.github.pushy.client.manager.MessageManager;
import com.github.pushy.common.codec.RequestEncoder;
import com.github.pushy.common.codec.ResponseDecoder;
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
        e.pipeline().addLast(new ResponseDecoder());
        e.pipeline().addLast(new RequestEncoder());
        e.pipeline().addLast(new ClientSocketHandler(messageManager));
        // 在管道中添加我们自己的接收数据实现方法
    }
}
