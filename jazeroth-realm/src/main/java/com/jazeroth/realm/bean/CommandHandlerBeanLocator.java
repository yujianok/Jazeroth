package com.jazeroth.realm.bean;


import com.jazeroth.realm.auth.handler.AuthCommandHandler;

public interface CommandHandlerBeanLocator {

    AuthCommandHandler getAuthCommandHandler(String authCommandHandler);

}
