package schoolManagement.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.concurrent.BrokenBarrierException;
import java.util.jar.Attributes.Name;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

import CommanSettings.CommanFunctions;
import CommanSettings.DBConnect;
import beans.*;
import oracle.jdbc.driver.Message;
import schoolManagement.Login;
import schoolManagement.indexClass;

public class MainFrame extends JFrame{
	Dimension d;
	JPanel topPanel,titlePanel,centerPanel,centerRightPanel,centerCenterPanel;
	MyPanel mainPanel;
	JLabel title,titleImage;
	JButton close;
	MyComboBox1 cb;
	Color cr=new Color(105,105,105);
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	PMenu pMenu;
	VMenu vMenu;
	adminInfo admin;
	EmployeeInfo employee;
	FeesInfo fees;
	EditMe editMe;
	ChangePassword cp1;
	AddEmployee ae;
	ShowManager sm;
	ShowTeacher st;
	AddFeesType af;
	ShowFeesTable sft;
	
	JMenuBar mb;
	JMenu m;
	JMenuItem mi1 ,mi2;
	
	
	
	public MainFrame(String name,String username) {
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
				if(name.equals("PRINCIPAL")) {
					admin.setVisible(true);
					editMe.setVisible(true);
					cp1.setVisible(false);
					employee.setVisible(false);
					ae.setVisible(false);
					sm.setVisible(false);
					st.setVisible(false);
					fees.setVisible(false);
					af.setVisible(false);
					sft.setVisible(false);

					
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

				}
				if(name.equals("VICE-PRINCIPAL")){
					admin.setVisible(true);
					editMe.setVisible(true);
					cp1.setVisible(false);
					employee.setVisible(false);
					ae.setVisible(false);
					sm.setVisible(false);
					st.setVisible(false);
					fees.setVisible(false);
					af.setVisible(false);
					sft.setVisible(false);
	
					
					
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
		if(name.equals("PRINCIPAL")) x=0;
		else x=30;	
		
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
		pMenu=new PMenu();
		vMenu=new VMenu();
		
		
		//center center
		editMe=new EditMe();
		cp1=new ChangePassword();
		ae=new AddEmployee();
		sm=new ShowManager();
		st=new ShowTeacher();
		af=new AddFeesType();
		sft=new ShowFeesTable();
		
		//center right
		admin=new adminInfo();
		employee=new EmployeeInfo();
		fees=new FeesInfo();
		
		
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
					st.setVisible(false);
					fees.setVisible(false);
					af.setVisible(false);
					sft.setVisible(false);
					
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
		

			
		if(name.equals("VICE-PRINCIPAL")) {
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
					st.setVisible(false);
					fees.setVisible(false);
					af.setVisible(false);
					sft.setVisible(false);
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
				af.setVisible(false);
				sft.setVisible(false);
				
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
				af.setVisible(false);
				sft.setVisible(false);
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
				st.setVisible(false);
				fees.setVisible(false);
				af.setVisible(false);
				sft.setVisible(false);
			}
		});
		
