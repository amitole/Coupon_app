package com.coupons.dao;

import java.util.List;

import com.coupons.beans.Company;
import com.coupons.beans.Coupon;
import com.coupons.exceptions.DaoException;

public interface CompanyDao {
	public void createCompany(Company c) throws DaoException;
	public Company getCompany(int id) throws DaoException;
	public void removeCompany(Company c) throws DaoException;
	public void updateCompany(Company c) throws DaoException;
	public List<Company> getAllCompanys() throws DaoException;
	public List<Coupon> getAllCoupons() throws DaoException;
	public boolean login(Company c, String compName, String password) throws DaoException;
}
