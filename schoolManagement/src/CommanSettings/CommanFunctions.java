package CommanSettings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
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
	public void setColor(Component com,int font, int size,boolean color) {
		if(color) com.setForeground(Color.WHITE); else com.setForeground(new Color(105,105,105)); 
		if(font==0) com.setFont(new Font("Bradley Hand ITC",Font.PLAIN,size));
		if(font==1) com.setFont(new Font("Bradley Hand ITC",Font.BOLD,size));
		if(font==2) com.setFont(new Font("Bradley Hand ITC",Font.ITALIC,size));
		if(font==3) com.setFont(new Font("Bradley Hand ITC",Font.BOLD+Font.ITALIC,size));
	}
}
