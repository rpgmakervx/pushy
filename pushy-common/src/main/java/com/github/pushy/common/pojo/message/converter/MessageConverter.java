package com.github.pushy.common.pojo.message.converter;/**
 * Description : MessageConverter
 * Created by YangZH on 2016/3/19 0019
 *  17:37
 */

import com.github.pushy.common.pojo.message.IMessage;

/**
 * Description : MessageConverter
 * Created by YangZH on 2016/3/19 0019
 * 17:37
 *
 * 消息转换器 主要为了 将传输消息和用户消息做转换
 *message,String senderId,
    String toId,StatusCode statusCode
 */

public class MessageConverter {

    /**
     * 源消息
     */
    private IMessage sourceMessage;

    /**
     * 目的消息
     */
    private IMessage objectMessage;


//    public IMessage convertTo(IMessage sourceMessage,Class<? extends IMessage> clazz){
//        IMessage result = sourceMessage;
//        if(clazz == TransMessage.class){
//            PMessage pMessage = (PMessage) sourceMessage;
//            switch (pMessage.getpHeader().getMessageType()){
//                case MessageType.SINGLE:
//                    result = new TransMessageFactory().createSingleMessage(pMessage.getContent(),
//                            pMessage.getpHeader().getSenderId(), pMessage.getpHeader().getToId(),Constants.StatusCode.SUCCESS);
//                    break;
//                case MessageType.GROUP:
//                    result = new PMessageFactory().createGroupMessage(transMessage.getContent(),
//                            transMessage.getTransHeader().getSenderId(), transMessage.getTransHeader().getToId());
//                    break;
//                case MessageType.CMD:
//                    result = new PMessageFactory().createCMDMessage(transMessage.getContent(),
//                            transMessage.getTransHeader().getSenderId(), transMessage.getTransHeader().getToId());
//                    break;
//                case Constants.MessageType.ALL:
//                    result = new PMessageFactory().createALLMessage(transMessage.getContent(),
//                            transMessage.getTransHeader().getSenderId(), transMessage.getTransHeader().getToId());
//                    break;
//            }
//            result = new TransMessageFactory().
//                    createSingleMessage(pMessage.getContent(),pMessage.getpHeader().getSenderId()
//                            ,pMessage.getpHeader().getToId(), StatusCode.SUCCESS);
//        }else if(clazz == PMessage.class){
//            TransMessage transMessage = (TransMessage) sourceMessage;
//            switch (transMessage.getTransHeader().getMessageType()){
//                case Constants.MessageType.SINGLE:
//                    result = new PMessageFactory().createSingleMessage(transMessage.getContent(),
//                            transMessage.getTransHeader().getSenderId(), transMessage.getTransHeader().getToId());
//                    break;
//                case Constants.MessageType.GROUP:
//                    result = new PMessageFactory().createGroupMessage(transMessage.getContent(),
//                            transMessage.getTransHeader().getSenderId(), transMessage.getTransHeader().getToId());
//                    break;
//                case Constants.MessageType.CMD:
//                    result = new PMessageFactory().createCMDMessage(transMessage.getContent(),
//                            transMessage.getTransHeader().getSenderId(), transMessage.getTransHeader().getToId());
//                    break;
//                case Constants.MessageType.ALL:
//                    result = new PMessageFactory().createALLMessage(transMessage.getContent(),
//                            transMessage.getTransHeader().getSenderId(), transMessage.getTransHeader().getToId());
//                    break;
//            }
//
//        }
//        return result;
//    }
}
