package caveExplorer;

public class TreasureRoom extends CaveRoom {

	public TreasureRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public void performAction(int direction) {
		if(direction == 4) {
			CaveExplorer.inventory.giveGold();
		} else {
			CaveExplorer.print("That key does nothing.");
		}
		
	}
}
