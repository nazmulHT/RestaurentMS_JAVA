package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class EmployeeHome extends JFrame implements ActionListener
{   ImageIcon img2;
	JButton logoutBtn, manageEmpBtn, managePurchaseBtn, manageFoodItem, manageOrderInfoBtn, manageOrderBtn, changePasswordBtn, salesBtn, backBtn;
	JPanel panel;
	Color myColor, myColor1, myColor2, myColor3;
	JLabel imgLabel;
	Font font;
	
	User user;
	
	
	public EmployeeHome(User user)
	{
		super("Welcome Employee");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		
		myColor = new Color(51, 204,255);
		myColor1 = new Color(0 , 255,51);
		myColor2 = new Color(255, 204, 0);
		myColor3 = new Color(255, 102, 102);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		manageEmpBtn = new JButton("Manage Employee");
		manageEmpBtn.setBounds(300, 50, 200, 30);
		manageEmpBtn.setBackground(myColor);
		manageEmpBtn.addActionListener(this);
		panel.add(manageEmpBtn);
		
		managePurchaseBtn = new JButton("Manage Purchase");
		managePurchaseBtn.setBounds(300, 90, 200, 30);
		managePurchaseBtn.setBackground(Color.RED);
		managePurchaseBtn.addActionListener(this);
		panel.add(managePurchaseBtn);
		
		

		manageFoodItem = new JButton("Manage FoodItems");
		manageFoodItem.setBounds(300, 130, 200, 30);
		manageFoodItem.setBackground(myColor1);
		manageFoodItem.addActionListener(this);
		panel.add(manageFoodItem);
		
			
		manageOrderInfoBtn = new JButton("Customer Information");
		manageOrderInfoBtn.setBounds(300, 170, 200, 30);
		manageOrderInfoBtn.setBackground(myColor3);
		manageOrderInfoBtn.addActionListener(this);
		panel.add(manageOrderInfoBtn);
		
		
		manageOrderBtn = new JButton("Manage Order");
		manageOrderBtn.setBounds(300, 210, 200, 30);
		manageOrderBtn.addActionListener(this);
		manageOrderBtn.setBackground(myColor2);
		panel.add(manageOrderBtn);
		
		salesBtn = new JButton("Sales");
		salesBtn.setBounds(300,250,200, 30);
		salesBtn.addActionListener(this);
		salesBtn.setBackground(Color.GRAY);
		panel.add(salesBtn);
		
		
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(300, 290, 200, 30);
		logoutBtn.addActionListener(this);
		logoutBtn.setBackground(Color.GREEN);
		panel.add(logoutBtn);
		
		
		backBtn = new JButton("<<Back");
		backBtn.setBounds(50, 370, 100, 30);
		backBtn.addActionListener(this);
		backBtn.setBackground(Color.ORANGE);
		panel.add(backBtn);
		
		img2 = new ImageIcon("Fz1.jpg");
		imgLabel = new JLabel(img2);
		imgLabel.setBounds(0, 0, 800, 450);
		panel.add(imgLabel);
		
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageEmpBtn.getText()))
		{
			if(user.getStatus()==1 || user.getStatus()==2)
			{
				EmployeeFrame ef = new EmployeeFrame(user);
				ef.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(managePurchaseBtn.getText()))
		{
			if(user.getStatus()==2 || user.getStatus() == 1 )
			{
				PurchaseFrame pf = new PurchaseFrame(user);
				pf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(manageFoodItem.getText()))
		{
			if(user.getStatus() == 1 || user.getStatus() == 2)
			{
				FoodItemFrame fi = new FoodItemFrame(user);
				fi.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		
		else if(command.equals(manageOrderInfoBtn.getText()))
		{
			if(user.getStatus()==1 || user.getStatus()==2)
			{
				OrderInfoFrame coi = new OrderInfoFrame(user);
				coi.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
	
		else if(command.equals(manageOrderBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus() == 1)
			{
				OrderFrame or = new OrderFrame(user);
				or.setVisible(true);
				this.setVisible(false);
			}
		
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(salesBtn.getText()))
		{
			if(user.getStatus()== 1 || user.getStatus() == 2)
			{
				SalesFrame sf = new SalesFrame(user);
				sf.setVisible(true);
				this.setVisible(false);
			}
		
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(backBtn.getText()))
		{
			
			LoginFrame li = new LoginFrame();
			li.setVisible(true);
			this.setVisible(false);
		}
		
		
		
		
		
		else{}
	}
}
