package users;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import CommanSettings.CommanFunctions;
import CommanSettings.DBConnect;

public class OldAdmission extends JPanel{
	JPanel titlePanel,dataPanel,buttonPanel,photoPanel,tablePanel;
	JLabel title,id,name,parent,dob,adate,address,mobile,ssamagraid,fsamagraid,sclass,photo,showimg;
	JTextField eid,ename,eparent,edob,eadate,eaddress,emobile,essamagraid,efsamagraid,ephoto;
	JComboBox esclass;
	JLabel wid,wname,wparent,wdob,wadate,waddress,wmobile,wssamagraid,wfsamagraid,wsclass;
	JButton save,reset,edit;
	ImageIcon img;
	LocalDateTime date;
	File file,file1,file2;
	CommanFunctions cf=new CommanFunctions();
	GridBagConstraints c=new GridBagConstraints();
	String roll;
	JTable tb;
	ResultSet rs = null;
	String pass;
	DefaultTableModel dt;
	Dimension d;
	ArrayList<String> imgpath=new ArrayList<String>();
	public OldAdmission() {
		setVisible(false);
		setOpaque(false);
		setLayout(new GridBagLayout());
		
		
		
		//title panel
		titlePanel=new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setLayout(new GridBagLayout());
		title=new JLabel("New Admission");
		cf.setColor(title, 3, 14, true);
				
		cf.addBag(titlePanel, title, c, 20, 5, 0, 0, 0, 0, GridBagConstraints.NORTH);
		cf.addBag(titlePanel, new JSeparator() , c, 130, 0, 0, 1, 0, 0, GridBagConstraints.NORTH);
		
		
		//button panel
		save=new JButton("Save");
		cf.setColor(save, 3, 14, true);
		save.setBackground(new Color(105,105,105));
		reset=new JButton("Reset");
		cf.undecorateButton(reset);
		cf.setColor(reset, 3, 14, true);
		
		
		buttonPanel=new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.add(save);
		buttonPanel.add(new JSeparator(JSeparator.VERTICAL));
		buttonPanel.add(reset);
		
		
		
		//data panel
		id=new JLabel("Student ID");
		cf.setColor(id, 2, 14, true);
		eid=new JTextField(15);
		cf.setColor(eid, 3, 12, false);
		wid=new JLabel(" ");
		cf.setColor(wid, 2, 14, true);
		Integer year=Calendar.getInstance().get(Calendar.YEAR);
		roll=year.toString();
		eid.setEditable(false);
		try {
			DBConnect x=new DBConnect();
			ResultSet a=x.QueryReturner("select count(id) from studenttable");
			a.next();
			Integer count=a.getInt(1);
			count++;
			int l=count.toString().length();
			for(int i=0;i<5-l;i++) 
				roll=roll+"0";
			roll=roll+count;
			eid.setText(roll);
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
		
		
		
		name=new JLabel("Student Name");
		cf.setColor(name, 2, 14, true);
		ename=new JTextField(15);
		cf.setColor(ename, 3, 12, false);
		wname=new JLabel(" ");
		cf.setColor(wname, 2, 14, true);
		
		parent=new JLabel("Student Parent");
		cf.setColor(parent, 2, 14, true);
		eparent=new JTextField(15);
		cf.setColor(eparent, 3, 12, false);
		wparent=new JLabel(" ");
		cf.setColor(wparent, 2, 14, true);
		
		dob=new JLabel("Date Of Birth");
		cf.setColor(dob, 2, 14, true);
		edob=new JTextField(15);
		cf.setColor(edob, 3, 12, false);
		wdob=new JLabel(" ");
		cf.setColor(wdob, 2, 14, true);
		
		adate=new JLabel("Admission Date");
		cf.setColor(adate, 2, 14, true);
		eadate=new JTextField(15);
		cf.setColor(eadate, 3, 12, false);
		wadate=new JLabel(" ");
		cf.setColor(wadate, 2, 14, true);

		address=new JLabel("Address");
		cf.setColor(address, 2, 14, true);
		eaddress=new JTextField(15);
		cf.setColor(eaddress, 3, 12, false);
		waddress=new JLabel(" ");
		cf.setColor(waddress, 2, 14, true);
		
		mobile=new JLabel("Mobile Number");
		cf.setColor(mobile, 2, 14, true);
		emobile=new JTextField(15);
		cf.setColor(emobile, 3, 12, false);
		wmobile=new JLabel(" ");
		cf.setColor(wmobile, 2, 14, true);
		
		ssamagraid=new JLabel("Student Samagra ID");
		cf.setColor(ssamagraid, 2, 14, true);
		essamagraid=new JTextField(15);
		cf.setColor(essamagraid, 3, 12, false);
		wssamagraid=new JLabel(" ");
		cf.setColor(wssamagraid, 2, 14, true);
		
		fsamagraid=new JLabel("Family Samagra ID");
		cf.setColor(fsamagraid, 2, 14, true);
		efsamagraid=new JTextField(15);
		cf.setColor(efsamagraid, 3, 12, false);
		wfsamagraid=new JLabel(" ");
		cf.setColor(wfsamagraid, 2, 14, true);

		sclass=new JLabel("Class");
		cf.setColor(sclass, 2, 14, true);
		esclass=new JComboBox();
		esclass.addItem("first");
		esclass.addItem("second");
		esclass.addItem("third");
		esclass.addItem("fourth");
		esclass.addItem("fifth");
		esclass.addItem("sixth");
		esclass.addItem("seventh");
		esclass.addItem("eighth");
		esclass.addItem("ninth");
		esclass.addItem("tenth");
		esclass.addItem("eleventh");
		esclass.addItem("twelfth");
		cf.setColor(esclass, 3, 12, false);
		wsclass=new JLabel(" ");
		cf.setColor(wsclass, 2, 14, true);
		
		photo=new JLabel("Photo");
		cf.setColor(photo, 2, 14, true);
		ephoto=new JTextField(15);
		cf.setColor(ephoto, 3, 12, false);
		
		
		showimg=new JLabel();
		img=new ImageIcon("images/student.png");
		showimg.setIcon(img);
		
		dataPanel=new JPanel();
		dataPanel.setOpaque(false);
		dataPanel.setLayout(new GridBagLayout());
		dataPanel.setVisible(false);
		
		
		
		//table panel
		String[] cheader= {"ID","Name","Parent","DOB","Admission Date","Address","Mobile","Samagra ID","family S ID","Ad. Class","Cu. Class"};
		edit=new JButton("Edit");
		edit.setVisible(false);
		cf.undecorateButton(edit);
		cf.setColor(edit, 3, 14, true);
		tb=new JTable();
		cf.setColor(tb, 0, 8, true);
		//tb.setEnabled(false);
		d=Toolkit.getDefaultToolkit().getScreenSize();
		tb.setPreferredScrollableViewportSize(new Dimension(d.width-50, 250));
		//tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JTableHeader th=tb.getTableHeader();
		
		th.setBackground(new Color(105,105,105));
		th.setForeground(Color.white);
		th.setFont(new Font("Bradley Hand ITC",Font.BOLD+Font.ITALIC,14));
		dt=new DefaultTableModel(cheader,0);
		
		showTable();
		
		
		tb.getColumnModel().getColumn(0).setMaxWidth(100);
		tb.getColumnModel().getColumn(1).setMaxWidth(300);
		tb.getColumnModel().getColumn(2).setMaxWidth(200);
		tb.getColumnModel().getColumn(3).setMaxWidth(140);
		tb.getColumnModel().getColumn(4).setMaxWidth(280);
		tb.getColumnModel().getColumn(5).setMaxWidth(250);
		tb.getColumnModel().getColumn(6).setMaxWidth(200);
		tb.getColumnModel().getColumn(7).setMaxWidth(150);
		tb.getColumnModel().getColumn(8).setMaxWidth(150);
		tb.getColumnModel().getColumn(9).setMaxWidth(100);
		tb.getColumnModel().getColumn(10).setMaxWidth(100);
		
		
		tablePanel=new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setLayout(new GridBagLayout());
		
		cf.setColor(tb, 3, 14, false);
		
		
		JScrollPane js=new JScrollPane(tb);
		
		
		
		
		
		
		
		cf.addBag(dataPanel, id, c, 20, 0, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eid, c, 0, 0, 2, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wid, c, 10, 5, 2, 1, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, name, c, 20, 0, 0, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, ename, c, 0, 0, 2, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 3, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, parent, c, 20, 0, 4, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 5, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eparent, c, 0, 0, 6, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wname, c, 10, 5, 2, 3, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, wparent, c, 10, 5, 6, 3, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, dob, c, 20, 0, 0, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, edob, c, 0, 0, 2, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 3, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, adate, c, 20, 0, 4, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 5, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eadate, c, 0, 0, 6, 4, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wdob, c, 10, 5, 2, 5, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, wadate, c, 10, 5, 6, 5, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, address, c, 20, 0, 0, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, eaddress, c, 0, 0, 2, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 3, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, mobile, c, 20, 0, 4, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 5, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, emobile, c, 0, 0, 6, 6, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, waddress, c, 10, 5, 2, 7, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, wmobile, c, 10, 5, 6, 7, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, ssamagraid, c, 20, 0, 0, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, essamagraid, c, 0, 0, 2, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 3, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, fsamagraid, c, 20, 0, 4, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 5, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, efsamagraid, c, 0, 0, 6, 8, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wssamagraid, c, 10, 5, 2, 9, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, wfsamagraid, c, 10, 5, 6, 9, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, photo, c, 20, 0, 0, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 1, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, ephoto, c, 0, 0, 2, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 3, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, sclass, c, 20, 0, 4, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel,new JSeparator(JSeparator.VERTICAL), c, 40, 0, 5, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(dataPanel, esclass, c, 0, 0, 6, 10, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, wsclass, c, 10, 5, 6, 11, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, showimg, c, 10, 5, 2, 12, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(dataPanel, buttonPanel, c, 0, 0, 6, 12, 0, 0, GridBagConstraints.FIRST_LINE_START);
		
		cf.addBag(tablePanel,js, c, 0, 0, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
		cf.addBag(tablePanel,edit, c, 0, 10, 0, 1, 0, 0, GridBagConstraints.CENTER);

		

		cf.addBag(this, tablePanel, c, 0, 70, 0, 2, 0, 0, GridBagConstraints.FIRST_LINE_START);

		
		//this panel
		cf.addBag(this, titlePanel, c, 0, 0, 0, 0, 0, 0, GridBagConstraints.NORTH);
		cf.addBag(this, dataPanel, c, 0, 50, 0, 1, 0, 0, GridBagConstraints.NORTH);
		
		ename.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(ename.getText().equals("")) {
					wname.setText("can't be empty");;
				}else {
					wname.setText(" ");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		eparent.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(eparent.getText().equals("")) {
					wparent.setText("can't be empty");;
				}else {
					wparent.setText(" ");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		edob.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(edob.getText().equals("")) {
					wdob.setText("can't be empty");;
				}else {
					wdob.setText(" ");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		eadate.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
				date=LocalDateTime.now();
				eadate.setText(dtf.format(date));
			}
		});
		eaddress.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(eaddress.getText().equals("")) {
					waddress.setText("can't be empty");;
				}else {
					waddress.setText(" ");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		emobile.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(emobile.getText().equals("")) {
					wmobile.setText("can't be empty");;
				}else {
					wmobile.setText(" ");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});


		essamagraid.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String g=essamagraid.getText();
				int a=g.length();
				if(a!=9) {
					wssamagraid.setText("should contain 9 digits");
				}
				else {
					wssamagraid.setText(" ");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		efsamagraid.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String g=efsamagraid.getText();
				int a=g.length();
				if(a!=9) {
					wfsamagraid.setText("should contain 9 digits");
				}
				else {
					wfsamagraid.setText(" ");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		ephoto.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				JFileChooser j=new JFileChooser();
				int r=j.showOpenDialog(null);
				if(r==JFileChooser.APPROVE_OPTION) {
					file=new File(j.getSelectedFile().getAbsolutePath());
					String file1=file.getName();
					int l=file1.lastIndexOf(".");
					if(l==-1)
						JOptionPane.showMessageDialog(null, "choose any image");
					String exe=file1.substring(l);
					if(exe.equals(".jpeg") ||exe.equals(".jpg")) {
						ephoto.setText(j.getSelectedFile().getAbsolutePath());
					}else {
						JOptionPane.showMessageDialog(null, "pleas choose any image with jpeg and jpg extention");
					}
				}
				ephoto.setFocusable(false);
				ephoto.setFocusable(true);
				
				file2=new File("D:\\backup\\schoolManagement\\schoolManagement\\studentimages\\"+eid.getText()+".jpg");
				try {
					copyFile(file, file2);
					ephoto.setText(file2.getPath());
					img=new ImageIcon("D:\\backup\\schoolManagement\\schoolManagement\\studentimages\\"+eid.getText()+".jpg");
					Image image=img.getImage().getScaledInstance(120, 150, java.awt.Image.SCALE_SMOOTH);
					img=new ImageIcon(image);
					showimg.setIcon(img);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ename.setText("");
				eparent.setText("");
				edob.setText("");
				eadate.setText("");
				eaddress.setText("");
				emobile.setText("");
				essamagraid.setText("");
				efsamagraid.setText("");
				ephoto.setText("");
				esclass.setSelectedIndex(0);
				img=new ImageIcon("images/student.png");
				showimg.setIcon(img);	
			}
		});
		tb.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				edit.setVisible(true);
				
			}
		});
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				edit.setVisible(false);
				dataPanel.setVisible(true);
				int a=tb.getSelectedRow();
				
				String dv = null;
				try {
					String datev=dt.getValueAt(a, 3).toString();
					java.util.Date date1v=new SimpleDateFormat("yyyy-MM-dd").parse(datev);
					SimpleDateFormat sdfv=new SimpleDateFormat("yyyy-MM-dd");
					dv=sdfv.format(date1v);	
				}catch(Exception ex) {}
				

				System.out.println(a);
					eid.setText(dt.getValueAt(a, 0).toString());
					ename.setText(dt.getValueAt(a, 1).toString());
					eparent.setText(dt.getValueAt(a, 2).toString());
					edob.setText(dv);
					eadate.setText(dt.getValueAt(a, 4).toString());
					eaddress.setText(dt.getValueAt(a, 5).toString());
					emobile.setText(dt.getValueAt(a, 6).toString());
					essamagraid.setText(dt.getValueAt(a, 7).toString());
					efsamagraid.setText(dt.getValueAt(a, 8).toString());
					ephoto.setText(imgpath.get(a));
					
					
					img=new ImageIcon(imgpath.get(a));
					Image image=img.getImage().getScaledInstance(120, 150, java.awt.Image.SCALE_SMOOTH);
					img=new ImageIcon(image);
					showimg.setIcon(img);
					
					
				}
		});

	}
	private static void copyFile(File sourceFile, File destFile) throws IOException {
	    if (!sourceFile.exists()) {
	        return;
	    }
	    if (!destFile.exists()) {
	        destFile.createNewFile();
	    }
	    FileChannel source = null;
	    FileChannel destination = null;
	    source = new FileInputStream(sourceFile).getChannel();
	    destination = new FileOutputStream(destFile).getChannel();
	    if (destination != null && source != null) {
	        destination.transferFrom(source, 0, source.size());
	    }
	    if (source != null) {
	        source.close();
	    }
	    if (destination != null) {
	        destination.close();
	    }

	}
	void showTable() {

		try {
			DBConnect x=new DBConnect();
			String sql="select * from studenttable";
			rs=x.QueryReturner(sql);
		
		
		
		while(rs.next()) {
			dt.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(11),rs.getString(12)});
			imgpath.add(rs.getString(10));
		}		
		}catch(Exception ex) {
			System.out.println(ex);
		}
	
		tb.setModel(dt);
				
	}

}
