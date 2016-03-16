package com.github.pushy.test; /**
 * Description : ClientTest
 * Created by YangZH on 2016/3/14 0014
 *  22:54
 */

import com.github.pushy.client.PushyClient;
import com.github.pushy.pojo.agreement.Body;
import com.github.pushy.pojo.agreement.Header;
import com.github.pushy.pojo.agreement.PMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description : ClientTest
 * Created by YangZH on 2016/3/14 0014
 * 22:54
 */

public class ClientTest {


    public static void main(String[] args) throws IOException {
//        new PushyServer(5000);
        PushyClient client = new PushyClient("localhost",5000);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        client.connect();
        while(true){
            System.out.println("请输入：");
            String msg = bufferedReader.readLine();
            Header header = new Header();
            header.setStatusCode(0);
            header.setToId(client.getChannel().id().toString());
            header.setTypeCode(1);
            Body body = new Body();
            body.setContent(msg);
            PMessage pMessage = new PMessage();
            pMessage.setBody(body);
            pMessage.setHeader(header);
            client.sendMessage(pMessage);
        }

    }
}
