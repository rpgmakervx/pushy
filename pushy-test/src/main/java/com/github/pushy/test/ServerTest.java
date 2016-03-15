package com.github.pushy.test; /**
 * Description : ServerTest
 * Created by YangZH on 2016/3/14 0014
 *  22:54
 */

import com.github.pushy.server.PushyServer;

/**
 * Description : ServerTest
 * Created by YangZH on 2016/3/14 0014
 * 22:54
 */

public class ServerTest {
    public static void main(String[] args) {
        new Thread(new PushyServer(5000)).start();
    }
}
