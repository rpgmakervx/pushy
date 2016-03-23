package com.github.pushy.server.session;/**
 * Description : Session
 * Created by YangZH on 2016/3/21 0021
 *  22:13
 */

/**
 * Description : Session
 * Created by YangZH on 2016/3/21 0021
 * 22:13
 */

public interface Session {

    /**
     * 会话绑定对象
     * @return
     */
    Object getAttachment();

    /**
     * 绑定对象
     * @return
     */
    void setAttachment(Object attachment);

    /**
     * 移除绑定对象
     * @return
     */
    void removeAttachment();

    /**
     * 向会话中写入消息
     * @param message
     */
    void write(Object message);

    /**
     * 判断会话是否在连接中
     * @return
     */
    boolean isConnected();

    /**
     * 关闭
     * @return
     */
    void close();
}
