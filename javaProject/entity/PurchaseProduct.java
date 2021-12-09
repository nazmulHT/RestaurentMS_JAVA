package entity;

import java.lang.*;

public class PurchaseProduct
{
   private String productName;
   private double productQuantity;
   private double productCost;
   
   
   
   public PurchaseProduct(){}
   public PurchaseProduct(String productName, double productQuantity, double productCost)
   
   {
	
	this.productName = productName;
	this.productQuantity = productQuantity;
	this.productCost = productCost;
	
   }
   
   public void setProductName(String productName)
   {
	   this.productName = productName;
   }
   public void setProductQuantity(double productQuantity)
    
   {
	   this.productQuantity = productQuantity;
   }
   public void setProductCost(double productCost)
   {
	   this.productCost= productCost;
   }
   public String getProductName(){return productName;}
   public  double getProductQuantity(){return productQuantity;}
   public  double getProductCost(){return productCost;}
   
   
	
}