
public class Location {

	private String region = "Forest of Goluth";
	private String location = "Temple of Thimvel";
	private String room;
	private boolean Empty;
	private int EnemyID;
	private int RoomID;
	private int Doors /*= NSEW*/;
	
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public int getDoors() {
		return Doors;
	}
	public void setDoors(int doors) {
		Doors = doors;
	}
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
	
	public void getRoomInfo(){
		switch(RoomID){
		case 1:
			room = "Entrance Way";
			Empty = false;
			EnemyID = 1;
			Doors = 1111;
			break;
		}
	}
}
