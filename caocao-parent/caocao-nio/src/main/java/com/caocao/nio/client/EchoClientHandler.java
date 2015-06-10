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
package com.caocao.nio.client;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.caocao.nio.tools.Msg;



/**
 * Handler implementation for the echo client.  It initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<Msg> {


    @Override
	protected void channelRead0(ChannelHandlerContext ctx, Msg msg)
			throws Exception {
		// TODO Auto-generated method stub
    	System.out.println("客户端收到:"+msg.toString());
		
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
	}

	/**
     * Creates a client-side handler.
     */
    public EchoClientHandler() {
    }

    private String getString(int cmd){
    	StringBuilder sb  =  new StringBuilder();
    	cmd %= 300;
    	if(cmd<0){
    		cmd = -cmd;
    	}
    	for(int i =0; i<cmd; i++){
    		sb.append(i);
    	}
    	return sb.toString();
    }
    
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
    	final Random random = new Random(0);
    	Timer timer = new Timer();
    	
    	timer.scheduleAtFixedRate(new TimerTask(){
    		byte i = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Msg m = new Msg();
				m.cmd  = i++;
				m.content = getString(random.nextInt());
				ctx.write(m);
			}
    		
    	}, 0, 1000);
    	

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
