	import java.util.Scanner;
public class Monster {
		private String nom;
		private int Force;
		private int Adresse;
		private int Resistance;
		private int life;
		private int px;
		
	public Monster (String nom) {
		this.nom = nom;
		this.Force = 5;
		this.Adresse = 5;
		this.Resistance = 5;
		this.px = 100;
		this.life = 50;
	}

	/*public void Deplacer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Haut     2.Droite      3.Bas       4.Gauche      ");
		int x =sc.nextInt();
		p.SetPosition(x);
		this.PA = PA -2;
	}*/

	public int CombatM(int degat) {
		this.life = this.life-degat;
		return this.life;
	}
	public int getlife() {
		return this.life;
	}
	 
	public int getAdresse() {
		return this.Adresse;
	}

	}

