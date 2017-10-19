package arrays;

public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[34];
		populate(people);
		
	//	people[0] = new Thing("toaster oven");
		//for(Object p : group) {
		//	System.out.println(p);
		//}
		for(Person p: people) {
			p.mingle(people);
			System.out.println(p);
			p.statYourFriends();
		}
	}
	private void analyzeCommonalities(Person [] people,Person[] group) {
		double averageCommonality = 0;
		int trails = 500;
		for(int i =0;i<trails;i++) {
			group = selectGroup(people,people.length);
			averageCommonality += countCommonalities(people,group);
		}
		averageCommonality = averageCommonality/trails;
		System.out.println("After " + trails+" trails, shuffling " + people.length+ " people, on average " + averageCommonality+" people end up in the same position where they started.");
	}
	private void populate(Object[] people) {
		for(int i = 0; i < people.length; i ++) {
			String firstName = randomNameFrom(Person.FIRST_START,Person.FIRST_MIDDLE,Person.FIRST_END);
			String lastName =  randomNameFrom(Person.LAST_START,Person.LAST_MIDDLE,Person.LAST_END);
			Borough home = randomBorough();
			/*in an object array you can have multiple data types!
			This is unlike a primitve array, like int[], bool
			ean[] etc  */
			if (Math.random() < .6) {
				int money = (int)(Math.random()*20+1)*100000;
				people[i] = new Athlete(firstName,lastName,home,money);
			}else {
				people[i] = new Person(firstName,lastName,home);
			}
		}
	}
	
	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()* Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();
	}
	// returns the number of items that are the same in both arrays
	// and in the same location (index) too
	private int countCommonalities(Object[] arr1,Object[] arr2) {
		int numberS = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] == arr2[i]) {
				numberS++;
			}
		}
		return numberS;
	}
	private Person[] selectGroup(Person[] population,int length) {
		Person[] newP = new Person[length];
		for(int i = 0;i<newP.length;i++) {
			Person lookCopy = randomPerson(population);
			while(alreadyContains(newP,lookCopy)) {
				lookCopy = randomPerson(population);
			}
			newP[i] = lookCopy;
		}
		return newP;
		
	}
	private Person randomPerson(Person[] population) {
		int index = (int)(Math.random()* population.length);
		return population[index];
	}
	private boolean alreadyContains(Person[] population, Person p) {
		for(int i = 0;i<population.length;i++) {
			if(population[i] == p) {
				return true;
			}
		}
		return false;
	}
	
}
