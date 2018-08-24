package schoolManagement.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.*;

import CommanSettings.CommanFunctions;
import beans.MyPanel;

public class MainFrame extends JFrame{
	Dimension d;
	JPanel topPanel,titlePanel,centerPanel,centerRightPanel,centerCenterPanel;
	MyPanel mainPanel;
	JLabel title,titleImage;
	JButton close;

	Color cr=new Color(105,105,105);
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	PMenu pMenu;
	VMenu vMenu;
	adminInfo admin;
	public MainFrame(String name) {
		d=getToolkit().getScreenSize();
		setUndecorated(true);
		setVisible(true);
		setTitle("Principal log");
		setSize(d.width, d.height-40);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon ii=new ImageIcon("images/bg.jpeg");
		Image image=ii.getImage();
		
		close=new JButton();
		cf.undecorateButton(close);
		close.setIcon(new ImageIcon("images/close.png"));
		
		mainPanel=new MyPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setImage(image);
		
		//top panel
		title=new JLabel(name);
		cf.setColor(title, 3, 16, true);
		ImageIcon imageIcon1=new ImageIcon("images/logo.png");
		Image newing1=image.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		ImageIcon imageIcon=new ImageIcon(newing1);
		titleImage=new JLabel(imageIcon1);
		titlePanel=new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setBackground(cr);
		c.fill=GridBagConstraints.HORIZONTAL;
		cf.addBag(titlePanel,titleImage,c,30,20,0,0,0,0,GridBagConstraints.LINE_START);
		
		
		
		cf.addBag(titlePanel,title,c,1215,20,1,0,0,0,GridBagConstraints.LINE_START);
		
		
		
		topPanel=new JPanel();
		topPanel.setLayout(new GridBagLayout());
		topPanel.setBackground(cr);
		
		cf.addBag(topPanel,titlePanel,c,0,0,0,0,0,0,GridBagConstraints.LINE_START);
		cf.addBag(topPanel,close,c,10,10,1,0,0,0,GridBagConstraints.LINE_END);
		
		//center top
		
		centerPanel=new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new BorderLayout());
		pMenu=new PMenu();
		vMenu=new VMenu();
		
		
		
		
		
		//center right
		admin=new adminInfo();
		
		
		
		if(name.equals("PRINCIPAL")) {
			centerPanel.add(pMenu,BorderLayout.NORTH);
			pMenu.setVisible(true);
			pMenu.adminButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					admin.setVisible(true);
				}
			});
			
			
			
			
			
			
		}
			
		if(name.equals("VIS-PRINCIPAL")) {
			centerPanel.add(vMenu,BorderLayout.NORTH);
			
			
			
			
			
			
			
			
			
		}
		
		//center right panel
		
		
		centerRightPanel=new JPanel();
		centerRightPanel.setBackground(new Color(105,105,105));
		centerRightPanel.add(admin);
		
		
		
		
		
		
		//center center panel
		centerCenterPanel=new JPanel();
		centerCenterPanel.setOpaque(false);
		
		
				
		
		
		
		
		centerPanel.add(centerRightPanel,BorderLayout.EAST);
		centerPanel.add(centerCenterPanel,BorderLayout.CENTER);
		
		
		mainPanel.add(topPanel,BorderLayout.NORTH);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		getContentPane().add(mainPanel);
		
		
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String args[]) {
		new MainFrame("PRINCIPAL");
	}
}
