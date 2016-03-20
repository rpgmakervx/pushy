package com.github.pushy.common.pojo.message.factory;/**
 * Description : TransMessageFactory
 * Created by YangZH on 2016/3/19 0019
 *  17:55
 */

import com.github.pushy.common.pojo.message.MessageType;
import com.github.pushy.common.pojo.message.StatusCode;
import com.github.pushy.common.pojo.message.TransMessage;
import com.github.pushy.common.pojo.message.builder.TransHeaderBuilder;
import com.github.pushy.common.pojo.message.builder.TransMessageBuilder;
import com.github.pushy.common.pojo.message.builder.director.HeaderDirector;
import com.github.pushy.common.pojo.message.builder.director.MessageDirector;

/**
 * Description : TransMessageFactory
 * Created by YangZH on 2016/3/19 0019
 * 17:55
 */

public class TransMessageFactory {


    private MessageDirector messageDirector;
    private HeaderDirector headerDirector;
    /**
     * 构造一个TransMessage
     * 方法默认类型是Constants.MessageType.SINGLE
     * @param message       消息体
     * @param senderId      发送者
     * @param toId          接收者
     * @param statusCode    消息状态码
     * @return senderId,toId, Constants.MessageType.SINGLE,statusCode
     */
    public TransMessage createSingleMessage(String message,String senderId,
                                                   String toId,StatusCode statusCode){
        construct(statusCode);
        TransMessage transMessage = (TransMessage) messageDirector.make(message,
                headerDirector.make(senderId, toId, MessageType.SINGLE));
        return transMessage;
    }

    public TransMessage createGroupMessage(String message,String senderId,
                                                  String toId,StatusCode statusCode){
        construct(statusCode);
        TransMessage transMessage = (TransMessage) messageDirector.make(message,
                headerDirector.make(senderId, toId, MessageType.GROUP));
        return transMessage;
    }

    private void construct(StatusCode statusCode){
        this.messageDirector = new MessageDirector(new TransMessageBuilder());
        this.headerDirector = new HeaderDirector(new TransHeaderBuilder(statusCode));
    }
}
