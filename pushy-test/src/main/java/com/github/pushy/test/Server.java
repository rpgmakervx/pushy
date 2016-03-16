package com.github.pushy.test;/**
 * Description : Server
 * Created by YangZH on 2016/3/16 0016
 *  14:20
 */

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;


/**
 * Description : Server
 * Created by YangZH on 2016/3/16 0016
 * 14:20
 */

public class Server {

    public static void main(String[] args) {
        System.out.println("开启服务端");
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel e) throws Exception {
                    // 解码转 String
                    e.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
                    // 编码器 String
                    e.pipeline().addLast(new StringEncoder(Charset.forName("UTF-8")));
                    e.pipeline().addLast(new ServerHandler());
                }
            });
            b.option(ChannelOption.SO_BACKLOG, 2048);//serverSocketchannel的设置，链接缓冲池的大小
            b.childOption(ChannelOption.SO_KEEPALIVE, true);//socketchannel的设置,维持链接的活跃，清除死链接
            b.childOption(ChannelOption.TCP_NODELAY, true);
            // 端口可配
            ChannelFuture f = b.bind(12120).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
