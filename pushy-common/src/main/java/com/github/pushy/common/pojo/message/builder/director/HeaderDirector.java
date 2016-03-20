package com.github.pushy.common.pojo.message.builder.director;/**
 * Description : TransMessageDirector
 * Created by YangZH on 2016/3/20 0020
 *  18:31
 */

import com.github.pushy.common.pojo.agreement.IHeader;
import com.github.pushy.common.pojo.message.MessageType;
import com.github.pushy.common.pojo.message.builder.HeaderBuilder;

/**
 * Description : TransMessageDirector
 * Created by YangZH on 2016/3/20 0020
 * 18:31
 */

public class HeaderDirector {

    private HeaderBuilder headerBuilder;

    public HeaderDirector(HeaderBuilder headerBuilder){
        this.headerBuilder = headerBuilder;
    }

    public IHeader make(String senderId,String toId,
                        MessageType messageType){
        headerBuilder.buildSender(senderId);
        headerBuilder.buildToId(toId);
        headerBuilder.buildMessageType(messageType);
        return headerBuilder.get();
    }
}
