package Pack;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import java.awt.Label;
import javax.swing.table.DefaultTableModel;
public class FenEole {

	private JFrame frmRgate;
	private JTextField txtNom;
	private JTextField txtClasse;
	private JTextField txtRating;
	private JTextField txtSkipper;
	JComboBox<String> cbbBateau;
	private JTable tblParticipants;
	private JTextField textField;
	private ArrayList<Participant> participants;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenEole window = new FenEole();
					window.frmRgate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenEole() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		participants = new ArrayList<Participant>();
		
		frmRgate = new JFrame();
		frmRgate.setTitle("R\u00E9gate");
		frmRgate.setBounds(100, 100, 537, 554);
		frmRgate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRgate.getContentPane().setLayout(null);
		
		JLabel lblParticipants = new JLabel("PARTICIPANTS");
		lblParticipants.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipants.setBounds(50, 11, 108, 23);
		frmRgate.getContentPane().add(lblParticipants);
		
		txtNom = new JTextField();
		txtNom.setBounds(10, 62, 86, 20);
		frmRgate.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtClasse = new JTextField();
		txtClasse.setBounds(106, 62, 86, 20);
		frmRgate.getContentPane().add(txtClasse);
		txtClasse.setColumns(10);
		
		txtRating = new JTextField();
		txtRating.setBounds(205, 62, 86, 20);
		frmRgate.getContentPane().add(txtRating);
		txtRating.setColumns(10);
		
		txtSkipper = new JTextField();
		txtSkipper.setBounds(301, 62, 86, 20);
		frmRgate.getContentPane().add(txtSkipper);
		txtSkipper.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterParticipant(txtNom.getText(), Integer.parseInt(txtClasse.getText()), Integer.parseInt(txtRating.getText()), txtSkipper.getText());
			}
		});
		btnAjouter.setBounds(397, 61, 89, 23);
		frmRgate.getContentPane().add(btnAjouter);
		
		tblParticipants = new JTable();
		tblParticipants.setBounds(10, 93, 476, 215);
		frmRgate.getContentPane().add(tblParticipants);
		cbbBateau = new JComboBox<String>();
		cbbBateau.setBounds(10, 333, 190, 23);
		frmRgate.getContentPane().add(cbbBateau);
		
		JButton btnArrive = new JButton("Ligne d'arrivee");
		btnArrive.setBounds(224, 333, 135, 23);
		frmRgate.getContentPane().add(btnArrive);
		
		JButton btnAbandon = new JButton("Abandon");
		btnAbandon.setBounds(369, 333, 103, 23);
		frmRgate.getContentPane().add(btnAbandon);
		
		JLabel lblDistance = new JLabel("Distance en km : ");
		lblDistance.setBounds(10, 378, 109, 14);
		frmRgate.getContentPane().add(lblDistance);
		
		JLabel lblTemps = new JLabel("Temps :");
		lblTemps.setBounds(224, 378, 135, 14);
		frmRgate.getContentPane().add(lblTemps);
		
		JButton btnTimer = new JButton("Start");
		btnTimer.setBounds(369, 374, 103, 23);
		frmRgate.getContentPane().add(btnTimer);
		
		Label lblClassement = new Label("CLASSEMENT :");
		lblClassement.setBounds(50, 415, 86, 22);
		frmRgate.getContentPane().add(lblClassement);
		
		JComboBox<String> cbbClasse = new JComboBox<String>();
		cbbClasse.setBounds(10, 454, 190, 20);
		frmRgate.getContentPane().add(cbbClasse);
		
		textField = new JTextField();
		textField.setBounds(95, 375, 63, 20);
		frmRgate.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmRgate.dispose();
			}
		});
		btnQuitter.setBounds(378, 482, 108, 23);
		frmRgate.getContentPane().add(btnQuitter);
		
		JLabel lblVoilier = new JLabel("Voilier");
		lblVoilier.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoilier.setBounds(10, 37, 86, 23);
		frmRgate.getContentPane().add(lblVoilier);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasse.setBounds(106, 37, 86, 23);
		frmRgate.getContentPane().add(lblClasse);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setHorizontalAlignment(SwingConstants.CENTER);
		lblRating.setBounds(205, 37, 86, 23);
		frmRgate.getContentPane().add(lblRating);
		
		JLabel lblSkipper = new JLabel("Skipper");
		lblSkipper.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkipper.setBounds(301, 37, 86, 23);
		frmRgate.getContentPane().add(lblSkipper);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setBounds(237, 453, 103, 23);
		frmRgate.getContentPane().add(btnAfficher);
		
		Chronometre c = new Chronometre();
		c.tacheTimer= new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				c.setSeconde(c.getSeconde()+1);
				if(c.getSeconde()==60) {
					c.setSeconde(0);
					c.setMinute(c.getMinute()+1);
				}
				if(c.getMinute()==60) {
					c.setMinute(0);
					c.setHeure(c.getHeure()+1);
				}
				String temps= "Temps : ";
				if(c.getHeure()<10){
					temps+="0";
				}
				temps+=c.getHeure()+":";
				if(c.getMinute()<10){
					temps+="0";
				}
				temps+=c.getMinute()+":";
				if(c.getSeconde()<10){
					temps+="0";
				}
				temps+=c.getSeconde();
				lblTemps.setText(temps);
			}
		};
		c.timer1 = new Timer(c.getDelais(),c.getTacheTimer());
		
		btnTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texte;
				texte=btnTimer.getText();
				
				if(texte.compareTo("Start")==0) {
					btnTimer.setText("Stop");
					c.timer1.start();
				}
				else if(texte.compareTo("Stop")==0) {
					
					btnTimer.setText("Start");
					c.timer1.stop();
				}
			}
		});

	}
	public void ajouterParticipant(String nom, int classe, int rating, String skipper) {
		this.participants.add(new Participant(nom, classe, rating, skipper));
		cbbBateau.addItem(nom);
		/*
		cbbBateau.set
		cbbBateau.cbbBateau.getItemCount()-1;
		*/
	}
	public int chercherParticipant(String nom)
	{
		int res=-1;
		for(int i =0;i<participants.size()&&res==-1;i++){
			if(participants.get(i).getNom().equals(nom)){
				res=i;
			}
		}
		return (res);
	}
}