package com.jazeroth.realm.bean;

import io.netty.channel.ChannelHandler;

/**
 * Created by Jack on 2016/5/8.
 */
public interface ChannelHandlerBeanLocator {

    ChannelHandler getChannelHandler(String channelHandlerClass);

}
