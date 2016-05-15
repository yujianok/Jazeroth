package com.jazeroth.realm.auth.result;

import io.netty.buffer.ByteBuf;

public interface AuthResult {

    byte commandCode();

    byte errorCode();

    void write(ByteBuf byteBuf);

}
