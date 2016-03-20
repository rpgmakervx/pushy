package com.github.pushy.common.pojo.message.factory;/**
 * Description : MessageFactory
 * Created by YangZH on 2016/3/19 0019
 *  11:18
 */

import com.github.pushy.common.pojo.message.MessageType;
import com.github.pushy.common.pojo.message.PMessage;
import com.github.pushy.common.pojo.message.builder.PHeaderBuilder;
import com.github.pushy.common.pojo.message.builder.PMessageBuilder;
import com.github.pushy.common.pojo.message.builder.director.HeaderDirector;
import com.github.pushy.common.pojo.message.builder.director.MessageDirector;

/**
 * Description : MessageFactory
 * Created by YangZH on 2016/3/19 0019
 * 11:18
 */

public class PMessageFactory {

    private MessageDirector messageDirector;
    private HeaderDirector headerDirector;
    /**
     * 构造单聊消息
     * @param message   消息体
     * @param toId  接收者
     * @return
     */
    public PMessage createSingleMessage(String message,String senderId,String toId){
        construct();
        PMessage pMessage = (PMessage) messageDirector.make(message,
                headerDirector.make(senderId, toId, MessageType.SINGLE));
        return pMessage;
    }

    /**
     * 构造群聊消息
     * @param message   消息体
     * @param toId  接收群组
     * @return
     */
    public PMessage createGroupMessage(String message,String senderId,String toId){
        construct();
        PMessage pMessage = (PMessage) messageDirector.make(message,
                headerDirector.make(senderId, toId, MessageType.GROUP));
        return pMessage;
    }

    /**
     * 构造透传消息
     * @param message   消息体
     * @param toId  接收群组
     * @return
     */
    public PMessage createCMDMessage(String message,String senderId,String toId){
        construct();
        PMessage pMessage = (PMessage) messageDirector.make(message,
                headerDirector.make(senderId, toId, MessageType.CMD));
        return pMessage;
    }
    /**
     * 构造广播消息
     * @param message   消息体
     * @param toId  接收群组
     * @return
     */
    public PMessage createALLMessage(String message,String senderId,String toId){
        construct();
        PMessage pMessage = (PMessage) messageDirector.make(message,
                headerDirector.make(senderId,toId, MessageType.ALL));
        return pMessage;
    }

    private void construct(){
        this.messageDirector = new MessageDirector(new PMessageBuilder());
        this.headerDirector = new HeaderDirector(new PHeaderBuilder());
    }

}
