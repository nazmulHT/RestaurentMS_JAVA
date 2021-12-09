package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class PurchaseProductRepo implements IPurchaseProductRepo
{
	DatabaseConnection dbc;
	
	public PurchaseProductRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void  insertPurchaseProductInDB(PurchaseProduct p)
	{
		String query = "INSERT INTO purchaseinfo VALUES ('"+p.getProductName()+"','"+p.getProductQuantity()+"','"+p.getProductCost()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deletePurchaseProductFromDB(String productName)
	{
		String query = "DELETE from purchaseinfo WHERE productName='"+productName+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updatePurchaseProductInDB(PurchaseProduct p)
	{
		String query = "UPDATE purchaseinfo SET productQuantity = '"+p.getProductQuantity()+"', prductCost = "+p.getProductCost()+" WHERE productName='"+p.getProductName()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public PurchaseProduct searchPurchaseProductInDB(String productName)
	{
		PurchaseProduct prp = null;
		String query = "SELECT  `productQuantity`, `productCost` FROM `purchaseinfo` WHERE `productName`='"+productName+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
		  
		        double productQuantity = Double.parseDouble(dbc.result.getString("productQuantity"));
				double productCost = Double.parseDouble(dbc.result.getString("productCost"));
			
	
				prp = new PurchaseProduct();
				prp.setProductName(productName);
				prp.setProductQuantity(productQuantity);
				prp.setProductCost(productCost);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return prp;
	}
	
	
	public String[][] getAllPurchaseProduct()
	{
		ArrayList<PurchaseProduct> ar = new ArrayList<PurchaseProduct>();
		String query = "SELECT * FROM purchaseinfo;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				
				String productName = dbc.result.getString("productName");
				double  productQuantity = Double.parseDouble(dbc.result.getString("productQuantity"));
				double  productCost = Double.parseDouble(dbc.result.getString("productCost"));
				
				PurchaseProduct pp = new PurchaseProduct(productName, productQuantity, productCost);
				ar.add(pp);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((PurchaseProduct)obj[i]).getProductName();
			data[i][1] = (((PurchaseProduct)obj[i]).getProductQuantity()+"");
			data[i][2] = (((PurchaseProduct)obj[i]).getProductCost()+"");
	
		}
		return data;
	}
}

