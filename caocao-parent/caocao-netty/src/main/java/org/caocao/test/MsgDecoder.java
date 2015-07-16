package org.caocao.test;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

public class MsgDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		if(in.readableBytes()<7)
		{
			return;
		}
	   int index=in.readerIndex();
	   byte cmd=in.getByte(index); //一个byte占一位 0
	   short messageId=in.getShort(index+1); //一个short占2位 1+2
	   System.out.println("messageId:"+messageId);
       int contentlength=in.getInt(index+3);
       System.out.println("contentlength:"+contentlength);
       if(in.readableBytes()<contentlength+7)
       {
    	   return ;
       }
       byte[] shuju=new byte[contentlength];
       in.skipBytes(7);
       in.readBytes(shuju);
       String cont=new String(shuju,CharsetUtil.UTF_8);
       Msg g=new Msg();
       g.setCmd(cmd);
       g.setContent(cont);
       g.setContentLength(contentlength);
       g.setMessageId(messageId);
       out.add(g);
	}

}
