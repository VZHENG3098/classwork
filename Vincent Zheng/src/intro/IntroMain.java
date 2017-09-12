package intro;//package declaration: matches folder where this file is located
//class header
public class IntroMain {
	
	//this is aa constant, they can be public
	public static final String[] DESCRIPTIONS = {" is a student at BTHS"," is a teacher at BTHS"}; 
	
	// this is the first method that is executed. It is static because it is independent of instances
	public static void main(String[] args) {
		//this is the declaration of an instance of CodingConventions
		// in the same line of code, it is also being instantiated 
		//note the use of the word "new" this word is always used when calling constructors
	
		
		int numberOfPeople = 10;
		for(int i = 0; i< numberOfPeople;i++) {
			CodingConventions conventionsInstance = new CodingConventions("Vincent Zheng",i%2);
			//a note on local variables: they are NOT FIELDS (HAS-A relationships)
			// they are variables that are only used in the scope of a method
			// after the method, they are destroyed
			
			/*
			 * instance method call (the method belongs to the instance, not the class)
			 * 
			 */
		
	
		conventionsInstance.doStuff();
		}
		
		
	}
	
	
}
