package com.cqupt.utils;

public class CodeUtils {

	public static String decode(String key){
		if(key.equals("user")){
			return "root";
		}else if(key.equals("password")){
			return "1234";
		}
		return null;
	}

}
