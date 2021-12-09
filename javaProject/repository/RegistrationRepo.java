package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class RegistrationRepo implements IRegistrationRepo
{
	DatabaseConnection dbc;
	
	public RegistrationRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void  insertRegistration(Registration r)
	{
		String query = "INSERT INTO regInfo VALUES ('"+r.getCustomerName()+"','"+r.getEmail()+"','"+r.getAddress()+"','"+r.getPhnNo()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
			
	
}