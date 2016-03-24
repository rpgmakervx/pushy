package org.code4j.pushy.server.manager;

import org.code4j.pushy.common.pojo.chatroom.ChatRoom;
import org.code4j.pushy.common.util.StringUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : ChannelCache
 * Created by code4j on 2016/3/10 0010
 * 14:43
 */

public class ChatRoomManager {

    public static Map<String,ChatRoom> chatRooms = Collections.synchronizedMap(new HashMap<String,ChatRoom>());


    /**
     * 创建房间
     * @param hostId
     * @return
     */
    public static String createRoom(long hostId){
        String roomId = StringUtil.randomCode(9);
        //不允许出现roomId重复
        while(roomExists(roomId = StringUtil.randomCode(9))) {}
        ChatRoom chatRoom = new ChatRoom(roomId,hostId);
        //将房主加入房间
        chatRoom.addMember(hostId);
        //加入缓存
        chatRooms.put(roomId, chatRoom);
        return roomId;
    }

    /**
     * 用户加入房间
     * @param clientId
     * @param roomId
     * @return
     */
    public static boolean joinRoom(long clientId,String roomId){
        if (roomExists(roomId)){
            ChatRoom chatRoom = getChatRoom(roomId);
            chatRoom.addMember(clientId);
            return true;
        }
        return false;
    }

    /**
     * 离开房间
     * @param clientId
     * @param roomId
     * @return
     */
    public static boolean leaveChatRoom(long clientId,String roomId){
        if (roomExists(roomId)){
            ChatRoom chatRoom = getChatRoom(roomId);
            //不是房主直接离开，是房主则需要解散房间
            if(chatRoom.isHost(clientId)){
                removeIfAbsent(roomId);
            }else{
                chatRoom.removeMember(clientId);
            }
            return true;
        }
        return false;
    }
    /**
     * 强制删除房间
     * @param roomId
     * @return
     */
    public static ChatRoom removeIfAbsent(String roomId){
        if (roomExists(roomId)){
            return chatRooms.remove(roomId);
        }
        return null;
    }

    /**
     * 安全删除房间，房间没有人时才能删除
     * 房间不存在也认为删除成功
     * @param roomId
     * @return
     */
    public static boolean removeIfEmpty(String roomId){
        //房间存在
        if (roomExists(roomId)){
            //且没有人在里面
            if(!getChatRoom(roomId).hasMember()){
                chatRooms.remove(roomId);
                return true;
            }
            return false;
        }
        return true;
    }
    /**
     * 获取房间
     * @param roomId
     * @return
     */
    public static ChatRoom getChatRoom(String roomId){
        return chatRooms.get(roomId);
    }

    /**
     * 房间是否存在
     * @param roomId
     * @return
     */
    public static boolean roomExists(String roomId){
        return isEmpty(roomId)&&getChatRoom(roomId)!=null;
    }

    public static boolean isEmpty(String roomId){
        return chatRooms.isEmpty();
    }
}
