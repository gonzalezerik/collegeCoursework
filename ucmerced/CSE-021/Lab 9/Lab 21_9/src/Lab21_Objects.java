public class Lab21_Objects {

	public static void main(String[] args) {
		// DO NOT CREATE NEW VARIABLES
		
		Dummy[] dlist = new Dummy[11];
		int[] iarr = new int[11];
		double[] darr = new double[11];

		// DO NOT USE ANY CONSTANTS OR NEW VARIABLES
		
		// Calls to Constructors 1 and 2  
		dlist[0] = new Dummy();
		dlist[1] = new Dummy(iarr[0]);
		
		// Fill-in calls to Constructors 3-11 and assign them to dlist array indices 2-10
		
		// Calls to diplay methods 1 and 2
		dlist[0].display();
		dlist[1].display(iarr[0]);
	
		// Fill-in calls to display methods 3-11 for the dlist objects at indices 2-10
	}
}
