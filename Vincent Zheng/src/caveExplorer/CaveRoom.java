package caveExplorer;

public class CaveRoom {
	private String description;
	private String directions;
	private String contents;
	private String defaultContents;
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	//constant 
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
		
	}
	/*
	 * for every door in doors[] that is not null
	 * this method appends a string describing the door and where it is. For example
	 * There is (passage) to (the North)
	 * If there are no doors that are not null, this set direction
	 * "There is no way out. You are trapped in this room"
	 * 
	 */
	public void setDirections() {
		directions = "";
		boolean exitFound = false;
		for(int i = 0; i<doors.length;i++) {
			if(doors[i] != null) {
				exitFound = true;
				directions += "There is a "+doors[i].getDescription()+"to the " + toDirection(i)
				+". "+doors[i].getDetails()+"\n";
			}
			
		}
		if(!exitFound) {
			directions = "There is no way out. You are trapped in this room";
		}
	}
	public static String toDirection(int dir) {
		String [] directions = {"the North","the East","the South","The West"};
		return directions[dir];
	}
	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}
