package entity;

import java.lang.*;

public class FoodItem
{
	private String itemName;
	private double price;
	private int quantity;
	private String itemId;
	
	public FoodItem(){}
	public FoodItem(String itemName, double price, int quantity, String itemId)
	{
		this.itemName=itemName;
		this.price=price;
		this.quantity=quantity;
		this.itemId=itemId;
	}
	
	public void setItemName(String itemName){this.itemName=itemName;}
	public void setPrice(double price){this.price=price;}
	public void setQuantity(int quantity){this.quantity=quantity;}
	public void setItemId(String itemId){this.itemId=itemId;}
	
	public String getItemName(){return itemName;}
	public double getPrice(){return price;}
	public int getQuantity(){return quantity;}
	public String getItemId(){return itemId;}
}