
public class Player {
	
	private int PlayerHealth, PlayerMaxHealth, PlayerArmour, PlayerMaxArmour, PlayerArmourStrength, PlayerCurrentPosition;
		
	public Player(int playerHealth, int playerMaxHealth, int playerArmour, int playerMaxArmour, int playerArmourStrength)
	{
		PlayerHealth = playerHealth;
		PlayerMaxHealth = playerMaxHealth;
		PlayerArmour = playerArmour;
		PlayerMaxArmour = playerMaxArmour;
		PlayerArmourStrength = playerArmourStrength;
		PlayerCurrentPosition = 0;
	}
	
	
	//Getters and Setters for PlayerStats
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
	
	public String HealthBar(double max, double current){
		double Upper = (Math.round((current/max)*10))*2;
		double Lower = 20-Upper;
		String tempFull = "#########################################################";
		String tempEmpty = "______________________________________________________";
		tempFull = tempFull.substring(0, (int) Upper);
		tempEmpty = tempEmpty.substring(0, (int) Lower);
		String bar = tempFull.concat(tempEmpty);
				
		return bar;
	}
	



}
