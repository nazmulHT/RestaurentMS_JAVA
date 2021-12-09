package interfaces;

import java.lang.*;

import entity.*;

public interface IOrderRepo
{
	public Order searchOrderInfo(String orderId);
	void insertOrderInformation(Order o);
	void deleteOrderInfoFromDB(String orderId);
	public String[][] getAllOrderInfo();
	
}