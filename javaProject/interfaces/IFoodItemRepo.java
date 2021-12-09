package interfaces;

import java.lang.*;

import entity.*;

public interface IFoodItemRepo
{
	public void insertInDB(FoodItem fi);
	public void deleteFromDB(String itemId);
	public void updateInDB(FoodItem fi);
	public FoodItem searchFoodItem(String itemId);
	//public void updateQuantity(String itemId);
	public String[][] getAllFoodItem();
}