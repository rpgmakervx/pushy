package org.code4j.pushy.server.bootstrap;/**
 * Description : Launcher
 * Created by YangZH on 2016/3/8 0008
 *  22:40
 */

import org.code4j.pushy.server.handler.ServerChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Description : Launcher
 * Created by YangZH on 2016/3/8 0008
 * 22:40
 */

public final class PushyServer implements Runnable{

    private ChannelFuture f;
    private int port;

    public PushyServer(int port){
        this.port = port;
    }
    /**
     * 客户端填写启动端口
     */
    private void startup(){
        System.out.println("服务已启动");
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.option(ChannelOption.SO_BACKLOG, 2048);//serverSocketchannel的设置，链接缓冲池的大小
            b.childOption(ChannelOption.SO_KEEPALIVE, true);//socketchannel的设置,维持链接的活跃，清除死链接
            b.childOption(ChannelOption.TCP_NODELAY, true);
            b.childHandler(new ServerChildChannelHandler());
            // 端口可配
            f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    @Override
    public void run() {
        startup();
    }
}
