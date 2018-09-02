package schoolManagement.principal;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;

import javax.swing.*;

import CommanSettings.CommanFunctions;
import CommanSettings.DBConnect;

public class AddFeesType extends JPanel {
	JPanel titlePanel,dataPanel;
	JLabel title,id,name,amount1, amount2,amount3;
	JTextField eid,ename,eamount1,eamount2,eamount3;
	JButton save, reset;
	JLabel wid,wname,wamount1,wamount2,wamount3;
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	public AddFeesType() {
		setOpaque(false);
		setVisible(false);
		setLayout(new GridBagLayout());
		
		//title panel
		title=new JLabel("Add Fees Type");
		cf.setColor(title, 3, 14, true);		
		
		titlePanel=new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setOpaque(false);
		
		cf.addBag(titlePanel, title, c, 20, 5, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(titlePanel, new JSeparator(), c, 120, 0, 0, 1, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		//data panel
		id=new JLabel("Fees ID");
		cf.setColor(id, 2, 14, true);
		eid=new JTextField(15);
		cf.setColor(eid, 3, 12, false);
		wid=new JLabel(" ");
		cf.setColor(wid, 2, 14, true);
		
		name=new JLabel("Fees Name");
		cf.setColor(name, 2, 14, true);
		ename=new JTextField(15);
		cf.setColor(ename, 3, 14, false);
		wname=new JLabel(" ");
		cf.setColor(wname, 2, 12, true);
		
		amount1=new JLabel("First To Fifth");
		cf.setColor(amount1, 2, 14, true);
		eamount1=new JTextField(15);
		cf.setColor(eamount1, 3, 14, false);
		wamount1=new JLabel(" ");
		cf.setColor(wamount1, 2, 12, true);
		
		amount2=new JLabel("Sixth To Tenth");
		cf.setColor(amount2, 2, 14, true);
		eamount2=new JTextField(15);
		cf.setColor(eamount2, 3, 14, false);
		wamount2=new JLabel(" ");
		cf.setColor(wamount2, 2, 12, true);
		
		amount3=new JLabel("Eleventh Twelfth");
		cf.setColor(amount3, 2, 14, true);
		eamount3=new JTextField(15);
		cf.setColor(eamount3, 3, 14, false);
		wamount3=new JLabel(" ");
		cf.setColor(wamount3, 2, 12, true);
		
				
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
		
		
		cf.addBag(dataPanel, id, c, 0, 0, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eid, c, 0, 0, 2, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wid, c, 0, 10, 2, 1, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, name, c, 20, 0, 0, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, ename, c, 0, 0, 2, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wname, c, 0, 10, 2, 3, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		cf.addBag(dataPanel, amount1, c, 20, 0, 0, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eamount1, c, 0, 0, 2, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		cf.addBag(dataPanel, wamount1, c, 0, 10, 2, 5, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		cf.addBag(dataPanel, amount2, c, 20, 0, 0, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eamount2, c, 0, 0, 2, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		cf.addBag(dataPanel, wamount2, c, 0, 10, 2, 7, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		cf.addBag(dataPanel, amount3, c, 20, 0, 0, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eamount3, c, 0, 0, 2, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		cf.addBag(dataPanel, wamount3, c, 0, 10, 2, 9, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, save, c, 0, 10, 5, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, reset, c, 0, 10, 6, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		
		
		cf.addBag(this, titlePanel, c, 0, 20, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(this, dataPanel, c, 0, 70, 0, 1, 0, 0, GridBagConstraints.FIRST_LINE_START);

		
		eid.setEditable(false);
		count();
		
		
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

		eamount1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(eamount1.getText().equals("")) {
					wamount1.setText("Not be empty");
					return;
				}
				wamount1.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		
		eamount2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(eamount2.getText().equals("")) {
					wamount2.setText("Not be empty");
					return;
				}
				wamount2.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		eamount3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(eamount3.getText().equals("")) {
					wamount3.setText("Not be empty");
					return;
				}
				wamount3.setText(" ");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ename.setText("");
				eamount1.setText("");
				eamount2.setText("");
				eamount3.setText("");
				
			}
		});
		
	}
	public void count() {
		try {
			DBConnect x=new DBConnect();
			String sql="select id from feesstruecture";
			ResultSet rs=x.QueryReturner(sql);
			Integer a=0;
			while(rs.next()) 
				a=rs.getInt("id");
			a++;
			eid.setText(a.toString());
		}catch(Exception ex) {}
	}
}
