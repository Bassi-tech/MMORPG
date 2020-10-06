
public class Sword extends Equipement{

	public Sword(String nom) {
		super(nom);
		this.force = 10;
		this.adresse = 5;
	}
	public String toString() {
		String s = "";
		s = this.nom;
		return s;
	}

}
