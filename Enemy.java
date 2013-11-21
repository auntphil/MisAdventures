public class Enemy {

	private String Type, Name, Weapon;
	private int Height, Weight, Health, MaxHealth, Armour, MaxArmour, Damage,
			ArmourStrength, ArmourDurable, Speed;

	public int getSpeed(){
		return Speed;
	}
	public String getWeapon(){
		return Weapon;
	}	
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

	public void AttackEnemyHealth(int damage) {
		if (ArmourStrength > damage && Armour > 0) {

		} else {
			if (Armour > 0) {
				Health = Health - (damage - ArmourStrength);
			} else {
				Health = Health - damage;
			}
			if (Health < 0) {
				Health = 0;
			}
		}
	}

	public void AttackEnemyArmour(int damage) {
		if (Armour != 0) {
			if (ArmourDurable < damage) {
				if (Armour != 0)
					Armour = Armour - (damage - ArmourDurable);
			} else
				Armour = Armour - 1;
			if (Armour <= 0)
				Armour = 0;
		}
	}

	// Health for Enemy
	public String HealthBar() {
		double H = Health;
		double M = MaxHealth;
		double Upper = (Math.round((H / M) * 10)) * 2;
		double Lower = 20 - Upper;
		String tempFull = "#########################################################";
		String tempEmpty = "______________________________________________________";
		tempFull = tempFull.substring(0, (int) Upper);
		tempEmpty = tempEmpty.substring(0, (int) Lower);
		String bar = tempFull.concat(tempEmpty);
		return bar;
	}

	// Armour for Enemy
	public String ArmourBar() {
		double A = Armour;
		double M = MaxArmour;
		double Upper = (Math.round((A / M) * 10)) * 2;
		double Lower = 20 - Upper;
		String tempFull = "#########################################################";
		String tempEmpty = "______________________________________________________";
		tempFull = tempFull.substring(0, (int) Upper);
		tempEmpty = tempEmpty.substring(0, (int) Lower);
		String bar = tempFull.concat(tempEmpty);

		return bar;
	}

	public void getEnemy() {
		Type = "Ogre";
		Name = "Brutish";
		Height = 97;
		Weight = 512;
		Health = 50;
		MaxHealth = 50;
		Armour = 25;
		MaxArmour = 25;
		Damage = 10;
		ArmourStrength = 2;
		ArmourDurable = 1;
		Speed = 3;
		Weapon = "Club";
	}
}
