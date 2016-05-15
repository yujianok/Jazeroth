package com.jazeroth.realm.oi.channel;

import com.jazeroth.realm.auth.result.AuthResult;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AuthCommandEncoder extends MessageToByteEncoder<AuthResult> {

    @Override
    protected void encode(ChannelHandlerContext ctx, AuthResult authResult, ByteBuf out) throws Exception {
        out = ctx.alloc().buffer();

        authResult.write(out);

        ctx.writeAndFlush(out);
    }

}
