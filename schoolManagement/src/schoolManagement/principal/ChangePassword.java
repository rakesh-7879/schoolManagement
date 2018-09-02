package schoolManagement.principal;

import java.awt.*;

import javax.swing.*;

import CommanSettings.CommanFunctions;

public class ChangePassword extends JPanel {
	JLabel olderp,newp1,newp2,wolderp,wnewp1,wnewp2;
	JTextField eolderp,enewp1,enewp2;
	JButton save,cancel;
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	public ChangePassword() {
		setVisible(false);
		setOpaque(false);
		setLayout(new GridBagLayout());
		
		olderp=new JLabel("Older Password");
		cf.setColor(olderp, 2, 14, true);
		eolderp=new JTextField(15);
		cf.setColor(eolderp, 3, 14, false);
		wolderp=new JLabel("");
		cf.setColor(wolderp, 2, 12, true);
		
		newp1=new JLabel("New Password");
		cf.setColor(newp1, 2, 14, true);
		enewp1=new JTextField(15);
		cf.setColor(enewp1, 3, 14, false);
		wnewp1=new JLabel("");
		cf.setColor(wnewp1, 2, 12, true);
		
		
		newp2=new JLabel("New Password");
		cf.setColor(newp2, 2, 14, true);
		enewp2=new JTextField(15);
		cf.setColor(enewp2, 3, 14, false);
		wnewp2=new JLabel("");
		cf.setColor(wnewp2, 2, 12, true);
		
		save=new JButton("Save");
		save.setBackground(new Color(105,105,105));
		cf.setColor(save, 16, 3, true);
		cancel=new JButton("Cancel");
		cf.undecorateButton(cancel);
		cf.setColor(cancel, 14, 2, true);
		
		
		cf.addBag(this,new JSeparator(),c,0,200,0,0,0,0,GridBagConstraints.PAGE_START);
		
		cf.addBag(this,olderp,c,20,0,0,1,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,30,0,1,1,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,eolderp,c,0,0,2,1,0,0,GridBagConstraints.SOUTH);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,30,0,3,1,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,wolderp,c,0,0,4,1,0,0,GridBagConstraints.PAGE_START);
				
		cf.addBag(this,new JSeparator(),c,0,20,0,2,0,0,GridBagConstraints.PAGE_START);
		
		cf.addBag(this,newp1,c,20,0,0,3,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,30,0,1,3,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,enewp1,c,0,0,2,3,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,30,0,3,3,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,wnewp1,c,0,0,4,3,0,0,GridBagConstraints.PAGE_START);
		
		cf.addBag(this,new JSeparator(),c,0,20,0,4,0,0,GridBagConstraints.PAGE_START);
		
		cf.addBag(this,newp2,c,20,0,0,5,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,30,0,1,5,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,enewp2,c,0,0,2,5,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,new JSeparator(JSeparator.VERTICAL),c,30,0,3,5,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,wnewp2,c,0,0,4,5,0,0,GridBagConstraints.PAGE_START);
		
		cf.addBag(this,new JSeparator(),c,0,20,0,6,0,0,GridBagConstraints.PAGE_START);
		
		cf.addBag(this,save,c,0,0,1,7,0,0,GridBagConstraints.PAGE_START);
		cf.addBag(this,cancel,c,0,0,2,7,0,0,GridBagConstraints.PAGE_START);
	}
}
