package com.jazeroth.realm.auth.command;

import org.springframework.stereotype.Component;

import static com.jazeroth.realm.auth.AuthConstants.AUTH_LOGON_CHALLENGE_CODE;


@Component
public class AuthCommandFactory {

    public AuthCommand createCommandByCode(byte code) {
        switch (code) {
            case AUTH_LOGON_CHALLENGE_CODE:
                return new LogonChallenge();
            default:
                return null;
        }
    }

}
