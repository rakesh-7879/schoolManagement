package schoolManagement.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import CommanSettings.CommanFunctions;
import beans.MyPanel;

public class MainFrame extends JFrame{
	Dimension d;
	JPanel topPanel,titlePanel,centerPanel,centerTopPanel,centerRightPanel,centerCenterPanel;
	MyPanel mainPanel;
	JLabel title,titleImage;
	JButton close,adminButton,empButton,feesButton,resultButton,studentButton;
	JSeparator seprator;
	Color cr=new Color(105,105,105);
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	public MainFrame() {
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
		title=new JLabel("Principal");
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
		
		//center top panel
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
		
		centerTopPanel=new JPanel();
		centerTopPanel.setBackground(new Color(105,105,105));
		centerTopPanel.add(adminButton);
		centerTopPanel.add(empButton);
		centerTopPanel.add(studentButton);
		centerTopPanel.add(feesButton);
		centerTopPanel.add(resultButton);
		
		
		
		//center right panel
		
		
		
		centerRightPanel=new JPanel();
		centerRightPanel.setBackground(new Color(105,105,105));
		
		
		
		
		
		
		
		
		
		centerPanel=new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(centerTopPanel,BorderLayout.NORTH);
		centerPanel.add(centerRightPanel,BorderLayout.WEST);
		
		
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
		new MainFrame();
	}
}
