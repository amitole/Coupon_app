package com.coupons.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.coupons.beans.Company;
import com.coupons.beans.Coupon;
import com.coupons.beans.CouponType;
import com.coupons.beans.Customer;
import com.coupons.dao.CompanyDao;
import com.coupons.dao.CouponDao;
import com.coupons.dao.CustomerDao;
import com.coupons.dao.dbimpl.CompanyDBDao;
import com.coupons.dao.dbimpl.CouponDBDao;
import com.coupons.dao.dbimpl.CustomerDBDao;

public class TestDAO {
	public static void main(String[] args) throws Exception{
		
//		CustomerDao cDao = new CustomerDBDao();
//		
//		Customer c = new Customer(2, "rivi", "2233");
//		Customer c1 = new Customer(2, "amit", "1234");
//		
////		cDao.createCustomer(c);
////		cDao.getCustomer(5);
//		cDao.updateCustomer(c1);
//		List<Customer> list = cDao.getAllCustomers();
//		list.forEach(Customer -> Customer.print());
		
		
		CouponDao cDao = new CouponDBDao();
//		CouponDao cDao1 = new CouponDBDao();
//		
//		
		Coupon c = new Coupon(1, "Ring", new Date(), new Date(), 1, CouponType.ELECTRICITY, "bla bla", 3, null);
		Coupon c1 = new Coupon(2, "Ring", new Date(), new Date(), 1, CouponType.ELECTRICITY, "bla bla", 3, null);
		

//		Coupon c1= new Coupon(2, "apple", null, null, 4, CouponType.FOOD, "4 Red Apples", 4.99, null);
		
//		cDao.createCoupon(c1);
		cDao.removeCoupon(c);
//		cDao.removeCoupon(c1);
//		cDao.removeCoupon(c1);
//		cDao.getCouponsByType("FOOD");
//		cDao.updateCoupon(c1);
		
//		System.out.println(c.getStartDate());
//		System.out.println(c1.getStartDate());
//		System.out.println("--------------------------");
//		System.out.println(c.getEndDate());
//		System.out.println(c1.getEndDate());
		
//		List<Coupon> list = cDao.getAllCoupons();
//		System.out.println(list);
//		list.forEach(Coupon -> Coupon.print());
		
		
	}
}
