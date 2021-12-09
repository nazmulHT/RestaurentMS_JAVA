package entity;

import java.lang.*;

public class Sales{

   private String slPrdctName;
   private int slQuantity;
   private double slAmount;
   
   public Sales(){}
   public Sales(String slPrdctName, int slQuantity, double slAmount)
   {
	   this.slPrdctName = slPrdctName;
	   this.slQuantity = slQuantity;
	   this.slAmount = slAmount;
   }
   public void setSlPrdctName(String slPrdctName)
   {
	   
	   this.slPrdctName = slPrdctName;
   }
   public void setSlQuantity(int slQuantity)
   {
	   this.slQuantity = slQuantity;
   }
   public void setSlAmount(double slAmount)
   {
	   this.slAmount = slAmount;
   }
   public String getSlPrdctName(){return slPrdctName;}
   public int getSlQuantity(){return slQuantity;}
   public double getSlAmount(){return  slAmount;}
 
}