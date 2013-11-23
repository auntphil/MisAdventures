
public class Location {

	private String region = "Forest of Goluth";
	private String location = "Temple of Thimvel";
	private String room = "Entrance Way";
	private boolean Empty = false;
	private int EnemyID = 1;
	
	public int getEnemyID() {
		return EnemyID;
	}
	public void setEnemyID(int enemyID) {
		EnemyID = enemyID;
	}
	public boolean isEmpty() {
		return Empty;
	}
	public void setEmpty(boolean empty) {
		Empty = empty;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
}
