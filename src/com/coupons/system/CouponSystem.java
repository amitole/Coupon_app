package com.coupons.system;

import java.sql.SQLException;

import com.coupons.pool.ConnectionPool;

public class CouponSystem {
	private static ConnectionPool pool;
	
	static{
		String dbName = "CouponSystem";
		String url = "jdbc:mysql://127.0.0.1:3306/" + dbName;
		String username = "root";
		String password = "didi182";
		try {
			pool = new ConnectionPool(url, username, password);
		} catch (SQLException e) {
			System.out.println("Cannot create connection pool. "
					+ "reason: " + e.getMessage());
			System.exit(1);
		}
	}
	
	public static ConnectionPool getConnectionPool()
	{
		return pool;
	}
}


//private Connection getConnection() throws SQLException
////{
////	// TODO: maybe we should catch the exception here
////	// and close the program. It is too severe
////	String dbName = "CouponSystem";
////	String url = "jdbc:mysql://127.0.0.1:3306/" + dbName; 
////	return DriverManager.getConnection(url, "root", "didi182");
////}
