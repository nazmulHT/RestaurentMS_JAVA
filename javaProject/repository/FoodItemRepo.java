package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class FoodItemRepo implements IFoodItemRepo
{
	DatabaseConnection dbc;
	
	public FoodItemRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(FoodItem fi)
	{
		String query = "INSERT INTO foodItem VALUES ('"+fi.getItemId()+"','"+fi.getItemName()+"','"+fi.getPrice()+"',"+fi.getQuantity()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String itemId)
	{
		String query = "DELETE from orderinfo WHERE itemId='"+itemId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(FoodItem fi)
	{
		String query = "UPDATE foodItem SET itemName ='"+fi.getItemName()+"', price = '"+fi.getPrice()+"', quantity = "+fi.getQuantity()+" WHERE itemId='"+fi.getItemId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public FoodItem searchFoodItem(String itemId)
	{
		FoodItem fdi = null;
		String query = "SELECT  `itemName`, `price`, `quantity` FROM `foodItem` WHERE `itemId`='"+itemId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
		     
				String itemName = dbc.result.getString("itemName");
				double price = Double.parseDouble(dbc.result.getString("price"));
				int quantity=   Integer.parseInt(dbc.result.getString("quantity"));
				
				fdi = new FoodItem();
				fdi.setItemId(itemId);
				fdi.setItemName(itemName);
				fdi.setPrice(price);
				fdi.setQuantity(quantity);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return fdi;
	}
	
	
	
	
	public String[][] getAllFoodItem()
	{
		ArrayList<FoodItem> ar = new ArrayList<FoodItem>();
		String query = "SELECT * FROM foodItem;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String itemId = dbc.result.getString("itemId");
				String itemName = dbc.result.getString("itemName");
				double price = Double.parseDouble(dbc.result.getString("price"));
				int quantity = Integer.parseInt(dbc.result.getString("quantity"));
				
				FoodItem fi = new FoodItem(itemName, price, quantity, itemId);
				ar.add(fi);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((FoodItem)obj[i]).getItemId();
			data[i][1] = ((FoodItem)obj[i]).getItemName();
			data[i][2] = (((FoodItem)obj[i]).getPrice()+"");
			data[i][3] = (((FoodItem)obj[i]).getQuantity()+"");
		}
		return data;
	}
}


