package com.github.pushy.test; /**
 * Description : ClientTest
 * Created by YangZH on 2016/3/14 0014
 *  22:54
 */

import com.github.pushy.client.bootstrap.ClientBootstrap;
import com.github.pushy.common.pojo.agreement.Body;
import com.github.pushy.common.pojo.agreement.Header;
import com.github.pushy.common.pojo.message.TransMessage;
import com.github.pushy.server.bootstrap.PushyServer;
import com.github.pushy.common.util.Constants;

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
        new PushyServer(5000);
        ClientBootstrap client = new ClientBootstrap("localhost",5000);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        client.connect();
        while(true){
            System.out.println("请输入：");
            String msg = bufferedReader.readLine();
            Header header = new Header();
            header.setStatusCode(Constants.StatusCode.SUCCESS);
            header.setToId(client.getChannel().id().toString());
            header.setTypeCode(Constants.MessageType.POINT);
            Body body = new Body();
            body.setContent(msg);
            TransMessage transMessage = new TransMessage();
            transMessage.setBody(body);
            transMessage.setHeader(header);
            client.sendMessage(transMessage);
        }
    }
}
