package com.jazeroth.realm.auth.command;

import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;

public interface AuthCommand {

    byte commandCode();

    String commandHandler();

    public short getSize();

    public void setSize(short size);

    AuthCommand read(ByteBuf byteBuf);
}
