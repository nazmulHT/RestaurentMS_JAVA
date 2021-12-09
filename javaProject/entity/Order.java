package entity;

import java.lang.*;

public class Order{
	
	private String orderId;
	private int orderSerial;
	private String orderPersonName;
	private double orderAmount;
	private String orderDate;
	
	
	public Order(){}
	public Order(String orderId, int orderSerial, String orderPersonName, double orderAmount, String orderDate)
	{
		this.orderId = orderId;
		this.orderSerial = orderSerial;
		this.orderPersonName = orderPersonName;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		
	}
	
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
		
	}
	public void setOrderSerial(int orderSerial)
	
	{
		this.orderSerial = orderSerial;
		
	}
	public void setOrderPersonName(String orderPersonName)
	
	{
		this.orderPersonName = orderPersonName;
		
	}
	
	
	public void setOrderDate(String orderDate)
	{
		this.orderDate = orderDate;
		
	}
	
	
	public  void setOrderAmount(double orderAmount)
	{
		this.orderAmount = orderAmount;
	}
	
	public String getOrderId(){return orderId;}
	public int getOrderSerial() {return orderSerial;}
	public String getOrderPersonName(){return orderPersonName;}
	public double getOrderAmount(){return orderAmount;}
	public String getOrderDate(){return orderDate;}
	
}