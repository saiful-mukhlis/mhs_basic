package com.bmb.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class S {
	

	private S() {
	}
	private static ApplicationContext appContext = null;
	public static synchronized ApplicationContext getCtx() {
		if (null == appContext) {
				appContext = new ClassPathXmlApplicationContext("ac.xml");
			
		} 
		return appContext;
	}
	public static Object getBean(String nama) {
		return getCtx().getBean(nama);
	}
}
