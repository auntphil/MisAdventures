
public class Attack {
	//0 = Not Glance
	//1 = Glance
	private boolean glance = false;
	private int chance;

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
			int glanceDam = (int) (Math.random());
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

}
