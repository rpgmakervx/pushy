package com.github.pushy.client.bootstrap;/**
 * Description : PushyClient
 * Created by YangZH on 2016/3/18 0018
 *  16:05
 *
 *  暴露给用户，用来调配消息管理器并初始化其数据
 */

import com.github.pushy.client.manager.MessageManager;
import com.github.pushy.common.pojo.message.RequestMessage;
import com.github.pushy.common.util.Constants;

/**
 * Description : PushyClient
 * Created by YangZH on 2016/3/18 0018
 * 16:05
 */

public final class PushyClient {

    private static PushyClient pushyClient = new PushyClient();

    private MessageManager messageManager;

    private ClientBootstrap bootstrap;

    /**
     * 初始化netty客户端，并初始化消息管理器。
     */
    private PushyClient(){
        initClient();
        messageManager = new MessageManager(bootstrap);
    }
    public static PushyClient getInstance(){
        return pushyClient;
    }

    /**
     * 获取消息管理器
     * @return
     */
    public MessageManager msgManager(){
        return messageManager;
    }

    /**
     * 初始化netty客户端，并传递给消息管理器
     */
    private void initClient(){
        bootstrap = new ClientBootstrap(Constants.RemoteHost.LOCAL_HOST,
                    Constants.RemoteHost.PORT,this.messageManager);
        bootstrap.connect();
    }

    public void sendMessage(RequestMessage requestMessage){

    }
}
