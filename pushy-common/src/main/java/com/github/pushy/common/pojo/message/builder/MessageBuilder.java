package com.github.pushy.common.pojo.message.builder;/**
 * Description : Builder
 * Created by YangZH on 2016/3/19 0019
 *  14:38
 */

import com.github.pushy.common.pojo.agreement.IHeader;
import com.github.pushy.common.pojo.message.IMessage;

/**
 * Description : Builder
 * Created by YangZH on 2016/3/19 0019
 * 14:38
 */

public interface MessageBuilder{

    public IMessage get();

    public MessageBuilder buildContent(String content);

    public MessageBuilder buildHeader(IHeader iHeader);
}
