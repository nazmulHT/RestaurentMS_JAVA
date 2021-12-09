package entity;

import java.lang.*;

public class Registration{
	
    private String customerName;
	private String email;
	private String address;
	private String phnNo;
	
	public Registration(){}
	
	public Registration(String customerName, String email, String address, String phnNo)
	
	{
		
		this.customerName = customerName;
		this.email = email;
		this.address = address;
		this.phnNo = phnNo;
		
	}
	
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setAddress(String address)
	
	{
		this.address = address;
	}
	
	public void setPhnNo(String phnNo)
	
	{
		this.phnNo = phnNo;
	}
	
	public String getCustomerName(){return customerName;}
	public String getEmail(){return email;}
	public String getAddress(){return address;}
	public String getPhnNo(){return phnNo;}
	
	
	
	
	
	
}
