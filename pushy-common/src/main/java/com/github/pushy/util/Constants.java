package com.github.pushy.util;/**
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
        public static final int SUCCESS = 200;
    }

    public static final class TypeCode{
        public static final int GROUP = 0X00;
        public static final int POINT = 0X01;
    }

    public static final class CharsetClass{
        public static final Charset UTF8 = Charset.forName("UTF-8");
        public static final Charset GBK = Charset.forName("GBK");
    }
}
