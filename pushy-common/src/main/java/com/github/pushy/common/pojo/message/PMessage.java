package com.github.pushy.common.pojo.message;/**
 * Description : PMessage
 * Created by YangZH on 2016/3/19 0019
 *  11:11
 */

import com.github.pushy.common.pojo.agreement.PHeader;

/**
 * Description : PMessage
 * Created by YangZH on 2016/3/19 0019
 * 11:11
 */

public class PMessage implements IMessage{

    private PHeader pHeader;
    private String content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PHeader getpHeader() {
        return pHeader;
    }

    public void setpHeader(PHeader pHeader) {
        this.pHeader = pHeader;
    }
}
