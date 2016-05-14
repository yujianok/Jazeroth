package com.jazeroth.realm.oi.channel;

import com.jazeroth.realm.auth.command.AuthCommand;
import com.jazeroth.realm.auth.handler.AuthCommandHandler;
import com.jazeroth.realm.auth.result.AuthResult;
import com.jazeroth.realm.bean.CommandHandlerBeanLocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Jack on 2016/5/10.
 */
@Component
@Scope("prototype")
public class AuthCommandDispatcher extends ChannelInboundHandlerAdapter {

    @Autowired
    private CommandHandlerBeanLocator commandHandlerBeanLocator;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        AuthCommand authCommand = (AuthCommand) msg;
        String authCommandHandlerName = authCommand.commandHandler();
        AuthCommandHandler authCommandHandler = commandHandlerBeanLocator.getAuthCommandHandler(authCommandHandlerName);

        AuthResult authResult = authCommandHandler.handleAuthCommand(authCommand);
        ctx.write(authResult);
    }
}
