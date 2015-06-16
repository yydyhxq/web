package org.caocao.test;

import java.nio.charset.Charset;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

public class NettyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NioEventLoopGroup lg=new NioEventLoopGroup(1);
      Bootstrap client=new Bootstrap();
      client.group(lg).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY,true)
      .handler(new ChannelInitializer<SocketChannel>() {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			// TODO Auto-generated method stub
	ChannelPipeline line=ch.pipeline();
	line.addLast(new LoggingHandler());
	line.addLast(new MsgDecoder());
	line.addLast(new MsgEncoder());
	line.addLast(new SimpleChannelInboundHandler<Msg>() {

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println(cause.getMessage());
			ctx.channel().close();
			ctx.channel().disconnect();
		//	super.exceptionCaught(ctx, cause);
		}

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, Msg msg)
				throws Exception {
			// TODO Auto-generated method stubt
		
			
			System.out.println("客户端"+ctx.channel().localAddress().toString()+"接受到消息:"+msg.toString());
			Thread.sleep(2000);
			String content="hellocity222";
			System.out.println("content.getBytes().length:"+content.getBytes().length);
			Msg msg2=new Msg((byte)100,(short) 256,content.getBytes().length,content);
			ctx.writeAndFlush(msg2);
		}

		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			// TODO Auto-generated method stub
			System.out.println(ctx.channel().localAddress().toString());
			String content="hellocity";
			System.out.println("content.getBytes().length:"+content.getBytes().length);
			Msg msg=new Msg((byte)100,(short) 256,content.getBytes().length,content);
			ctx.writeAndFlush(msg);
		
		}
		
	});	
	line.addLast(new SimpleChannelInboundHandler<String>()
			{

				@Override
				protected void channelRead0(ChannelHandlerContext ctx,
						String msg) throws Exception {
					System.out.println("从服务端接收到:"+msg);
					// TODO Auto-generated method stub
					
				}
		
			});
	
		}
    	  
	});
     try {
		ChannelFuture future= client.connect("127.0.0.1", 8080).sync();
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
		lg.shutdownGracefully();
	}
	}

}
