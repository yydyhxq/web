package com.caocao.nio.tools;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息解码
 */
public class MsgDecoder extends ByteToMessageDecoder {
	private static final Logger logger = LoggerFactory.getLogger(MsgDecoder.class);

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
		System.out.println("执行消息解码");
		try {
			if (in.readableBytes() < 10) {// 不够读出消息头
				return;
			}
			int index = in.readerIndex();
			byte cmd = in.getByte(index);
			boolean needConfirm = (in.getByte(index+1) == 1);
			int msgId = in.getInt(index+2);
			int length = in.getInt(index + 6);
			if (in.readableBytes() < length + 10) {// 不够读出一条完整的消息内容
				return;
			}
			byte[] data = new byte[length];
			in.skipBytes(10);
			in.readBytes(data);		
			EncryptUtil.encrypt(data);
			String content = new String(data, CharsetUtil.UTF_8);
			Msg msg = new Msg();
			msg.cmd = cmd;
			msg.content = content;
			msg.msgId = msgId;
			msg.needConfirm = needConfirm;

			out.add(msg);
		} catch (Exception e) {
		    logger.error("消息{}读取出错,关闭客户端",in);
			ctx.channel().close();
			ctx.channel().disconnect();
		}

	}

}
