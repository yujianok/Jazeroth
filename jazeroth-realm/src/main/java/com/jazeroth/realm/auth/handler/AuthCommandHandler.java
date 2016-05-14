package com.jazeroth.realm.auth.handler;

import com.jazeroth.realm.auth.command.AuthCommand;
import com.jazeroth.realm.auth.result.AuthResult;

/**
 * Created by Jack on 2016/5/10.
 */
public interface AuthCommandHandler<T extends AuthCommand, R extends AuthResult> {

    R handleAuthCommand(T authCommand);

}
