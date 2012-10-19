package com.bmb.ioc.config;

import org.bmb.lang.i8n.Lang;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LangConfig {
	@Bean
	public Lang lang() {
		Lang langall=new Lang("com.bmb.lang.all");
		return langall;
	}
}
