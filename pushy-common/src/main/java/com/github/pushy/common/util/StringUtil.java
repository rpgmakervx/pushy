package com.github.pushy.common.util;

import java.util.Random;

public class StringUtil {

	public static String seperate(String cp,int index){
		String[] obj = cp.split("-");
		return obj[index];
	}
	public static String randomCode(int level){
		String randCode = "abcdefghijklmnopqrstuvwxyz";
		String numberic = "1234567890";
		String password = "";
		Random rand = new Random();
		for(int i=0;i<level;i++){
			if(i<level/2){
				password = password + randCode.charAt(rand.nextInt(26));
			}else{
				password = password + numberic.charAt(rand.nextInt(10));
			}
		}
		return password;
	}
}
