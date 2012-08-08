package com.moerog.util;

import java.util.*;

import javax.servlet.http.*;

import com.moerog.module.user.*;

public class FindUserInSession {
	
	public static User getUserBySession(HttpSession session) {
		Enumeration<String> names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			String nextElement = names.nextElement();
			if (nextElement.equalsIgnoreCase("user")) {
				return (User) session.getAttribute("user");
			}
		}
		
		return new User();
	}
}
