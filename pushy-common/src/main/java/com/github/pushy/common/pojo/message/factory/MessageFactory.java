package com.github.pushy.common.pojo.message.factory;/**
 * Description : MessageFactory
 * Created by YangZH on 2016/3/19 0019
 *  11:18
 */

import com.github.pushy.common.pojo.message.ChatType;
import com.github.pushy.common.pojo.message.PMessage;

/**
 * Description : MessageFactory
 * Created by YangZH on 2016/3/19 0019
 * 11:18
 */

public class MessageFactory {

    /**
     * 构造单聊消息
     * @param content   消息体
     * @param toId  接收者
     * @return
     */
    public static PMessage createSingleMessage(String content,String toId){
        PMessage pMessage = new PMessage();
        pMessage.setChatType(ChatType.SINGLE);
        pMessage.setContent(content);
        pMessage.setToId(toId);
        return pMessage;
    }

    /**
     * 构造群聊消息
     * @param content   消息体
     * @param toId  接收群组
     * @return
     */
    public static PMessage createGroupMessage(String content,String toId){
        PMessage pMessage = new PMessage();
        pMessage.setChatType(ChatType.GROUP);
        pMessage.setContent(content);
        pMessage.setToId(toId);
        return pMessage;
    }

}
