package com.github.pushy.common.pojo.message.builder;/**
 * Description : TransHeader
 * Created by YangZH on 2016/3/19 0019
 *  22:57
 */

import com.github.pushy.common.pojo.agreement.IHeader;
import com.github.pushy.common.pojo.agreement.TransHeader;
import com.github.pushy.common.pojo.message.MessageType;
import com.github.pushy.common.pojo.message.StatusCode;
import com.github.pushy.common.util.Constants;

/**
 * Description : TransHeader
 * Created by YangZH on 2016/3/19 0019
 * 22:57
 */

public class TransHeaderBuilder implements HeaderBuilder {

    private TransHeader transHeader;

    public TransHeaderBuilder(StatusCode statusCode){
        transHeader = new TransHeader();
        buildStatusCode(statusCode);
    }

    @Override
    public void buildSender(String senderId) {
        transHeader.setSenderId(senderId);
    }

    @Override
    public void buildToId(String toId) {
        transHeader.setToId(toId);
    }

    @Override
    public void buildMessageType(MessageType messageType){
        byte type = 0X0;
        switch (messageType){
            case SINGLE:
                type = Constants.MessageType.SINGLE;
                break;
            case GROUP:
                type = Constants.MessageType.GROUP;
                break;
            case CMD:
                type = Constants.MessageType.CMD;
                break;
            case ALL:
                type = Constants.MessageType.ALL;
                break;
        }
        transHeader.setMessageType(type);
    }

    public void buildStatusCode(StatusCode statusCode){
        byte code = 0X0;
        switch (statusCode){
            case SUCCESS:
                code = Constants.StatusCode.SUCCESS;
                break;
            case LOGIN_FAIL:
                code = Constants.StatusCode.LOGIN_FAIL;
                break;
            case SERVER_ERROR:
                code = Constants.StatusCode.SERVER_ERROR;
                break;
        }
        transHeader.setStatusCode(code);
    }

    @Override
    public IHeader get() {
        return transHeader;
    }
}
