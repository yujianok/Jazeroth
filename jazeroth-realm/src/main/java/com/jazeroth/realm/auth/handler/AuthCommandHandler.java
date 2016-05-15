package com.jazeroth.realm.auth.handler;

import com.jazeroth.realm.auth.command.AuthCommand;
import com.jazeroth.realm.auth.result.AuthResult;

public interface AuthCommandHandler<T extends AuthCommand, R extends AuthResult> {

    R handleAuthCommand(T authCommand);

}
