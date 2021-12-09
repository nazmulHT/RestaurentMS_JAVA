package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class FoodItemFrame extends JFrame implements ActionListener
{
	private JLabel itemIdLabel, itemNameLabel, itemPriceLabel, itemQuantityLabel;
	private JTextField itemIdTF, itemNameTF, itemPriceTF, itemQuantityTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn, logoutBtn;
	private JPanel panel;
	private JTable foodItemTable;
	private JScrollPane foodItemTableSP;
	
	private User user;
	private FoodItemRepo fr;
	
	
	
	public FoodItemFrame(User user)
	{
		super("FoodItemFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		fr = new FoodItemRepo();
		//ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Item Id", "Item Name", "Price", "Quantity"};
		
		foodItemTable = new JTable(data,head);
		foodItemTableSP = new JScrollPane(foodItemTable);
		foodItemTableSP.setBounds(350, 80, 400, 150);
		foodItemTable.setEnabled(false);
		panel.add(foodItemTableSP);
		
		itemIdLabel = new JLabel("Item ID :");
		itemIdLabel.setBounds(100,80,100,30);
		itemIdLabel.setBackground(Color.GREEN);
		panel.add(itemIdLabel);
		
		itemIdTF = new JTextField();
		itemIdTF.setBounds(220,80,100,30);
		panel.add(itemIdTF);
		
		itemNameLabel = new JLabel("Item Name :");
		itemNameLabel.setBounds(100,130,100,30);
		itemNameLabel.setBackground(Color.RED);
		panel.add(itemNameLabel);
		
		itemNameTF = new JTextField();
		itemNameTF.setBounds(220,130,100,30);
		panel.add(itemNameTF);
		
		itemPriceLabel = new JLabel("Price: ");
		itemPriceLabel.setBounds(100,180,100,30);
		itemPriceLabel.setBackground(Color.BLUE);
		panel.add(itemPriceLabel);
		
		itemPriceTF = new JTextField();
		itemPriceTF.setBounds(220,180,100,30);
		panel.add(itemPriceTF);
		
		itemQuantityLabel = new JLabel("Quantity: ");
		itemQuantityLabel.setBounds(100,230,100,30);
		itemQuantityLabel.setBackground(Color.RED);
		panel.add(itemQuantityLabel);
		
		itemQuantityTF = new JTextField();
		itemQuantityTF.setBounds(220,230,100,30);
		panel.add(itemQuantityTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		loadBtn.setBackground(Color.BLUE);
		loadBtn.setForeground(Color.RED);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		insertBtn.setBackground(Color.GREEN);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		deleteBtn.setBackground(Color.YELLOW);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		refreshBtn.setForeground(Color.GREEN);
		refreshBtn.setBackground(Color.CYAN);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,250,80,30);
		getAllBtn.addActionListener(this);
		getAllBtn.setForeground(Color.ORANGE);
		getAllBtn.setBackground(Color.BLACK);
		panel.add(getAllBtn);
		
		backBtn = new JButton("<<Back");
		backBtn.setBounds(100, 350, 100, 30);
		backBtn.setBackground(Color.ORANGE);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton ("LogOut");
		logoutBtn.setBounds(600, 350, 80, 40);
		logoutBtn.addActionListener(this);
		logoutBtn.setBackground(Color.GREEN);
		panel.add(logoutBtn);
		
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
					itemNameTF.setText(fi.getItemName());
					itemPriceTF.setText(fi.getPrice()+"");
					itemQuantityTF.setText(fi.getQuantity()+"");
					
					itemIdTF.setEnabled(false);
					itemNameTF.setEnabled(true);
				    itemPriceTF.setEnabled(true);
					itemQuantityTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Food Item ID");
				}
			}
		}
		
		else if(command.equals(insertBtn.getText()))
		{
			FoodItem fi = new FoodItem();
			
			
			
			fi.setItemId(itemIdTF.getText());
			fi.setItemName(itemNameTF.getText());
			fi.setPrice(Double.parseDouble(itemPriceTF.getText()));
			fi.setQuantity(Integer.parseInt(itemQuantityTF.getText()));
			
		
			
			fr.insertInDB(fi);
			
			
			
			
			itemIdTF.setText("");
			itemNameTF.setText("");
			itemPriceTF.setText("");
			itemQuantityTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			itemIdTF.setText("");
			itemNameTF.setText("");
			itemPriceTF.setText("");
			itemQuantityTF.setText("");
			
			itemIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			FoodItem fi = new FoodItem();
			
			fi.setItemId(itemIdTF.getText());
			fi.setItemName(itemNameTF.getText());
			fi.setPrice(Double.parseDouble(itemPriceTF.getText()));
			fi.setQuantity(Integer.parseInt(itemQuantityTF.getText()));
			
			fr.updateInDB(fi);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			itemIdTF.setText("");
			itemNameTF.setText("");
			itemPriceTF.setText("");
			itemQuantityTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			itemIdTF.setEnabled(true);
			itemNameTF.setEnabled(true);
			itemPriceTF.setEnabled(true);
		    itemQuantityTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			fr.deleteFromDB(itemIdTF.getText());
			//ur.deleteUser(empIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			itemIdTF.setText("");
			itemNameTF.setText("");
			itemPriceTF.setText("");
			itemQuantityTF.setText("");
			
			itemIdTF.setEnabled(true);
			itemNameTF.setEnabled(true);
			itemPriceTF.setEnabled(true);
			itemQuantityTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = fr.getAllFoodItem();
			String head[] = {"Item Id", "Item Name", "Price", "Quantity"};
			
			panel.remove(foodItemTableSP);
			
			foodItemTable = new JTable(data,head);
			foodItemTable.setEnabled(false);
			foodItemTableSP = new JScrollPane(foodItemTable);
			foodItemTableSP.setBounds(350, 100, 400, 150);
			panel.add(foodItemTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else if(command.equals(backBtn.getText()))
		{
			
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
			
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