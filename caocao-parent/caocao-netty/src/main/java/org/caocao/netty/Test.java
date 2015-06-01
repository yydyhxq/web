package org.caocao.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Test {
private static final int port=8080;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
         EventLoopGroup parentGroup=new NioEventLoopGroup();
    //     EventLoopGroup childrenGroup=new NioEventLoopGroup();
         try{
        	 ServerBootstrap serverBootstrap=new ServerBootstrap();
        	 serverBootstrap.group(parentGroup);
        	 serverBootstrap.localAddress(port);
        	 serverBootstrap.channel(NioServerSocketChannel.class);
        	 serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					// TODO Auto-generated method stub
					ch.pipeline().addLast("myHandler", new MyHanler());
				}		
			});
        	 ChannelFuture cf=serverBootstrap.bind().sync();
        	  System.out.println(MyHanler.class.getName() + " started and listen on " + cf.channel().localAddress());
        	 cf.channel().closeFuture().sync();
         }catch(Exception e){
        	 e.printStackTrace();
         }finally{
        	 parentGroup.shutdownGracefully();
         }
	}

}
