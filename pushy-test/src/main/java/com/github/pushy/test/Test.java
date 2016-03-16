package com.github.pushy.test;/**
 * Description : Test
 * Created by YangZH on 2016/3/16 0016
 *  21:58
 */

import com.github.pushy.pojo.agreement.Body;
import com.github.pushy.pojo.agreement.Header;
import com.github.pushy.pojo.agreement.PMessage;

/**
 * Description : Test
 * Created by YangZH on 2016/3/16 0016
 * 21:58
 */

public class Test {

    public static void main(String[] args) {
        Header header = new Header();
        header.setStatusCode(0);
        header.setToId("");
        header.setTypeCode(1);
        Body body = new Body();
        body.setContent("hello world");
        PMessage pMessage = new PMessage();
        pMessage.setBody(body);
        pMessage.setHeader(header);
        byte[] bytes = pMessage.getBytes();
        System.out.println("序列化长度："+bytes.length);
    }
}
