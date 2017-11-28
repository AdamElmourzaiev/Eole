package Pack;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Toolkit;

public class FenClassement {
	private JFrame frame;
	private String nom;
	private ArrayList<Participant> participantsClassement;
	
	/**
	 * Create the application.
	 */
	public FenClassement(String nom) {
		super();
		this.setNom(nom);
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void run() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/Abdallah/git/Eole/Voilier.png"));
		frame.setVisible(true);
		frame.setTitle(nom);
		frame.setBounds(100, 100, 562, 378);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClassement = new JLabel("CLASSEMENT");
		lblClassement.setBounds(223, 11, 143, 23);
		frame.getContentPane().add(lblClassement);
		
		DefaultTableModel model;
		JTable tblClassement = new JTable(new DefaultTableModel());
		model = (DefaultTableModel) tblClassement.getModel();
		model.addColumn("Numéro");
		model.addColumn("Nom du voilier");
		model.addColumn("Rating");
		model.addColumn("Temps");
		model.addColumn("Temps compensé");
		JScrollPane pane = new JScrollPane(tblClassement);
		pane.setBounds(10, 41, 526, 253);
		int temps,tempsCompense;
		for(int i=0;i<participantsClassement.size();i++) {
			temps =(int) participantsClassement.get(i).getTemps().getSeconds();
			tempsCompense =(int) participantsClassement.get(i).getTempsCompense().getSeconds();
			model.addRow(new Object[]{i+1,participantsClassement.get(i).getNom(),participantsClassement.get(i).getRating(),Participant.formatTemps(temps/3600%60, temps/60%60, temps%60),Participant.formatTemps(tempsCompense/3600%60, tempsCompense/60%60, tempsCompense%60)});
		}
		
		frame.getContentPane().add(pane);
		
		JButton btnQuit = new JButton("Quitter");
		
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(409, 305, 108, 23);
		frame.getContentPane().add(btnQuit);
	}

	public ArrayList<Participant> getParticipantsClassement() {
		return participantsClassement;
	}

	public void setParticipantsClassement(ArrayList<Participant> participantsClassement) {
		this.participantsClassement = participantsClassement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}	

