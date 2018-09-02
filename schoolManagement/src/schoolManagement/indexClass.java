package schoolManagement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import CommanSettings.*;
import beans.MyPanel;


public class indexClass extends JFrame {
	JPanel topPanel,titlePanel,centerUpPanel,centerDownPanel,centerPanel;
	MyPanel mainPanel;
	JButton close,principal,visPrincipal,feesManager,teachar;
	JLabel title,titleImage;
	Color cr=new Color(105,105,105);
	
	
	
	
	JButton db1,db2,db3;
	GridBagConstraints c=new GridBagConstraints();
	Dimension d=new Dimension();
	CommanFunctions cf=new CommanFunctions();
	
	public indexClass(){
		setUndecorated(true);
		setVisible(true);
		setBounds(100, 100, 700, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//background image setting 
		ImageIcon imageIcon=new ImageIcon("images/bg.jpeg");
		Image image=imageIcon.getImage();
		//Image newing=image.getScaledInstance(700, 480,Image.SCALE_SMOOTH);
		//imageIcon=new ImageIcon(newing);
		//JLabel l=new JLabel(imageIcon);
		
		
		
		//testing button
		db1=new JButton("1");
		db2=new JButton("2");
		db3=new JButton("");
		
		d=Toolkit.getDefaultToolkit().getScreenSize();
		//components
		close=new JButton();
		cf.undecorateButton(close);
		close.setIcon(new ImageIcon("images/close.png"));
			
		
		mainPanel=new MyPanel();
		//background of frame
		mainPanel.setLayout(new BorderLayout());
		//mainPanel.add(l);
		mainPanel.setImage(image);
		
		
		//top of the frame
		title=new JLabel("SCHOOL MANAGEMENT");
		cf.setColor(title, 3, 16,true);
		ImageIcon imageIcon1=new ImageIcon("images/logo.png");
		Image newing1=image.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		imageIcon=new ImageIcon(newing1);
		titleImage=new JLabel(imageIcon1);
		titlePanel=new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setBackground(cr);
		c.fill=GridBagConstraints.HORIZONTAL;
		cf.addBag(titlePanel,titleImage,c,30,30,0,0,0,0,GridBagConstraints.LINE_START);
		cf.addBag(titlePanel,title,c,370,20,1,0,0,0,GridBagConstraints.LINE_START);
		topPanel=new JPanel();
		topPanel.setLayout(new GridBagLayout());
		topPanel.setBackground(cr);
		
		cf.addBag(topPanel,titlePanel,c,0,0,0,0,0,0,GridBagConstraints.LINE_START);
		cf.addBag(topPanel,close,c,10,10,1,0,0,0,GridBagConstraints.LINE_END);
		
		
		
		
		//center of the frame
		principal=new JButton();
		cf.undecorateButton(principal);
		principal.setIcon(new ImageIcon("images/admin.png"));
		
		visPrincipal=new JButton();
		cf.undecorateButton(visPrincipal);
		visPrincipal.setIcon(new ImageIcon("images/subAdmin.png"));
		
		feesManager=new JButton();
		cf.undecorateButton(feesManager);
		feesManager.setIcon(new ImageIcon("images/manager.png"));
		
		teachar=new JButton();
		cf.undecorateButton(teachar);
		teachar.setIcon(new ImageIcon("images/teacher.png"));
		
		
		centerUpPanel=new JPanel();
		centerUpPanel.setOpaque(false);
		centerUpPanel.add(principal);
		
		centerDownPanel=new JPanel();
		centerDownPanel.setOpaque(false);
		centerDownPanel.add(visPrincipal);
		centerDownPanel.add(feesManager);
		centerDownPanel.add(teachar);
		
		centerPanel=new JPanel();
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new GridBagLayout());
		
		cf.addBag(centerPanel,centerUpPanel,c,0,240,1,0,0,0,GridBagConstraints.NORTH);
		cf.addBag(centerPanel,centerDownPanel,c,0,80,1,0,0,0,GridBagConstraints.SOUTH);
		
		
		mainPanel.add(topPanel,BorderLayout.NORTH);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		getContentPane().add(mainPanel);
		
		
		//actionListener
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		principal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login("PRINCIPAL");
			}
		});
		visPrincipal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login("VICE-PRINCIPAL");
			}
		});
		feesManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login("FEES MANAGER");
			}
		});
		teachar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login("TEACHER");
			}
		});

	}
	
	
	
	
	public static void main(String args[]) {
		new indexClass();
	}

}
