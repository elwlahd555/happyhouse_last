package com.ssafy.happy.common;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DButil {
	public static Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/ssafy");
		return dataSource.getConnection();
	}
}
