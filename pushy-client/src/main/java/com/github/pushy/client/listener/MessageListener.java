package com.github.pushy.client.listener;/**
 * Description : MessageHnadler
 * Created by YangZH on 2016/3/18 0018
 *  13:13
 */

import com.github.pushy.common.pojo.message.TransMessage;

import java.util.EventListener;

/**
 * Description : MessageHnadler
 * Created by YangZH on 2016/3/18 0018
 * 13:13
 */

public interface MessageListener extends EventListener{

    public void onGroupMessageReceived(TransMessage message);

    public void onSingleMessageReceived(TransMessage message);

    public void onCMDMessage(TransMessage message);
}
