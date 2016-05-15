package com.jazeroth.realm.auth.command;

import io.netty.buffer.ByteBuf;

import static com.jazeroth.realm.auth.AuthConstants.AUTH_LOGON_CHALLENGE_CODE;

public class LogonChallenge implements AuthCommand {

    private static final String AUTH_CHALLENGE_HANDLER = "logonChallengeHandler";

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

    public byte[] getGamename() {
        return gamename;
    }

    public byte getVersion1() {
        return version1;
    }

    public byte getVersion2() {
        return version2;
    }

    public byte getVersion3() {
        return version3;
    }

    public short getBuild() {
        return build;
    }

    public byte[] getPlatform() {
        return platform;
    }

    public byte[] getOs() {
        return os;
    }

    public byte[] getCountry() {
        return country;
    }

    public int getTimezone_bias() {
        return timezone_bias;
    }

    public byte[] getIp() {
        return ip;
    }

    public String getIpAsString() {
        return (ip[0] & 0xFF) + "."
                + (ip[1] & 0xFF) + "."
                + (ip[2] & 0xFF) + "."
                + (ip[3] & 0xFF);
    }

    public byte getUsernameLength() {
        return usernameLength;
    }

    public String getUsername() {
        return username;
    }
}
