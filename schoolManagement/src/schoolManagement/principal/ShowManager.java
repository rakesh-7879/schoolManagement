package schoolManagement.principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import CommanSettings.CommanFunctions;
import CommanSettings.DBConnect;

public class ShowManager extends JPanel {
	JPanel titlePanel,dataPanel,tablePanel;
	JLabel title,userName,name,age,jDate,eMail,mobile,lline,address,type;
	JTextField euser,ename,eage,ejDate,eeMail,emobile,elline,eaddress;
	JComboBox etype;
	JButton save, reset,b1;
	JLabel wuser,wname,wage,wjDate,weMail,wmobile,wlline,waddress;
	JTable tb;
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	public ShowManager() {
		setOpaque(false);
		setVisible(false);
		setLayout(new GridBagLayout());
		
		//title panel
		title=new JLabel("Managers");
		cf.setColor(title, 3, 14, true);		
		
		titlePanel=new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setOpaque(false);
		
		cf.addBag(titlePanel, title, c, 0, 5, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(titlePanel, new JSeparator(), c, 80, 0, 0, 1, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		//data panel
		userName=new JLabel("User Name");
		cf.setColor(userName, 2, 14, true);
		euser=new JTextField(15);
		cf.setColor(euser, 3, 12, false);
		euser.setEditable(false);
		wuser=new JLabel(" ");
		cf.setColor(wuser, 2, 14, true);
		
		name=new JLabel("Employe Name");
		cf.setColor(name, 2, 14, true);
		ename=new JTextField(15);
		cf.setColor(ename, 3, 14, false);
		wname=new JLabel(" ");
		cf.setColor(wname, 2, 12, true);
		
		age=new JLabel("Age");
		cf.setColor(age, 2, 14, true);
		eage=new JTextField(15);
		cf.setColor(eage, 3, 14, false);
		wage=new JLabel(" ");
		cf.setColor(wage, 2, 12, true);
		
		jDate=new JLabel("Joining Date");
		cf.setColor(jDate, 2, 14, true);
		ejDate=new JTextField(15);
		cf.setColor(ejDate, 3, 14, false);
		wjDate=new JLabel(" ");
		cf.setColor(wjDate, 2, 12, true);
		
		eMail=new JLabel("Email ID");
		cf.setColor(eMail, 2, 14, true);
		eeMail=new JTextField(15);
		cf.setColor(eeMail, 3, 14, false);
		weMail=new JLabel(" ");
		cf.setColor(weMail, 2, 12, true);

		mobile=new JLabel("Mobile");
		cf.setColor(mobile, 2, 14, true);
		emobile=new JTextField(15);
		cf.setColor(emobile, 3, 14, false);
		wmobile=new JLabel(" ");
		cf.setColor(wmobile, 2, 12, true);
		
		lline=new JLabel("Land Line");
		cf.setColor(lline, 2, 14, true);
		elline=new JTextField(15);
		cf.setColor(elline, 3, 14, false);
		wlline=new JLabel(" ");
		cf.setColor(wlline, 2, 12, true);
		
		address=new JLabel("Address");
		cf.setColor(address, 2, 14, true);
		eaddress=new JTextField(15);
		cf.setColor(eaddress, 3, 14, false);
		waddress=new JLabel(" ");
		cf.setColor(waddress, 2, 12, true);
		
		type=new JLabel("Employee Type");
		cf.setColor(type, 2, 14, true);
		etype=new JComboBox();
		cf.setColor(etype, 3, 14, false);
		etype.addItem("TEACHER");
		etype.addItem("FEES MANAGER");
		
		save=new JButton("Save");
		cf.setColor(save, 3, 14, true);
		save.setBackground(new Color(105,105,105));
		save.setContentAreaFilled(true);
		
		reset=new JButton("Reset");
		cf.setColor(reset, 3, 14, true);
		cf.undecorateButton(reset);
		
		
		dataPanel=new JPanel();
		dataPanel.setOpaque(false);
		dataPanel.setLayout(new GridBagLayout());
		dataPanel.setVisible(false);
		
		
		cf.addBag(dataPanel, userName, c, 0, 0, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, euser, c, 0, 0, 2, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wuser, c, 0, 10, 2, 1, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, name, c, 20, 0, 3, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 4, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, ename, c, 0, 0, 5, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 6, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, age, c, 20, 0, 7, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 8, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eage, c, 0, 0, 9, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wname, c, 0, 10, 5, 3, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, wage, c, 0, 10, 9, 3, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, jDate, c, 20, 0, 3, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 4, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, ejDate, c, 0, 0, 5, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 6, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eMail, c, 20, 0, 7, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 8, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eeMail, c, 0, 0, 9, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wjDate, c, 0, 10, 5, 5, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, weMail, c, 0, 10, 9, 5, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, mobile, c, 20, 0, 3, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 4, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, emobile, c, 0, 0, 5, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 6, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, lline, c, 20, 0, 7, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 8, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, elline, c, 0, 0, 9, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wmobile, c, 0, 10, 5, 7, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, wlline, c, 0, 10, 9, 7, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, address, c, 20, 0, 3, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 4, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eaddress, c, 0, 0, 5, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 6, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, type, c, 20, 0, 7, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 8, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, etype, c, 30, 0, 9, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, waddress, c, 0, 10, 5, 9, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, save, c, 0, 10, 8, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, reset, c, 0, 10, 9, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		//table panel
		String[] cheader= {"Name","Age","Joining Date","E-Mail","Mobile","Land Line","Address"," "};
		tb=new JTable();
		//tb.setEnabled(false);
		tb.setPreferredScrollableViewportSize(new Dimension(1000, 100));
		tb.setFillsViewportHeight(true);
		JTableHeader th=tb.getTableHeader();
		th.setBackground(new Color(105,105,105));
		th.setForeground(Color.white);
		th.setFont(new Font("Bradley Hand ITC",Font.BOLD+Font.ITALIC,14));
		DefaultTableModel dt=new DefaultTableModel(cheader,0);
		try {
			DBConnect x=new DBConnect();
			String sql="select aname,aage,ajdate,aemail,amobile,alline,aaddress from adminlog where atype='FEES MANAGER'";
			ResultSet rs=x.QueryReturner(sql);
		
		
		JButton b=new JButton("Edit");
		while(rs.next()) {
			dt.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),b});
			
		}
		
		
		}catch(Exception ex) {}
		
		tb.setModel(dt);
		
		tablePanel=new JPanel();
		tablePanel.setOpaque(false);
		
		cf.setColor(tb, 3, 14, false);
		
		
		JScrollPane js=new JScrollPane(tb);
		
		
		tablePanel.add(js);
		
		
		
		
		
		cf.addBag(this, titlePanel, c, 0, 0, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(this, dataPanel, c, 0, 70, 0, 1, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(this, tablePanel, c, 0, 70, 0, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		ename.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(ename.getText().equals("")) {
					wname.setText("Not be empty");
					return;
				}
				wname.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		eage.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(eage.getText().equals("")) {
					wage.setText("Not be empty");
					return;
				}
				wage.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ejDate.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(ejDate.getText().equals("")) {
					wjDate.setText("Not be empty");
					return;
				}
				wjDate.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		eeMail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(eeMail.getText().equals("")) {
					weMail.setText("Not be empty");
					return;
				}
				weMail.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		emobile.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(emobile.getText().equals("")) {
					wmobile.setText("Not be empty");
					return;
				}
				wmobile.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		elline.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(elline.getText().equals("")) {
					wlline.setText("Not be empty");
					return;
				}
				wlline.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		eaddress.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(eaddress.getText().equals("")) {
					waddress.setText("Not be empty");
					return;
				}
				waddress.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});




		
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(wuser.getText().equals("Avalible") && wname.getText().equals(" ") && wage.getText().equals(" ") && wjDate.getText().equals(" ") && weMail.getText().equals(" ")  && wmobile.getText().equals(" ") && wlline.getText().equals(" ") && waddress.getText().equals(" ")) {
					try {
						DBConnect x=new DBConnect();
						
					}catch(Exception ex) {	System.out.println(ex);}
					JOptionPane.showMessageDialog(null, "Data fill sucessfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "first fill all the required textFieled");
				}
				
			}
		});		
		
		
		
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				euser.setText("");
				ename.setText("");
				eage.setText("");
				ejDate.setText("");
				eeMail.setText("");
				emobile.setText("");
				elline.setText("");
				eaddress.setText("");
				etype.setSelectedIndex(0);
			}
		});
		
	}
}
