package com.caocao.nio.tools;

import java.nio.charset.Charset;

public class EncryptUtil {
	private final static String keyStr = "CaoCaoZhuanChe密钥";
	private final static byte[] keyData = keyStr.getBytes(Charset.forName("UTF-8"));
	
	public static byte[] encrypt(byte[] data){
	    for(int i=0; i<data.length;i++){
	    		data[i] ^= keyData[i%keyData.length];
	    }
	    return data;
	}
	
}
