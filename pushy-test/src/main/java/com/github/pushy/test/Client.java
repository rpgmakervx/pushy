package com.github.pushy.test;/**
 * Description : Client
 * Created by YangZH on 2016/3/16 0016
 *  14:25
 */

import com.github.pushy.test.handler.ClientHandler;
import com.github.pushy.test.handler.MessageDecoder;
import com.github.pushy.test.handler.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Description : Client
 * Created by YangZH on 2016/3/16 0016
 * 14:25
 */

public class Client {

    public static void main(String[] args) {
        //服务类
        Bootstrap bootstrap = new Bootstrap();
        //worker
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            //设置线程池
            bootstrap.group(worker);
            //设置socket工厂、
            bootstrap.channel(NioSocketChannel.class);
            //设置管道
            bootstrap.handler(new ChannelInitializer<Channel>() {

                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new StringEncoder());
                    ch.pipeline().addLast(new MessageDecoder());
                    ch.pipeline().addLast(new MessageEncoder());
                    ch.pipeline().addLast(new ClientHandler());
                }
            });
            ChannelFuture connect = bootstrap.connect("127.0.0.1", 12120);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.println("请输入：");
                String msg = bufferedReader.readLine();
                connect.channel().writeAndFlush(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            worker.shutdownGracefully();
        }
    }
}
