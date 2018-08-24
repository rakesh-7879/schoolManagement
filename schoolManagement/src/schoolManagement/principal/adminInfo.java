package schoolManagement.principal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.JPopupMenu.Separator;

import CommanSettings.CommanFunctions;

public class adminInfo extends JPanel{
	JButton editMe,editVis,changePassword,help;
	JSeparator s0,s1,s2;
	GridBagConstraints c=new GridBagConstraints();
	CommanFunctions cf=new CommanFunctions();
	public adminInfo() {
		setVisible(false);
		setSize(300,600);
		setOpaque(false);
		setLayout(new GridBagLayout());
		
		
		
		editMe=new JButton("Edit Me");
		cf.setColor(editMe, 3, 16, true);
		cf.undecorateButton(editMe);
		
		editVis=new JButton("Edit Vis-Principal");
		cf.setColor(editVis, 3, 16, true);
		cf.undecorateButton(editVis);
		
		changePassword=new JButton("Change Password");
		cf.setColor(changePassword, 3, 16, true);
		cf.undecorateButton(changePassword);
		
		help=new JButton("Get Help");
		cf.setColor(help, 3, 16, true);
		cf.undecorateButton(help);
		
		s0=new JSeparator();
		s1=new JSeparator();
		s2=new JSeparator();
		
		cf.addBag(this,editMe,c,0,0,0,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,s0,c,200,10,0,1,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,editVis,c,0,0,0,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,s1,c,200,10,0,3,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,changePassword,c,0,0,0,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,s2,c,200,10,0,5,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,help,c,0,0,0,6,0,0,GridBagConstraints.SOUTH);
	}
}
