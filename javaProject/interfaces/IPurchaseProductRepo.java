package interfaces;

import java.lang.*;

import entity.*;

public interface IPurchaseProductRepo
{
	public void insertPurchaseProductInDB(PurchaseProduct p);
	public void deletePurchaseProductFromDB(String productName);
	public void updatePurchaseProductInDB(PurchaseProduct p);
	public PurchaseProduct searchPurchaseProductInDB(String productName);
	public String[][] getAllPurchaseProduct();
}