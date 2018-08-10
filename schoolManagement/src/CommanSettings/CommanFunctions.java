package CommanSettings;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.*;

public class CommanFunctions {
	public void undecorateButton(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	public void addBag(Container con, Component com,GridBagConstraints c,int ipx,int ipy,int gx,int gy,double wx,double wy,int anr){
		c.ipadx=ipx;
		c.ipady=ipy; 
		c.gridx=gx;
		c.gridy=gy;
		c.anchor=anr;
		c.weightx=wx;
		c.weighty=wy;
		con.add(com,c);
	}
}
