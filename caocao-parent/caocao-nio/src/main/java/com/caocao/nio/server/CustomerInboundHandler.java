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

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caocao.nio.tools.Msg;

/**
 * 执行读取客户端数据、进行业务处理
 */
@Sharable
public class CustomerInboundHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerInboundHandler.class);


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object o) {
		Msg msg = (Msg) o;
		
		/*switch (msg.cmd) {
		case MsgProtocol.CMD_HEART_BEAT:// 心跳
			ctx.write(o);
			break;
		case MsgProtocol.CMD_CONNECT:// 初次连接
			if (!channels.containsKey(ctx.channel())) {
				String[] data = msg.content.split(":", 2);
				String userId = data[0];
				//ctx.channel().pipeline().addLast(new Ch)
			}
			break;
		case MsgProtocol.CMD_RECONNECT:// 断线重连
			break;
		case MsgProtocol.CMD_UPDATE_DRIVER_LOCATION:// 更新司机端位置信息
			Driver driver = channels.get(ctx.channel());
			String content = msg.content;
			break;
		}*/
		ReferenceCountUtil.release(o);
		System.out.println("客户端收到消息:"+msg.toString());
	//	 ctx.write(Unpooled.copiedBuffer("you are ok",CharsetUtil.UTF_8));
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		// ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// Close the connection when an exception is raised.
		logger.error("消息处理出错{}", cause.getMessage());
		ctx.channel().close();
		ctx.channel().disconnect();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			if (event.state().equals(IdleState.READER_IDLE)) {
				ctx.channel().close();
				ctx.channel().disconnect();
				logger.info("客户端{}长时间无数据请求，自动断线", ctx.channel().remoteAddress());
			}
		}
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
	}
}
