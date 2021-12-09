package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class SalesRepo implements ISalesRepo
{
	DatabaseConnection dbc;
	
	public SalesRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertSalesInformation(Sales s)
	{
		String query = "INSERT INTO salesinfo VALUES ('"+s.getSlPrdctName()+"','"+s.getSlQuantity()+"','"+s.getSlAmount()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	
	
	
	public void deleteSalesInfoFromDB(String slPrdctName)
	{
		String query = "DELETE from salesinfo WHERE slPrdctName='"+slPrdctName+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	
	
	
	public String[][] getAllSalesInfo()
	{
		ArrayList<Sales> ar = new ArrayList<Sales>();
		String query = "SELECT * FROM salesinfo;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String slPrdctName = dbc.result.getString("slPrdctName");
				int slQuantity = Integer.parseInt(dbc.result.getString("slQuantity"));
				double slAmount = Double.parseDouble(dbc.result.getString("slAmount"));
				
			
				
				Sales sl = new Sales(slPrdctName, slQuantity, slAmount);
				ar.add(sl);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Sales)obj[i]).getSlPrdctName();
			data[i][1] = (((Sales)obj[i]).getSlQuantity()+"");
			data[i][2] = (((Sales)obj[i]).getSlAmount()+"");
		}
		
		
		return data;
	}

		
	
}