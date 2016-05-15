package com.jazeroth.realm.auth.handler;

import com.jazeroth.realm.auth.command.LogonChallenge;
import com.jazeroth.realm.auth.result.LogonChallengeResult;
import com.jazeroth.realm.dao.AccountDao;
import com.jazeroth.realm.dao.BannedIpDao;
import com.jazeroth.realm.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.jazeroth.realm.auth.AuthConstants.WOW_FAIL_BANNED;

@Component
public class LogonChallengeHandler implements AuthCommandHandler<LogonChallenge, LogonChallengeResult> {

    private static final Logger logger = LoggerFactory.getLogger(LogonChallengeHandler.class);

    @Autowired
    private BannedIpDao bannedIpDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    public LogonChallengeResult handleAuthCommand(LogonChallenge authCommand) {
        LogonChallengeResult result = new LogonChallengeResult();

        if (isIpBanned(authCommand.getIpAsString())) {
            result.setErrorCode(WOW_FAIL_BANNED);
            logger.info("Banned ip {} tries to login!", authCommand.getIpAsString());
        } else {
            Account account = accountDao.findByUsername(authCommand.getUsername());
            if (account.isLocked()) {
                result.setErrorCode(WOW_FAIL_BANNED);
                logger.info("Account {} is locked to IP - '{}'", authCommand.getUsername(), authCommand.getIpAsString());
            }
        }

        return result;
    }

    private boolean isIpBanned(String ip) {
        return bannedIpDao.countBannedIp(ip) > 0;
    }
}
