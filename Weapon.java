
public class Weapon {
	private String Name;
	private int Damage, ID, Speed=10;
	
	public int getSpeed(){
		return Speed;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getDamage() {
		return this.Damage;
	}
	public void setDamage(int damage) {
		Damage = damage;
	}
	
	public void DifferentWeapons(){
		switch(ID){
		case 1:
			Name = "Flame Sword";
			Damage = 5;
			Speed = 6;
			break;
		default:
			Name = "Fist";
			Damage = 1;
			Speed = 10;
			break;
				
		}
	}
}