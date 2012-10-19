package com.bmb.db.config;

import org.apache.commons.dbcp.BasicDataSource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class DataSource extends BasicDataSource {
	public DataSource() {
		super();
		setDriverClassName("com.mysql.jdbc.Driver");
		//setUrl("jdbc:h2:db/jdl");//app
		setUrl("jdbc:mysql://localhost:3306/test");//develop
		setUsername("root");
		setPassword("");
		setInitialSize(10);
		setMaxActive(8);
		setMaxWait(5000);
		setMinIdle(1);
	}

}


