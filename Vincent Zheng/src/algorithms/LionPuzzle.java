package algorithms;

public class LionPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfLions = 3;
		if(willEat(numberOfLions)) {
			System.out.println("Eat the sheep!");
		}else {
			System.out.println("Do not eat the sheep!");
		}
	}
	
	private static boolean willEat(int numberOfLions) {
		if(numberOfLions == 1) {
			return true;
		}else {
			return !willEat(numberOfLions-1);
		}
	}
}
