package schoolManagement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class indexClass extends JFrame implements ActionListener{
	JPanel mainPanel, topPanel,titlePanel;
	JButton close;
	JLabel title,titleImage;
	Color cr=new Color(105,105,105);
	
	
	
	
	JButton db1,db2,db3;
	GridBagConstraints c=new GridBagConstraints();
	Dimension d=new Dimension();
	
	
	public indexClass(){
		setUndecorated(true);
		setVisible(true);
		setBounds(100, 100, 700, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imageIcon=new ImageIcon("images/bg.jpeg");
		Image image=imageIcon.getImage();
		Image newing=image.getScaledInstance(700, 480,Image.SCALE_SMOOTH);
		imageIcon=new ImageIcon(newing);
		JLabel l=new JLabel(imageIcon);
		//testing button
		db1=new JButton("1");
		db2=new JButton("2");
		db3=new JButton("");
		
		d=Toolkit.getDefaultToolkit().getScreenSize();
		//components
		close=new JButton();
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setIcon(new ImageIcon("images/close.png"));
			
		
		mainPanel=new JPanel();
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(l);
		
		
		title=new JLabel("SCHOOL MANAGEMENT");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("arial",Font.BOLD+Font.ITALIC,16));
		
		
		ImageIcon imageIcon1=new ImageIcon("images/logo.png");
		Image imag1e=imageIcon1.getImage();
		Image newing1=image.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		imageIcon=new ImageIcon(newing1);
		titleImage=new JLabel(imageIcon1);
		
		
		titlePanel=new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setBackground(cr);
		c.fill=GridBagConstraints.HORIZONTAL;
		addBag(titlePanel,titleImage,c,30,30,0,0,0,0,GridBagConstraints.LINE_START);
		addBag(titlePanel,title,c,420,20,1,0,0,0,GridBagConstraints.LINE_START);
		
		
		
		topPanel=new JPanel();
		topPanel.setLayout(new GridBagLayout());
		topPanel.setBackground(cr);
		addBag(topPanel,close,c,10,10,1,0,0.1,0,GridBagConstraints.PAGE_START);
		addBag(topPanel,titlePanel,c,0,0,0,0,0,0,GridBagConstraints.LINE_END);
		
				
		
		
		
		
		mainPanel.add(topPanel,BorderLayout.NORTH);
		
		getContentPane().add(mainPanel);
		
		
		//actionListener
		close.addActionListener(this);
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
	
	public static void main(String args[]) {
		new indexClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
