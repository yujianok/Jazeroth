package com.jazeroth.realm.bean;

import io.netty.channel.ChannelHandler;

public interface ChannelHandlerBeanLocator {

    ChannelHandler getChannelHandler(String channelHandlerClass);

}
