package org.code4j.pushy.common.pojo.chatroom;

import org.code4j.pushy.common.util.StringUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Description : ${CLASS_NAME}
 * Created by code4j on 2016/3/24 0024
 * 12:46
 */
public class ChatRoom {

    private String roomId;

    private long hostId;

    private Set<Long> membersId = Collections.synchronizedSet(new HashSet<Long>());

    public ChatRoom(){}

    public ChatRoom(long hostId) {
        this.hostId = hostId;
        this.roomId = StringUtil.randomCode(9);
    }

    public ChatRoom(String roomId, long hostId) {
        this.roomId = roomId;
        this.hostId = hostId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public long getHostId() {
        return hostId;
    }

    public void setHostId(long hostId) {
        this.hostId = hostId;
    }

    public Set<Long> getMembersId() {
        return membersId;
    }

    public void setMembersId(Set<Long> membersId) {
        this.membersId = membersId;
    }

    public void addMember(long clientId){
        this.membersId.add(clientId);
    }

    public void removeMember(long clientId){
        this.membersId.remove(clientId);
    }

    public void removeAll(){
        this.membersId.clear();
    }

    /**
     * 是否是房主
     * @param clientId
     * @return
     */
    public boolean isHost(long clientId){
        return clientId == this.hostId;
    }
    /**
     * 人数为1时表示房间没人（不算群主）
     * @return
     */
    public boolean hasMember(){
        return this.membersId.size()>1;
    }

    public int number(){
        return this.membersId.size();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatRoom)) return false;

        ChatRoom chatRoom = (ChatRoom) o;

        if (!roomId.equals(chatRoom.roomId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return roomId.hashCode();
    }
}
