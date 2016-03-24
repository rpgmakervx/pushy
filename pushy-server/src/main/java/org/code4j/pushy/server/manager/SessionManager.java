package org.code4j.pushy.server.manager;/**
 * Description : SessionManager
 * Created by YangZH on 2016/3/21 0021
 *  22:34
 */


import org.code4j.pushy.common.pojo.message.ResponseMessage;
import org.code4j.pushy.common.pojo.response.Response;
import org.code4j.pushy.server.session.Session;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description : SessionManager
 * Created by code4j on 2016/3/21 0021
 * 22:34
 *
 * session管理器
 */

public class SessionManager {
    private static Map<Long,Session> onlineSession = Collections.synchronizedMap(new HashMap<Long,Session>());


    /**
     * 添加一个用户session
     * @param clientId
     * @param session
     * @return
     */
    public static boolean putSession(long clientId,Session session){
        if(isOnline(clientId)){
            onlineSession.put(clientId,session);
            return true;
        }
        return false;
    }

    /**
     * 移除一个用户session
     * @param clientId
     * @return
     */
    public static Session removeSession(String clientId){
        return onlineSession.remove(clientId);
    }

    /**
     * 判断某用户是否在线
     * @param clientId
     * @return
     */
    public static boolean isOnline(long clientId){
        Session session = getSession(clientId);
        return session!=null&&session.isConnected();
    }

    /**
     * 获取当前在线用户
     * 获取结果集合不可被修改
     * @return
     */
    public static Set<Long> getOnlineIds(){
        return Collections.unmodifiableSet(onlineSession.keySet());
    }

    /**
     * SessionManager内部的方法，获取session
     * @param clientId
     * @return
     */
    private static Session getSession(long clientId){
        return onlineSession.get(clientId);
    }

    /**
     * 发送响应给客户端
     * @param type       消息类型
     * @param action     消息业务
     * @param statusCode 消息状态码
     * @param message    消息体
     */
    public static void sendResponse(byte type,byte action,byte statusCode,ResponseMessage message){
        if (isOnline(message.getSenderId())){
            Response response = new Response(type,action,statusCode,message.getBytes());
            getSession(message.getSenderId()).write(response);
        }
    }
}
