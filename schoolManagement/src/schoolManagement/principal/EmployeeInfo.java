package schoolManagement.principal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.JPopupMenu.Separator;

import CommanSettings.CommanFunctions;

public class EmployeeInfo extends JPanel{
	JButton addEmployee,managers,teachers;
	JSeparator s0,s1,s2;
	GridBagConstraints c=new GridBagConstraints();
	CommanFunctions cf=new CommanFunctions();
	public EmployeeInfo() {
		setVisible(false);
		setSize(300,600);
		setOpaque(false);
		setLayout(new GridBagLayout());
		
		
		
		addEmployee=new JButton("Add Employee");
		cf.setColor(addEmployee, 3, 16, true);
		cf.undecorateButton(addEmployee);
		
		managers=new JButton("Managers");
		cf.setColor(managers, 3, 16, true);
		cf.undecorateButton(managers);
		
		teachers=new JButton("Teachers");
		cf.setColor(teachers, 3, 16, true);
		cf.undecorateButton(teachers);
		
		s0=new JSeparator();
		s1=new JSeparator();
		s2=new JSeparator();
		
		cf.addBag(this,addEmployee,c,0,0,0,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,s1,c,200,10,0,3,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,new JSeparator(),c,200,10,0,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,managers,c,0,0,0,5,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,s2,c,200,10,0,6,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,teachers,c,0,0,0,7,0,0,GridBagConstraints.SOUTH);
	}
}
