package com.jazeroth.realm.bean;


import com.jazeroth.realm.auth.handler.AuthCommandHandler;

/**
 * Created by Jack on 2016/5/10.
 */
public interface CommandHandlerBeanLocator {

    AuthCommandHandler getAuthCommandHandler(String authCommandHandler);

}
