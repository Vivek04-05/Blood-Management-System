package WorkersOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import DataBaseConnectivity.DatabaseConnection; //import the Class of Database connection

public class AddWorker extends JFrame implements ActionListener ,WindowListener {

	private JPanel contentPane;
	private JTextField workid;
	private JPasswordField workpass;
	private JTextField workname;
	private JTextField workphone;
	private JButton btnadd;
	private JTextArea workaddress;
	private JRadioButton rdfemale;
	private JRadioButton rdmale;
	private final ButtonGroup gender = new ButtonGroup();
	Connection con;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorker frame = new AddWorker();
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
	public AddWorker() {
		con=DatabaseConnection.createConnection(); // here we create the connetion of our code to the mysql Database
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddWorker.class.getResource("/ImagesBlood/Add Employee.png")));
		setTitle("Add Worker");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 789, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		workphone = new JTextField();
		workphone.setBounds(438, 200, 238, 32);
		contentPane.add(workphone);
		workphone.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("Gender");
		lblNewLabel_1_5.setForeground(Color.BLACK);
		lblNewLabel_1_5.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(218, 376, 106, 24);
		contentPane.add(lblNewLabel_1_5);
		
		rdfemale = new JRadioButton("Female");
		gender.add(rdfemale);
		rdfemale.setFont(new Font("Serif", Font.BOLD, 18));
		rdfemale.setBounds(571, 378, 90, 21);
		contentPane.add(rdfemale);
		
		rdmale = new JRadioButton("Male");
		gender.add(rdmale);
		
		rdmale.setFont(new Font("Serif", Font.BOLD, 18));
		rdmale.setBounds(442, 372, 77, 32);
		contentPane.add(rdmale);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(218, 254, 106, 24);
		contentPane.add(lblNewLabel_1_4);
		
		workaddress = new JTextArea();
		workaddress.setBounds(439, 257, 237, 83);
		contentPane.add(workaddress);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone Number");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(218, 208, 146, 24);
		contentPane.add(lblNewLabel_1_3);
		
		workname = new JTextField();
		workname.setBounds(438, 147, 241, 31);
		contentPane.add(workname);
		workname.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(218, 158, 106, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Passwrad");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(218, 105, 135, 24);
		contentPane.add(lblNewLabel_1_1);
		
		workpass = new JPasswordField();
		workpass.setBounds(438, 92, 240, 30);
		contentPane.add(workpass);
		
		workid = new JTextField();
		workid.setBounds(438, 47, 238, 30);
		contentPane.add(workid);
		workid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Worker ID");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1.setBounds(214, 53, 166, 24);
		contentPane.add(lblNewLabel_1);
		
		btnadd = new JButton("ADD");
		btnadd.addActionListener(this);
		btnadd.setBackground(new Color(153, 153, 204));
		btnadd.setFont(new Font("Serif", Font.BOLD, 22));
		btnadd.setBounds(297, 437, 173, 32);
		contentPane.add(btnadd);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBackground(new Color(204, 255, 255));
		lblNewLabel.setBounds(10, 10, 755, 472);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=workname.getText();
		String id=workid.getText();
		char[] pass=workpass.getPassword();
		String passward=String.valueOf(pass);
		String addre=workaddress.getText();
		String phone=workphone.getText();
		
		//take value form RADIO BUTTON 
		String gender_status=" ";
		if(rdfemale.isSelected())
		{
			gender_status=rdfemale.getText();
		}
		
		if(rdmale.isSelected())
		{
			gender_status=rdmale.getText();
		}
		
		//Code for checking the boxes are empty or not
		
		if(name.isEmpty() || id.isEmpty() || passward.isEmpty() || addre.isEmpty() || phone.isEmpty() || (gender_status.equalsIgnoreCase(" "))){
			JOptionPane.showMessageDialog(this, "Fields must be filled and selected");
		}
		else {
			
			PreparedStatement ps=null;
			try {
				// Note in Table the columns name has not space otherwise it show error
				String strsql="insert into workerdetails(WorkerID, Passward, Name, PhoneNumber, Address, Gender) values(?,?,?,?,?,?)";
				ps=con.prepareStatement(strsql);
				ps.setString(1, id);// position 1 is Worker ID in sql statement and id is our data 
				ps.setString(2, passward);
				ps.setString(3, name);
				ps.setString(4, phone);
				ps.setString(5, addre);
				ps.setString(6, gender_status);
				
				int status_sql=ps.executeUpdate();// it return it value 
				
				if(status_sql>0) 
				{
					JOptionPane.showMessageDialog(this, "Employee Data  Add Successfully");
					workname.setText(" ");
					workaddress.setText(" ");
					workid.setText(" ");
					workpass.setText(" ");
					workphone.setText(" ");
					
				}	
				}
			catch(SQLException se)
				{
				se.printStackTrace();
				}
			finally
			{
				try {
					if(ps!=null)
					{
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
		DatabaseConnection.closeConnecttion(); // cccode for closing the connection when user click on The close windoe the window 
		
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
