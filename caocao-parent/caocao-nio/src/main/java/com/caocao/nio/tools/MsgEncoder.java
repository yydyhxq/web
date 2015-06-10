package com.caocao.nio.tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息编码
 */
public class MsgEncoder extends MessageToByteEncoder<Msg> {
	private static final Logger logger = LoggerFactory
			.getLogger(MsgEncoder.class);

	@Override
	protected void encode(ChannelHandlerContext ctx, Msg m, ByteBuf out) {
		try {
			byte[] data = m.content.getBytes(MsgProtocol.CHARSET);
			ByteBuf byteBuf = Unpooled.buffer(data.length + 10);
			byteBuf.writeByte(m.cmd);
			byteBuf.writeByte(m.needConfirm ? 1 : 0);
			byteBuf.writeInt(m.msgId);
			byteBuf.writeInt(data.length);
			EncryptUtil.encrypt(data);
			byteBuf.writeBytes(data);
			ctx.write(byteBuf);
			ctx.flush();
		} catch (Exception e) {
			logger.error("消息解码出错{}", e);
		}
	}
}
