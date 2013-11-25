
public class Attack {
	//0 = Not Glance
	//1 = Glance
	private boolean glance = false;
	private int chance;
	private boolean evade = false;

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public boolean isEvade() {
		return evade;
	}

	public void setEvade(boolean evade) {
		this.evade = evade;
	}

	public void setGlance(boolean glance) {
		this.glance = glance;
	}

	public boolean getGlance() {
		return glance;
	}
	
	public int PlayerAttack(int Wsp, int Wdam, int EnSp){
		if(Wsp > EnSp){
			chance = Wsp - EnSp;
			if(chance<5)
				chance=5;
		}
		else{
			chance = EnSp - Wsp;
			switch(chance){
			case 9:
				chance = 1;
				break;
			case 8:
				chance = 1;
				break;
			case 7:
				chance = 2;
				break;
			case 6:
				chance = 2;
				break;
			case 5:
				chance = 3;
				break;
			case 4:
				chance = 3;
				break;
			case 3:
				chance = 3;
				break;
			case 2:
				chance = 4;
				break;
			case 1:
				chance = 4;
				break;
			}
		}
		
		int hit = (int) (Math.random() * ((9)+1));
		if(hit>=chance){
			int glanceDam = (int) (Math.random() * ((1)+1));
			//System.out.println("Glance: " + glanceDam);
			if(glanceDam==0){
				glance = false;
				return 0;}
			else{
				glance = true;
				return Math.round(Wdam/2);}
		}
		else
			glance = false;
			return Wdam;
	}
	
	public int EnemyAttack(int Damage, int Speed){
		chance = (int) (Math.random()*((9)+1));
		//System.out.println("Random Chance: " + chance);
		if(chance>=Speed){
			evade = true;
			return 0;
		}
		else {
			evade = false;
			return Damage;
		}
		
	}

}
