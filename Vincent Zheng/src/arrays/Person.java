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
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	public void setInFirstPlace(Person f) {
		//go backward through an array
		for(int i = friends.length -1;i>0;i--) {
			friends[i] = friends[i-1];
		}
		friends[0] = f;
	}
	public void mingle(Person[] peers) {
		for(Person p: peers) {
			if(p != this) {
				setInFirstPlace(p);
			}
		}
	}
	public void statYourFriends() {
		String statement = "";
		for(int i = 0; i< friends.length ;i++) {
			if(i == friends.length-1) {
				statement += "and "+friends[i].firstName;
			}else {
				statement += friends[i].firstName+", ";
			}
		}
		System.out.println(statement);
	}
	public String toString() {
		return "My name is "+firstName+" " + lastName+" and I am from "+home+".";
	}
}
