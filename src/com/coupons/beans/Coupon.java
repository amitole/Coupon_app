package com.coupons.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Coupon {
	
	private int id;
	private String title;
	private Date startDate = new Date();
	private Date endDate;
	private int amount;
	private CouponType type;
	private String message;
	private double price;
	private String image;
	
	public Coupon(){
		
	}

	public Coupon(int id, String title, Date startDate, Date endDate, int amount, CouponType type, String message,
			double price, String image) {
		super();
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24));
		this.amount = amount;
		this.type = type;
		this.message = message;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		
		this.startDate = startDate;
	}
	 

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CouponType getCouponType() {
		return type;
	}

	public void setCouponType(CouponType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String mwssage) {
		this.message = mwssage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon ID = " + id + ", Title = " + title + ", Start Date = " + startDate + ", End Date = " + endDate
				+ ", Amount = " + amount + ", Type = " + type + ", Message = " + message + ", Price = " + price + ", Image = "
				+ image ;
	}

	public void print() {
		System.out.println(this.toString());
		System.out.println("--------------------------------------");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if (amount != other.amount)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
//		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
//		result = prime * result + (int) (amount ^ (amount >>> 32));
//		result = prime * result + ((type == null) ? 0 : type.hashCode());
//		result = prime * result + ((message == null) ? 0 : message.hashCode());
//		result = prime * result + ((image == null) ? 0 : image.hashCode());
//		
//		return result;
//	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
