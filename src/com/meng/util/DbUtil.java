package com.meng.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//数据库工具类
public class DbUtil {
	private static ComboPooledDataSource ds = null;

	static {
		//初始化数据库连接池
		try {
			//创建数据库连接池
			ds = new ComboPooledDataSource();
			// 设置JDBC的Driver类
			ds.setDriverClass("com.mysql.jdbc.Driver");
			// 设置JDBC的URL
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/guet?characterEncoding=utf-8");
			// 设置数据库的登录用户名
			ds.setUser("root");
			// 设置数据库的登录用户密码
			ds.setPassword("1234");
			// 设置连接池的最大连接数
			ds.setMaxPoolSize(100);
			// 设置连接池的最小连接数
			ds.setMinPoolSize(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取数据库连接
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

}
