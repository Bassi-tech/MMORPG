
public class Item {
	protected String nom;
	protected int plus;
	protected int plPA;
	
public Item(String nom ) {
	this.nom = nom;
	this.plus = 10;
	this.plPA  = 3;
}
public int getHeal() {
	return this.plus;
	}

public int getPA() {
	return this.plPA;
	}


}
