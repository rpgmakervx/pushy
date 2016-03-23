package com.github.pushy.common.pojo.message;/**
 * Description : ChatType
 * Created by YangZH on 2016/3/19 0019
 *  11:16
 */

/**
 * Description : ChatType
 * Created by YangZH on 2016/3/19 0019
 * 11:16
 *
 * 消息类型
 */

public interface Type {
    //
    public static final byte CMD = 0X0;
    public static final byte PUSH = 0X1;
    public static final byte USER = 0X2;
    public static final byte GROUP = 0X3;
    public static final byte ALL = 0X4;
}
