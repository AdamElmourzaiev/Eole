package Pack;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Chronometre {
	
	private int heure=0,minute=0,seconde=0;
	private int delais=1000;
	ActionListener tacheTimer;
	Timer timer1;
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSeconde() {
		return seconde;
	}
	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}
	public int getDelais() {
		return delais;
	}
	public void setDelais(int delais) {
		this.delais = delais;
	}
	public ActionListener getTacheTimer() {
		return tacheTimer;
	}
	public void setTacheTimer(ActionListener tacheTimer) {
		this.tacheTimer = tacheTimer;
	}
	public Timer getTimer1() {
		return timer1;
	}
	public void setTimer1(Timer timer1) {
		this.timer1 = timer1;
	}
	//commentaire inutile.000
//nouvel commenentaire

		
		
}
