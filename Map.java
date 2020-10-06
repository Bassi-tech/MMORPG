import java.lang.Math;
import java.util.Scanner; 
public class Map {
	private String map [][];
	private int lig;
	private int col;

	public Map (String [][] map ,int lig, int col) {
		this.map = map;	
		this.lig = lig;
		this.col = col;	

	}
	public Map() {

	}

	public void CreateMap () {
		for ( int i = 0 ; i < lig ; i++ ) {
			for ( int j = 0 ; j < col ; j++) {
				if (i > 0 && i < lig-1 && j > 0 && j < col-1) {
					this.map[i][j] = " ";
				}
				else {
					this.map[i][j] = "#";
				}
			}
		}
	}

	public void Spawn() {
		String p = "J";
		this.map[11][17] = "M";
		this.map[8][11] = "M";
		this.map[18][3] = "M";
		this.map[6][3] = "M";
		this.map[5][8] = "M";
		this.map[2][5] = "M";
		this.map[11][12] = "M";
		this.map[1][14] = "M";
		this.map[1][12] = "J";
		this.map[1][9] = "g";
		this.map[2][13] = "p";
		this.map[7][16] = "p";
		this.map[4][14] = "p";
		this.map[14][2] = "p";
		this.map[1][2] = "a";
	}	
	public void ShowMap () {
		for ( int i = 0 ; i < lig ; i++ ) {
			for ( int j = 0 ; j < col ; j++) {
				System.out.print(this.map[i][j]);
			}
			System.out.println("");
		}
	}
	public int getLine() {
		int g = 0;
	    for ( int i = 0 ; i < lig ; i++ ) {
	    	for (int j = 0 ; j < col ; j++) {
	    		if ( this.map[i][j] == "J") {
	    			g = i;
	    	}
	    }
	    	
	}
	    return g;
}
	public int getLineMonster() {
		int g = 0;
	    for ( int i = 0 ; i < lig ; i++ ) {
	    	for (int j = 0 ; j < col ; j++) {
	    		if ( this.map[i][j] == "M") {
	    			g = i;
	    	}
	    }
	    	
	}
	    return g;
}
	public int getCol() {
		int p = 0;
	    for ( int i = 0 ; i < lig ; i++ ) {
	    	for (int j = 0 ; j < col ; j++) {
	    		if ( this.map[i][j] == "J") {
	    			p = j;
	    	}
	    }
	    	
	}
	    return p;
}
	public int getColMonster() {
		int p = 0;
	    for ( int i = 0 ; i < lig ; i++ ) {
	    	for (int j = 0 ; j < col ; j++) {
	    		if ( this.map[i][j] == "M") {
	    			p = j;
	    	}
	    }
	    	
	}
	    return p;
}
	public void SetPosition(int x) {// 1. h 2.d 3.b 4.g
		int lig = getLine();
		int col = getCol();
		if ( x == 1 && this.map[lig-1][col] != "#") {
		this.map[lig-1][col] = "J";
		this.map[lig][col] = " ";
		}
		else if ( x == 2 && this.map[lig][col+1] != "#") {
		this.map[lig][col+1] = "J";
		this.map[lig][col] = " ";
		}
		else if ( x == 3 && this.map[lig+1][col] != "#") {
		this.map[lig+1][col] = "J";
		this.map[lig][col] = " ";
		}
		else if ( x == 4 && this.map[lig][col-1] != "#") {
		this.map[lig][col-1] = "J";
		this.map[lig][col] = " ";
		}

}

	public boolean DetectMonster() {
	    for ( int i = 0 ; i < lig ; i++ ) {
	    	for ( int j = 0 ; j < col ; j++) {
	    		if (this.map[i][j] == "M") {
	    			return false;
	    	}
	    }
	}
	    			return true;
	}
	public boolean DetectObject() {
			int lig = getLine();
			int col = getCol();
			boolean g = false;
			if (this.map[lig-1][col] == "p") {
				g = true;
				}
			if (this.map[lig][col+1]== "p") {
				g = true;
				}
			if (this.map[lig+1][col]== "p") {
				g = true;
				}
			if (this.map[lig][col-1] == "p"  ) {
				g = true;
				}
			return g;
	}
	public boolean DetectFight() {
	int lig = getLine();
	int col = getCol();
	boolean g = false;
	if (this.map[lig-1][col] == "M") {
		g = true;
		}
	if (this.map[lig][col+1]== "M") {
		g = true;
		}
	if (this.map[lig+1][col]== "M") {
		g = true;
		}
	if (this.map[lig][col-1] == "M"  ) {
		g = true;
		}
	return g;
	}
	
