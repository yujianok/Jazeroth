package com.jazeroth.realm.oi.channel;

import com.jazeroth.realm.auth.result.AuthResult;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * Created by Jack on 2016/5/10.
 */
public class AuthCommandEncoder extends MessageToByteEncoder<AuthResult> {


    @Override
    protected void encode(ChannelHandlerContext ctx, AuthResult authResult, ByteBuf out) throws Exception {
        ByteBuf byteBuf = authResult.serialize();

        out.writeBytes(byteBuf);
    }
}