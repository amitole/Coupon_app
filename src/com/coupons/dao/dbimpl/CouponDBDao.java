package com.coupons.dao.dbimpl;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coupons.beans.Coupon;
import com.coupons.beans.CouponType;
import com.coupons.dao.CouponDao;
import com.coupons.exceptions.DaoException;
import com.coupons.system.CouponSystem;

public class CouponDBDao implements CouponDao
{
	private static final String TABLE_NAME = "Coupon";
	
	@Override
	public void createCoupon(Coupon c) throws DaoException {
		// 1. get a connection (from pool)
		Connection con = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement(
					"INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stat.setInt(1, c.getId());
			stat.setString(2, c.getTitle());
			//stat.setDate(3,   new java.sql.Date(c.getStartDate().getTime()));
			stat.setTimestamp(3, new Timestamp(c.getStartDate().getTime()));
			
			//stat.setDate(4, new java.sql.Date(c.getEndDate().getTime()));
			stat.setTimestamp(4, new Timestamp(c.getEndDate().getTime()));
			
			stat.setInt(5, c.getAmount());
			stat.setString(6, c.getCouponType().name());
			stat.setString(7, c.getMessage());
			stat.setDouble(8, c.getPrice());
			stat.setString(9, c.getImage());
			
			System.out.println("Executing: " + stat.toString());
			stat.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		}
		finally{
			// 3. release connection
			releaseConnection(con);
		}
	}

	@Override
	public Coupon getCoupon(int id) throws DaoException {
		Connection con = null;
		Coupon result = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			Statement stat = con.createStatement();
			
					
			String sql = "SELECT * FROM " + TABLE_NAME + " where ID =" + id;
			ResultSet rs = stat.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while (rs.next()) 
			{
				
				result = new Coupon(
						rs.getInt("ID"),
						rs.getString("TITLE"),
						new Date(rs.getTimestamp("START_DATE").getTime()),
						new Date(rs.getTimestamp("END_DATE").getTime()),
						rs.getInt("AMOUNT"),
						CouponType.valueOf(rs.getString("TYPE")),
						rs.getString("MESSAGE"),
						rs.getDouble("PRICE"),
						rs.getString("IMAGE")
						);
			
			}
			
			return result;
		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		}
		finally{
			// 3. release connection
			releaseConnection(con);
		}
		
		return result;
	}

	@Override
	public void removeCoupon(Coupon c) throws DaoException {
		Connection con = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement(
					"DELETE FROM " + TABLE_NAME + " WHERE ID = ?");
			stat.setInt(1, c.getId());
			
			System.out.println("Executing: " + stat.toString());
			stat.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		}
		finally{
			// 3. release connection
			releaseConnection(con);
		}
	
		
	}

	@Override
	public void updateCoupon(Coupon c) throws DaoException {
		Connection con = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement(
					"UPDATE " + TABLE_NAME + " SET TITLE =  ? , START_DATE = ?  , END_DATE =  ? ,"
							+ " AMOUNT = ? , TYPE =  ? , MESSAGE = ? , PRICE =  ? , IMAGE = ? WHERE ID = ?");
			
			
				
			stat.setString(1, c.getTitle());
			stat.setDate(2, new java.sql.Date(c.getStartDate().getTime()));
			stat.setDate(3, new java.sql.Date(c.getEndDate().getTime()));
			stat.setInt(4, c.getAmount());
			stat.setString(5, c.getCouponType().name());
			stat.setString(6, c.getMessage());
			stat.setDouble(7, c.getPrice());
			stat.setString(8, c.getImage());
			stat.setInt(9, c.getId());
			System.out.println("Executing: " + stat.toString());
			stat.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		}
		finally{
			// 3. release connection
			releaseConnection(con);
		}
		
	}
	
	@Override
	public List<Coupon> getAllCoupons() throws DaoException {
		Connection con = null;
		List<Coupon> result = new ArrayList<>();
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * FROM " + TABLE_NAME);
			
			ResultSet rs = stat.executeQuery();

			while (rs.next()) 
			{
				
				result.add(new Coupon(
						rs.getInt("ID"),
						rs.getString("TITLE"),
						new Date(rs.getTimestamp("START_DATE").getTime()),
						new Date(rs.getTimestamp("END_DATE").getTime()),
						rs.getInt("AMOUNT"),
						CouponType.valueOf(rs.getString("TYPE")),
						rs.getString("MESSAGE"),
						rs.getDouble("PRICE"),
						rs.getString("IMAGE")
						));
			
			}
			
			return result;
		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		}
		finally{
			// 3. release connection
			releaseConnection(con);
		}
			
		return result;
	}

	public List<Coupon> getCouponsByType(String byWhat) throws DaoException {
		Connection con = null;
		List<Coupon> result = new ArrayList<>();
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE TYPE  = ?");
			
			stat.setString(1, byWhat);
			
			ResultSet rs = stat.executeQuery();

			while (rs.next()) 
			{
				
				result.add(new Coupon(
						rs.getInt("ID"),
						rs.getString("TITLE"),
						new Date(rs.getTimestamp("START_DATE").getTime()),
						new Date(rs.getTimestamp("END_DATE").getTime()),
						rs.getInt("AMOUNT"),
						CouponType.valueOf(rs.getString("TYPE")),
						rs.getString("MESSAGE"),
						rs.getDouble("PRICE"),
						rs.getString("IMAGE")
						));
			
			}
			
			return result;
		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		}
		finally{
			// 3. release connection
			releaseConnection(con);
		}
			
		return result;
	}
	
	private Connection getConnection() throws SQLException
	{
		
		return CouponSystem.getConnectionPool().getConnection();
	}
	
	private void releaseConnection(Connection con)
	{		
		CouponSystem.getConnectionPool().free(con);
	}

	

	

	
	
}
