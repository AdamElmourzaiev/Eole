package Pack;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
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
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
public class FenEole {
	
	private JFrame frame;
	private Chronometre c;
	private JTextField txtNom;
	private JTextField txtClasse;
	private JTextField txtRating;
	private JTextField txtSkipper;
	private JComboBox<String> cbbBateau;
	private JButton btnAjouter;
	private JButton btnArrive;
	private JButton btnAbandon;
	private JButton btnTimer;
	private JTable tblParticipants;
	private DefaultTableModel model;
	private JTextField txtKm;
	private ArrayList<Participant> participants;
	private ArrayList<Participant> participantsArrives;
	private ArrayList<Participant> participantsAbandon;
	
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
	public FenEole(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		participants = new ArrayList<Participant>();
		participantsArrives = new ArrayList<Participant>();
		participantsAbandon = new ArrayList<Participant>();
		
		frame = new JFrame();
		frame.setTitle("R\u00E9gate");
		frame.setBounds(100, 100, 537, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblParticipants = new JLabel("PARTICIPANTS");
		lblParticipants.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipants.setBounds(50, 11, 108, 23);
		frame.getContentPane().add(lblParticipants);
		
		txtNom = new JTextField();
		txtNom.setBounds(10, 62, 86, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtClasse = new JTextField();
		txtClasse.setBounds(106, 62, 86, 20);
		frame.getContentPane().add(txtClasse);
		txtClasse.setColumns(10);
		
		txtRating = new JTextField();
		txtRating.setBounds(205, 62, 86, 20);
		frame.getContentPane().add(txtRating);
		txtRating.setColumns(10);
		
		txtSkipper = new JTextField();
		txtSkipper.setBounds(301, 62, 86, 20);
		frame.getContentPane().add(txtSkipper);
		txtSkipper.setColumns(10);
		
		tblParticipants = new JTable(new DefaultTableModel());
		model = (DefaultTableModel) tblParticipants.getModel();
		model.addColumn("Nom");
		model.addColumn("Classe");
		model.addColumn("Rating");
		model.addColumn("Skipper");
		JScrollPane pane = new JScrollPane(tblParticipants);
		pane.setBounds(10, 93, 476, 229);
		frame.getContentPane().add(pane);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					verifException(Integer.parseInt(txtClasse.getText()));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (ClasseException e1) {
					JOptionPane.showMessageDialog(frame, e1.toString());
				}
			}
		});
		btnAjouter.setBounds(397, 61, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		cbbBateau = new JComboBox<String>();
		cbbBateau.setBounds(10, 333, 190, 23);
		frame.getContentPane().add(cbbBateau);
		
		btnArrive = new JButton("Ligne d'arrivee");
		btnArrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arriveeParticipant(chercherParticipant((String)cbbBateau.getSelectedItem()));
				cbbBateau.removeItemAt(cbbBateau.getSelectedIndex());
				if(cbbBateau.getItemCount()==0)
				{
					btnTimer.doClick();
				}
			}
		});
		btnArrive.setEnabled(false);
		btnArrive.setBounds(224, 333, 135, 23);
		frame.getContentPane().add(btnArrive);
		
		btnAbandon = new JButton("Abandon");
		btnAbandon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abandonParticipant(chercherParticipant((String)cbbBateau.getSelectedItem()));
				cbbBateau.removeItemAt(cbbBateau.getSelectedIndex());
				if(cbbBateau.getItemCount()==0)
				{
					btnTimer.doClick();
				}
			}
		});
		btnAbandon.setEnabled(false);
		btnAbandon.setBounds(369, 333, 103, 23);
		frame.getContentPane().add(btnAbandon);
		
		JLabel lblDistance = new JLabel("Distance en km : ");
		lblDistance.setBounds(10, 378, 109, 14);
		frame.getContentPane().add(lblDistance);
		
		JLabel lblTemps = new JLabel("Temps :");
		lblTemps.setBounds(224, 378, 135, 14);
		frame.getContentPane().add(lblTemps);
		
		btnTimer = new JButton("Start");
		btnTimer.setBounds(369, 374, 103, 23);
		frame.getContentPane().add(btnTimer);
		
		Label lblClassement = new Label("CLASSEMENT :");
		lblClassement.setAlignment(Label.CENTER);
		lblClassement.setBounds(50, 415, 86, 22);
		frame.getContentPane().add(lblClassement);
		
		JComboBox<String> cbbClasse = new JComboBox<String>();
		cbbClasse.setBounds(10, 454, 190, 20);
		frame.getContentPane().add(cbbClasse);
		
		txtKm = new JTextField();
		txtKm.setBounds(106, 375, 94, 20);
		frame.getContentPane().add(txtKm);
		txtKm.setColumns(10);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Participant p:participantsArrives)
				{
					System.out.println("\n"+p.getNom());
					System.out.println(p.getTemps().toMinutes());
					System.out.println(p.getTemps().toString());
					System.out.println(p.getTemps().getSeconds());
				}
				
				for(Participant p:participantsAbandon)
				{
					System.out.println("\n"+p.getNom());
					System.out.println(p.getTemps().toMinutes());
					System.out.println(p.getTemps().toString());
					System.out.println(p.getTemps().getSeconds());
				}
				frame.dispose();
			}
		});
		btnQuitter.setBounds(378, 482, 108, 23);
		frame.getContentPane().add(btnQuitter);
		
		JLabel lblVoilier = new JLabel("Voilier");
		lblVoilier.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoilier.setBounds(10, 37, 86, 23);
		frame.getContentPane().add(lblVoilier);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasse.setBounds(106, 37, 86, 23);
		frame.getContentPane().add(lblClasse);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setHorizontalAlignment(SwingConstants.CENTER);
		lblRating.setBounds(205, 37, 86, 23);
		frame.getContentPane().add(lblRating);
		
		JLabel lblSkipper = new JLabel("Skipper");
		lblSkipper.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkipper.setBounds(301, 37, 86, 23);
		frame.getContentPane().add(lblSkipper);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setEnabled(false);
		btnAfficher.setBounds(237, 453, 103, 23);
		frame.getContentPane().add(btnAfficher);
		
		c = new Chronometre();
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
					btnAjouter.setEnabled(false);
					btnArrive.setEnabled(true);
					btnAbandon.setEnabled(true);
					btnTimer.setText("Stop");
					c.timer1.start();
					txtKm.setEditable(false);
				}
				else if(texte.compareTo("Stop")==0) {
					c.timer1.stop();
					while(!participants.isEmpty())
					{
						abandonParticipant(0);
					}
					cbbBateau.removeAllItems();
					btnArrive.setEnabled(false);
					btnAbandon.setEnabled(false);
					btnTimer.setEnabled(false);
					btnAfficher.setEnabled(true);
				}
			}
		});
	}
	
	public void ajouterParticipant(String nom, int classe, int rating, String skipper) {
		this.participants.add(new Participant(nom, classe, rating, skipper));
		cbbBateau.addItem(nom);
		if(cbbBateau.getItemCount()==20){
			btnAjouter.setEnabled(false);
		}
	}
	
	public void verifException(int classe) throws ClasseException{
		if(classe < 1 || classe > 4){
			throw new ClasseException();
		}else {
			ajouterParticipant(txtNom.getText(), Integer.parseInt(txtClasse.getText()), Integer.parseInt(txtRating.getText()), txtSkipper.getText());
			model.addRow(new Object[]{txtNom.getText(),txtClasse.getText(),txtRating.getText(),txtSkipper.getText()});
			txtNom.setText(null);
			txtClasse.setText(null);
			txtRating.setText(null);
			txtSkipper.setText(null);
		}
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
	
	public void arriveeParticipant(int i)
	{
		Participant p = participants.get(i);
		p.setTemps(Duration.ofSeconds(c.getSeconde()+c.getMinute()*60+c.getHeure()*3600));
		participantsArrives.add(p);
		participants.remove(i);
	}
	
	public void abandonParticipant(int i)
	{
		participantsAbandon.add(participants.get(i));
		participants.remove(i);
	}
}