package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class PurchaseFrame extends JFrame implements ActionListener
{
	private JLabel productNameLabel,  productQuantityLabel, productCostLabel;
	private JTextField  productNameTF, productQuantityTF, productCostTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn, logoutBtn;
	private JPanel panel;
	private JTable purchaseTable;
	private JScrollPane purchaseTableSP;
	
	private User user;
	private PurchaseProductRepo ppr;
	private UserRepo ur;
	
	
	public PurchaseFrame(User user)
	{
		super("PurchaseFrame");
		this.setSize(800, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		ppr = new PurchaseProductRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", ""}};
		
		String head[] = {"Product Name", "Product Quantity", "Product Cost"};
		
		purchaseTable = new JTable(data,head);
		purchaseTableSP = new JScrollPane(purchaseTable);
		purchaseTableSP.setBounds(350, 80, 400, 150);
		purchaseTable.setEnabled(false);
		panel.add(purchaseTableSP);
		
		/*empIdLabel = new JLabel("ID :");
		empIdLabel.setBounds(100,100,100,30);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(220,100,100,30);
		panel.add(empIdTF);
		*/
		
		productNameLabel = new JLabel("Name :");
		productNameLabel.setBounds(80,90,100,30);
		productNameLabel.setBackground(Color.YELLOW);
		panel.add(productNameLabel);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(220,90,100,30);
		productNameTF.setBackground(Color.GREEN);
		panel.add( productNameTF);
		
		productQuantityLabel = new JLabel("Product Quantity:");
		productQuantityLabel.setBounds(80,150,120,30);
		productQuantityLabel.setBackground(Color.RED);
		panel.add(productQuantityLabel);
		
		productQuantityTF = new JTextField();
		productQuantityTF.setBounds(220,150,100,30);
		productQuantityTF.setBackground(Color.GREEN);
		panel.add(productQuantityTF);
		
		productCostLabel = new JLabel("Prduct Cost:");
	    productCostLabel.setBounds(80,200,120,30);
		productCostLabel.setBackground(Color.BLUE);
		panel.add(productCostLabel);
		
	    productCostTF = new JTextField();
		productCostTF.setBounds(220,200,100,30);
		productCostTF.setBackground(Color.GREEN);
		panel.add(productCostTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(80,300,80,30);
		loadBtn.addActionListener(this);
		loadBtn.setBackground(Color.BLUE);
		loadBtn.setForeground(Color.RED);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(180,300,80,30);
		insertBtn.addActionListener(this);
		insertBtn.setBackground(Color.GREEN);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(280,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(380,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		deleteBtn.setBackground(Color.YELLOW);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(480,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setForeground(Color.GREEN);
		refreshBtn.setBackground(Color.CYAN);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,250,80,30);
		getAllBtn.addActionListener(this);
		getAllBtn.setForeground(Color.ORANGE);
		getAllBtn.setBackground(Color.BLACK);
		panel.add(getAllBtn);
		
		backBtn = new JButton("<<Back");
		backBtn.setBounds(80, 350, 100, 30);
		backBtn.addActionListener(this);
		backBtn.setBackground(Color.ORANGE);
		panel.add(backBtn);
		
		logoutBtn = new JButton ("LogOut");
		logoutBtn.setBounds(600, 350, 80, 40);
		logoutBtn.setBackground(Color.GREEN);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!productNameTF.getText().equals("") || !productNameTF.getText().equals(null))
			{
				PurchaseProduct p = ppr.searchPurchaseProductInDB(productNameTF.getText());
				if(p!= null)
				{
				
					productQuantityTF.setText(p.getProductQuantity()+"");
					productCostTF.setText(p.getProductCost()+"");
					
					productNameTF.setEnabled(false);
					productQuantityTF.setEnabled(true);
					productCostTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Product Name");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			PurchaseProduct p = new PurchaseProduct();
			
			p.setProductName(productNameTF.getText());
			p.setProductQuantity(Double.parseDouble(productQuantityTF.getText()));
			p.setProductCost(Double.parseDouble(productCostTF.getText()));
			
			
			ppr.insertPurchaseProductInDB(p);
			
			productNameTF.setText("");
			productQuantityTF.setText("");
			productCostTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			productNameTF.setText("");
			productQuantityTF.setText("");
			productCostTF.setText("");
		
			
			productNameTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			PurchaseProduct p = new PurchaseProduct();
			
			p.setProductName(productNameTF.getText());
			p.setProductQuantity(Double.parseDouble(productQuantityTF.getText()));
			p.setProductCost(Double.parseDouble(productCostTF.getText()));
			
			ppr.updatePurchaseProductInDB(p);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
		    productNameTF.setText("");
			productQuantityTF.setText("");
			productCostTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			productNameTF.setEnabled(true);
			productQuantityTF.setEnabled(true);
			productCostTF.setEnabled(true);
			
		}
		else if(command.equals(deleteBtn.getText()))
		{
			ppr.deletePurchaseProductFromDB(productNameTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			productNameTF.setText("");
			productQuantityTF.setText("");
			productCostTF.setText("");
			
			productNameTF.setEnabled(true);
			productQuantityTF.setEnabled(true);
			productCostTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = ppr.getAllPurchaseProduct();
			String head[] = {"Product Name", "Product Quantity", "Product Cost"};
			
			panel.remove(purchaseTableSP);
			
			purchaseTable = new JTable(data,head);
			purchaseTable.setEnabled(false);
			purchaseTableSP = new JScrollPane(purchaseTable);
			purchaseTableSP.setBounds(350, 100, 400, 150);
			panel.add(purchaseTableSP);
			
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