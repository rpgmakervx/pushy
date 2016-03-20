package com.github.pushy.server.chache;/**
 * Description : UserCache
 * Created by YangZH on 2016/3/20 0020
 *  22:32
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : UserCache
 * Created by YangZH on 2016/3/20 0020
 * 22:32
 *
 * 记录用户和channelId关联
 */

public class UserCache {
    public static Map<String,String> cachedUsers = Collections.synchronizedMap(new HashMap<String, String>());
}
