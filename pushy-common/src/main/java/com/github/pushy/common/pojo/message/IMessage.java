package com.github.pushy.common.pojo.message;/**
 * Description : AbstractMessage
 * Created by YangZH on 2016/3/19 0019
 *  14:04
 */

/**
 * Description : AbstractMessage
 * Created by YangZH on 2016/3/19 0019
 * 14:04
 *
 * 仅仅定义一个抽象消息，为Builder构造消息准备
 * 消息包括消息内容（content）还有消息头（header）
 *
 * 消息在1.0.0版只分为：传输消息和用户消息
 * 传输消息不暴露给用户，只用来在netty搭建的网络传输部分。
 * 用户消息用来给客户端调用
 */

public interface IMessage {
}
