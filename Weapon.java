
public class Weapon {
	private String Name;
	private int Damage, ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		NameWeapon();
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getDamage() {
		WeaponDamage();
		return this.Damage;
	}
	public void setDamage(int damage) {
		Damage = damage;
	}
	
	public void NameWeapon(){
		switch(ID){
		case 1:
			Name = "Flame Sword";
			break;
		default:
			Name = "Fist";
			break;
				
		}
	}
	
	public void WeaponDamage(){
		switch(ID){
		case 1:
			Damage = 5;
			break;
		default:
			Damage = 1;
			break;
		}
	}

}