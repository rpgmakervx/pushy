package org.code4j.pushy.server.handler;

import org.code4j.pushy.common.pojo.message.RequestMessage;
import org.code4j.pushy.server.manager.SessionManager;
import org.code4j.pushy.server.session.Session;

/**
 * Description : RequestHandler
 * Created by code4j on 2016/3/23 0023
 *  23:02
 *
 *  该类直接接触SessionManager,只处理请求在通信中的业务，
 *  用户身份验证等业务在service中处理
 */

public class RequestHandler {

    /**
     * 用户登录
     * @param clientId
     * @param session
     * @return
     */
    public boolean login(long clientId,Session session){
        if (SessionManager.isOnline(clientId)){
            //可以用异常代替
            return false;
        }else{
            SessionManager.putSession(clientId,session);
            //可以用异常代替
            return true;
        }
    }

    public void sendMessage(long clientId,RequestMessage message){
        if (SessionManager.isOnline(message.getTargetId())){
            //接收方不在线
        }else if (SessionManager.isOnline(clientId)){
            //发送方不在线
        }else{
            SessionManager.sendResponse();
        }
    }
}
