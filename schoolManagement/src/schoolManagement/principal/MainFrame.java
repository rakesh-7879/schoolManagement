package schoolManagement.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.concurrent.BrokenBarrierException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

import CommanSettings.CommanFunctions;
import CommanSettings.DBConnect;
import beans.MyPanel;
import oracle.jdbc.driver.Message;

public class MainFrame extends JFrame{
	Dimension d;
	JPanel topPanel,titlePanel,centerPanel,centerRightPanel,centerCenterPanel;
	MyPanel mainPanel;
	JLabel title,titleImage;
	JButton close;

	Color cr=new Color(105,105,105);
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	PMenu pMenu;
	VMenu vMenu;
	adminInfo admin;
	EmployeeInfo employee;
	EditMe editMe;
	ChangePassword cp1;
	AddEmployee ae;
	ShowManager sm;
	
	public MainFrame(String name) {
		d=getToolkit().getScreenSize();
		setUndecorated(true);
		setVisible(true);
		setTitle("Principal log");
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
		
		
		
		cf.addBag(titlePanel,title,c,1015,20,1,0,0,0,GridBagConstraints.LINE_START);
		
		
		
		topPanel=new JPanel();
		topPanel.setLayout(new GridBagLayout());
		topPanel.setBackground(cr);
		
		cf.addBag(topPanel,titlePanel,c,0,0,0,0,0,0,GridBagConstraints.LINE_START);
		cf.addBag(topPanel,close,c,10,10,1,0,0,0,GridBagConstraints.LINE_END);
		
		//center top
		
		centerPanel=new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new BorderLayout());
		pMenu=new PMenu();
		vMenu=new VMenu();
		
		
		//center center
		editMe=new EditMe();
		cp1=new ChangePassword();
		ae=new AddEmployee();
		sm=new ShowManager();
		
		
		//center right
		admin=new adminInfo();
		employee=new EmployeeInfo();
		
		
		if(name.equals("PRINCIPAL")) {
			
			pMenu.setVisible(true);
			
			
			
			//admin menu ke action Listener
			//adminInfo top menu
			pMenu.adminButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					admin.setVisible(true);
					editMe.setVisible(true);
					cp1.setVisible(false);
					employee.setVisible(false);
					ae.setVisible(false);
					sm.setVisible(false);
				}
			});		
			
			//editme right menu
			admin.editMe.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					editMe.setVisible(true);
					editMe.principal.setEditable(true);
					editMe.age.setEditable(true);
					editMe.joining.setEditable(true);
					editMe.eMail.setEditable(true);
					editMe.mobile.setEditable(true);
					editMe.home.setEditable(true);
					editMe.address.setEditable(true);
					editMe.pSave.setVisible(true);
					
					editMe.vprincipal.setEditable(false);
					editMe.vage.setEditable(false);
					editMe.vjoining.setEditable(false);
					editMe.veMail.setEditable(false);
					editMe.vmobile.setEditable(false);
					editMe.vhome.setEditable(false);
					editMe.vaddress.setEditable(false);
					editMe.pSave2.setVisible(false);

					cp1.setVisible(false);
				}
			});
			
			
			
		}
		

			
		if(name.equals("VIS-PRINCIPAL")) {
			pMenu.setVisible(true);
			admin.editMe.setVisible(false);
			admin.editVis.setText("Edit Me");
			admin.s0.setVisible(false);
			
			//admin menu ke action Listener
			//adminInfo top menu
			pMenu.adminButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					admin.setVisible(true);
					editMe.setVisible(true);
					cp1.setVisible(false);
					employee.setVisible(false);
					ae.setVisible(false);
					sm.setVisible(false);
				}
			});		
			
			
		}
		
		
		
		
		
		//edit Visprincipal right menu
		admin.editVis.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				editMe.setVisible(true);
				editMe.vprincipal.setEditable(true);
				editMe.vage.setEditable(true);
				editMe.vjoining.setEditable(true);
				editMe.veMail.setEditable(true);
				editMe.vmobile.setEditable(true);
				editMe.vhome.setEditable(true);
				editMe.vaddress.setEditable(true);
				editMe.pSave2.setVisible(true);
				
				
				editMe.principal.setEditable(false);
				editMe.age.setEditable(false);
				editMe.joining.setEditable(false);
				editMe.eMail.setEditable(false);
				editMe.mobile.setEditable(false);
				editMe.home.setEditable(false);
				editMe.address.setEditable(false);
				editMe.pSave.setVisible(false);

				cp1.setVisible(false);
			}
		});
		
		
				
		
		
		
		
		//open change password action active	
		admin.changePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editMe.setVisible(false);
				cp1.setVisible(true);
				
			}
		});
		
		
		cp1.save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnect x=new DBConnect();
					String sql="update adminlog set apassword='"+ cp1.enewp2.getText() +"' where apassword='"+cp1.eolderp.getText()+"' and atype='"+name+"'";
					x.QueryExecuter(sql);
					JOptionPane.showMessageDialog(null, "Password Changed");
				}catch(Exception ex) {}
				
			}
		});
		
		
		cp1.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.setVisible(true);
				editMe.setVisible(true);
				cp1.setVisible(false);
			}
		});
		

		pMenu.empButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.setVisible(false);
				editMe.setVisible(false);
				cp1.setVisible(false);
				employee.setVisible(true);
				ae.setVisible(true);
				sm.setVisible(false);
			}
		});
		
		try {
			DBConnect x=new DBConnect();
			String sql="select * from adminlog";
			ResultSet rs=x.QueryReturner(sql);
			rs.next();
						
			String date=rs.getDate(4).toString();
			java.util.Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String d=sdf.format(date1);
			
			editMe.principal.setText(rs.getString(2));
			editMe.age.setText(rs.getString(3));
			editMe.joining.setText(d);
			editMe.eMail.setText(rs.getString(5));
			editMe.mobile.setText(rs.getString(6));
			editMe.home.setText(rs.getString(7));
			editMe.address.setText(rs.getString(8));
			
			
			rs.next();
			
			String datev=rs.getDate(4).toString();
			java.util.Date date1v=new SimpleDateFormat("yyyy-MM-dd").parse(datev);
			SimpleDateFormat sdfv=new SimpleDateFormat("yyyy-MM-dd");
			String dv=sdfv.format(date1v);
			
			editMe.vprincipal.setText(rs.getString(2));
			editMe.vage.setText(rs.getString(3));
			editMe.vjoining.setText(dv);
			editMe.veMail.setText(rs.getString(5));
			editMe.vmobile.setText(rs.getString(6));
			editMe.vhome.setText(rs.getString(7));
			editMe.vaddress.setText(rs.getString(8));
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		employee.addEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.setVisible(false);
				editMe.setVisible(false);
				cp1.setVisible(false);
				employee.setVisible(true);
				ae.setVisible(true);
				sm.setVisible(false);
				}
		});

		
		employee.managers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.setVisible(false);
				editMe.setVisible(false);
				cp1.setVisible(false);
				employee.setVisible(true);
				ae.setVisible(false);
				sm.setVisible(true);
				
			}
		});
		
		
		
		
		
		//center center panel
		centerCenterPanel=new JPanel();
		centerCenterPanel.setOpaque(false);
		centerCenterPanel.add(editMe);
		centerCenterPanel.add(cp1);
		centerCenterPanel.add(ae);
		centerCenterPanel.add(sm);
		
		
		
		
		//center right panel
		
		
		centerRightPanel=new JPanel();
		centerRightPanel.setBackground(new Color(105,105,105));
		centerRightPanel.add(admin);
		centerRightPanel.add(employee);
		
		
		
		
		
		
				
		
		
		
		centerPanel.add(pMenu,BorderLayout.NORTH);
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
		new MainFrame("PRINCIPAL");
	}
}
