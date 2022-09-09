package Donor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBaseConnectivity.DatabaseConnection;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddDonor extends JFrame implements ActionListener ,ItemListener,WindowListener{

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textemail;
	private JTextField textphone;
	private JTextField textage;
	JButton btnadd;
	JRadioButton rdbloodmale;
	JRadioButton rdbloodfemale;
	JTextArea textaddress;
	JComboBox combloodgroup;
	
	Connection con;
	
	private final ButtonGroup gender = new ButtonGroup();
	private JLabel lblNewLabel_1_4_1_2;
	private JTextField textbags;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDonor frame = new AddDonor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	void fillcombo() {
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			String strsql="select BloodGroup from bloodtype";
			ps=con.prepareStatement(strsql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String type=rs.getString("BloodGroup");
				combloodgroup.addItem(type);//addItem is function of Jcombo box
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	
	public AddDonor() {
		con=DatabaseConnection.createConnection();
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Add Donor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Person Details");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 27));
		lblNewLabel.setBounds(161, 21, 176, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1.setBounds(82, 90, 142, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(82, 132, 142, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number");
		lblNewLabel_1_2.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(82, 175, 142, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Age");
		lblNewLabel_1_3.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(82, 207, 142, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(82, 253, 142, 22);
		contentPane.add(lblNewLabel_1_4);
		
		textaddress = new JTextArea();
		textaddress.setBounds(300, 255, 142, 47);
		contentPane.add(textaddress);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Gender");
		lblNewLabel_1_4_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(82, 317, 142, 22);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Blood Group");
		lblNewLabel_1_4_1_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_4_1_1.setBounds(82, 362, 142, 22);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		btnadd = new JButton("Add");
		btnadd.addActionListener(this);
		btnadd.setFont(new Font("Serif", Font.BOLD, 27));
		btnadd.setBounds(224, 459, 155, 47);
		contentPane.add(btnadd);
		
		textname = new JTextField();
		textname.setBounds(300, 93, 142, 24);
		contentPane.add(textname);
		textname.setColumns(10);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(300, 132, 142, 22);
		contentPane.add(textemail);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(300, 173, 142, 24);
		contentPane.add(textphone);
		
		textage = new JTextField();
		textage.setColumns(10);
		textage.setBounds(300, 210, 142, 24);
		contentPane.add(textage);
		
		rdbloodmale = new JRadioButton("Male");
		gender.add(rdbloodmale);
		rdbloodmale.setFont(new Font("Serif", Font.BOLD, 16));
		rdbloodmale.setBounds(300, 321, 59, 21);
		contentPane.add(rdbloodmale);
		
		rdbloodfemale = new JRadioButton("Female");
		gender.add(rdbloodfemale);
		rdbloodfemale.setFont(new Font("Serif", Font.BOLD, 16));
		rdbloodfemale.setBounds(371, 321, 81, 21);
		contentPane.add(rdbloodfemale);
		
		combloodgroup = new JComboBox();
		combloodgroup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		combloodgroup.setModel(new DefaultComboBoxModel(new String[] {"Select Blood Group"}));
		combloodgroup.setBounds(300, 362, 142, 21);
		fillcombo();
		contentPane.add(combloodgroup);
		
		lblNewLabel_1_4_1_2 = new JLabel("No Of Bags");
		lblNewLabel_1_4_1_2.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_4_1_2.setBounds(82, 406, 142, 22);
		contentPane.add(lblNewLabel_1_4_1_2);
		
		textbags = new JTextField();
		textbags.setColumns(10);
		textbags.setBounds(300, 404, 142, 24);
		contentPane.add(textbags);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=textname.getText();
		String email=textemail.getText();
		String phone=textphone.getText();
		String age=textage.getText();
		String type="Donor";
		String bag=textbags.getText();
		
		String bloodgroup=(String)combloodgroup.getSelectedItem();
		
		String address=textaddress.getText();
		
		String gender_type=" ";
		if(rdbloodmale.isSelected()) {
			gender_type=rdbloodmale.getText();
		}
		
		if(rdbloodfemale.isSelected()) {
			gender_type=rdbloodfemale.getText();
		}
		
		
		java.util.Date d=new java.util.Date();
		long dt=d.getTime();
		java.sql.Date sd=new java.sql.Date(dt);
		
		if(name.isEmpty() ||email.isEmpty() ||phone.isEmpty() ||age.isEmpty() || bloodgroup.isEmpty() || address.isEmpty() || bag.isEmpty() || gender_type.equalsIgnoreCase(" ")) {
			JOptionPane.showMessageDialog(this, "field can not be empty");
		}
		else 
		{
		PreparedStatement ps=null,ps1=null;
		try {
			
			String strsql="insert into blooddonorandrecevier (name, email, phonenumber, age, address, gender, bloodgroup, type) values(?,?,?,?,?,?,?,?)";
			
			String str="insert into blooddonatedetails  (phoneno, date, NoOfBags, BloodGroup) values(?,?,?,?)";
			
			ps=con.prepareStatement(strsql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			int a=Integer.parseInt(age);
			ps.setInt(4, a);
			ps.setString(5, address);
			ps.setString(6, gender_type);
			ps.setString(7, bloodgroup);
			ps.setString(8, type);
			
			// for str into Blood Donate Request Table
			ps1=con.prepareStatement(str);
			ps1.setString(1, phone);
			ps1.setDate(2, sd);
			int b=Integer.parseInt(bag);
			ps1.setInt(3, b);
			ps1.setString(4, bloodgroup);
			
			
			int sts=ps.executeUpdate();
			int stat1=ps1.executeUpdate();
			if(sts>0 && stat1>0) {
				
				JOptionPane.showMessageDialog(this, "Donor Data add successfully");
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(ps1!=null) {
					ps1.close();
				}
			}
			catch (SQLException se) {
				// TODO: handle exception
				se.printStackTrace();
			}
		}
		
		
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		DatabaseConnection.closeConnecttion();
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
