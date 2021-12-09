package interfaces;

import java.lang.*;

import entity.*;

public interface ISalesRepo
{
	
	void insertSalesInformation(Sales s);
	void deleteSalesInfoFromDB(String slPrdctName);
	public String[][] getAllSalesInfo();
	
}