	public void Kill() {
		int lig = getLine();
		int col = getCol();
		if (this.map[lig-1][col] == "M") {
			this.map[lig-1][col] = " ";
		}
		else if (this.map[lig][col+1]== "M") {
			this.map[lig][col+1] = " ";
			}
		else if (this.map[lig+1][col]== "M") {
			this.map[lig+1][col] = " ";
			}
		else if (this.map[lig][col-1] == "M"  ) {
			this.map[lig][col-1] = " ";
			}
		
	}
	public void TakeObject() {
		int lig = getLine();
		int col = getCol();
		if (this.map[lig-1][col] == "p") {
			this.map[lig-1][col] = " ";
			}
		else if (this.map[lig][col+1]== "p") {
			this.map[lig][col+1] = " ";
			}
		else if (this.map[lig+1][col]== "p") {
			this.map[lig+1][col] = " ";
			}
		else if (this.map[lig][col-1] == "p"  ) {
			this.map[lig][col-1] = " ";
			}
		
	}
	public void DropObject() {
		int lig = getLine();
		int col = getCol();
		if (this.map[lig-1][col] == " ") {
			this.map[lig-1][col] = "p";
			}
		else if (this.map[lig][col+1]== " ") {
			this.map[lig][col+1] = "p";
			}
		else if (this.map[lig+1][col]== " ") {
			this.map[lig+1][col] = "p";
			}
		else if (this.map[lig][col-1] == " "  ) {
			this.map[lig][col-1] = "p";
			}
		
	}
	
public boolean DetectWeapon() {
	int lig = getLine();
	int col = getCol();
	boolean g = false;
	if (this.map[lig-1][col] == "a") {
		g = true;
		}
	if (this.map[lig][col+1]== "a") {
		g = true;
		}
	if (this.map[lig+1][col]== "a") {
		g = true;
		}
	if (this.map[lig][col-1] == "a"  ) {
		g = true;
		}
	return g;
}

public void TakeWeapon() {
	int lig = getLine();
	int col = getCol();
	if (this.map[lig-1][col] == "a") {
		this.map[lig-1][col] = " ";
		}
	else if (this.map[lig][col+1]== "a") {
		this.map[lig][col+1] = " ";
		}
	else if (this.map[lig+1][col]== "a") {
		this.map[lig+1][col] = " ";
		}
	else if (this.map[lig][col-1] == "a"  ) {
		this.map[lig][col-1] = " ";
		}
	
}
public void DropWeapon() {
	int lig = getLine();
	int col = getCol();
	if (this.map[lig-1][col] == " ") {
		this.map[lig-1][col] = "a";
		}
	else if (this.map[lig][col+1]== " ") {
		this.map[lig][col+1] = "a";
		}
	else if (this.map[lig+1][col]== " ") {
		this.map[lig+1][col] = "a";
		}
	else if (this.map[lig][col-1] == " "  ) {
		this.map[lig][col-1] = "a";
		}
	
}
public boolean DetectArmor() {
	int lig = getLine();
	int col = getCol();
	boolean g = false;
	if (this.map[lig-1][col] == "g") {
		g = true;
		}
	if (this.map[lig][col+1]== "g") {
		g = true;
		}
	if (this.map[lig+1][col]== "g") {
		g = true;
		}
	if (this.map[lig][col-1] == "g"  ) {
		g = true;
		}
	return g;
}

public void TakeArmor() {
	int lig = getLine();
	int col = getCol();
	if (this.map[lig-1][col] == "g") {
		this.map[lig-1][col] = " ";
		}
	else if (this.map[lig][col+1]== "g") {
		this.map[lig][col+1] = " ";
		}
	else if (this.map[lig+1][col]== "g") {
		this.map[lig+1][col] = " ";
		}
	else if (this.map[lig][col-1] == "g"  ) {
		this.map[lig][col-1] = " ";
		}
	
}
public void DropArmor() {
	int lig = getLine();
	int col = getCol();
	if (this.map[lig-1][col] == " ") {
		this.map[lig-1][col] = "g";
		}
	else if (this.map[lig][col+1]== " ") {
		this.map[lig][col+1] = "g";
		}
	else if (this.map[lig+1][col]== " ") {
		this.map[lig+1][col] = "g";
		}
	else if (this.map[lig][col-1] == " "  ) {
		this.map[lig][col-1] = "g";
		}
	
}

}