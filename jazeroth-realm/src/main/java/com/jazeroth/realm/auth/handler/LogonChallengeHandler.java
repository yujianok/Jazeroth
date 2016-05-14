package com.jazeroth.realm.auth.handler;

import com.jazeroth.realm.auth.command.LogonChallenge;
import com.jazeroth.realm.auth.command.LogonChallengeResult;
import org.springframework.stereotype.Component;

/**
 * Created by Jack on 2016/5/10.
 */
@Component
public class LogonChallengeHandler implements AuthCommandHandler<LogonChallenge, LogonChallengeResult> {

    @Override
    public LogonChallengeResult handleAuthCommand(LogonChallenge authCommand) {
        return null;
    }
}
