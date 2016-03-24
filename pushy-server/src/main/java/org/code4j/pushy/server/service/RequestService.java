package org.code4j.pushy.server.service;

import org.code4j.pushy.common.pojo.message.RequestMessage;
import org.code4j.pushy.common.pojo.request.Request;
import org.code4j.pushy.common.pojo.user.User;
import org.code4j.pushy.common.util.GsonUtils;
import org.code4j.pushy.server.handler.RequestHandler;
import org.code4j.pushy.server.session.Session;

import java.util.Arrays;

/**
 * Description : RequestService
 * Created by code4j on 2016/3/23 0023
 *  23:02
 */

public class RequestService {

    private RequestHandler requestHandler;
    public RequestService(){
        requestHandler = new RequestHandler();
    }

    public void login(Request request,Session session){
        String jsonData = Arrays.toString(request.getData());
        User user = GsonUtils.fromJson(jsonData, User.class);
        requestHandler.login(user.getClientId(),session);
    }

    public void sendRequest(Request request,Session session){
        RequestMessage message = new RequestMessage();
        message.readFromBytes(request.getData());

    }
}
