package com.jazeroth.realm.oi.channel;

import com.jazeroth.realm.auth.command.AuthCommand;
import com.jazeroth.realm.auth.command.AuthCommandFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.nio.ByteOrder;
import java.util.List;

/**
 * Created by Jack on 2016/5/8.
 */
@Component
@Scope("prototype")
public class AuthCommandDecoder extends ByteToMessageDecoder {

    private static final Logger logger = LoggerFactory.getLogger(AuthCommandDecoder.class);

    @Autowired
    private AuthCommandFactory authCommandFactory;

    private AuthCommand currentAuthCommand;

    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }

        ByteBuf byteBuf = in.order(ByteOrder.LITTLE_ENDIAN);
        if (currentAuthCommand == null) {
            byte code = byteBuf.readByte();
            byte error = byteBuf.readByte();
            short size = byteBuf.readShort();
            currentAuthCommand = authCommandFactory.createCommandByCode(code);
            currentAuthCommand.setSize(size);
        }

        if (currentAuthCommand.getSize() <= byteBuf.readableBytes()) {
            currentAuthCommand.deserialize(byteBuf);
            out.add(currentAuthCommand);
        }
    }

}
