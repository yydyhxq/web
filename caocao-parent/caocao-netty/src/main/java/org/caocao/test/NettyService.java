package org.caocao.test;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

import java.util.concurrent.ConcurrentHashMap;
public class NettyService {
public static void main(String[] args)
{
	final ConcurrentHashMap mp=new ConcurrentHashMap();
	NioEventLoopGroup bossgroup=new NioEventLoopGroup();
	NioEventLoopGroup workgroup=new NioEventLoopGroup();
	ServerBootstrap server=new ServerBootstrap();
	server.group(bossgroup,workgroup).channel(NioServerSocketChannel.class).childOption(ChannelOption.SO_KEEPALIVE,true)
	.childOption(ChannelOption.SO_BACKLOG,128)
//	.handler(new IdleStateHandler(5, 5, 5, TimeUnit.SECONDS))
	.handler(new LoggingHandler(LogLevel.INFO))
	.childHandler(new ChannelInitializer<SocketChannel>() {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			// TODO Auto-generated method stub
			ChannelPipeline line=ch.pipeline();

			line.addLast(new MsgDecoder());
			line.addLast(new MsgEncoder());
			line.addLast(new StringDecoder(CharsetUtil.UTF_8));
			line.addLast(new StringEncoder(CharsetUtil.UTF_8));
	//		line.addLast(new IdleStateHandler(5, 5, 5, TimeUnit.SECONDS));
			line.addLast(new SimpleChannelInboundHandler<Msg>() {

				@Override
				protected void channelRead0(ChannelHandlerContext ctx,
						Msg msg) throws Exception {
					// TODO Auto-generated method stub
					System.out.println("从客户端"+ctx.channel().remoteAddress().toString()+"接受:"+msg.getMessageId());
					if(mp.get(ctx.channel().remoteAddress())==null)
					{
					mp.put(ctx.channel().remoteAddress(), ctx.channel());
					}
				System.out.println("共有个连接："+mp.entrySet().size());
				
				Channel temp=(Channel)mp.get(ctx.channel().remoteAddress());
			//    temp.writeAndFlush(msg);
				Iterator it=mp.entrySet().iterator();
				while(it.hasNext())
				{
			    Entry  e=(Entry)it.next();
				System.out.println("客户端信息IP:"+e.getKey());
				System.out.println("开始广播消息...");
				   ((Channel)e.getValue()).writeAndFlush(msg);
				}


				}

				@Override
				public void userEventTriggered(ChannelHandlerContext ctx,
						Object evt) throws Exception {
					if(evt instanceof IdleStateEvent)
					{
						IdleState st=((IdleStateEvent) evt).state();
						if(st.equals(IdleState.READER_IDLE))
						{
							System.out.println("读取数据长时间空闲");
							ChannelFuture  future=ctx.channel().close();
							future.addListener(new FutureListener() {

								@Override
								public void operationComplete(Future future)
										throws Exception {
									// TODO Auto-generated method stub
									System.out.println("是否关闭成功:"+future.isSuccess());
								}
								
							});
						}
					}
					// TODO Auto-generated method stub
					super.userEventTriggered(ctx, evt);
				}
				
			});
		}
		
	});
	try {
		ChannelFuture future=server.bind(8080).sync();
		future.addListener(new FutureListener() {

			@Override
			public void operationComplete(Future future) throws Exception {
				// TODO Auto-generated method stub
			 System.out.println(future.isSuccess());
			}

	
			
		});
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		bossgroup.shutdownGracefully();
		workgroup.shutdownGracefully();
	}
}
}
