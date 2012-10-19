package org.bmb.util;
import org.bmb.lang.i8n.Lang;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bmb.ioc.config.LangConfig;
public enum  Ioc {

	LANGALL("lang",Lang.class);
	
	private Class<?> cls;
	private String nama;
	private final static AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(LangConfig.class);

	private Ioc(String nama, Class<?> cls) {
		this.cls = cls;
		this.nama=nama;
	}

	public Object get() {
		return ctx.getBean(nama,cls);
	}
}
