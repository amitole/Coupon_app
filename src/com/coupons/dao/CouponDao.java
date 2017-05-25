package com.coupons.dao;

import java.util.List;

import com.coupons.beans.Coupon;
import com.coupons.exceptions.DaoException;

public interface CouponDao {
	public void createCoupon(Coupon c) throws DaoException;
	public Coupon getCoupon(int id) throws DaoException;
	public void removeCoupon(Coupon c) throws DaoException;
	public void updateCoupon(Coupon c) throws DaoException;
	public List<Coupon> getAllCoupons() throws DaoException;
	public List<Coupon> getCouponsByType(String byWhat) throws DaoException;
	
	
}
