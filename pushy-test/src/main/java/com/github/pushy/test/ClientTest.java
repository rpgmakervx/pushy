package com.github.pushy.test; /**
 * Description : ClientTest
 * Created by YangZH on 2016/3/14 0014
 *  22:54
 */

import com.github.pushy.client.bootstrap.PushyClient;
import com.github.pushy.client.listener.MessageListener;
import com.github.pushy.client.manager.MessageManager;
import com.github.pushy.common.pojo.agreement.TransHeader;
import com.github.pushy.common.pojo.message.TransMessage;
import com.github.pushy.common.util.Constants;
import com.github.pushy.common.util.StringUtil;

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
            public void onGroupMessageReceived(TransMessage message) {
                System.out.println("收到群消息--> 发送者："+message.getTransHeader().getSenderId()+
                        "   消息内容："+message.getContent());
            }

            @Override
            public void onSingleMessageReceived(TransMessage message) {
                System.out.println("收到单人消息--> 发送者："+message.getTransHeader().getSenderId()+
                        "   消息内容："+message.getContent());

            }
            @Override
            public void onCMDMessage(TransMessage message) {
                System.out.println("收到透传消息--> 发送者："+message.getTransHeader().getSenderId()+
                        "   消息内容："+message.getContent());
            }
        });
        String userid = StringUtil.randomCode(6);
        System.out.println("用户随机id: "+userid);
        while(true){
            System.out.println("请输入接收方送方id：");
            String toId = bufferedReader.readLine();
            System.out.println("请输入消息内容：");
            String msg = bufferedReader.readLine();
            TransHeader transHeader = new TransHeader();
            transHeader.setStatusCode(Constants.StatusCode.SUCCESS);
            transHeader.setToId(toId);
            transHeader.setSenderId(userid);
            transHeader.setMessageType(Constants.MessageType.SINGLE);
            TransMessage transMessage = new TransMessage();
            transMessage.setContent(msg);
            transMessage.setTransHeader(transHeader);
            msgManager.sendMessage(transMessage);
        }

    }
}
