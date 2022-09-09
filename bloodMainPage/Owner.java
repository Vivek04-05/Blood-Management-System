package bloodMainPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.result.UpdatableResultSet;

import WorkersOperation.AddWorker;
import WorkersOperation.DeleteWorker;
import WorkersOperation.UpdateWorker;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Owner extends JFrame implements ActionListener ,WindowListener{

	private JPanel contentPane;
	JMenuItem mnadd,mndelete,mnupdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Owner frame = new Owner();
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
	public Owner() {
		this.addWindowListener(this);
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnWorker = new JMenu("Worker");
		menuBar.add(mnWorker);
		
		mnadd = new JMenuItem("Add Employee");
		mnadd.addActionListener(this);
		mnWorker.add(mnadd);
		
		mndelete = new JMenuItem("Delete Employee");
		mndelete.addActionListener(this);
		mnWorker.add(mndelete);
		
		mnupdate = new JMenuItem("Update Employee");
		mnupdate.addActionListener(this);
		mnWorker.add(mnupdate);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		
		switch(caption)
		{
		case "Add Employee":
			AddWorker addwo=new AddWorker();
			addwo.setVisible(true);
			break;
		
		case "Delete Employee":
			DeleteWorker wo=new DeleteWorker();
			wo.setVisible(true);
			break;
		
		case "Update Employee":
			UpdateWorker w=new UpdateWorker();
			w.setVisible(true);
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
		
		LogInBlood log=new LogInBlood();
		log.setVisible(true);
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
