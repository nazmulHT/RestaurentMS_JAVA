package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class OrderInfoFrame extends JFrame implements ActionListener
{
	
    private JLabel orderIdLabel, orderPersonNameLabel, orderAmountLabel, orderDateLabel;
	private JTextField orderIdTF, orderPersonNameTF, orderAmountTF, orderDteTF;
	private JTable OrderInfoTable;
	private JScrollPane OrderInfoTableSP;
	private JPanel panel;
	private JButton getAllBtn, backBtn, logoutBtn, deleteBtn, loadBtn, refreshBtn;
	
	OrderRepo or; 
	User user;
	
	
	public OrderInfoFrame(User user){
	   

	    super("CustomerInfoFrame");
		this.setSize(800, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    or = new OrderRepo();
		this.user = user;
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "", ""}};
		
		String head[] = {"Order Id", "Order Setrial", "Order Person Name", "Order Amount", "Order Date"};
		
		OrderInfoTable = new JTable(data,head);
		OrderInfoTableSP = new JScrollPane(OrderInfoTable);
		OrderInfoTableSP.setBounds(20, 50, 500,200);
		OrderInfoTable.setEnabled(false);
		OrderInfoTable.setBackground(Color.CYAN);
		panel.add(OrderInfoTableSP);
		
		getAllBtn = new JButton ("Get All InfO of Order");
		getAllBtn.setBounds(250,270, 200, 40);
		getAllBtn.addActionListener(this);
		getAllBtn.setForeground(Color.ORANGE);
		getAllBtn.setBackground(Color.BLACK);
		panel.add(getAllBtn);
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100, 270,80,30);
		loadBtn.addActionListener(this);
		loadBtn.setBackground(Color.BLUE);
		loadBtn.setForeground(Color.RED);
		panel.add(loadBtn);
		
		orderIdLabel = new JLabel("Order Id");
		orderIdLabel.setBounds(210,350,80,30);
		orderIdLabel.setBackground(Color.GREEN);
		orderIdLabel.setEnabled(false);
		panel.add(orderIdLabel);
		
		
		orderIdTF = new JTextField();
		orderIdTF.setBounds(300,350,80,30);
		//orderIdTF.setEnabled(false);
		orderIdTF.setBackground(Color.RED);
		panel.add(orderIdTF);
		
		orderPersonNameLabel = new JLabel("Order Person Name:");
		orderPersonNameLabel.setBounds(530,50,150,30);
		orderPersonNameLabel.setBackground(Color.RED);
		panel.add(orderPersonNameLabel);
		
		
		orderPersonNameTF = new JTextField();
		orderPersonNameTF.setBounds(690, 50, 80,30);
		panel.add(orderPersonNameTF);
		
		orderAmountLabel = new JLabel("Order Amount:");
		orderAmountLabel.setBounds(530,90,120,30);
		orderAmountLabel.setBackground(Color.BLUE);
		panel.add(orderAmountLabel);
		
		orderAmountTF = new JTextField();
		orderAmountTF.setBounds(690, 90,80,30);
		panel.add(orderAmountTF);
		
		
		
	    orderDateLabel = new JLabel("Order Date:");
		orderDateLabel.setBounds(530, 130,100,30);
		orderDateLabel.setBackground(Color.RED);
		panel.add( orderDateLabel);
		
		orderDteTF = new JTextField();
		orderDteTF.setBounds(690,130,80,30);
		panel.add(orderDteTF);
		
		
		
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(470,270,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setBackground(Color.YELLOW);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(530,170,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		refreshBtn.setForeground(Color.GREEN);
		refreshBtn.setBackground(Color.CYAN);
		panel.add(refreshBtn);
		
		backBtn = new JButton ("<<Back");
		backBtn.setBounds(80, 350, 100, 30);
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
			if(!orderIdTF.getText().equals("") || !orderIdTF.getText().equals(null))
			{
				Order o = or.searchOrderInfo(orderIdTF.getText());
				if(o!= null)
				{
					orderPersonNameTF.setText(o.getOrderPersonName());
					orderAmountTF.setText(o.getOrderAmount()+"");
					orderDteTF.setText(o.getOrderDate());
					
					orderIdTF.setEnabled(false);
					orderPersonNameTF.setEnabled(true);
				    orderAmountTF.setEnabled(true);
					orderDteTF.setEnabled(true);
					
					//updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					//insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild OrderID");
				}
			}
		}
	
         	
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = or.getAllOrderInfo();
			String head[] = {"Order Id", "Order Serial", "Order Persno Name", "Order Amount", "Order Date"};
			
			panel.remove(OrderInfoTableSP);
			
			OrderInfoTable = new JTable(data,head);
			OrderInfoTable.setEnabled(false);
			OrderInfoTableSP = new JScrollPane(OrderInfoTable);
			OrderInfoTableSP.setBounds(20, 50, 500, 200);
			panel.add(OrderInfoTableSP);
			
			panel.revalidate();
			panel.repaint();
			
			orderIdLabel.setEnabled(true);
			deleteBtn.setEnabled(true);
			
		}
		
		else if(command.equals(deleteBtn.getText()))
		{
			or.deleteOrderInfoFromDB(orderIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
	
			//loadBtn.setEnabled(true);	
		}
		
		
		else if(command.equals(refreshBtn.getText()))
		{
			orderIdTF.setText("");
			orderPersonNameTF.setText("");
			orderAmountTF.setText("");
			orderDteTF.setText("");
			
			orderIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			//updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
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
		
		
		else{};
	}
		
}