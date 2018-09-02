package schoolManagement.principal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPopupMenu.Separator;

import CommanSettings.CommanFunctions;

public class FeesInfo extends JPanel{
	JButton addFType,showFees,studentFeesTable;
	JSeparator s0,s1,s2;
	GridBagConstraints c=new GridBagConstraints();
	CommanFunctions cf=new CommanFunctions();
	public FeesInfo() {
		setVisible(false);
		setSize(300,600);
		setOpaque(false);
		setLayout(new GridBagLayout());
		
		
		
		addFType=new JButton("Add fees type");
		cf.setColor(addFType, 3, 16, true);
		cf.undecorateButton(addFType);
		
		showFees=new JButton("Show Fees Table");
		cf.setColor(showFees, 3, 16, true);
		cf.undecorateButton(showFees);
		
		studentFeesTable=new JButton("Student Fees Table");
		cf.setColor(studentFeesTable, 3, 16, true);
		cf.undecorateButton(studentFeesTable);
		
		s0=new JSeparator();
		s1=new JSeparator();
		s2=new JSeparator();
		
		cf.addBag(this,addFType,c,0,0,0,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,s1,c,200,10,0,3,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,new JSeparator(),c,200,10,0,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,showFees,c,0,0,0,5,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,s2,c,200,10,0,6,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,studentFeesTable,c,0,0,0,7,0,0,GridBagConstraints.SOUTH);
				
	}
	
	
}
