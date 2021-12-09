package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class RegistrationFrame extends JFrame implements ActionListener
{
	private JButton submitBtn, backBtn;
	private JLabel nameLabel, emailLabel, addressLabel, phnNoLabel;
    private JTextField nameTF, emailTF, addressTF, phnNoTF;	
	private JPanel panel;
	private LoginFrame lf;
	RegistrationRepo rg;
	Color  myColor1, myColor2,myColor3, myColor4;
	
	public RegistrationFrame(LoginFrame lf)
	{
		super("Register Now !!!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		rg = new RegistrationRepo();
		this.lf = lf;
		
		myColor1 = new Color(51, 153, 255);
		myColor2 = new Color(255, 102, 102);
		myColor3 = new Color(255, 51, 51);
		myColor4 = new Color(51, 204, 255);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		
	
		nameLabel = new JLabel("Customer Name:");
		nameLabel.setBounds(50, 100, 200, 30);
		nameLabel.setBackground(myColor1);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(260, 100, 200, 30);
		nameTF.setBackground(myColor2);
		panel.add(nameTF);
		
		
	    emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(50, 150, 200, 30);
		emailLabel.setBackground(myColor3);
		panel.add(emailLabel);
		
		emailTF = new JTextField();
		emailTF.setBounds(260, 150, 200, 30);
		emailTF.setBackground(myColor1);
		panel.add(emailTF);
		
		
		addressLabel = new JLabel("Adress:");
		addressLabel.setBounds(50, 200, 200, 30);
		addressLabel.setBackground(myColor4);
		panel.add(addressLabel );
		
	    addressTF = new JTextField();
		addressTF.setBounds(260, 200, 200, 30);
		addressTF.setBackground(myColor2);
		panel.add(addressTF);
		
		
		
		phnNoLabel= new JLabel("Phone No:");
		phnNoLabel.setBounds(50, 250, 200, 30);
		phnNoLabel.setBackground(Color.BLUE);
		panel.add(phnNoLabel);
		
	    phnNoTF = new JTextField();
		phnNoTF.setBounds(260, 250, 200, 30);
		phnNoTF.setBackground(Color.GREEN);
		panel.add(phnNoTF);
		
		
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(100, 300, 80, 30);
		submitBtn.addActionListener(this);
		submitBtn.setBackground(Color.BLUE);
		submitBtn.setForeground(Color.RED);
		panel.add(submitBtn);
		
		
		backBtn = new JButton("<<Back");
		backBtn.setBounds(200, 300, 80, 30);
		backBtn.addActionListener(this);
		backBtn.setBackground(Color.ORANGE);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
	 if(command.equals(submitBtn.getText()))
		{
			Registration r = new Registration();
			r.setCustomerName(nameTF.getText());
			r.setEmail(emailTF.getText());
			r.setAddress(addressTF.getText());
			r.setPhnNo(phnNoTF.getText());
			
			rg.insertRegistration(r);
            JOptionPane.showMessageDialog(this, "Successfully Registered");	

           	nameTF.setText("");
            emailTF.setText("");
            addressTF.setText("");
            phnNoTF.setText("");
			
		}
	 else if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			lf.setVisible(true);
		}
	 else{}
	}
}