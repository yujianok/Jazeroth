package com.jazeroth.realm.auth;

public class AuthConstants {

    public static final byte AUTH_LOGON_CHALLENGE_CODE = 0x00;



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

    public static final byte WOW_SUCCESS = 0x00;
    public static final byte WOW_FAIL_UNKNOWN0 = 0x01;                 ///< ? Unable to connect
    public static final byte WOW_FAIL_UNKNOWN1 = 0x02;                 ///< ? Unable to connect
    public static final byte WOW_FAIL_BANNED = 0x03;                 ///< This <game> account has been closed and is no longer available for use. Please go to <site>/banned.html for further information.
    public static final byte WOW_FAIL_UNKNOWN_ACCOUNT = 0x04;                 ///< The information you have entered is not valid. Please check the spelling of the account name and password. If you need help in retrieving a lost or stolen password; see <site> for more information
    public static final byte WOW_FAIL_INCORRECT_PASSWORD = 0x05;                 ///< The information you have entered is not valid. Please check the spelling of the account name and password. If you need help in retrieving a lost or stolen password; see <site> for more information
    // client reject next login attempts after this error; so in code used WOW_FAIL_UNKNOWN_ACCOUNT for both cases
    public static final byte WOW_FAIL_ALREADY_ONLINE = 0x06;                 ///< This account is already logged into <game>. Please check the spelling and try again.
    public static final byte WOW_FAIL_NO_TIME = 0x07;                 ///< You have used up your prepaid time for this account. Please purchase more to continue playing
    public static final byte WOW_FAIL_DB_BUSY = 0x08;                 ///< Could not log in to <game> at this time. Please try again later.
    public static final byte WOW_FAIL_VERSION_INVALID = 0x09;                 ///< Unable to validate game version. This may be caused by file corruption or interference of another program. Please visit <site> for more information and possible solutions to this issue.
    public static final byte WOW_FAIL_VERSION_UPDATE = 0x0A;                 ///< Downloading
    public static final byte WOW_FAIL_INVALID_SERVER = 0x0B;                 ///< Unable to connect
    public static final byte WOW_FAIL_SUSPENDED = 0x0C;                 ///< This <game> account has been temporarily suspended. Please go to <site>/banned.html for further information
    public static final byte WOW_FAIL_FAIL_NOACCESS = 0x0D;                 ///< Unable to connect
    public static final byte WOW_SUCCESS_SURVEY = 0x0E;                 ///< Connected.
    public static final byte WOW_FAIL_PARENTCONTROL = 0x0F;                 ///< Access to this account has been blocked by parental controls. Your settings may be changed in your account preferences at <site>
    public static final byte WOW_FAIL_LOCKED_ENFORCED = 0x10;                 ///< You have applied a lock to your account. You can change your locked status by calling your account lock phone number.
    public static final byte WOW_FAIL_TRIAL_ENDED = 0x11;                 ///< Your trial subscription has expired. Please visit <site> to upgrade your account.
    public static final byte WOW_FAIL_USE_BATTLENET = 0x12;                 ///< WOW_FAIL_OTHER This account is now attached to a Battle.net account. Please login with your Battle.net account email address and password.

}
