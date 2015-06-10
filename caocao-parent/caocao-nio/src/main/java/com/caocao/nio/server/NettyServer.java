/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.caocao.nio.server;

import javax.annotation.PreDestroy;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * nio通信主服务端
 */
@Component("nettyServer")
public class NettyServer {
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerInboundHandler.class);

	@Value("${nio.port}")
	private int port;
	private EventLoopGroup bossGroup, workerGroup;

	// @PostConstruct
	public void initAndStart() {
		// Configure the server.
		bossGroup = new NioEventLoopGroup(Runtime.getRuntime()
				.availableProcessors() * 2);
		workerGroup = new NioEventLoopGroup(Runtime.getRuntime()
				.availableProcessors() * 2);
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 128)
					.option(ChannelOption.SO_KEEPALIVE, true)
					.option(ChannelOption.TCP_NODELAY, true)
					.option(ChannelOption.SO_SNDBUF, 5 * 1024)
					.option(ChannelOption.SO_SNDBUF, 5 * 1024)
					.option(ChannelOption.RCVBUF_ALLOCATOR,
							new AdaptiveRecvByteBufAllocator(40, 64, 1024))
					.option(ChannelOption.ALLOCATOR,
							PooledByteBufAllocator.DEFAULT)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new CustomerInitializer());

			// Start the server.
			ChannelFuture f = b.bind(port).sync();

			// Wait until the server socket is closed.
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			logger.error("netty服务器启动失败", e);
		} finally {
			// Shut down all event loops to terminate all threads.
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	@PreDestroy
	public void destory() {
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
	}
}
