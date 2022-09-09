package Donor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBaseConnectivity.DatabaseConnection;
import bloodMainPage.LogInBlood;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;

public class DeleteDonor extends JFrame implements ActionListener,WindowListener{

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textphone;
	JButton btndelete;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDonor frame = new DeleteDonor();
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
	public DeleteDonor() {
		con=DatabaseConnection.createConnection();
		//this.addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteDonor.class.getResource("/ImagesBlood/delete.png")));
		setTitle("Delete Donor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Donor");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 23));
		lblNewLabel.setBounds(161, 23, 146, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Donor Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(71, 99, 137, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Donor Phonr No.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(71, 153, 165, 23);
		contentPane.add(lblNewLabel_1_1);
		
		textname = new JTextField();
		textname.setBounds(288, 99, 157, 28);
		contentPane.add(textname);
		textname.setColumns(10);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(288, 148, 157, 28);
		contentPane.add(textphone);
		
		btndelete = new JButton("Delete");
		btndelete.addActionListener(this);
		btndelete.setBounds(170, 246, 137, 37);
		contentPane.add(btndelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=textname.getText();
		String phone=textphone.getText();
		String donor="Donor";
		
		if(name.isEmpty() || phone.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Fields Can not be Empty");
		}
		else {
			int choice=JOptionPane.showConfirmDialog(this, "Are sure to delete");
			PreparedStatement ps=null;
			if(choice==0) 
			{
				String strsql="delete from blooddonorandrecevier where type=? AND phonenumber=?";
			try {
				ps=con.prepareStatement(strsql);
				ps.setString(1, donor);
				ps.setString(2, phone);
				
				int status=ps.executeUpdate();
				if(status>0) {
					JOptionPane.showMessageDialog(this, "Delete Successfully");
					textname.setText("");
					textphone.setText("");
				}
				else {
					JOptionPane.showMessageDialog(this, "This data doe not exit");
					textname.setText("");
					textphone.setText("");
				}
				
			}catch(SQLException se) {
				se.printStackTrace();
			}
			finally {
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
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		DatabaseConnection.closeConnecttion();
//		LogInBlood log=new LogInBlood();
//		log.setVisible(true);
		
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
