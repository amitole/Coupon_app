package com.coupons.dao.dbimpl;

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
import com.coupons.beans.Customer;
import com.coupons.dao.CustomerDao;
import com.coupons.exceptions.DaoException;
import com.coupons.system.CouponSystem;

public class CustomerDBDao implements CustomerDao
{
	private static final String TABLE_NAME = "Customer";
	
	@Override
	public void createCustomer(Customer c) throws DaoException {
		// 1. get a connection (from pool)
		Connection con = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement(
					"INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?)");
			stat.setInt(1, c.getId());
			stat.setString(2, c.getName());
			stat.setString(3, c.getPassword());
			
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
	public Customer getCustomer(int id) throws DaoException {
		
		Connection con = null;
		Customer result = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			Statement stat = con.createStatement();
			
					
			String sql = "SELECT * FROM " + TABLE_NAME + " where ID =" + id;
			ResultSet rs = stat.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while (rs.next()) {
				result = new Customer(
						rs.getInt("ID"),
						rs.getString("CUST_NAME"),
						rs.getString("PASSWORD")
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
	public void removeCustomer(Customer c) throws DaoException {
		
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
	public void updateCustomer(Customer c) throws DaoException {
		Connection con = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement(
					"UPDATE " + TABLE_NAME + " SET CUST_NAME =  ? , PASSWORD = ? WHERE ID = ?");
			
			
			stat.setInt(3, c.getId());	
			stat.setString(1, c.getName());
			stat.setString(2, c.getPassword());
			
			
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
	public List<Customer> getAllCustomers() throws DaoException {
		Connection con = null;
		List<Customer> result = new ArrayList<>();
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * from " + TABLE_NAME);
			
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				result.add(new Customer(
						rs.getInt("ID"),
						rs.getString("CUST_NAME"),
						rs.getString("PASSWORD")
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
	
	@Override
	public List<Coupon> getAllCoupons() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login( Customer c, String name, String password) throws DaoException {
		
		if (c.getName().equals(name) && c.getPassword().equals(password)) {
	        System.out.print("Login Succeeded ");
	        return true;
	    } else {
	        System.out.print("Name Or Password Incorrect");
	    }
		
		return false;
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
