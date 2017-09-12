package intro;

public class CodingConventions {

		//FIELDS ARE AT THE TOP!!
		private String name;
		/*
		 * IOW don't do this:
		 * private String name = "Vincent Zheng"
		 */
		private String description;
		
		/* this is a constructor, it is like a method except the "return type" is an instance of the class
		 * for this reason, a constructor must ALWAYS be named after the class
		 */
		public CodingConventions(int nameIndex , int descriptionIndex) {
			//instantiate variable now:
			//there are two variables called "name" the local variable and the field
			//distinguish between the two using the reserve word "this" (field)
			this.name = name;
			
			//this is a static call to the constant
			description = IntroMain.DESCRIPTIONS[descriptionIndex];
			name = IntroMain.NAMES[nameIndex];
			
		}
		// normal method "void" is the return type
		public void doStuff() {
			//static method call:
			String output = name + description;// use spaces in between operation 1 + 1 = 2 not 1+1=2
			System.out.println(output);
		}
}
