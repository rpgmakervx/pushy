package com.github.pushy.common.pojo.message;/**
 * Description : PMessage
 * Created by YangZH on 2016/3/19 0019
 *  11:11
 */

/**
 * Description : PMessage
 * Created by YangZH on 2016/3/19 0019
 * 11:11
 */

public class PMessage {

    private ChatType chatType ;

    private String content;

    private String toId;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType){
        this.chatType = chatType;
    }
}
