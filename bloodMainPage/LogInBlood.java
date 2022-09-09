package bloodMainPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBaseConnectivity.DatabaseConnection;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class LogInBlood extends JFrame implements ActionListener,WindowListener{

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField passtxt;
	JButton btnsubmit;
	JRadioButton rdemployee;
	JRadioButton rdadmin;
	
	Connection con;
	
	private final ButtonGroup chosseuser = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInBlood frame = new LogInBlood();
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
	public LogInBlood() {
		con=DatabaseConnection.createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInBlood.class.getResource("/ImagesBlood/log-in.png")));
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel frontimg = new JLabel(" ");
		frontimg.setBackground(new Color(153, 0, 204));
		frontimg.setBounds(0, 222, 548, 212);
		ImageIcon icom= new ImageIcon(LogInBlood.class.getResource("/ImagesBlood/Blood Background.jpg"));
		Image img=icom.getImage().getScaledInstance(548, 401, Image.SCALE_DEFAULT);
		ImageIcon icon=new ImageIcon(img);
		contentPane.setLayout(null);
		
		JLabel logtxt = new JLabel("Log In");
		logtxt.setForeground(new Color(0, 0, 0));
		logtxt.setBackground(new Color(255, 51, 102));
		logtxt.setFont(new Font("Serif", Font.BOLD, 28));
		logtxt.setBounds(213, 0, 104, 31);
		contentPane.add(logtxt);
		
		btnsubmit = new JButton("SUBMIT");
		btnsubmit.addActionListener(this);
		btnsubmit.setBackground(new Color(204, 204, 204));
		btnsubmit.setForeground(new Color(0, 0, 0));
		btnsubmit.setFont(new Font("Serif", Font.BOLD, 16));
		
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnsubmit.setBounds(187, 224, 104, 31);
		contentPane.add(btnsubmit);
		
		passtxt = new JPasswordField();
		passtxt.setEchoChar('*');
		passtxt.setBounds(258, 163, 162, 31);
		contentPane.add(passtxt);
		
		JLabel lblNewLabel_1 = new JLabel("Passward");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1.setBounds(91, 170, 122, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setBackground(new Color(153, 204, 0));
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel.setBounds(91, 109, 132, 31);
		contentPane.add(lblNewLabel);
		
		userid = new JTextField();
		userid.setBounds(258, 109, 159, 31);
		contentPane.add(userid);
		userid.setColumns(10);
		frontimg.setIcon(icon);
		contentPane.add(frontimg);
		
		rdadmin = new JRadioButton("Admin");
		chosseuser.add(rdadmin);
		rdadmin.setFont(new Font("Serif", Font.BOLD, 18));
		rdadmin.setBounds(273, 66, 103, 21);
		contentPane.add(rdadmin);
		
		rdemployee = new JRadioButton("Employee");
		chosseuser.add(rdemployee);
		rdemployee.setFont(new Font("Serif", Font.BOLD, 18));
		rdemployee.setBounds(378, 66, 103, 21);
		contentPane.add(rdemployee);
		
		JLabel lblNewLabel_1_1 = new JLabel("Select User Type");
		lblNewLabel_1_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(91, 64, 158, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setBounds(0, 0, 548, 214);
		ImageIcon ico=new ImageIcon(LogInBlood.class.getResource("/ImagesBlood/is-a-symbol-related-to-humanity-that-is-blood-donation-M9KF83.jpg"));
		Image img1=ico.getImage().getScaledInstance(548, 214, Image.SCALE_DEFAULT);
		ImageIcon icoo=new ImageIcon(img1);
		contentPane.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String status_suer=" ";
		if(rdadmin.isSelected()) {
			status_suer=rdadmin.getText();	
		}
		if(rdemployee.isSelected()) {
			status_suer=rdemployee.getText();
			
		}
		
		String user =userid.getText();
		char[] passward=passtxt.getPassword();
		String pass=String.valueOf(passward);
		
		if(user.isEmpty() || pass.isEmpty() || status_suer.equals(" ")) {
			JOptionPane.showMessageDialog(this, "Data Required");
		}
		else {
			
			
			if(status_suer.equalsIgnoreCase("Employee") ) {
				//code for Employee
				
				//String strtxt="select * from workerdetails where WorkerID=? AND Passward=?";
				
			}
			else if(status_suer.equalsIgnoreCase("Admin")) {
				//Code for owner 
				
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					String strtxt="select * from admindetails where AdminID=? AND Passward=?";
					ps=con.prepareStatement(strtxt);
					ps.setString(1, user);
					ps.setString(2, pass);
					rs=ps.executeQuery();
					
					if(rs.next()) {
						//Code for opening Owner/Admin Tab
						//JOptionPane.showConfirmDialog(this, "welcome Employee");
						Owner ow=new Owner();
						ow.setVisible(true);
						this.dispose();
						
						
					}
					else {
						JOptionPane.showMessageDialog(this, "Wrong  User ID or Passward");
					}
					
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				finally {
					try {
						if(ps!=null) {
							ps.close();
						}
						if(rs!=null) {
							rs.close();
						}
					}
					catch(SQLException se) {
						se.printStackTrace();
					}
				}
				
			}
			else {
				JOptionPane.showMessageDialog(this,"Inavlid/Wrong userID or Passward","Login Error",JOptionPane.ERROR_MESSAGE);
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
