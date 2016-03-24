package org.code4j.pushy.client.listener;

import org.code4j.pushy.common.pojo.message.RequestMessage;

import java.util.EventListener;

/**
 * Description : MessageHnadler
 * Created by code4j on 2016/3/18 0018
 * 13:13
 */

public interface MessageListener extends EventListener{

    public void onGroupMessageReceived(RequestMessage message);

    public void onSingleMessageReceived(RequestMessage message);

    public void onCMDMessage(RequestMessage message);
}
