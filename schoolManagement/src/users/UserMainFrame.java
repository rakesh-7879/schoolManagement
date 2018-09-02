package users;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import CommanSettings.CommanFunctions;

import beans.*;
import schoolManagement.indexClass;


public class UserMainFrame extends JFrame{
	Dimension d;
	JPanel topPanel,titlePanel,centerPanel,centerRightPanel,centerCenterPanel;
	MyPanel mainPanel;
	JLabel title,titleImage;
	JButton close;
	JMenuBar mb;
	JMenu m;
	JMenuItem mi1,mi2;
	Color cr=new Color(105,105,105);
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	
	
	public UserMainFrame(String name,String username) {
		d=getToolkit().getScreenSize();
		setUndecorated(true);
		setVisible(true);
		setTitle("User log");
		setSize(d.width, d.height-40);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon ii=new ImageIcon("images/bg.jpeg");
		Image image=ii.getImage();
		
		close=new JButton();
		cf.undecorateButton(close);
		close.setIcon(new ImageIcon("images/close.png"));
		
		mainPanel=new MyPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setImage(image);
		
		//top panel
		title=new JLabel(name);
		cf.setColor(title, 3, 16, true);
		ImageIcon imageIcon1=new ImageIcon("images/logo.png");
		Image newing1=image.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		ImageIcon imageIcon=new ImageIcon(newing1);
		titleImage=new JLabel(imageIcon1);
		titlePanel=new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setBackground(cr);
		c.fill=GridBagConstraints.HORIZONTAL;
		cf.addBag(titlePanel,titleImage,c,30,20,0,0,0,0,GridBagConstraints.LINE_START);
		//cb=new MyComboBox1();
		//cb.setBackground(new Color(105,105,105));
		//cb.setFocusable(false);
		//cf.setColor(cb, 3, 14, true);
		//cb.addItem(username);
		
		
		mb=new JMenuBar();
		m=new JMenu(username);
		mi1=new JMenuItem("Edit Me");
		mi2=new JMenuItem("Log out");
		m.add(mi1);
		m.add(mi2);
		mb.add(m);
		
		mi1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name.equals("TEACHER")) {
					
					
				}
				if(name.equals("FEES MANAGER")){
	
					
				}
			}
		});
		mi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new indexClass();
				dispose();
			}
		});
		

		
		
		int x;
		if(name.equals("TEACHER")) x=0;
		else x=20;	
		
		cf.addBag(titlePanel,title,c,d.width-280-x,20,1,0,0,0,GridBagConstraints.LINE_START);
		
		
		
		topPanel=new JPanel();
		topPanel.setLayout(new GridBagLayout());
		topPanel.setBackground(cr);
		
		cf.addBag(topPanel,titlePanel,c,0,0,0,0,0,0,GridBagConstraints.LINE_START);
		cf.addBag(topPanel,mb,c,60,20,1,0,0,0,GridBagConstraints.LINE_END);
		cf.addBag(topPanel,close,c,10,10,2,0,0,0,GridBagConstraints.LINE_END);
		
		//center top
		
		centerPanel=new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new BorderLayout());
		
		
		
		
		

		//center center panel
		centerCenterPanel=new JPanel();
		centerCenterPanel.setOpaque(false);
		
		
		
		//center right panel
		
		
		centerRightPanel=new JPanel();
		centerRightPanel.setBackground(new Color(105,105,105));
		
		
		
		
				
		
		
		
		//centerPanel.add(pMenu,BorderLayout.NORTH);
		centerPanel.add(centerRightPanel,BorderLayout.EAST);
		centerPanel.add(centerCenterPanel,BorderLayout.CENTER);
		
		
		mainPanel.add(topPanel,BorderLayout.NORTH);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		getContentPane().add(mainPanel);
		
		
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
		

}
