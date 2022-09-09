package Donor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBaseConnectivity.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateDonor extends JFrame implements ActionListener,WindowListener{

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textphone;
	private JTextField textemail;
	private JTextField textaddress;
	JButton btnupdate;
	
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDonor frame = new UpdateDonor();
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
	public UpdateDonor() {
		setTitle("Update Donor");
		con=DatabaseConnection.createConnection();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Name");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel.setBounds(72, 53, 120, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterPhoneNo = new JLabel("Enter Phone No");
		lblEnterPhoneNo.setFont(new Font("Serif", Font.BOLD, 18));
		lblEnterPhoneNo.setBounds(72, 100, 130, 20);
		contentPane.add(lblEnterPhoneNo);
		
		textname = new JTextField();
		textname.setBounds(284, 41, 180, 35);
		contentPane.add(textname);
		textname.setColumns(10);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(284, 85, 180, 35);
		contentPane.add(textphone);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel_1.setBounds(72, 181, 120, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(72, 222, 120, 20);
		contentPane.add(lblNewLabel_1_1);
		
		textemail = new JTextField();
		textemail.setBounds(303, 168, 161, 27);
		contentPane.add(textemail);
		textemail.setColumns(10);
		
		textaddress = new JTextField();
		textaddress.setColumns(10);
		textaddress.setBounds(303, 221, 161, 27);
		contentPane.add(textaddress);
		
		btnupdate = new JButton("Update");
		btnupdate.addActionListener(this);
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnupdate.setFont(new Font("Serif", Font.BOLD, 21));
		btnupdate.setBounds(184, 314, 110, 35);
		contentPane.add(btnupdate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String namedo=textname.getText();
		String phonedo=textphone.getText();
		String emaildo=textemail.getText();
		String addressdo=textaddress.getText();
		String donor="Donor";
	
		
		if(namedo.isEmpty() || phonedo.isEmpty() || addressdo.isEmpty() || emaildo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Field Can not be Empty");
		}
		else {
			PreparedStatement ps=null;
			try {
				String Strsql="update blooddonorandrecevier set email=? ,address=? where type=? AND phonenumber=?";
				ps=con.prepareStatement(Strsql);
				ps.setString(1, emaildo);
				ps.setString(2, addressdo);
				ps.setString(3, donor);
				ps.setString(4, phonedo);
				int stat=ps.executeUpdate();
				if(stat>0) {
					JOptionPane.showMessageDialog(this, "Update Successfully");
					textname.setText("");;
					textphone.setText("");
					textaddress.setText("");
					textphone.setText("");
				}
				else {
					JOptionPane.showMessageDialog(this, "Data Does not exst");
				}
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				try {
					if(ps!=null) {
						ps.close();
					}
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
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
