package Pack;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FenEole {

	private JFrame frame;
	private JTextField txtNom;
	private JTextField txtClasse;
	private JTextField txtRating;
	private JTextField txtSkipper;
	private JTable tblParticipants;
	private JTable tblClassement;
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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 983, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblParticipants = new JLabel("PARTICIPANTS");
		lblParticipants.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipants.setBounds(205, 11, 108, 23);
		frame.getContentPane().add(lblParticipants);
		
		txtNom = new JTextField();
		txtNom.setText("Voilier");
		txtNom.setToolTipText("");
		txtNom.setBounds(10, 62, 86, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtClasse = new JTextField();
		txtClasse.setText("3");
		txtClasse.setBounds(106, 62, 86, 20);
		frame.getContentPane().add(txtClasse);
		txtClasse.setColumns(10);
		
		txtRating = new JTextField();
		txtRating.setText("7");
		txtRating.setBounds(205, 62, 86, 20);
		frame.getContentPane().add(txtRating);
		txtRating.setColumns(10);
		
		txtSkipper = new JTextField();
		txtSkipper.setText("Skipper");
		txtSkipper.setBounds(301, 62, 86, 20);
		frame.getContentPane().add(txtSkipper);
		txtSkipper.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(397, 61, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		tblParticipants = new JTable();
		tblParticipants.setBounds(10, 93, 476, 215);
		frame.getContentPane().add(tblParticipants);
		
		JComboBox cbbBateau = new JComboBox();
		cbbBateau.setBounds(10, 323, 190, 23);
		frame.getContentPane().add(cbbBateau);
		
		JButton btnArrive = new JButton("Ligne d'arriv\u00E9e");
		btnArrive.setBounds(224, 323, 135, 23);
		frame.getContentPane().add(btnArrive);
		
		JButton btnAbandon = new JButton("Abandon");
		btnAbandon.setBounds(369, 323, 103, 23);
		frame.getContentPane().add(btnAbandon);
		
		JLabel lblDistance = new JLabel("Distance en km : ");
		lblDistance.setBounds(10, 368, 109, 14);
		frame.getContentPane().add(lblDistance);
		
		JLabel lblTemps = new JLabel("Temps :");
		lblTemps.setBounds(251, 368, 108, 14);
		frame.getContentPane().add(lblTemps);
		
		JButton btnTimer = new JButton("Start");
		btnTimer.setBounds(369, 364, 103, 23);
		frame.getContentPane().add(btnTimer);
		
		Label lblClassement = new Label("CLASSEMENT :");
		lblClassement.setBounds(689, 11, 86, 22);
		frame.getContentPane().add(lblClassement);
		
		JComboBox cbbClasse = new JComboBox();
		cbbClasse.setBounds(524, 62, 190, 20);
		frame.getContentPane().add(cbbClasse);
		
		tblClassement = new JTable();
		tblClassement.setBounds(524, 93, 432, 215);
		frame.getContentPane().add(tblClassement);
		
		textField = new JTextField();
		textField.setBounds(129, 365, 63, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(848, 367, 108, 23);
		frame.getContentPane().add(btnQuitter);
		
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
}
