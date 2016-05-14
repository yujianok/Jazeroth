package com.jazeroth.realm.auth.command;

import io.netty.buffer.ByteBuf;

import static com.jazeroth.realm.auth.AuthConstants.AUTH_CHALLENGE_HANDLER;
import static com.jazeroth.realm.auth.AuthConstants.AUTH_LOGON_CHALLENGE_CODE;

/**
 * Created by Jack on 2016/5/8.
 */
public class LogonChallenge implements AuthCommand {

    private short size;

    private byte[] gamename = new byte[4];

    private byte version1;

    private byte version2;

    private byte version3;

    private short build;

    private byte[] platform = new byte[4];

    private byte[] os = new byte[4];

    private byte[] country = new byte[4];

    private int timezone_bias;

    private byte[] ip = new byte[4];

    private byte usernameLength;

    private String username;

    public byte commandCode() {
        return AUTH_LOGON_CHALLENGE_CODE;
    }

    public String commandHandler() {
        return AUTH_CHALLENGE_HANDLER;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    @Override
    public AuthCommand read(ByteBuf byteBuf) {
        byteBuf.readBytes(gamename);
        version1 = byteBuf.readByte();
        version2 = byteBuf.readByte();
        version3 = byteBuf.readByte();
        build = byteBuf.readShort();
        byteBuf.readBytes(platform);
        byteBuf.readBytes(os);
        byteBuf.readBytes(country);
        timezone_bias = byteBuf.readInt();
        byteBuf.readBytes(ip);
        usernameLength = byteBuf.readByte();
        byte[] usernameBytes = new byte[usernameLength];
        byteBuf.readBytes(usernameBytes);
        username = new String(usernameBytes);

        return this;
    }


}
