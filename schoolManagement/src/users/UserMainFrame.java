package users;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.*;

import CommanSettings.CommanFunctions;
import CommanSettings.DBConnect;
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
	
	UMenu uMenu;
	
	NewAdmission na;
	OldAdmission oa;
	
	
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
		uMenu=new UMenu();
		
		
		
		
		centerPanel=new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new BorderLayout());
		
		
		//center center initilization
		na=new NewAdmission();
		oa=new OldAdmission();
		
		
		
		
		if(name.equals("FEES MANAGER")) {
			uMenu.setVisible(true);
			
			uMenu.newAdmission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					na.setVisible(true);
					oa.setVisible(false);
				}
			});
			uMenu.oldAdmission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					na.setVisible(false);
					oa.setVisible(true);
					
				}
			});
			
			na.save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(na.ename.getText().equals("") && na.eparent.getText().equals("") && na.edob.getText().equals("") && na.eadate.getText().equals("") && na.eaddress.getText().equals("") && na.emobile.getText().equals("") && na.essamagraid.getText().equals("") && na.efsamagraid.getText().equals("") ) {
						JOptionPane.showMessageDialog(null, "first fill all the fields");
					}else {
					try {
						DBConnect x=new DBConnect();
						String sql="insert into studenttable values('"+na.eid.getText()+"','"+
						na.ename.getText()+"','"+
						na.eparent.getText()+"',TO_DATE('"+
						na.edob.getText()+"','YYYY/MM/DD'),TO_DATE('"+
						na.eadate.getText()+"','YYYY/MM/DD hh/MI/SS'),'"+
						na.eaddress.getText()+"','"+
						na.emobile.getText()+"','"+
						na.essamagraid.getText()+"','"+
						na.efsamagraid.getText()+"','"+
						na.ephoto.getText()+"','"+
						na.esclass.getSelectedItem()+"','"+
						na.esclass.getSelectedItem()+"')";
						x.QueryExecuter(sql);
						JOptionPane.showMessageDialog(null, "sucessfully");
						na.roll="";
						Integer year=Calendar.getInstance().get(Calendar.YEAR);
						na.roll=year.toString();
						try {
							DBConnect xx=new DBConnect();
							ResultSet a=xx.QueryReturner("select count(id) from studenttable");
							a.next();
							Integer count=a.getInt(1);
							count++;
							int l=count.toString().length();
							for(int i=0;i<5-l;i++) 
								na.roll=na.roll+"0";
							na.roll=na.roll+count;
							na.eid.setText(na.roll);
							
						} catch (Exception e2) {
							
							e2.printStackTrace();
						}
						na.ename.setText("");
						na.eparent.setText("");
						na.edob.setText("");
						na.eadate.setText("");
						na.eaddress.setText("");
						na.emobile.setText("");
						na.essamagraid.setText("");
						na.efsamagraid.setText("");
						na.ephoto.setText("");
						na.esclass.setSelectedIndex(0);
						na.img=new ImageIcon("images/student.png");
						na.showimg.setIcon(na.img);	

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					}
					
				}
			});
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		

		//center center panel
		centerCenterPanel=new JPanel();
		centerCenterPanel.setOpaque(false);
		centerCenterPanel.add(na);
		centerCenterPanel.add(oa);
		
		
		//center right panel
		centerRightPanel=new JPanel();
		centerRightPanel.setBackground(new Color(105,105,105));
		
		
		
		
				
		
		
		
		centerPanel.add(uMenu,BorderLayout.NORTH);
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
		
	
	
	public static void main(String args[]) {
		new UserMainFrame("FEES MANAGER","rakesh");
	}

}