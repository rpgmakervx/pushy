package org.code4j.pushy.server.session;

/**
 * Description : Session
 * Created by code4j on 2016/3/21 0021
 * 22:13
 *
 * Session就是抽象出来的Channel。防止server端的用户直接使用channel
 * 并简化包装了channel的部分操作
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
