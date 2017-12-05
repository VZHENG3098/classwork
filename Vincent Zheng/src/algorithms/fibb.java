package algorithms;

public class fibb {

	public static void main(String[] args) {
		System.out.println(fibba(10));
	}
	
	
	public static int fibba(int x) {
		if(x <= 2) {
			return 1;
		}else {
			return fibba(x-1) + fibba(x-2);
		}
	}
}
