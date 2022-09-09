package bloodMainPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBaseConnectivity.DatabaseConnection;
import Donor.AddDonor;
import Donor.DeleteDonor;
import Donor.UpdateDonor;
import Recevier.AddRecevier;
import Recevier.DeleteRecevier;
import Recevier.UpdateRecevier;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;

public class Worker extends JFrame implements ActionListener ,WindowListener{

	private JPanel contentPane;
	JMenuItem mnaddDonor;
	JMenuItem mndeldonor;
	JMenuItem mnupdonor;
	JMenuItem mnaddreceiver;
	JMenuItem mndelreceiver;
	JMenuItem mnupreceiver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Worker frame = new Worker();
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
	public Worker() {
		setTitle("Employee Frame");
		this.addWindowListener(this);// Must add window listener
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 456);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Donor");
		mnNewMenu.setBackground(new Color(250, 240, 230));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		mnaddDonor = new JMenuItem("Add Donor");
		mnaddDonor.addActionListener(this);
		mnaddDonor.setIcon(new ImageIcon(Worker.class.getResource("/ImagesBlood/Add Employee.png")));
		mnNewMenu.add(mnaddDonor);
		
		mndeldonor = new JMenuItem("Delete Donor");
		mndeldonor.addActionListener(this);
		mndeldonor.setIcon(new ImageIcon(Worker.class.getResource("/ImagesBlood/delete.png")));
		mnNewMenu.add(mndeldonor);
		
		mnupdonor = new JMenuItem("Update Donor");
		mnupdonor.addActionListener(this);
		mnNewMenu.add(mnupdonor);
		
		JMenu mnNewMenu_1 = new JMenu("Receiver");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		mnaddreceiver = new JMenuItem("Add Receiver");
		mnaddreceiver.addActionListener(this);
		mnaddreceiver.setIcon(new ImageIcon(Worker.class.getResource("/ImagesBlood/Add Employee.png")));
		mnNewMenu_1.add(mnaddreceiver);
		
		mndelreceiver = new JMenuItem("Delete Receiver");
		mndelreceiver.addActionListener(this);
		mndelreceiver.setIcon(new ImageIcon(Worker.class.getResource("/ImagesBlood/delete.png")));
		mnNewMenu_1.add(mndelreceiver);
		
		mnupreceiver = new JMenuItem("Update Receiver");
		mnupreceiver.addActionListener(this);
		mnNewMenu_1.add(mnupreceiver);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		
		switch(caption) {
		case "Add Donor":
			AddDonor ad=new AddDonor();
			ad.setVisible(true);
			break;
		case "Delete Donor":
			DeleteDonor deldo=new DeleteDonor();
			deldo.setVisible(true);
			break;
		case "Update Donor":
			UpdateDonor updo=new UpdateDonor();
			updo.setVisible(true);
			break;
		
		case "Add Receiver":
			AddRecevier ar=new AddRecevier();
			ar.setVisible(true);
			break;
			
		case "Delete Receiver":
			DeleteRecevier dr=new DeleteRecevier();
			dr.setVisible(true);
			break;
			
		case "Update Receiver":
			UpdateRecevier ur=new UpdateRecevier();
			ur.setVisible(true);
			break;
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		LogInBlood ab=new LogInBlood();
		ab.setVisible(true);
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
