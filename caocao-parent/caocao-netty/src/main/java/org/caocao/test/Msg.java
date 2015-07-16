package org.caocao.test;

public class Msg {
	private byte cmd; // 一个BYTE占一个字节(英文，可以表示2的8次方-1个数字，即-128~+127）
	private short messageId; // 一个short表示2个字节(英文，可以表示2的16次方-1个数字）
	private int contentLength; // 一个INT表示4个字节(英文，可以表示2的32次方-1个数字）；
	private String content; // 需要根据contentlength计算出长度

	public Msg(byte cmd, short messageId, int contentLength, String content) {
		this.cmd = cmd;
		this.messageId = messageId;
		this.contentLength = contentLength;
		this.content = content;
	}
   public Msg()
   {
	   
   }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.cmd+this.messageId+this.contentLength+this.content;
	}

	public byte getCmd() {
		return cmd;
	}

	public void setCmd(byte cmd) {
		this.cmd = cmd;
	}

	public short getMessageId() {
		return messageId;
	}

	public void setMessageId(short messageId) {
		this.messageId = messageId;
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
