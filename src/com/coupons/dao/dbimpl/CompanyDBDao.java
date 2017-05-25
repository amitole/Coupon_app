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

import com.coupons.beans.Company;
import com.coupons.beans.Coupon;
import com.coupons.beans.Customer;
import com.coupons.dao.CompanyDao;
import com.coupons.exceptions.DaoException;
import com.coupons.system.CouponSystem;

public class CompanyDBDao implements CompanyDao
{
	private static final String TABLE_NAME = "Company";
	@Override
	public void createCompany(Company c) throws DaoException {
		// 1. get a connection (from pool)
		Connection con = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement(
					"INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?)");
			stat.setLong(1, c.getId());
			stat.setString(2, c.getCompName());
			stat.setString(3, c.getPassword());
			stat.setString(4, c.getEmail());
			
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
	
	public Company getCompany(int id) throws DaoException {
		Connection con = null;
		Company result = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			Statement stat = con.createStatement();
			
					
			String sql = "SELECT * FROM " + TABLE_NAME + " where ID =" + id;
			ResultSet rs = stat.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while (rs.next()) {
				result = new Company(
						rs.getInt("ID"),
						rs.getString("COMP_NAME"),
						rs.getString("PASSWORD"),
						rs.getString("EMAIL")
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
	public void removeCompany(Company c) throws DaoException {
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
	public void updateCompany(Company c) throws DaoException {
		Connection con = null;
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement(
					"UPDATE " + TABLE_NAME + " SET COMP_NAME =  ? , PASSWORD = ? , PASSWORD = ? WHERE ID = ?");
				
			stat.setString(1, c.getCompName());
			stat.setString(2, c.getPassword());
			stat.setString(3, c.getEmail());
			stat.setInt(4, c.getId());
			
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
	public List<Company> getAllCompanys() throws DaoException {
		Connection con = null;
		List<Company> result = new ArrayList<>();
		try {
			con = getConnection();
			
			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * from " + TABLE_NAME);
			
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				result.add(new Company(
						rs.getInt("ID"),
						rs.getString("COMP_NAME"),
						rs.getString("PASSWORD"),
						rs.getString("EMAIL")
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
	public boolean login( Company c, String compName, String password) throws DaoException {
		
		if (c.getCompName().equals(compName) && c.getPassword().equals(password)) {
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

	
	
//	
	
}
