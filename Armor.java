
public class Armor extends Equipement {

	public Armor(String nom) {
		super(nom);
		this.Resistance = 20;
	}
	public String toString() {
		String s = "";
		s = this.nom;
		return s;
	}

}
