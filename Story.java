
public class Story {
	
	
	public String PlayerAttack(boolean glance, int damage){
		if(glance)
			return "It was a glancing blow, did make connection for " + damage + " damage!";
		else
			return "Great hit! You did " + damage + " damage.";
	}

}
