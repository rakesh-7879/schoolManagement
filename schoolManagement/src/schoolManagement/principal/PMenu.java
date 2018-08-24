package schoolManagement.principal;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import CommanSettings.CommanFunctions;

public class PMenu extends JPanel{
	JButton adminButton,empButton,feesButton,resultButton,studentButton;
	JSeparator s0,s1,s2,s3,s4,s5;	
	Color cr=new Color(105,105,105);
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();

	public PMenu() {
		setVisible(false);
		adminButton=new JButton("Admin Info");
		cf.setColor(adminButton, 1, 14, true);
		cf.undecorateButton(adminButton);
		empButton=new JButton("Employee Info");
		cf.setColor(empButton, 1, 14, true);
		cf.undecorateButton(empButton);
		studentButton=new JButton("Student Info");
		cf.setColor(studentButton, 1, 14, true);
		cf.undecorateButton(studentButton);
		feesButton=new JButton("Fees Info");
		cf.setColor(feesButton, 1, 14, true);
		cf.undecorateButton(feesButton);
		resultButton=new JButton("Results Info");
		cf.setColor(resultButton, 1, 14, true);
		cf.undecorateButton(resultButton);
		s0=new JSeparator();
		s0.setOrientation(SwingConstants.VERTICAL);
		s1=new JSeparator();
		s1.setOrientation(SwingConstants.VERTICAL);
		s2=new JSeparator();
		s2.setOrientation(SwingConstants.VERTICAL);
		s3=new JSeparator();
		s3.setOrientation(SwingConstants.VERTICAL);
		s4=new JSeparator();
		s4.setOrientation(SwingConstants.VERTICAL);
		s5=new JSeparator();
		s5.setOrientation(SwingConstants.VERTICAL);
		

		
		
		setBackground(new Color(105,105,105));
		setLayout(new GridBagLayout());

		
		//cf.addBag(centerPanel,centerUpPanel,c,0,240,1,0,0,0,GridBagConstraints.NORTH);
		cf.addBag(this,adminButton,c,0,0,0,0,0,0,GridBagConstraints.WEST);
		cf.addBag(this,s0,c,0,25,1,0,0,0,GridBagConstraints.WEST);
		
		cf.addBag(this,empButton,c,10,5,2,0,0,0,GridBagConstraints.WEST);
		cf.addBag(this,s1,c,0,25,3,0,0,0,GridBagConstraints.WEST);
		
		cf.addBag(this,studentButton,c,10,5,4,0,0,0,GridBagConstraints.WEST);
		cf.addBag(this,s3,c,0,25,5,0,0,0,GridBagConstraints.WEST);
		
		cf.addBag(this,feesButton,c,10,5,6,0,0,0,GridBagConstraints.WEST);		
		cf.addBag(this,s4,c,0,25,7,0,0,0,GridBagConstraints.WEST);
		
		cf.addBag(this,resultButton,c,10,5,8,0,0,0,GridBagConstraints.WEST);
		cf.addBag(this,s5,c,0,25,9,0,0.1,0,GridBagConstraints.WEST);
		
	}
}
