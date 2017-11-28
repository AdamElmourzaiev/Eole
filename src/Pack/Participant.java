package Pack;
import java.time.Duration;
import java.util.ArrayList;

public class Participant {
	private String nom;
	private int classe;
	private int rating;
	private String skipper;
	private Duration temps;
	private Duration tempsCompense;
	
	public Participant(String nom, int classe, int rating, String skipper) {
		super();
		this.nom = nom;
		this.classe = classe;
		this.rating = rating;
		this.skipper = skipper;
		this.temps = Duration.ZERO;
		this.tempsCompense = Duration.ZERO;
	}
	
	public static int calculTemps(int secondes, int rating, double distance){
		int temps= secondes;
		if(secondes!=0) {
			temps = temps+(int) ((5143/(Math.sqrt(rating)+3.5))*distance);
		}
		return (temps);
	}
	
	public static String formatTemps(int heures, int minutes, int secondes) {
		String temps= "";
		if(heures<10){
			temps+="0";
		}
		temps+=heures+":";
		if(minutes<10){
			temps+="0";
		}
		temps+=minutes+":";
		if(secondes<10){
			temps+="0";
		}
		temps+=secondes;
		return (temps);
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

	public Duration getTempsCompense() {
		return tempsCompense;
	}

	public void setTempsCompense(Duration tempsCompense) {
		this.tempsCompense = tempsCompense;
	}
	
}