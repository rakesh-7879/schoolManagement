package schoolManagement.principal;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

import CommanSettings.CommanFunctions;


public class EditMe extends JPanel{
	JPanel up,inner1,down,inner2,pSave,pSave2;
	JLabel title1,title2,pName,pAge,pJoining,pEMail,pMobile,pHome,pAddress,vName,vAge,vJoining,vEMail,vMobile,vHome,vAddress;
	JTextField principal,age,joining,eMail,mobile,home,address,vprincipal,vage,vjoining,veMail,vmobile,vhome,vaddress;
	JSeparator s00,s11;
	JButton save1,cancel1,save2,cancel2;
	GridBagConstraints c=new GridBagConstraints();
	CommanFunctions cf=new CommanFunctions();
	public EditMe() {
		setOpaque(false);
		setLayout(new GridBagLayout());
		
		//up
		up=new JPanel();
		up.setOpaque(false);
		up.setLayout(new GridBagLayout());
		title1=new JLabel("Principal");
		cf.setColor(title1, 3, 16, true);
		s00=new JSeparator();
		inner1=new JPanel();
		inner1.setOpaque(false);
		inner1.setLayout(new GridBagLayout());
		
		
		pName=new JLabel("Principal Name");
		cf.setColor(pName, 2, 14, true);
		principal=new JTextField(15);
		principal.setEditable(false);
		cf.setColor(principal, 2, 14, false);
		
		pAge=new JLabel("Principal Age");
		cf.setColor(pAge, 2, 14, true);
		age=new JTextField(15);
		age.setEditable(false);
		cf.setColor(age, 2, 14, false);
		
		pJoining=new JLabel("Joining Date");
		cf.setColor(pJoining, 2, 14, true);
		joining=new JTextField(15);
		joining.setEditable(false);
		cf.setColor(joining, 2, 14, false);
		
		
		pEMail=new JLabel("EMail Address");
		cf.setColor(pEMail, 2, 14, true);
		eMail=new JTextField(15);
		eMail.setEditable(false);
		cf.setColor(eMail, 2, 14, false);
		
		
		pMobile=new JLabel("Mobile Number");
		cf.setColor(pMobile, 2, 14, true);
		mobile=new JTextField(15);
		mobile.setEditable(false);
		cf.setColor(mobile, 2, 14, false);
		
		
		pHome=new JLabel("Landline Number");
		cf.setColor(pHome, 2, 14, true);
		home=new JTextField(15);
		home.setEditable(false);
		cf.setColor(home, 2, 14, false);
		
		
		
		pAddress=new JLabel("Address");
		cf.setColor(pAddress, 2, 14, true);
		address=new JTextField(15);
		address.setEditable(false);
		cf.setColor(address, 2, 14, false);		
		
		//save
		save1=new JButton("Save");
		cf.setColor(save1, 3, 14, false);
		cf.undecorateButton(save1);
		save1.setContentAreaFilled(true);
		cancel1=new JButton("Cancel");
		cf.setColor(cancel1, 3, 14, true);
		cf.undecorateButton(cancel1);
		
		
		pSave=new JPanel();
		pSave.setOpaque(false);
		pSave.setVisible(false);
		pSave.add(save1);
		pSave.add(cancel1);
		
		
		cf.addBag(inner1,pName,c,40,0,0,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,principal,c,40,0,1,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,new JSeparator(JSeparator.VERTICAL),c,40,0,2,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,pAge,c,40,0,3,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,age,c,40,0,4,0,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner1,new JSeparator(JSeparator.HORIZONTAL),c,0,20,4,1,0,0,GridBagConstraints.SOUTH);
		
		
		cf.addBag(inner1,pJoining,c,40,0,0,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,joining,c,40,0,1,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,new JSeparator(JSeparator.VERTICAL),c,40,0,2,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,pEMail,c,40,0,3,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,eMail,c,40,0,4,2,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner1,new JSeparator(JSeparator.HORIZONTAL),c,0,20,4,3,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner1,pMobile,c,40,0,0,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,mobile,c,40,0,1,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,new JSeparator(JSeparator.VERTICAL),c,40,0,2,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,pHome,c,40,0,3,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,home,c,40,0,4,4,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner1,new JSeparator(JSeparator.HORIZONTAL),c,0,20,4,5,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner1,pAddress,c,40,0,0,6,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,address,c,40,0,1,6,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,new JSeparator(JSeparator.VERTICAL),c,40,0,2,6,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner1,pSave,c,40,0,4,7,0,0,GridBagConstraints.SOUTH);
		
		
		
		
		
		cf.addBag(up,title1,c,0,0,0,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(up,s00,c,90,50,0,1,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(up,inner1,c,0,0,0,2,0,0,GridBagConstraints.PAGE_START);
		
		
		//down
		down=new JPanel();
		down.setOpaque(false);
		down.setLayout(new GridBagLayout());
		title2=new JLabel("Vis-Principal");
		cf.setColor(title2, 3, 16, true);
		s11=new JSeparator();
		inner2=new JPanel();
		inner2.setOpaque(false);
		inner2.setLayout(new GridBagLayout());
		
		
		vName=new JLabel("Vis-Principal Name");
		cf.setColor(vName, 2, 14, true);
		vprincipal=new JTextField(15);
		vprincipal.setEditable(false);
		cf.setColor(vprincipal, 2, 14, false);
		
		vAge=new JLabel("Vis-Principal Age");
		cf.setColor(vAge, 2, 14, true);
		vage=new JTextField(15);
		vage.setEditable(false);
		cf.setColor(vage, 2, 14, false);
		
		vJoining=new JLabel("Joining Date");
		cf.setColor(vJoining, 2, 14, true);
		vjoining=new JTextField(15);
		vjoining.setEditable(false);
		cf.setColor(vjoining, 2, 14, false);
		
		
		vEMail=new JLabel("EMail Address");
		cf.setColor(vEMail, 2, 14, true);
		veMail=new JTextField(15);
		veMail.setEditable(false);
		cf.setColor(veMail, 2, 14, false);
		
		
		vMobile=new JLabel("Mobile Number");
		cf.setColor(vMobile, 2, 14, true);
		vmobile=new JTextField(15);
		vmobile.setEditable(false);
		cf.setColor(vmobile, 2, 14, false);
		
		
		vHome=new JLabel("Landline Number");
		cf.setColor(vHome, 2, 14, true);
		vhome=new JTextField(15);
		vhome.setEditable(false);
		cf.setColor(vhome, 2, 14, false);
		
		
		
		vAddress=new JLabel("Address");
		cf.setColor(vAddress, 2, 14, true);
		vaddress=new JTextField(15);
		vaddress.setEditable(false);
		cf.setColor(vaddress, 2, 14, false);		
		
		//save
		save2=new JButton("Save");
		cf.setColor(save2, 3, 14, false);
		cf.undecorateButton(save2);
		save2.setContentAreaFilled(true);
		cancel2=new JButton("Cancel");
		cf.setColor(cancel2, 3, 14, true);
		cf.undecorateButton(cancel2);
		
		
		pSave2=new JPanel();
		pSave2.setOpaque(false);
		pSave2.setVisible(false);
		pSave2.add(save2);
		pSave2.add(cancel2);
		
		
		cf.addBag(inner2,vName,c,40,0,0,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vprincipal,c,40,0,1,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,new JSeparator(JSeparator.VERTICAL),c,40,0,2,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vAge,c,40,0,3,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vage,c,40,0,4,0,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner2,new JSeparator(JSeparator.HORIZONTAL),c,0,20,4,1,0,0,GridBagConstraints.SOUTH);
		
		
		cf.addBag(inner2,vJoining,c,40,0,0,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vjoining,c,40,0,1,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,new JSeparator(JSeparator.VERTICAL),c,40,0,2,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vEMail,c,40,0,3,2,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,veMail,c,40,0,4,2,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner2,new JSeparator(JSeparator.HORIZONTAL),c,0,20,4,3,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner2,vMobile,c,40,0,0,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vmobile,c,40,0,1,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,new JSeparator(JSeparator.VERTICAL),c,40,0,2,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vHome,c,40,0,3,4,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vhome,c,40,0,4,4,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner2,new JSeparator(JSeparator.HORIZONTAL),c,0,20,4,5,0,0,GridBagConstraints.SOUTH);
		
		cf.addBag(inner2,vAddress,c,40,0,0,6,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,vaddress,c,40,0,1,6,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,new JSeparator(JSeparator.VERTICAL),c,40,0,2,6,0,0,GridBagConstraints.SOUTH);
		cf.addBag(inner2,pSave2,c,40,0,4,7,0,0,GridBagConstraints.SOUTH);
		
		
		
		
		
		cf.addBag(down,title2,c,0,0,0,0,0,0,GridBagConstraints.SOUTH);
		cf.addBag(down,s11,c,90,50,0,1,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(down,inner2,c,0,0,0,2,0,0,GridBagConstraints.PAGE_START);
		
		
		cf.addBag(this,up,c,0,0,0,0,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,new JSeparator(),c,0,100,0,1,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,down,c,0,0,0,2,0,0,GridBagConstraints.PAGE_START);
		
	}
}
