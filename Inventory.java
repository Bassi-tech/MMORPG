import java.util.Scanner;

public class Inventory implements ObjetcInGame{
	protected Equipement ed;  
	
	public Inventory() {
	}
	public void addInventory(Object a) {
		 all.add(a);
	}
	public void addEquipement(Equipement a) {
		 equip.add(a);
	}
	
	public boolean ShowInventory() {
		boolean ap = false;
		Scanner sc = new Scanner(System.in);
		if (all.isEmpty() == true) {
			System.out.println("Inventaire vide !");
		}
		else {
		System.out.println(" Quel objet voulez-vous utiliser ou equiper ?");
		for (int i = 0 ; i < all.size() ; i++) {
			 System.out.println(i+" "+all.get(i)+"\n");
		}
		int pp = sc.nextInt();
		if(all.get(pp) instanceof Item) {
			ap = true;
		}
		else
			ap = false;
		UseInventory(pp);
	}
		return ap;
	}
	public boolean ShowEquipement() {
		boolean ap = false;
		Scanner sc = new Scanner(System.in);
		int pp = 0;
		if (equip.isEmpty() == true) {
			System.out.println("Inventaire vide !");
		}
		else {
		System.out.println(" Que voulez-vous equiper ?");
		for (int i = 0 ; i < equip.size() ; i++) {
			 System.out.println(i+" "+equip.get(i)+"\n");
		}
		 pp = sc.nextInt();
		}
		if(equip.get(pp) instanceof Armor) {
			ap = true;
		}
		equip.remove(pp);
		return ap;
	}
	public int ShowGear() {
		Scanner sc = new Scanner(System.in);
		int pp = 0;
		if (gear.isEmpty() == true) {
			System.out.println("Inventaire vide !");
		}
		else {
		System.out.println(" Que voulez-vous equiper ?");
		for (int i = 0 ; i < gear.size() ; i++) {
			 System.out.println(i+" "+gear.get(i)+"\n");
		}
		 pp = sc.nextInt();
		UseEquipement(pp);
		}
		return pp;
	}
	
	public void UseInventory(int a) {
				all.remove(a);
			}
	public void UseEquipement(int a) {
		//gear.add(equip.get(a));
		equip.remove(a);
	}
	public int CancelInventory() {
		Scanner sc = new Scanner(System.in);
		int ap = 0;
		System.out.println(" Quel objet voulez-vous deposer ?");
		for (int i = 0 ; i < all.size() ; i++) {
			 System.out.println(i+" "+all.get(i)+"\n");
		}
		int pp = sc.nextInt();
		if(all.get(pp) instanceof Equipement) {
			ap = 0;
		}
		UseInventory(pp);
		return ap;
		}
	public boolean Check() {
		boolean g;
		if (all.isEmpty() == true) {
			g = true;
		}
		else 
			g = false;
		
		return g;
	}
	public int CancelEquipement() {
		Scanner sc = new Scanner(System.in);
		int ap = 0;
		System.out.println(" Quel objet voulez-vous deposer ?");
		for (int i = 0 ; i < equip.size() ; i++) {
			 System.out.println(i+" "+equip.get(i)+"\n");
		}
		int pp = sc.nextInt();
		if (equip.get(pp) instanceof Armor ) {
			ap = 1;
		}
		else
			ap = 2;
		UseEquipement(pp);
	return ap;
}
}

