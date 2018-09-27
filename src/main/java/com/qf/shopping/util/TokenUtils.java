package com.qf.shopping.util;

import java.util.Base64;
import com.qf.shopping.pojo.User;

public class TokenUtils {
   
    
	public static String getToken(String sessionId,User user) {
		String str=user.getLoginName()+user.getPassword();
		String userNamePwdStr=new String(Base64.getEncoder().encode(str.getBytes()));
		return userNamePwdStr;
	}
	
}
