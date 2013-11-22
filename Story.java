
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

}
