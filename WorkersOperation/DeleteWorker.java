package WorkersOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBaseConnectivity.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Color;
import DataBaseConnectivity.DatabaseConnection;
import java.awt.Toolkit;

public class DeleteWorker extends JFrame implements ActionListener, WindowListener{

	private JPanel contentPane;
	private JTextField worktxt;
	private JButton btndelete;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteWorker frame = new DeleteWorker();
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
	public DeleteWorker() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteWorker.class.getResource("/ImagesBlood/delete.png")));
		con=DatabaseConnection.createConnection();
		setTitle("Delete Worker");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Worker ID");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel.setBounds(115, 154, 164, 24);
		contentPane.add(lblNewLabel);
		
		worktxt = new JTextField();
		worktxt.setBounds(333, 154, 215, 24);
		contentPane.add(worktxt);
		worktxt.setColumns(10);
		
		btndelete = new JButton("Delete");
		btndelete.addActionListener(this);
		btndelete.setBackground(new Color(192, 192, 192));
		btndelete.setFont(new Font("Serif", Font.BOLD, 22));
		btndelete.setBounds(239, 262, 133, 36);
		contentPane.add(btndelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String workerid=worktxt.getText();
		if(workerid.isEmpty()) {
			JOptionPane.showMessageDialog(this, "field can not be empty");
		}
		else {
			int choice=JOptionPane.showConfirmDialog(this, "Are you sure want to delete ?");
			PreparedStatement ps=null;
			if(choice==0) {
				String strsql="delete from workerdetails where WorkerID=?";
				try {
					ps=con.prepareStatement(strsql);
					ps.setString(1, workerid);
					
					int ststus=ps.executeUpdate();
					
					if(ststus>0) {
						JOptionPane.showMessageDialog(this, "Delete Successfully");
						worktxt.setText("");
					}
					else {
						JOptionPane.showMessageDialog(this, "Worker id does not exit");
						worktxt.setText("");
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
