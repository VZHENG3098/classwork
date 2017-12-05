package algorithms;

public class hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(4,"a","b","c");
	}

	public static void hanoi(int n ,String start, String help, String end) {
		if(n == 1) {
			System.out.println(start +" to "+ end);
		}else {
			hanoi(n-1,start,end,help); 
			System.out.println(start +" to "+ end);
			hanoi(n-1,help,start,end);
			
		}
	}
}
