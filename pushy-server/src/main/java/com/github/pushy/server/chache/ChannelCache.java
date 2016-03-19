package com.github.pushy.server.chache;/**
 * Description : ChannelCache
 * Created by YangZH on 2016/3/10 0010
 *  14:43
 */

import com.github.pushy.common.pojo.Connection;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : ChannelCache
 * Created by YangZH on 2016/3/10 0010
 * 14:43
 */

public class ChannelCache {

    public static Map<String,Connection> cachedChannels = Collections.synchronizedMap(new HashMap<String, Connection>());

    public static ChannelGroup cachedChannelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
