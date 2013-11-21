
public class Attack {
	//0 = Not Glance
	//1 = Glance
	private int glance = 0;
	private int chance;

	public int getGlance() {
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
			glance = (int) (Math.random());
			if(glance==0)
				return 0;
			else
				return Math.round(Wdam/2);
		}
		else
			return Wdam;
	}

}
