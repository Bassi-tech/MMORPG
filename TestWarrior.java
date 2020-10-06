import java.util.Scanner;
public class TestWarrior implements ObjetcInGame {
	public static void main( String [ ]  args ) {
		int play = 0;
		int lig = 30;
		int col = 20;
		int jok;
		int x = 0;
		int val = 0;
		int bla = 0;
		int PA = 100;
		boolean t = false;
		boolean stop = false;
		boolean off = false;
		Scanner sc = new Scanner(System.in);
		Scanner pc = new Scanner(System.in);
		Scanner pla = new Scanner(System.in);
		String tab[][] = new String [lig][col];
		Map p = new Map (tab,lig,col);
		String j = "Test";
		String m = "Poporing";
		Player j1 = new Player(j);
		Monster m1 = new Monster(m);
		Inventory i = new Inventory();
		PotionPV i1 = new PotionPV("Potion de vie");
		PotionPA i2 = new PotionPA("Potion d'action");
		Equipement eq = new Sword("Epee d'argent ");
		Equipement eq2 = new Armor ("Armure de cuivre");
		int a = 0;
		int b = 0;
		int co = 0;
		int rok = 0;
		System.out.println("#################################################################################################\r\n" + 
																															"            \r\n" + 
			       "##          ##         #         ################# ################# ## ################# #################          \r\n" + 
				   "###        ###        ###	 ##             ## ##             ## ## ################# ##             ##          \r\n" + 
				   "####      ####       #####	 ##             ## ##             ## ## ##             ## ##             ##          \r\n" + 
				   "#####    #####      #######	 ##             ## ##             ## ## ##             ## ##             ##          \r\n" + 
				   "#####    #####     #########	 ##             ## ##             ## ## ##             ## ##             ##          \r\n" + 
				   "##############    ###########	 ##             ## ##             ## ## ##             ## ##             ##          \r\n" + 
				   "##############   #############	 ################# ################# ## ##             ## #################          \r\n" + 
				   "##############  ###############  ################  ################  ## ##             ## ################            \r\n" + 
				   "####      #### ################# ##            ##  ##            ##  ## ################# ##            ##            \r\n" + 
				   "####      #########################             ## ##             ## ## ################# ##             ##           \r\n" + 
				   "                              \r\n" + 
				   "########################################################################################################### \n"
				   + "1.Commencer le jeu ?");
		play = pla.nextInt();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		if ( play == 1) {
		p.CreateMap();
		p.Spawn();
		p.ShowMap();
		while (p.DetectMonster()==false ) {
		System.out.println(" Action de "+ j +" : ");
		System.out.println("      1. Se deplacer (2PA)      2. Attaquer (3PA) ");
		System.out.println("      3. Utiliser objet   4. Ramasser/Deposer objet(2PA) ");
		System.out.println("      5. Finir son tour  ");
		System.out.println(""+PA);
		x =sc.nextInt();
		if (x == 1 && PA >= 2) {
			j1.Check(PA);
			val = j1.Deplacer();
			p.SetPosition(val);
			PA = PA -2;
			
		}
		else if (x == 1 && PA < 2)
			System.out.println(" Plus de PA !");
		
		if (x == 2 && PA >= 3) {
			j1.Check(PA);
			t = p.DetectFight();
			if (t == true) {
					b = j1.CombatP(10);
					if (b == 0) {
						stop = true;
					}
					System.out.println(" Vous avez recu 10 pts de degats !");
					a = m1.CombatM(50);
					if (a == 0) {
					p.Kill();
					m1 = new Monster(m);
					}
					System.out.println(" Vous avez infligez 50 pts de degats !");
					System.out.println(" Life :"+j1.getlife()+"");
				}
			else if (t == false)
				System.out.println(" Pas de monstre a proximite !");
			else if (x == 2 && PA < 3) {
				System.out.println(" Plus de PA !");
			}
			PA = PA -3;
		}
			
		if (stop == true) {
			System.out.println("Game Over");
			break;
				}
		if (x == 3) {
			System.out.println(" 1.Utiliser objet    2.S'equiper ");
			bla = pc.nextInt();
			if (bla == 1) {
			if (i.ShowInventory() == true ) {
			j1.setlife(i1.getHeal());
				}
			}
			else if (bla == 2) {
				if (i.ShowEquipement() == false ) {
					j1.setForce(eq.getForce());
					j1.setAdresse(eq.getadresse());
				}
				else {
					j1.setResistance(eq.getResistance());
				}
			}
			/*else if (bla == 3) {
				if(equip.get(i.ShowGear()) instanceof Sword) {
					j1.RemoveForce(eq.getForce());
					j1.RemoveAdresse(eq.getadresse());
				}
				else if(equip.get(i.ShowEquipement()) instanceof Armor) {
					j1.RemoveResistance(eq.getResistance());
				}
			}*/
		}
		if (x == 4 && PA >= 2) {
			System.out.println("1.Ramasser  2.Deposer ? 3.Deposer equipement ?");
			co =sc.nextInt();
			if (p.DetectObject() == true && co == 1) {
				p.TakeObject();
				jok = (int)( Math.random());
				if (jok == 0) {
				i.addInventory(i1);
				}
				else if (jok == 1) {
					i.addInventory(i2);
					}
			}
			else if (p.DetectWeapon() == true && co == 1) {
				p.TakeWeapon();
				i.addEquipement(eq);
				for (int i11 = 0 ; i11 < equip.size() ; i11++) {
					 System.out.println(i11+" "+equip.get(i11)+"\n");
				}
			}
			else if (p.DetectArmor() == true && co == 1) {
				p.TakeArmor();
				i.addEquipement(eq2);
			}
			else if (co == 2){
				if (i.Check() == false) {
						i.CancelInventory();
						p.DropObject();
				}
				else
					System.out.println(" Inventaire vide !");
			}
			else if (co == 3){
				if (i.Check() == false) {
					if ( i.CancelEquipement() == 1)
						p.DropArmor();
				}
				else if ( i.CancelEquipement() == 2)
						p.DropWeapon();
			}
			else if (p.DetectObject() == false && p.DetectWeapon() == false && co == 1 )
				System.out.println(" Pas d'objet a proximite !");
			else if (x == 4 && PA < 2) {
				System.out.println(" Plus de PA");
			}
		}
		if (x == 5) {
			if ( PA  == 5) {
				System.out.println(" PA au max !");
			}
			else
			PA = PA +1;
		}
			
		p.ShowMap();
		}
		}
		System.out.println(" Niveau termine !");
	}
}
