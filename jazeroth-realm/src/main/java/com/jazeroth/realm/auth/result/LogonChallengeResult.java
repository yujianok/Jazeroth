package com.jazeroth.realm.auth.result;

import com.jazeroth.realm.auth.AuthConstants;
import io.netty.buffer.ByteBuf;

import static com.jazeroth.realm.auth.AuthConstants.AUTH_LOGON_CHALLENGE_CODE;

public class LogonChallengeResult implements AuthResult {

    private final byte commandCode = AUTH_LOGON_CHALLENGE_CODE;

    private byte unknownField1 = 0x00;

    private byte errorCode;

    private byte[] B = new byte[32];

    private byte g_len;

    private byte g;

    private byte N_len;

    private byte[] N = new byte[32];

    private byte[] s = new byte[32];

    private byte[] unknownField2 = new byte[16];

    private byte unknownField3 = 0x00;

    @Override
    public byte commandCode() {
        return commandCode;
    }

    @Override
    public byte errorCode() {
        return errorCode;
    }

    public byte getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(byte errorCode) {
        this.errorCode = errorCode;
    }

    public byte getUnknownField1() {
        return unknownField1;
    }

    public void setUnknownField1(byte unknownField1) {
        this.unknownField1 = unknownField1;
    }

    public byte[] get_B() {
        return B;
    }

    public void set_B(byte[] B) {
        this.B = B;
    }

    public byte get_g_len() {
        return g_len;
    }

    public void set_g_len(byte g_len) {
        this.g_len = g_len;
    }

    public byte get_g() {
        return g;
    }

    public void set_g(byte g) {
        this.g = g;
    }

    public byte get_N_len() {
        return N_len;
    }

    public void set_N_len(byte N_len) {
        this.N_len = N_len;
    }

    public byte[] get_N() {
        return N;
    }

    public void set_N(byte[] N) {
        this.N = N;
    }

    public byte[] get_s() {
        return s;
    }

    public void set_s(byte[] s) {
        this.s = s;
    }

    public byte[] getUnknownField2() {
        return unknownField2;
    }

    public void setUnknownField2(byte[] unknownField2) {
        this.unknownField2 = unknownField2;
    }

    public byte getUnknownField3() {
        return unknownField3;
    }

    public void setUnknownField3(byte unknownField3) {
        this.unknownField3 = unknownField3;
    }

    @Override
    public void write(ByteBuf byteBuf) {
        byteBuf.writeByte(commandCode);
        byteBuf.writeByte(unknownField1);
        byteBuf.writeByte(errorCode);

        if (errorCode == AuthConstants.WOW_SUCCESS) {
            byteBuf.writeBytes(B);
            byteBuf.writeByte(g_len);
            byteBuf.writeByte(g);
            byteBuf.writeByte(N_len);
            byteBuf.writeBytes(N);
            byteBuf.writeBytes(s);
            byteBuf.writeBytes(unknownField2);
            byteBuf.writeByte(unknownField3);
        }
    }
}
