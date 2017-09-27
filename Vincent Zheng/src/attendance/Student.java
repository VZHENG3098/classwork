package attendance;

public class Student implements Attendee {

	private String firstName;
	private String lastName;
	private boolean present;
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public boolean isPresent() {
		if(present == true) {
			return true;
		}else {
			return false;
		}
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public boolean mathces(String first, String last) {
		return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase());
	}
	public boolean matches(String last) {
		return last.toLowerCase().equals(lastName.toLowerCase());
	}
	public String getReportString() {
		String report = lastName;
		
		while(report.length()<20) {
			report += " ";
		}
		
		report += firstName;
		while(report.length()<40) {
			report += " ";
		}
		
		if(present) {
			return report += "PRESENT"; //
		}else{
			return report += "ABSENT";
		}
		
	}

}
