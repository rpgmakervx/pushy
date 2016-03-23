package com.github.pushy.server.session;/**
 * Description : SessionManager
 * Created by YangZH on 2016/3/21 0021
 *  22:34
 */


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description : SessionManager
 * Created by YangZH on 2016/3/21 0021
 * 22:34
 *
 * session管理器
 */

public class SessionManager {
    public static Map<Long,Session> onlineSession= Collections.synchronizedMap(new HashMap<Long,Session>());

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
        return onlineSession.containsKey(clientId);
    }

    /**
     * 获取当前在线用户
     * 获取结果集合不可被修改
     * @return
     */
    public static Set<Long> getOnlineIds(){
        return Collections.unmodifiableSet(onlineSession.keySet());
    }

}
