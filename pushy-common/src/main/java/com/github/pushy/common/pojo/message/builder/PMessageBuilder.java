package com.github.pushy.common.pojo.message.builder;/**
 * Description : PMessageBuilder
 * Created by YangZH on 2016/3/19 0019
 *  16:15
 */

import com.github.pushy.common.pojo.agreement.IHeader;
import com.github.pushy.common.pojo.agreement.PHeader;
import com.github.pushy.common.pojo.message.PMessage;

/**
 * Description : PMessageBuilder
 * Created by YangZH on 2016/3/19 0019
 * 16:15
 */

public class PMessageBuilder implements MessageBuilder {

    private PMessage pMessage ;

    public PMessageBuilder(){
        this.pMessage = new PMessage();
    }

    @Override
    public PMessage get() {
        return pMessage;
    }

    @Override
    public PMessageBuilder buildContent(String message) {
        pMessage.setContent(message);
        return this;
    }

    @Override
    public MessageBuilder buildHeader(IHeader iHeader) {
        pMessage.setpHeader((PHeader) iHeader);
        return this;
    }
}
