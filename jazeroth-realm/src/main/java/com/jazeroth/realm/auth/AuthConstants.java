package com.jazeroth.realm.auth;

/**
 * Created by Jack on 2016/5/10.
 */
public class AuthConstants {

    public static final byte AUTH_LOGON_CHALLENGE_CODE = 0x00;
    public static final short AUTH_LOGON_CHALLENGE_SIZE = 35;
    public static final String AUTH_CHALLENGE_HANDLER = "LogonChallengeHandler";


    public static final byte AUTH_LOGON_PROOF_CODE = 0x01;
    public static final byte AUTH_RECONNECT_CHALLENGE_CODE = 0x02;
    public static final byte AUTH_RECONNECT_PROOF_CODE = 0x03;
    public static final byte REALM_LIST_CODE = 0x10;
    public static final byte XFER_INITIATE_CODE = 0x30;
    public static final byte XFER_DATA_CODE = 0x31;

    // these opcodes no longer exist in currently supported client
    public static final byte XFER_ACCEPT_CODE = 0x32;
    public static final byte XFER_RESUME_CODE = 0x33;
    public static final byte XFER_CANCEL_CODE = 0x34;

}
