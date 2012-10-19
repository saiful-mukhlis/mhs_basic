package com.bmb.util;

public enum Db {
	USR("daoUsr")
	;
	
	private String cls;
	private Db(String n) {
		cls = n;
	}
	public Object get() {
		return S.getBean(cls);
	}
}
