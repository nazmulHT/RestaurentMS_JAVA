package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class OrderRepo implements IOrderRepo
{
	DatabaseConnection dbc;
	
	public OrderRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertOrderInformation(Order o)
	{
		String query = "INSERT INTO orderinfo VALUES ('"+o.getOrderId()+"','"+o.getOrderSerial()+"','"+o.getOrderPersonName()+"','"+o.getOrderAmount()+"','"+o.getOrderDate()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	

	
	public void deleteOrderInfoFromDB(String orderId)
	{
		String query = "DELETE from orderinfo WHERE orderId='"+orderId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public Order searchOrderInfo(String orderId)
	{
		Order o = null;
		String query = "SELECT  `orderPersonName`, `orderAmount`, `orderDate` FROM `orderinfo` WHERE `orderId`='"+orderId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
		     
				String orderPersonName = dbc.result.getString("orderPersonName");
				double orderAmount = Double.parseDouble(dbc.result.getString("orderAmount"));
				String orderDate = dbc.result.getString("orderDate");
				
			    o = new Order();
				o.setOrderId(orderId);
				o.setOrderPersonName(orderPersonName);
				o.setOrderAmount(orderAmount);
				o.setOrderDate(orderDate);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return o;
	}
	
	
	
	
	public String[][] getAllOrderInfo()
	{
		ArrayList<Order> ar = new ArrayList<Order>();
		String query = "SELECT * FROM orderinfo;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String orderId = dbc.result.getString("orderId");
				String orderPersonName = dbc.result.getString("orderPersonName");
				double orderAmount = Double.parseDouble(dbc.result.getString("orderAmount"));
				int orderSerial = Integer.parseInt(dbc.result.getString("orderSerial"));
				String orderDate = dbc.result.getString("orderDate");
				
				Order oi = new Order(orderId, orderSerial, orderPersonName, orderAmount, orderDate);
				ar.add(oi);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Order)obj[i]).getOrderId();
			data[i][1] = (((Order)obj[i]).getOrderSerial()+"");
			data[i][2] = ((Order)obj[i]).getOrderPersonName();
			data[i][3] = (((Order)obj[i]).getOrderAmount()+"");
			data[i][4] = ((Order)obj[i]).getOrderDate();
		}
		
		
		return data;
	}

		
	
}