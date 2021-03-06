package org.code4j.pushy.client.manager;/**
 * Description : MessageManager
 * Created by YangZH on 2016/3/18 0018
 *  15:21
 */

import org.code4j.pushy.client.bootstrap.ClientBootstrap;
import org.code4j.pushy.client.listener.MessageListener;
import org.code4j.pushy.common.pojo.message.Action;
import org.code4j.pushy.common.pojo.message.RequestMessage;
import org.code4j.pushy.common.pojo.message.Type;
import org.code4j.pushy.common.pojo.request.Request;
import org.code4j.pushy.common.pojo.user.User;
import org.code4j.pushy.common.util.GsonUtils;

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
     * @param request 消息封装体
     */
    public void sendRequest(Request request){
        client.sendRequest(request);
    }
    /**
     * 添加监听器
     * @param listener
     */
    public void setMessageListener(MessageListener listener){
        this.listener = listener;
    }

    public void login(User user){
        String json = GsonUtils.toJson(user);
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setMessage(json);
        requestMessage.setAction(Action.LOGIN);
        Request request = new Request();
        request.setData(requestMessage.getBytes());
        request.setType(Type.CMD);
        sendRequest(request);
    }
    public MessageListener getMessageListener(){
        return this.listener;
    }

}
