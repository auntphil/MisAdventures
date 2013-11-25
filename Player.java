
public class Player {
	
<<<<<<< HEAD
	private int PlayerHealth, PlayerMaxHealth, PlayerArmour, PlayerMaxArmour, PlayerArmourStrength, PlayerCurrentPosition;
=======
	private int PlayerHealth, PlayerMaxHealth, PlayerArmour, PlayerMaxArmour, PlayerArmourStrength, PlayerWeapon;
>>>>>>> 5d9bf0fbec608c25d0bfc8e4506d43ac7f5f568b
		
	public Player(int playerHealth, int playerMaxHealth, int playerArmour, int playerMaxArmour, int playerArmourStrength)
	{
		PlayerHealth = playerHealth;
		PlayerMaxHealth = playerMaxHealth;
		PlayerArmour = playerArmour;
		PlayerMaxArmour = playerMaxArmour;
		PlayerArmourStrength = playerArmourStrength;
<<<<<<< HEAD
		PlayerCurrentPosition = 0;
=======
		PlayerWeapon = 0;
>>>>>>> 5d9bf0fbec608c25d0bfc8e4506d43ac7f5f568b
	}
	
	
	//Getters and Setters for PlayerStats
	public int getPlayerWeapon() {return this.PlayerWeapon;}
	public void setPlayerWeapon(int PlayerWeapon){this.PlayerWeapon = PlayerWeapon;}
	public int getPlayerHealth() {return this.PlayerHealth;}
	public void setPlayerHealth(int playerHealth) {this.PlayerHealth = playerHealth;}
	public int getPlayerMaxHealth() {return this.PlayerMaxHealth;}
	public void setPlayerMaxHealth(int playerMaxHealth) {this.PlayerMaxHealth = playerMaxHealth;}
	public int getPlayerArmour() {return this.PlayerArmour;}
	public void setPlayerArmour(int playerArmour) {this.PlayerArmour = playerArmour;}
	public int getPlayerMaxArmour() {return this.PlayerMaxArmour;}
	public void setPlayerMaxArmour(int playerMaxArmour) {this.PlayerMaxArmour = playerMaxArmour;}
	public int getPlayerArmourStrenth() {return this.PlayerArmourStrength;}
	public void setPlayerArmourStrength(int playerArmourStrength) {this.PlayerArmourStrength = playerArmourStrength;}
	public int getPlayerCurrentPosition() {return this.PlayerCurrentPosition;}
	public void setPlayerCurrentPosition(int playerCurrentPosition) {this.PlayerCurrentPosition = playerCurrentPosition;}
	
	
	public void Damage()//(/*int health, int max, int armour, int armourMax*/)
	{
		System.out.println(getPlayerHealth());
		PlayerHealth = PlayerHealth - 10;
	}
	
	public void DisplayCurrentPosition()
	{
		System.out.println("Players Current Position: " + PlayerCurrentPosition);
	}
	
	public int DamagePlayerHealth(int damage)
	{
		if (PlayerArmourStrength > damage && PlayerArmour > 0)
		{
			return PlayerHealth;
		}
		if (PlayerArmour > 0)
		{
			PlayerHealth = PlayerHealth - (damage - PlayerArmourStrength);
		}
		else
		{
			PlayerHealth = PlayerHealth - damage;
		}
		if (PlayerHealth < 0)
		{
			PlayerHealth = 0;
		}
		
		return PlayerHealth;
	}
	
	public int DamagePlayerArmour(int damage, int durable) {
		if (durable < damage) {
			if (PlayerArmour != 0)
				PlayerArmour = PlayerArmour - (damage - durable);
		} else
			PlayerArmour = PlayerArmour - 1;
		if (PlayerArmour < 0)
			PlayerArmour = 0;
		
		return PlayerArmour;
	}
}
