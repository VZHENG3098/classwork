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
		//NOTE: Arrays are instantiated with 'null' values
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
	 */
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a "+doors[i].getDescription()+" to the "+
				toDirection(i)+". "+doors[i].getDetails()+"\n";
			}
		}
		if(!doorFound) {
			directions = "There is no way out. You are trapped in this room";
		}
		//hint: to check if a door is null (or not null), use:
		//doors[0] == null   (OR USE   doors[0] != null)
	}
	public static String toDirection(int dir) {
		String [] directions = {"the North","the East","the South","The West"};
		return directions[dir];
	}
	
	public void enter() {
		contents = "X";
	}
	public void leave() {
		contents = defaultContents;
	}
	/*
	 * This is how we join rooms together
	 * It gives this room access to anotherRoom and vice-versa
	 * it also puts the door between both rooms
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction,anotherRoom,door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	private void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();//updates the direction
		
	}
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		int direction = "wdsa".indexOf(input);
		/*
		 * convert wasd into 0,3,2,1
		 */
		goToRoom(direction);
	}
	private boolean isValid(String input) {
		String accepted = "wasd";
		return accepted.indexOf(input) != -1 && input.length() == 1;
				
	}
	/*
	 * This is where you edit your caves
	 */
	public static void setUpCaves() {
		//1.Determine size of caves
		CaveExplorer.caves = new CaveRoom[5][5];
		CaveRoom[][] c = CaveExplorer.caves; // create a short cut for accessing CaveExplorer.caves;
		
		//2. Populate with default caves
		for(int row = 0; row < c.length; row++) {
			for (int col = 0; col <c[row].length; col++) {
				c[row][col] = new CaveRoom("Coordinate ("+row+","+col+")");
			}
		}
		//3. Replace some default rooms with the customs rooms (Save for later)
		
		//4. Set starting room
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		
		//5. Set up doors
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
	}
	public void goToRoom(int direction) {
		if(borderingRooms[direction] != null && doors[direction] != null &&
				doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}else {
			//print red text
			System.err.println("You can't do that!");
		}
	}
	public static int oppositeDirection(int dir) {
		int [] direction = {2,3,0,1};
		return direction[dir];
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
	public Door getDoor(int direction) {
	return doors[direction];
	}
}
