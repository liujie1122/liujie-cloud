package com.zjty.threem.utils;

import java.util.UUID;

public class UUIDUtils {

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String getUUIDFileName(String filename){
		return UUID.randomUUID().toString().replace("-", "");
	}
}