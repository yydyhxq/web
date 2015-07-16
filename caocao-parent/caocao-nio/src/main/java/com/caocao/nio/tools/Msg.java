package com.caocao.nio.tools;

public class Msg {
	/**指令 **/
	public byte cmd;
	/**是否需要回复**/
	public boolean needConfirm;
	/**消息正文**/
	public String content;
	/**消息ID**/
	public int msgId;
	
	public String toString(){
		return "CMD:"+cmd+"    Content:"+content;
	}
	
	
	
}
