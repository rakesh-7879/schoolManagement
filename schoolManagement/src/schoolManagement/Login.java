package schoolManagement;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import CommanSettings.CommanFunctions;
import beans.*;
import schoolManagement.indexClass;

public class Login extends JFrame{
	JPanel topPanel,titlePanel,centerUpPanel,centerDownPanel,centerPanel,userDetail,logButton;
	MyPanel mainPanel;
	JButton close,loginButton,forgetButton;
	JLabel title,titleImage,userImage,userName,userPassword,b1,b2,b3,w1,w2,w3;
	JTextField user,password;
	Color cr=new Color(105,105,105);
	JSeparator s1,s2,s3;
	
	
	
	JButton db1,db2,db3;
	GridBagConstraints c=new GridBagConstraints();
	Dimension d=new Dimension();
	CommanFunctions cf=new CommanFunctions();
	
	public Login(String userName) {
		setUndecorated(true);
		setVisible(true);
		setBounds(100, 100, 700, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//background image setting 
		ImageIcon imageIcon=new ImageIcon("images/bg.jpeg");
		Image image=imageIcon.getImage();
		//Image newing=image.getScaledInstance(700, 480,Image.SCALE_SMOOTH);
		//imageIcon=new ImageIcon(newing);
		//JLabel l=new JLabel(imageIcon);
		
		
		
		//testing button
		db1=new JButton("1");
		db2=new JButton("2");
		db3=new JButton("");
		
		d=Toolkit.getDefaultToolkit().getScreenSize();
		//components
		close=new JButton();
		cf.undecorateButton(close);
		close.setIcon(new ImageIcon("images/close.png"));
			
		
		mainPanel=new MyPanel();
		//background of frame
		mainPanel.setLayout(new BorderLayout());
		//mainPanel.add(l);
		mainPanel.setImage(image);
		
		
		//image path
		String path="";int a=460;
		if(userName.equals("PRINCIPAL")) { path="images/admin.png";a=460;}
		if(userName.equals("VIS-PRINCIPAL")) { path="images/subadmin.png";a=430;}
		if(userName.equals("FEES MANAGER")) { path="images/manager.png";a=420;}
		if(userName.equals("TEACHR")) { path="images/teacher.png";a=480;}

		
		
		//top of the frame
		title=new JLabel(userName+" LOGIN");
		cf.setColor(title, 3, 16,true);
		ImageIcon imageIcon1=new ImageIcon("images/logo.png");
		Image newing1=image.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		imageIcon=new ImageIcon(newing1);
		titleImage=new JLabel(imageIcon1);
		titlePanel=new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setBackground(cr);
		c.fill=GridBagConstraints.HORIZONTAL;
		cf.addBag(titlePanel,titleImage,c,30,30,0,0,10,0,GridBagConstraints.LINE_START);
		cf.addBag(titlePanel,title,c,a,20,1,0,0,0,GridBagConstraints.LINE_START);
		topPanel=new JPanel();
		topPanel.setLayout(new GridBagLayout());
		topPanel.setBackground(cr);
		
		cf.addBag(topPanel,titlePanel,c,0,0,0,0,0,0,GridBagConstraints.LINE_START);
		cf.addBag(topPanel,close,c,10,10,1,0,0,0,GridBagConstraints.LINE_END);
		
		
		
		
		//center of the frame
		userImage=new JLabel();
		userImage.setIcon(new ImageIcon(path));
		
		
		centerUpPanel=new JPanel();
		centerUpPanel.setOpaque(false);
		centerUpPanel.add(userImage);
		
		
		//center down components user name and password
		this.userName=new JLabel("USER NAME");
		cf.setColor(this.userName, 3, 16,true);
		user=new JTextField(14);
		cf.setColor(user, 2, 14,false);
		userPassword=new JLabel("PASSWORD");
		cf.setColor(userPassword, 3, 16, true);
		password=new JTextField(14);
		cf.setColor(password, 2, 14, false);
		b1=new JLabel();
		b2=new JLabel();
		b3=new JLabel();
		s1=new JSeparator();
		s2=new JSeparator();
		w1=new JLabel();
		w2=new JLabel();
		
		//center down components login buttons
		loginButton=new JButton("Login");
		forgetButton=new JButton("Forget ??");
		loginButton.setBackground(new Color(105,105,105));
		forgetButton.setBackground(new Color(105,105,105));
		cf.setColor(loginButton, 3, 16, true);
		cf.setColor(forgetButton, 3, 16, true);
		w3=new JLabel();
		
		
		
		//center down container
		userDetail=new JPanel();
		userDetail.setOpaque(false);
		userDetail.setLayout(new GridLayout(4, 3));
		userDetail.add(this.userName);
		userDetail.add(user);
		userDetail.add(w1);
		userDetail.add(b1);
		userDetail.add(b2);
		userDetail.add(b3);
		userDetail.add(userPassword);
		userDetail.add(password);
		userDetail.add(w2);
		userDetail.add(s1);
		userDetail.add(s2);
		
		cf.setColor(w1, 2, 14, true);
		cf.setColor(w2, 2, 14, true);
		cf.setColor(w3, 2, 14, true);
		
		
		
		logButton=new JPanel();
		logButton.setOpaque(false);
		logButton.add(loginButton);
		logButton.add(forgetButton);
		logButton.add(w3);
		
		
		
		
		centerDownPanel=new JPanel();
		centerDownPanel.setOpaque(false);
		centerDownPanel.add(userDetail);
		centerDownPanel.add(logButton);
		
		
		
		
		
		
		
		centerPanel=new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new GridBagLayout());
		
		cf.addBag(centerPanel,centerUpPanel,c,0,240,1,0,0,0,GridBagConstraints.NORTH);
		cf.addBag(centerPanel,centerDownPanel,c,0,80,1,0,0,0,GridBagConstraints.SOUTH);
		
		
		mainPanel.add(topPanel,BorderLayout.NORTH);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		getContentPane().add(mainPanel);
		
		
		//actionListener
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new indexClass();
			}
		});

	}

	
}
