package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class OrderFrame extends JFrame  implements ActionListener
{
	private JLabel  itemNameLabel, itemPriceLabel, itemIdLabel, availableQuantityLabel,orderQuantityLabel,itemQuantityLabel, totalAmountLabel;
	private JTextField itemNameTF, itemPriceTF, itemIdTF, availableQuantityTF, itemQuantityTF , orderQuantityTF ,totalAmountTF;
	private JTextField orderIdTF, orderPersonNameTF, orderDateTF, orderAmountTF, orderSerialTF;
	private JLabel orderIdLabel, orderPersonNameLabel, orderSerialLabel, orderDateLabel, orderAmountLabel;
	private JButton loadBtn,  backBtn, refreshBtn, getAllBtn, totalBtn, updateQuantityBtn, cnfrmOrderBtn, logoutBtn, addSalesBtn;

	private JTable foodItemTable;
	private JScrollPane foodItemTableSP;
	
	Color  myColor1, myColor2,myColor3, myColor4, myColor5, myColor6;
	Font myFont;
	JPanel panel;
	
	private FoodItemRepo fr;
	private OrderRepo or;
	private SalesRepo sr;
	User user;
	String s1, s2, s3, s4, s5;
	
	
	
	
	public OrderFrame(User user)
	
	{
		
		super("Order Page");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user = user;
		fr = new FoodItemRepo();
		or = new OrderRepo();
		sr = new SalesRepo();
		
		
		
		
		myColor1 = new Color(51, 153, 255);
		myColor2 = new Color(255, 102, 102);
		myColor3 = new Color(255, 51, 51);
		myColor4 = new Color(51, 204, 255);
		myColor5 = new Color(0, 255, 51);
		myColor6 = new Color(0, 204, 0);
		myFont = new Font("Cambria", Font.ITALIC | Font.BOLD, 25);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		
		
		String data[][] = {{"", "", "", ""}};
		String head[] = {"Item Id", "Item Name", "Price", "Quantity"};
		
		foodItemTable = new JTable(data,head);
		foodItemTableSP = new JScrollPane(foodItemTable);
		foodItemTableSP.setBounds(20, 5, 400, 150);
		foodItemTable.setEnabled(false);
		panel.add(foodItemTableSP);
		
	
		
		itemIdLabel = new JLabel("Item ID :");
		itemIdLabel.setBounds(20,165,100,30);
		itemIdLabel.setForeground(myColor6);
		panel.add(itemIdLabel);
		
		itemIdTF = new JTextField();
		itemIdTF.setBounds(140,165,100,30);
		itemIdTF.setForeground(myColor5);
		panel.add(itemIdTF);
		
		
		itemNameLabel = new JLabel("Item Name:");
		itemNameLabel.setBounds(250,165,100,30);
		//itemNameLabel.addActionListener(this);
		itemNameLabel.setEnabled(true);
		itemNameLabel.setForeground(myColor1);
		panel.add(itemNameLabel);
		
		itemNameTF = new JTextField();
		itemNameTF.setBounds(380,165, 100, 30);
		//itemNameTF.setBackground(Color.GREEN);
		panel.add(itemNameTF);
		
		orderIdLabel = new JLabel("OrderId");
		orderIdLabel.setBounds(490, 5, 100, 30);
		orderIdLabel.setForeground(myColor1);
		panel.add(orderIdLabel);
		
		orderIdTF = new JTextField();
		orderIdTF.setBounds(600, 5, 100, 30);
		orderIdTF.setBackground(myColor3);
		panel.add(orderIdTF);
		
		
		orderSerialLabel = new JLabel("Order Serial:");
		orderSerialLabel.setBounds(490, 45 ,100 ,30);
		orderSerialLabel.setForeground(myColor4);
		panel.add(orderSerialLabel );
		
		orderSerialTF = new JTextField();
		orderSerialTF.setBounds(600, 45, 100, 30);
	    orderSerialTF.setBackground(myColor5);
		panel.add(orderSerialTF);
		
		
		orderPersonNameLabel = new JLabel("Name:");
		orderPersonNameLabel .setBounds(490,80,100,30);
		orderPersonNameLabel.setForeground(myColor1);
		panel.add(orderPersonNameLabel);
		
		orderPersonNameTF = new JTextField();
		orderPersonNameTF .setBounds(600,80,100,30);
		panel.add(orderPersonNameTF);
		
		orderDateLabel = new JLabel("Date:");
		orderDateLabel.setBounds(490,120,100,30);
		orderDateLabel.setForeground(myColor6);
		panel.add(orderDateLabel);
		
		orderDateTF = new JTextField();
		orderDateTF.setBounds(600,120,100,30);
		orderDateTF.setBackground(myColor6);
		panel.add(orderDateTF);
		
		
		itemQuantityLabel = new JLabel("Quantity: ");
		itemQuantityLabel.setBounds(20,210,100,30);
		itemQuantityLabel.setBackground(myColor2);
		panel.add(itemQuantityLabel);
		
		itemQuantityTF = new JTextField();
		itemQuantityTF.setBounds(140,210,100,30);
		//itemQuantityTF.setBackground(myColor4);
		panel.add(itemQuantityTF);
		
		
		
		itemPriceLabel = new JLabel("Price: ");
		itemPriceLabel.setBounds(250,210,100,30);
		itemPriceLabel.setBackground(Color.GREEN);
		panel.add(itemPriceLabel);
		
		itemPriceTF = new JTextField();
		itemPriceTF.setBounds(380,210,100,30);
		//itemPriceTF.setBackground(myColor1);
		panel.add(itemPriceTF);
		
		orderQuantityLabel = new JLabel("Order Quantity:");
		orderQuantityLabel.setBounds(20,250,100,30);
		orderQuantityLabel.setBackground(myColor4);
		panel.add(orderQuantityLabel);
		
		orderQuantityTF = new JTextField();
		orderQuantityTF.setBounds(140,250,100,30);
		orderQuantityTF.setBackground(myColor6);
		panel.add( orderQuantityTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(20,290,80,30);
		loadBtn.addActionListener(this);
		loadBtn.setBackground(Color.BLUE);
		loadBtn.setForeground(Color.RED);
		panel.add(loadBtn);
		
		updateQuantityBtn = new JButton("Update Quantity");
		updateQuantityBtn.setBounds(310,290,130,30);
		updateQuantityBtn.addActionListener(this);
		updateQuantityBtn.setEnabled(false);
		updateQuantityBtn.setBackground(myColor3);
		panel.add(updateQuantityBtn);
		
		availableQuantityLabel = new JLabel("Available Quantity:");
		availableQuantityLabel.setBounds(250, 250, 120,30);
		availableQuantityLabel.setBackground(myColor2);
		panel.add(availableQuantityLabel);
		
		
		availableQuantityTF = new JTextField();
		availableQuantityTF.setBounds(380,250,100,30);
		availableQuantityTF.setBackground(myColor5);
		panel.add(availableQuantityTF);
		
		
		totalBtn = new JButton("Total");
		totalBtn.setBounds(510, 180, 80, 30);
		totalBtn.setBackground(myColor1);
	    totalBtn.addActionListener(this);
		totalBtn.setEnabled(false);
		panel.add(totalBtn);
		
		addSalesBtn = new JButton("Add Sales");
		addSalesBtn.setBounds(510,300,100,30);
		addSalesBtn.addActionListener(this);
		addSalesBtn.setEnabled(false);
		addSalesBtn.setBackground(myColor4);
		panel.add(addSalesBtn);
		
	    
		
		
		backBtn = new JButton("<<Back");
		backBtn.setBounds(30, 340, 80, 30);
		backBtn.setBackground(Color.GRAY);
	    backBtn.addActionListener(this);
		backBtn.setBackground(Color.ORANGE);
		panel.add(backBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(215,290,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		refreshBtn.setForeground(Color.GREEN);
		refreshBtn.setBackground(Color.CYAN);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(115,290,80,30);
		getAllBtn.addActionListener(this);
		getAllBtn.setForeground(Color.ORANGE);
		getAllBtn.setBackground(Color.BLACK);
		panel.add(getAllBtn);
		
	    /*
		totalAmountLabel = new JLabel("Total:");
		totalAmountLabel.setBounds(580,180, 50,30);
		panel.add(totalAmountLabel);
		*/
		
		totalAmountTF = new JTextField ();
		totalAmountTF.setBounds( 600, 180, 80,30);
		totalAmountTF.setBackground(myColor4);
		panel.add(totalAmountTF);
		
		cnfrmOrderBtn = new JButton("Confirm order");
		cnfrmOrderBtn.setBounds(510,250,130,30);
		cnfrmOrderBtn.addActionListener(this);
		cnfrmOrderBtn.setEnabled(false);
		cnfrmOrderBtn.setBackground(myColor2);
		panel.add(cnfrmOrderBtn);
		
		logoutBtn = new JButton ("LogOut");
		logoutBtn.setBounds(680, 340, 80, 40);
		logoutBtn.addActionListener(this);
		logoutBtn.setBackground(Color.GREEN);
		panel.add(logoutBtn);
		
		String s8 = "0";
		totalAmountTF.setText(s8);
		
		
		
		

		this.add(panel);
		
		
		
	}
	
	
	
	
	
	
	
	
	
    public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		
		
		if(command.equals(loadBtn.getText()))
		{
			if(!itemIdTF.getText().equals("") || !itemIdTF.getText().equals(null))
			{
				FoodItem fi = fr.searchFoodItem(itemIdTF.getText());
				if(fi!= null)
				{
				    itemNameTF.setText(fi.getItemName()+"");
					itemPriceTF.setText(fi.getPrice()+"");
					itemQuantityTF.setText(fi.getQuantity()+"");
					
					itemNameTF.setEnabled(false);
					itemIdTF.setEnabled(false);
					itemQuantityTF.setEnabled(false);
				    itemPriceTF.setEnabled(false);
					refreshBtn.setEnabled(true);
					//updateQuantityBtn.setEnabled(true);
					cnfrmOrderBtn.setEnabled(true);
					totalBtn.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Food Item ID");
				}
			}
		}
		
		
		
	   else if(command.equals(refreshBtn.getText()))
		{
			//itemIdTF.setText("");
			itemPriceTF.setText("");
			availableQuantityTF.setText("");
			itemQuantityTF.setText("");
			totalAmountTF.setText("0");
			orderIdTF.setText("");
			orderPersonNameTF.setText("");
			orderQuantityTF.setText("");
			orderDateTF.setText("");
			orderSerialTF.setText("");
			
			itemNameTF.setEnabled(false);
			itemIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			itemPriceTF.setEnabled(false);
			availableQuantityTF.setEnabled(false);
			totalAmountTF.setEnabled(false);
			refreshBtn.setEnabled(false);
			updateQuantityBtn.setEnabled(false);
			totalBtn.setEnabled(false);
			cnfrmOrderBtn.setEnabled(false);
			addSalesBtn.setEnabled(false);
			
		}
		
		else if (command.equals(totalBtn.getText()))
		{
			
			s1 = itemQuantityTF.getText();
			s2 = orderQuantityTF.getText();
			s3 = itemPriceTF.getText();
			s4 = orderQuantityTF.getText();
			s5 = totalAmountTF.getText();
			
			
			
			int a = Integer.parseInt(s1);
			int b = Integer.parseInt(s2);
			int c = a - b;
			
			String s6 = c + "";
			availableQuantityTF.setText(s6);
			
			double d = Double.parseDouble(s3);
			double e = Double.parseDouble(s4);
			double h = Double.parseDouble(s5);
			
			double f = d * e;
			h = h + f;
			String s7 = h + "";
			totalAmountTF.setText(s7);
			
			String s8 = f + "";
			itemPriceTF.setText(s8);
			
			
			 Random rd = new Random();
			 int x = rd.nextInt(9999)+1000;
			 String s = x +"";
			 
			 orderIdTF.setText(s);
			 
			 addSalesBtn.setEnabled(true);
			 itemIdTF.setEnabled(true);
				
		}
		
		
	
	    else if(command.equals(backBtn.getText()))
		{
			
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
			
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = fr.getAllFoodItem();
			String head[] = {"Item Id", "Item Name", "Price", "Quantity"};
			
			panel.remove(foodItemTableSP);
			
			foodItemTable = new JTable(data,head);
			foodItemTable.setEnabled(false);
			foodItemTableSP = new JScrollPane(foodItemTable);
			foodItemTableSP.setBounds(20, 5, 400, 150);
			panel.add(foodItemTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else if(command.equals(updateQuantityBtn.getText()))
		{
			FoodItem fi = new FoodItem();
			
			
			fi.setItemId(itemIdTF.getText());
			fi.setItemName(itemNameTF.getText());
			fi.setPrice(Double.parseDouble(itemPriceTF.getText()));
			fi.setQuantity(Integer.parseInt(availableQuantityTF.getText()));
	
			fr.updateInDB(fi);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			itemIdTF.setText("");
			//itemNameTF.setText("");
			itemPriceTF.setText("");
			itemQuantityTF.setText("");
			availableQuantityTF.setText("");
			
			loadBtn.setEnabled(true);
			updateQuantityBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			itemIdTF.setEnabled(true);
			//itemNameTF.setEnabled(true);
			itemPriceTF.setEnabled(true);
		    itemQuantityTF.setEnabled(true);
		}
		
		else if(command.equals(cnfrmOrderBtn.getText()))
			
			{
			   
			 
			 Order o = new Order();
			 //Sales sl = new Sales();
		
			 			
			o.setOrderId(orderIdTF.getText());
			o.setOrderPersonName(orderPersonNameTF.getText());
			o.setOrderSerial(Integer.parseInt(orderSerialTF.getText()));
			o.setOrderAmount(Double.parseDouble(totalAmountTF.getText()));
			o.setOrderDate(orderDateTF.getText());
			 
			or.insertOrderInformation(o);
			
			JOptionPane.showMessageDialog(this, "Total Amount: "+totalAmountTF.getText()+" "+"Order No: "+orderIdTF.getText()+" "+"Serial No: "+orderSerialTF.getText());
			 
			refreshBtn.setEnabled(true);
			updateQuantityBtn.setEnabled(true);
			addSalesBtn.setEnabled(false);
			
			
		}
		
		else if(command.equals(addSalesBtn.getText()))
			
			{
			   
			 Sales s = new Sales();
			
			s.setSlPrdctName(itemNameTF.getText());
			s.setSlQuantity(Integer.parseInt(orderQuantityTF.getText()));
			s.setSlAmount(Double.parseDouble(itemPriceTF.getText()));
			
			JOptionPane.showMessageDialog(this, "Added Sales Frame");
		
		    sr.insertSalesInformation(s);
			
			updateQuantityBtn.setEnabled(true);
			
			
		}
		
			
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
					
		else{}
		
	
		
		}
	
		
	}
	
