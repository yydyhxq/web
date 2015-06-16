package com.caocao.nio.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;

import com.caocao.nio.tools.MsgDecoder;
import com.caocao.nio.tools.MsgEncoder;

public class CustomerInitializer extends ChannelInitializer<SocketChannel> {
	@Value("${nio.idletime}")
	private long idleTime;

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ChannelPipeline pipe = ch.pipeline();
		pipe.addLast(new IdleStateHandler(idleTime, idleTime, idleTime,
				TimeUnit.SECONDS));
		pipe.addLast(new MsgDecoder());
		pipe.addLast(new MsgEncoder());
		pipe.addLast(new CustomerInboundHandler());
	}

}
