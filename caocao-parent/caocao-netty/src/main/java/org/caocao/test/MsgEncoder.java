package org.caocao.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

public class MsgEncoder extends MessageToByteEncoder<Msg> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Msg msg, ByteBuf out)
			throws Exception {
		// TODO Auto-generated method stub
       byte[] content=msg.getContent().getBytes(CharsetUtil.UTF_8);
       ByteBuf bf=Unpooled.buffer(content.length+7);
       bf.writeByte(msg.getCmd());
       bf.writeShort(msg.getMessageId());
       bf.writeInt(msg.getContentLength());
       bf.writeBytes(content);
       ctx.write(bf);
       ctx.flush();
	}

}
