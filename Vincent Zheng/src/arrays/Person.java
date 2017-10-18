package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr","Am","L","D","Th","Br","Vin","De"};
	public static final String[] FIRST_MIDDLE = {"ala","e","o","avi","ece","ola","omo","ana"};
	public static final String[] FIRST_END = {"na","d","k","da","les","tt","lay"};
	
	public static final String[] LAST_START = {"Bl","Gr","Ph","M","Thr","Sh"};
	public static final String[] LAST_MIDDLE = {"an","in","ast","own","il"};
	public static final String[] LAST_END = {"na","d","k","da","les","tt","lay"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
	}
	
	public String toString() {
		return "My name is "+firstName+" " + lastName+" and I am from "+home+".";
	}
}
