package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class LoginFrame extends JFrame implements ActionListener, MouseListener
{
	ImageIcon img1;
	JLabel title, userLabel, passLabel, imgLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn, regBtn, showPassBtn;
	JPanel panel;
	Color myColor1, myColor2,myColor3, myColor4, myColor5, myColor6;
	Font myFont, myFont1;
	
	public LoginFrame()
	{
		super("Cafe Management System - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		myColor1 = new Color(51, 153, 255);
		myColor2 = new Color(255, 102, 102);
		myColor3 = new Color(255, 51, 51);
		myColor4 = new Color(51, 204, 255);
		myColor5 = new Color(0, 255, 51);
		myColor6 = new Color(0, 204, 0);
		
		
		myFont1 = new Font("Arial", Font.BOLD, 20);
		myFont = new Font("Cambria", Font.ITALIC | Font.BOLD, 25);
		
		panel = new JPanel();
		panel.setLayout(null);
	
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(260, 240, 130, 30);
		userLabel.setOpaque(true);
		userLabel.setForeground(Color.BLUE);
		userLabel.setBackground(Color.WHITE);
		panel.add(userLabel);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(260, 280, 130, 30);
		passLabel.setOpaque(true);
		passLabel.setForeground(myColor6);
		passLabel.setBackground(Color.WHITE);
		//passLabel.setFont(myFont);
		panel.add(passLabel);
		
		userTF = new JTextField();
		userTF.setBounds(410, 240, 120, 30);
		userTF.setForeground(Color.BLUE);
		panel.add(userTF);
		
		
		passPF = new JPasswordField();
		passPF.setBounds(410, 280, 120, 30);
		panel.add(passPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(535,280,80,30);
		showPassBtn.addMouseListener(this);
		showPassBtn.setBackground(myColor4);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(260, 340, 115, 30);
	    loginBtn.setBackground(myColor1);
		loginBtn.setFont(myFont1);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		panel.add(loginBtn );
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(410, 340, 100, 30);
		exitBtn.setBackground(Color.RED);
		exitBtn.setFont(myFont1);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		regBtn = new JButton("Registration");
		regBtn.setBounds(530, 340, 130, 30);
		regBtn.addActionListener(this);
		regBtn.setBackground(myColor6);
		panel.add(regBtn);
		
		img1 = new ImageIcon("Fz.jpg");
		imgLabel = new JLabel(img1);
		imgLabel.setBounds(0, 0, 800, 450);
		panel.add(imgLabel);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0 || user.getStatus() == 1 || user.getStatus() == 2)
				{
					EmployeeHome eh = new EmployeeHome(user);
					eh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 2)
				{
					//CustomerHome ch = new CustomerHome(user);
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(command.equals(regBtn.getText()))
		{
			RegistrationFrame rf = new RegistrationFrame(this);
			rf.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(Color.GREEN);
			loginBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(Color.ORANGE);
			exitBtn.setForeground(Color.WHITE);
		}
		else
		{
			
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(myColor1);
			loginBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource() == exitBtn)
		{
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.BLACK);
		}
		else
		{
			
		}
	}

}



















