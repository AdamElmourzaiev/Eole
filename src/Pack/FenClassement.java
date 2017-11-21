package Pack;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class FenClassement {

	private JFrame frmClassement;
	private JTable tabClassement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenClassement window = new FenClassement();
					window.frmClassement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenClassement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClassement = new JFrame();
		frmClassement.setTitle("Classement");
		frmClassement.setBounds(100, 100, 543, 336);
		frmClassement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClassement.getContentPane().setLayout(null);
		
		JLabel lblClassement = new JLabel("CLASSEMENT");
		lblClassement.setBounds(223, 11, 143, 23);
		frmClassement.getContentPane().add(lblClassement);
		
		tabClassement = new JTable();
		tabClassement.setBounds(27, 45, 476, 202);
		frmClassement.getContentPane().add(tabClassement);
		
		JButton btnQuit = new JButton("Quitter");
		
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmClassement.dispose();
			}
		});
		btnQuit.setBounds(395, 258, 108, 23);
		frmClassement.getContentPane().add(btnQuit);
	}
}
