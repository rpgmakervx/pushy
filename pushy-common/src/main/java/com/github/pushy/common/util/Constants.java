package com.github.pushy.common.util;/**
 * Description : Constans
 * Created by YangZH on 2016/3/12 0012
 *  14:45
 */

import java.nio.charset.Charset;

/**
 * Description : Constans
 * Created by YangZH on 2016/3/12 0012
 * 14:45
 */

public class Constants {

    public static final class StatusCode{
        public static final byte SUCCESS = 0X00;
        public static final byte LOGIN_FAIL = 0X01;
        public static final byte SERVER_ERROR = 0X0;
    }

    public static final class MessageType{
        public static final byte CMD = 0X0;
        public static final byte SINGLE = 0X1;
        public static final byte GROUP = 0X3;
        public static final byte ALL = 0X4;
    }

    public static final class CharsetClass{
        public static final Charset UTF8 = Charset.forName("UTF-8");
        public static final Charset GBK = Charset.forName("GBK");
    }

    public static final class RemoteHost{
        public static final String LOCAL_HOST = "localhost";
        public static final String REMOTE_PATH = "114.215.143.83";
        public static final int PORT = 5000;
    }
}
