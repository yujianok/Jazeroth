package com.jazeroth.realm.auth.result;

import io.netty.buffer.ByteBuf;

/**
 * Created by Jack on 2016/5/10.
 */
public interface AuthResult {

    byte commandCode();

    byte errorCode();

    ByteBuf write(ByteBuf byteBuf);

}
