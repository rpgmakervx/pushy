package com.github.pushy.common.pojo.message.builder;/**
 * Description : HeaderBuilder
 * Created by YangZH on 2016/3/19 0019
 *  22:50
 */

import com.github.pushy.common.pojo.agreement.IHeader;
import com.github.pushy.common.pojo.message.MessageType;

/**
 * Description : HeaderBuilder
 * Created by YangZH on 2016/3/19 0019
 * 22:50
 */

public interface HeaderBuilder {

    public void buildSender(String senderId);

    public void buildToId(String toId);

    public void buildMessageType(MessageType messageType);

    public IHeader get();
}
