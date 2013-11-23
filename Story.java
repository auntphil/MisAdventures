
public class Story {
	
	
	public String PlayerAttack(boolean glance, int damage, String enemy){
		//System.out.println(damage);
		if(glance){
			if(damage!=0)
				return "It was a glancing blow, but you did make connection for " + damage + " damage!";
			else
				return "It was a glancing blow off of the " + enemy + "'s armour. Sadly for no damage.";
			}
		else{
			if(damage==0)
				return "Swing and a miss. You missed your target!";
			else
				return "Great hit! You did " + damage + " damage!";
		}
	}
	
	public String Death(String Enemy){
	
	return "You take a fatal blow from the " + Enemy + ". The lights starts to fade to black. A bright light appears in front of you and you crawl towards it.";
	}
	
	public String EnemyDefeat(String Enemy){
		
		return "You have vanquished your foe!";
	}
	
	public String SecEntry(String Enemy){
		
		return "There is a dead " + Enemy + " in the room. Not much else is here.";
	}

}
