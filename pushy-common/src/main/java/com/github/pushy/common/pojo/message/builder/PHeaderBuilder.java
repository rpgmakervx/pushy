package com.github.pushy.common.pojo.message.builder;/**
 * Description : PHeaderBuilder
 * Created by YangZH on 2016/3/19 0019
 *  23:03
 */

import com.github.pushy.common.pojo.agreement.IHeader;
import com.github.pushy.common.pojo.agreement.PHeader;
import com.github.pushy.common.pojo.message.MessageType;

/**
 * Description : PHeaderBuilder
 * Created by YangZH on 2016/3/19 0019
 * 23:03
 */

public class PHeaderBuilder implements HeaderBuilder {

    private PHeader pHeader;

    public PHeaderBuilder(){
        this.pHeader = new PHeader();
    }

    @Override
    public void buildSender(String senderId) {
        pHeader.setSenderId(senderId);
    }

    @Override
    public void buildToId(String toId) {
        pHeader.setToId(toId);
    }

    @Override
    public void buildMessageType(MessageType messageType) {
        pHeader.setMessageType(messageType);
    }

    @Override
    public IHeader get() {
        return pHeader;
    }
}
