package com.jazeroth.realm.oi.listener;

import com.jazeroth.realm.auth.command.AuthCommandFactory;
import com.jazeroth.realm.bean.ChannelHandlerBeanLocator;
import com.jazeroth.realm.config.RealmConfig;
import com.jazeroth.realm.oi.channel.AuthCommandDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Jack on 2016/5/8.
 */
@Component
public class AuthenticationListener {

    @Autowired
    private RealmConfig realmConfig;

    @Autowired
    private ChannelHandlerBeanLocator handlerBeanLocator;

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    private ChannelFuture channelFuture;

    @PostConstruct
    public void beginListening() throws InterruptedException {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(handlerBeanLocator.getChannelHandler("authCommandDecoder"));
                        ch.pipeline().addLast(handlerBeanLocator.getChannelHandler("authCommandEncoder"));
                        ch.pipeline().addLast(handlerBeanLocator.getChannelHandler("authCommandDispatcher"));
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);

        channelFuture = serverBootstrap.bind(realmConfig.getPort()).sync();
    }

    @PreDestroy
    public void stopListening() throws InterruptedException {
        channelFuture.channel().closeFuture().sync();
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

}
