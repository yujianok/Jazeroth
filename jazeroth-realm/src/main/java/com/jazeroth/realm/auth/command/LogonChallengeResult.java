package com.jazeroth.realm.auth.command;

import com.jazeroth.realm.auth.result.AuthResult;
import io.netty.buffer.ByteBuf;

import static com.jazeroth.realm.auth.command.AuthConstants.AUTH_LOGON_CHALLENGE_CODE;

/**
 * Created by Jack on 2016/5/10.
 */
public class LogonChallengeResult implements AuthResult {

    private byte errorCode;

    @Override
    public byte commandCode() {
        return AUTH_LOGON_CHALLENGE_CODE;
    }

    @Override
    public byte errorCode() {
        return errorCode;
    }

    @Override
    public ByteBuf serialize() {
        return null;
    }
}
