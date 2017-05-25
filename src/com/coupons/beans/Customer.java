package com.coupons.beans;

public class Customer {
	private int id;
	private String name;
	private String password;
	
	public Customer()
	{
		// TODO: check if this is necessary
	}
	
	public Customer(int id, String name, String password) 
	{
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public void print() {
		System.out.println(this.toString());
		System.out.println("-----------------------------------------------------------------------");
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer: ID = " + id + " , Name = " + name + " , Password = " + password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
