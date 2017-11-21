package Pack;
import java.time.Duration;
import java.util.ArrayList;

public class Participant {
	private String nom;
	private int classe;
	private int rating;
	private String skipper;
	private Duration temps;
	
	public Participant(String nom, int classe, int rating, String skipper) {
		super();
		this.nom = nom;
		this.classe = classe;
		this.rating = rating;
		this.skipper = skipper;
		this.temps = Duration.ZERO;
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
	
	public Duration getTemps() {
		return temps;
	}

	public void setTemps(Duration temps) {
		this.temps = temps;
	}
}