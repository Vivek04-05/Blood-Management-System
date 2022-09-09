package WorkersOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBaseConnectivity.DatabaseConnection;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class UpdateWorker extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textid;
	private JTextField textphone;
	private JTextArea textaddress;
	private JButton btnupdate;
	
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateWorker frame = new UpdateWorker();
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
	public UpdateWorker() {
		con=DatabaseConnection.createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateWorker.class.getResource("/ImagesBlood/system-update (1).png")));
		setTitle("Update");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Worker ID");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel.setBounds(93, 59, 164, 24);
		contentPane.add(lblNewLabel);
		
		textid = new JTextField();
		textid.setBounds(301, 59, 152, 24);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number");
		lblNewLabel_1_2.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(93, 128, 164, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(93, 199, 164, 24);
		contentPane.add(lblNewLabel_1_3);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(301, 132, 152, 24);
		contentPane.add(textphone);
		
		textaddress = new JTextArea();
		textaddress.setBounds(301, 202, 152, 63);
		contentPane.add(textaddress);
		
		btnupdate = new JButton("Update");
		btnupdate.addActionListener(this);
		btnupdate.setFont(new Font("Serif", Font.BOLD, 22));
		btnupdate.setBounds(167, 318, 140, 42);
		contentPane.add(btnupdate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=textid.getText();
		String phone=textphone.getText();
		String address=textaddress.getText();
		
		if(id.isEmpty() || phone.isEmpty() || address.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Field can not be Empty");
		}
		else
		{
			String strsql="update workerdetails set PhoneNumber=? , Address=? where WorkerID=?";
			PreparedStatement ps=null;
			try {
				ps=con.prepareStatement(strsql);
				ps.setString(1, phone);
				ps.setString(2, address);
				ps.setString(3, id);
				
				int status=ps.executeUpdate();
				if(status>0) {
					JOptionPane.showMessageDialog(this, "Update Sucessfully");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Worker ID does not exsit");
				}
				
			}
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
			finally {
				try {
					if(ps!=null)
					{
						ps.close();
					}
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			}
		}
		
	}
}
