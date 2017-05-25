package com.coupons.beans;

import java.util.*;

public class Company {

	private int id;
	private String compName;
	private String password;
	private String email;
//	private List<Coupon> coupons = new ArrayList<>(); 
	
	public Company(){
		
	}

	public Company(int id, String compName, String password, String email) {
		super();
		this.id = id;
		this.compName = compName;
		this.password = password;
		this.email = email;
//		this.coupons = coupons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void print() {
		System.out.println(this.toString());
		System.out.println("-----------------------------------------------------------------------");
	}
	
//	public List<Coupon> getCoupons() {
//		return coupons;
//	}
//
//	public void setCoupons(List<Coupon> coupons) {
//		
//		this.coupons = coupons;
//	}

	@Override
	public String toString() {
		return "Company: ID=" + id + ", Name=" + compName + ", Password=" + password + ", Email=" + email;
	}
	
	
	
	
}
