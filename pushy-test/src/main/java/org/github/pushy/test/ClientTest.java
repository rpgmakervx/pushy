package org.github.pushy.test; /**
 * Description : ClientTest
 * Created by YangZH on 2016/3/14 0014
 *  22:54
 */

import org.code4j.pushy.client.bootstrap.PushyClient;
import org.code4j.pushy.client.listener.MessageListener;
import org.code4j.pushy.client.manager.MessageManager;
import org.code4j.pushy.common.pojo.message.RequestMessage;
import org.code4j.pushy.common.util.StringUtil;

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
        MessageManager msgManager = PushyClient.getInstance().msgManager();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        msgManager.setMessageListener(new MessageListener() {
            @Override
            public void onGroupMessageReceived(RequestMessage message) {
                System.out.println("收到群消息--> 发送者："+
                        "   消息内容："+message.getMessage());
            }

            @Override
            public void onSingleMessageReceived(RequestMessage message) {
                System.out.println("收到单人消息--> 发送者："+
                        "   消息内容："+message.getMessage());

            }
            @Override
            public void onCMDMessage(RequestMessage message) {
                System.out.println("收到透传消息--> 发送者："+
                        "   消息内容："+message.getMessage());
            }
        });
        String userid = StringUtil.randomCode(6);
        System.out.println("用户随机id: "+userid);
        while(true){
            System.out.println("请输入接收方送方id：");
            String targetId = bufferedReader.readLine();
            System.out.println("请输入消息内容：");
            String msg = bufferedReader.readLine();
        }

    }
}
