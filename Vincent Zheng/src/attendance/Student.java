package attendance;

public class Student implements Attendee {

	private String first;
	private String last;
	private boolean inClass = false;
	
	public Student(String firstName, String lastName) {
		this.first = firstName;
		this.last = lastName;
	}
	
	public boolean isPresent() {
		if(inClass == true) {
			return true;
		}else {
			return false;
		}
	}

	public void setPresent(boolean present) {
		inClass = present;
	}

	public String getFirstName() {
		return first;
	}

	public String getLastName() {
		return last;
	}

}