		employee.addEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.setVisible(false);
				editMe.setVisible(false);
				cp1.setVisible(false);
				employee.setVisible(true);
				ae.setVisible(true);
				sm.setVisible(false);
				st.setVisible(false);
				fees.setVisible(false);
				af.setVisible(false);
				sft.setVisible(false);
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
				st.setVisible(false);			
				fees.setVisible(false);
				af.setVisible(false);
				sft.setVisible(false);
			}
		});
		
		
		employee.teachers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.setVisible(false);
				editMe.setVisible(false);
				cp1.setVisible(false);
				employee.setVisible(true);
				ae.setVisible(false);
				sm.setVisible(false);
				st.setVisible(true);
				fees.setVisible(false);
				af.setVisible(false);
				sft.setVisible(false);
			}
		});
		
		sm.save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sm.wname.getText().equals(" ") && sm.wage.getText().equals(" ") && sm.wjDate.getText().equals(" ") && sm.weMail.getText().equals(" ")  && sm.wmobile.getText().equals(" ") && sm.wlline.getText().equals(" ") && sm.waddress.getText().equals(" ")) {
					try {
						DBConnect x=new DBConnect();
						String sql="update adminlog set aname='"+sm.ename.getText()+
								"',aage="+sm.eage.getText()+
								",ajdate=TO_DATE('"+sm.ejDate.getText()+
								"','YYYY/MM/DD'),aemail='"+sm.eeMail.getText()+
								"',amobile='"+sm.emobile.getText()+
								"',alline='"+sm.elline.getText()+
								"',aaddress='"+sm.eaddress.getText()+
								"', atype='"+ sm.etype.getSelectedItem() +"' where ausername='"+sm.euser.getText()+"'";
						x.QueryExecuter(sql);
						JOptionPane.showMessageDialog(null, "Data fill sucessfully");
						
						update();
						
						sm.ename.setText("");
						sm.eage.setText("");
						sm.ejDate.setText("");
						sm.eeMail.setText("");
						sm.emobile.setText("");
						sm.elline.setText("");
						sm.eaddress.setText("");
						sm.etype.setSelectedIndex(1);
						sm.dataPanel.setVisible(false);
						

						
						
						
					}catch(Exception ex) {	System.out.println(ex);}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "first fill all the required textFieled");
				}
				
			}
		});	
		
		st.save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(st.wname.getText().equals(" ") && st.wage.getText().equals(" ") && st.wjDate.getText().equals(" ") && st.weMail.getText().equals(" ")  && st.wmobile.getText().equals(" ") && st.wlline.getText().equals(" ") && st.waddress.getText().equals(" ")) {
					try {
						DBConnect x=new DBConnect();
						String sql="update adminlog set aname='"+st.ename.getText()+
								"',aage="+st.eage.getText()+
								",ajdate=TO_DATE('"+st.ejDate.getText()+
								"','YYYY/MM/DD'),aemail='"+st.eeMail.getText()+
								"',amobile='"+st.emobile.getText()+
								"',alline='"+st.elline.getText()+
								"',aaddress='"+st.eaddress.getText()+
								"', atype='"+ st.etype.getSelectedItem() +"' where ausername='"+st.euser.getText()+"'";
						x.QueryExecuter(sql);
						JOptionPane.showMessageDialog(null, "Data fill sucessfully");
						
						update();
						
						st.ename.setText("");
						st.eage.setText("");
						st.ejDate.setText("");
						st.eeMail.setText("");
						st.emobile.setText("");
						st.elline.setText("");
						st.eaddress.setText("");
						st.etype.setSelectedIndex(1);
						st.dataPanel.setVisible(false);

						
					}catch(Exception ex) {	System.out.println(ex);}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "first fill all the required textFieled");
				}
				
			}
		});		
		
		
		ae.save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ae.wuser.getText().equals("Avalible") && ae.wname.getText().equals(" ") && ae.wage.getText().equals(" ") && ae.wjDate.getText().equals(" ") && ae.weMail.getText().equals(" ")  && ae.wmobile.getText().equals(" ") && ae.wlline.getText().equals(" ") && ae.waddress.getText().equals(" ")) {
					try {
						DBConnect x=new DBConnect();
						String sql="insert into adminlog values('"+ae.euser.getText()+"','"+
						ae.ename.getText()+"',"+
						ae.eage.getText()+",TO_DATE('"+
						ae.ejDate.getText()+"','DD/MM/YYYY'),'"+
						ae.eeMail.getText()+"','"+
						ae.emobile.getText()+"','"+
						ae.elline.getText()+"','"+
						ae.eaddress.getText()+"','admin','"+
						ae.etype.getSelectedItem()+"')";
						x.QueryExecuter(sql);
						
						ae.euser.setText("");
						ae.ename.setText("");
						ae.eage.setText("");
						ae.ejDate.setText("");
						ae.eeMail.setText("");
						ae.emobile.setText("");
						ae.elline.setText("");
						ae.eaddress.setText("");
						ae.etype.setSelectedIndex(0);
						ae.wuser.setText("");
						update();
						
					}catch(Exception ex) {	System.out.println(ex);}
					JOptionPane.showMessageDialog(null, "Data fill sucessfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "first fill all the required textFieled");
				}
				
			}
		});		
		

		

		pMenu.feesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				admin.setVisible(false);
				editMe.setVisible(false);
				cp1.setVisible(false);
				employee.setVisible(false);
				ae.setVisible(false);
				sm.setVisible(false);
				st.setVisible(false);
				fees.setVisible(true);
				af.setVisible(true);
				sft.setVisible(false);
				
			}
		});
		
		fees.addFType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				admin.setVisible(false);
				editMe.setVisible(false);
				cp1.setVisible(false);
				employee.setVisible(false);
				ae.setVisible(false);
				sm.setVisible(false);
				st.setVisible(false);
				fees.setVisible(true);
				af.setVisible(true);
				sft.setVisible(false);
			}
		});
		
		af.save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(af.eid.equals("") && af.ename.equals("") && af.eamount1.equals("") && af.eamount2.equals("") && af.eamount3.equals("") )
					{
						JOptionPane.showMessageDialog(null, "fill all the fieleds");
					}else {
						DBConnect x=new DBConnect();
						String sql="insert into feesstruecture values("+af.eid.getText()+",'"+af.ename.getText()+"',"+af.eamount1.getText()+","+af.eamount2.getText()+","+af.eamount3.getText()+")";
						x.QueryExecuter(sql);
						JOptionPane.showMessageDialog(null, "data fill sucessfully");
						af.count();
						af.ename.setText("");
						af.eamount1.setText("");
						af.eamount2.setText("");
						af.eamount3.setText("");
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		fees.showFees.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				admin.setVisible(false);
				editMe.setVisible(false);
				cp1.setVisible(false);
				employee.setVisible(false);
				ae.setVisible(false);
				sm.setVisible(false);
				st.setVisible(false);
				fees.setVisible(true);
				af.setVisible(false);
				sft.setVisible(true);
			}
		});
		
		sft.save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sft.wid.getText().equals(" ") && sft.wname.getText().equals(" ") && sft.wamount1.getText().equals(" ") && sft.wamount2.getText().equals(" ") && sft.wamount3.getText().equals(" ") ) {
					try {
						DBConnect x=new DBConnect();
						String sql="update feesstruecture set FEESNAME='"+sft.ename.getText()+"',FIRSTTOFIFTH="+sft.eamount1.getText()+",SIXTHTOTENTH="+sft.eamount2.getText()+",ELEVENTHTWELFTH="+sft.eamount3.getText()+" where id="+sft.eid.getText()+"";
						x.QueryExecuter(sql);
						JOptionPane.showMessageDialog(null, "Data fill sucessfully");
						
						updatefees();
						
						sft.eid.setText("");
						sft.ename.setText("");
						sft.eamount1.setText("");
						sft.eamount2.setText("");
						sft.eamount3.setText("");
						
					}catch(Exception ex) {	System.out.println(ex);}

				}
			}
		});
		
		
		//center center panel
		centerCenterPanel=new JPanel();
		centerCenterPanel.setOpaque(false);
		centerCenterPanel.add(editMe);
		centerCenterPanel.add(cp1);
		centerCenterPanel.add(ae);
		centerCenterPanel.add(sm);
		centerCenterPanel.add(st);
		centerCenterPanel.add(af);
		centerCenterPanel.add(sft);
		
		
		
		//center right panel
		
		
		centerRightPanel=new JPanel();
		centerRightPanel.setBackground(new Color(105,105,105));
		centerRightPanel.add(admin);
		centerRightPanel.add(employee);
		centerRightPanel.add(fees);
		
		
		
		
		
		
				
		
		
		
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
	public void update() {
		sm.dt.setRowCount(0);
		sm.showTable();
		st.dt.setRowCount(0);	
		st.showTable();
		
	}
	public void updatefees() {
		sft.dt.setRowCount(0);
		sft.showTable();

	}

}
