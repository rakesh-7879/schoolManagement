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
import java.sql.ResultSet;

import javax.swing.*;

import CommanSettings.CommanFunctions;
import CommanSettings.DBConnect;
import beans.*;
import schoolManagement.indexClass;
import schoolManagement.principal.MainFrame;
import users.UserMainFrame;

public class Login extends JFrame{
	JPanel topPanel,titlePanel,centerUpPanel,centerDownPanel,centerPanel,userDetail,logButton;
	MyPanel mainPanel;
	JButton close,loginButton,forgetButton;
	JLabel title,titleImage,userImage,userName,userPassword,b1,b2,b3,w1,w2,w3;
	JTextField user,password;
	Color cr=new Color(105,105,105);
	JSeparator s1,s2,s3;
	
	
	
	
	GridBagConstraints c=new GridBagConstraints();
	Dimension d=new Dimension();
	CommanFunctions cf=new CommanFunctions();
	
	public Login(String Name) {
		setUndecorated(true);
		setVisible(true);
		setBounds(100, 100, 700, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//background image setting 
		ImageIcon imageIcon=new ImageIcon("images/bg.jpeg");
		Image image=imageIcon.getImage();
		
		
		
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
		if(Name.equals("PRINCIPAL")) { path="images/admin.png";a=420;}
		if(Name.equals("VICE-PRINCIPAL")) { path="images/subadmin.png";a=370;}
		if(Name.equals("FEES MANAGER")) { path="images/manager.png";a=370;}
		if(Name.equals("TEACHER")) { path="images/teacher.png";a=420;}

		
		
		//top of the frame
		title=new JLabel(Name+" LOGIN");
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
		cf.setColor(this.userName, 2, 14,true);
		user=new JTextField(12);
		cf.setColor(user, 3, 14,false);
		userPassword=new JLabel("PASSWORD");
		cf.setColor(userPassword, 2, 14, true);
		password=new JTextField(12);
		cf.setColor(password, 3, 14, false);
		b1=new JLabel();
		b2=new JLabel();
		b3=new JLabel();
		s1=new JSeparator();
		s2=new JSeparator();
		w1=new JLabel(" ");
		w2=new JLabel(" ");
		
		//center down components login buttons
		loginButton=new JButton("Login");
		forgetButton=new JButton("Forget ??");
		loginButton.setBackground(new Color(105,105,105));
		cf.undecorateButton(forgetButton);
		//forgetButton.setBackground(new Color(105,105,105));
		cf.setColor(loginButton, 3, 16, true);
		cf.setColor(forgetButton, 2, 14, true);
		w3=new JLabel();
		
		
		
		//center down container
		userDetail=new JPanel();
		userDetail.setOpaque(false);
		userDetail.setLayout(new GridLayout(4, 3));
		userDetail.add(userName);
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
		
		
		
		
		centerDownPanel=new JPanel();
		centerDownPanel.setOpaque(false);
		centerDownPanel.setLayout(new GridLayout(2, 1));
		centerDownPanel.add(userDetail);
		centerDownPanel.add(logButton);
		
		
		
		
		
		
		
		centerPanel=new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new GridBagLayout());
		
		cf.addBag(centerPanel,centerUpPanel,c,0,240,1,0,0,0,GridBagConstraints.NORTH);
		cf.addBag(centerPanel,centerDownPanel,c,-10,-20,1,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(centerPanel,w3,c,0,40,1,1,0,0,GridBagConstraints.SOUTH);
		
		
		mainPanel.add(topPanel,BorderLayout.NORTH);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		getContentPane().add(mainPanel);
		
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new indexClass();
			}
		});
		
		if(Name.equals("PRINCIPAL") || Name.equals("VICE-PRINCIPAL")) {
		//actionListener
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnect x=new DBConnect();
					String sql="select ausername,apassword from adminlog where atype='"+Name+"'";
					ResultSet rs=x.QueryReturner(sql);
					rs.next();
					if(rs.getString(1).equals(user.getText()) && rs.getString(2).equals(password.getText()) ){
						new MainFrame(Name,rs.getString(1));
						dispose();
					}else {
						w3.setText("wong password");
					}
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
				
			}
		});
		
		
		

	}

	if(Name.equals("FEES MANAGER") || Name.equals("TEACHER")) {

	loginButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DBConnect x=new DBConnect();
				String sql="select ausername,apassword from adminlog where atype='"+Name+"'";
				ResultSet rs=x.QueryReturner(sql);
				while(rs.next()) {
				if(rs.getString(1).equals(user.getText()) && rs.getString(2).equals(password.getText()) ){
					new UserMainFrame(Name,rs.getString(1));					
					dispose();
				}
				}
				w3.setText("wong password          aaaaa");
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
			
		}
	});

}
}

	
}
