package Pack;
import java.util.ArrayList;

public class Participant {
	private String nom;
	private int classe;
	private int rating;
	private String skipper;
	
	public Participant(String nom, int classe, int rating, String skipper) {
		super();
		this.nom = nom;
		this.classe = classe;
		this.rating = rating;
		this.skipper = skipper;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Participant.calculTemps(4207,1134,3.8));
	}
	
	public static int calculTemps(int secondes, int rating, double distance){
		return (int) ((5143/Math.sqrt(rating))*distance);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getSkipper() {
		return skipper;
	}

	public void setSkipper(String skipper) {
		this.skipper = skipper;
	}
}