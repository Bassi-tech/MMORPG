import java.util.Scanner;

public class Player {
	private String nom;
	private int PA;
	private int Force;
	private int Adresse;
	private int Resistance;
	private int niv;
	private int px;
	private int life;
	static int lim = 12;
	
public Player (String nom) {
	this.nom = nom;
	this.PA = 5;
	this.Force = 5;
	this.Adresse = 5;
	this.Resistance = 5;
	this.niv = 1;
	this.px = 50;
	this.life = 100;
}

public int Deplacer() {
	Scanner sc = new Scanner(System.in);
	System.out.println("1.Haut     2.Droite      3.Bas       4.Gauche      ");
	int x = sc.nextInt();
	return x;
}

public int CombatP(int degat) {
	this.PA = PA-3;
	this.life = this.life-degat;
	return this.life;
}

public int getlife() {
	return this.life;
}

public void setlife(int pls) {
	this.life = this.life + pls;
}

public int getPA() {
	return this.PA;
}
public int getAdresse() {
	return this.Adresse;
}
public int getResistance() {
	return this.Resistance;
}

public void setPA(int a) {
	if ( this.PA < lim) {
	this.PA = this.PA + a;
	}
	else
		System.out.println("Limite de PA atteinte");
}
public void setAdresse(int p) {
	this.Adresse = this.Adresse + p;
}
public void setResistance(int p) {
	this.Resistance = this.Resistance + p;
}
public void setForce(int p) {
	this.Force = this.Force + p;
}
public void RemoveAdresse(int p) {
	this.Adresse = this.Adresse - p;
}
public void RemoveResistance(int p) {
	this.Resistance = this.Resistance - p;
}
public void RemoveForce(int p) {
	this.Force = this.Force - p;
}
public boolean Check(int p) {
	boolean g = false;
	if (p == 0) {
		g = true;
	}
	return g;
}

 

}
