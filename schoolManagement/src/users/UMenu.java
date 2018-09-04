package users;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import CommanSettings.CommanFunctions;

public class UMenu extends JPanel{
	JButton payFees,newAdmission,oldAdmission,feesTable,feesStructure;	
	Color cr=new Color(105,105,105);
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();

	public UMenu() {
		setVisible(false);
		payFees=new JButton("Pay Fees");
		cf.setColor(payFees, 1, 14, true);
		cf.undecorateButton(payFees);
		newAdmission=new JButton("New Admission");
		cf.setColor(newAdmission, 1, 14, true);
		cf.undecorateButton(newAdmission);
		oldAdmission=new JButton("Old Admission");
		cf.setColor(oldAdmission, 1, 14, true);
		cf.undecorateButton(oldAdmission);
		feesTable=new JButton("Fees Table");
		cf.setColor(feesTable, 1, 14, true);
		cf.undecorateButton(feesTable);
		feesStructure=new JButton("Fees Structure");
		cf.setColor(feesStructure, 1, 14, true);
		cf.undecorateButton(feesStructure);
		
		
		
		setBackground(new Color(105,105,105));
		setLayout(new GridBagLayout());

		
		//cf.addBag(centerPanel,centerUpPanel,c,0,240,1,0,0,0,GridBagConstraints.NORTH);
		cf.addBag(this,payFees,c,0,0,0,0,0,0,GridBagConstraints.WEST);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,0,25,1,0,0,0,GridBagConstraints.WEST);
		
		cf.addBag(this,newAdmission,c,10,5,2,0,0,0,GridBagConstraints.WEST);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,0,25,3,0,0,0,GridBagConstraints.WEST);
		
		cf.addBag(this,oldAdmission,c,10,5,4,0,0,0,GridBagConstraints.WEST);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,0,25,5,0,0,0,GridBagConstraints.WEST);
		
		cf.addBag(this,feesTable,c,10,5,6,0,0,0,GridBagConstraints.WEST);		
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,0,25,7,0,0,0,GridBagConstraints.WEST);
		
		cf.addBag(this,feesStructure,c,10,5,8,0,0,0,GridBagConstraints.WEST);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,0,25,9,0,0.1,0,GridBagConstraints.WEST);
		
	}
}
