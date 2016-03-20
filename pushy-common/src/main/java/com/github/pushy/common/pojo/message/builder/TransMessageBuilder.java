package com.github.pushy.common.pojo.message.builder;/**
 * Description : TransMessageBuilder
 * Created by YangZH on 2016/3/19 0019
 *  15:22
 */

import com.github.pushy.common.pojo.agreement.IHeader;
import com.github.pushy.common.pojo.agreement.TransHeader;
import com.github.pushy.common.pojo.message.TransMessage;

/**
 * Description : TransMessageBuilder
 * Created by YangZH on 2016/3/19 0019
 * 15:22
 */

public class TransMessageBuilder implements MessageBuilder {

    private TransMessage transMessage;

    public TransMessageBuilder(){
        this.transMessage = new TransMessage();
    }

    @Override
    public TransMessageBuilder buildContent(String message) {
        transMessage.setContent(message);
        return this;
    }

    @Override
    public MessageBuilder buildHeader(IHeader iHeader) {
        transMessage.setTransHeader((TransHeader) iHeader);
        return this;
    }

    @Override
    public TransMessage get() {
        return transMessage;
    }
}
