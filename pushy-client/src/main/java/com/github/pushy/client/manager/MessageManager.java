package com.github.pushy.client.manager;/**
 * Description : MessageManager
 * Created by YangZH on 2016/3/18 0018
 *  15:21
 */

import com.github.pushy.client.bootstrap.ClientBootstrap;
import com.github.pushy.client.listener.MessageListener;
import com.github.pushy.common.pojo.message.TransMessage;

/**
 * Description : MessageManager
 * Created by YangZH on 2016/3/18 0018
 * 15:21
 *
 * 消息管理器
 * 负责消息发送，接收，消息类型的处理
 */

public class MessageManager {

    private ClientBootstrap client;

    private MessageListener listener;

    public MessageManager(ClientBootstrap client){
        this.client = client;
    }
    /**
     * 发送传输消息
     * 客户端无需调用此类
     * @param transMessage 消息封装体
     */
    public void sendMessage(TransMessage transMessage){
        client.sendMessage(transMessage);
    }
    /**
     * 添加监听器
     * @param listener
     */
    public void setMessageListener(MessageListener listener){
        this.listener = listener;
    }

    public MessageListener getMessageListener(){
        return this.listener;
    }

}
