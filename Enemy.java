public class Enemy {

	private String Type, Name;
	private int Height, Weight, Health, MaxHealth, Armour, MaxArmour, Damage;
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public int getWeight() {
		return Weight;
	}
	public void setWeight(int weight) {
		Weight = weight;
	}
	public int getHealth() {
		return Health;
	}
	public void setHealth(int health) {
		Health = health;
	}
	public int getMaxHealth() {
		return MaxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		MaxHealth = maxHealth;
	}
	public int getArmour() {
		return Armour;
	}
	public void setArmour(int armour) {
		Armour = armour;
	}
	public int getMaxArmour() {
		return MaxArmour;
	}
	public void setMaxArmour(int maxArmour) {
		MaxArmour = maxArmour;
	}
	public int getDamage() {
		return Damage;
	}
	public void setDamage(int damage) {
		Damage = damage;
	}

	//Health and Armour for Enemy
	public String HealthBar(int health) {
		int current=0;
		int max=0;
		if(health == 0){
			current = Health;
			max = MaxHealth;
		}else{
			current = Armour;
			max = MaxArmour;
		}
		double Upper = (Math.round((current / max) * 10)) * 2;
		double Lower = 20 - Upper;
		String tempFull = "#########################################################";
		String tempEmpty = "______________________________________________________";
		tempFull = tempFull.substring(0, (int) Upper);
		tempEmpty = tempEmpty.substring(0, (int) Lower);
		String bar = tempFull.concat(tempEmpty);

		return bar;
	}
	
	public void getEnemy(){
		Type = "Ogre";
		Name = "Brutish";
		Height = 97;
		Weight = 512;
		Health = 50;
		MaxHealth = 50;
		Armour = 25;
		MaxArmour = 25;
		Damage = 10;
	}
}
