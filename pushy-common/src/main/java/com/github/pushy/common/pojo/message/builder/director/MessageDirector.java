package com.github.pushy.common.pojo.message.builder.director;/**
 * Description : Director
 * Created by YangZH on 2016/3/19 0019
 *  22:19
 */

import com.github.pushy.common.pojo.agreement.IHeader;
import com.github.pushy.common.pojo.message.IMessage;
import com.github.pushy.common.pojo.message.builder.MessageBuilder;

/**
 * Description : Director
 * Created by YangZH on 2016/3/19 0019
 * 22:19
 */

public class MessageDirector {

    private MessageBuilder builder;

    public MessageDirector(MessageBuilder builder){
        this.builder = builder;
    }

    public IMessage make(String content,IHeader iHeader){
        builder.buildContent(content);
        builder.buildHeader(iHeader);
        return builder.get();
    }
}
