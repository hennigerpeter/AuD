public abstract class Hanoi {

	// Don't delete!! Tests will fail otherwise
	public Hanoi() {
	}

	/**
	 * @param n Initial amount of rings on start tower
	 * @param start Identifier for start tower
	 * @param mid Identifier for middle tower
	 * @param end Identifier for final tower
	 * @param r Only for test purposes. Ignore it!
	 * @return String containing each move for solving towers of Hanoi
	 */
	public static String solve(int n, String start, String mid, String end, Hanoi r) {
		// Don't delete!! Tests will fail otherwise
		// Pass object r to other function calls of solve (e.g. for recursion). Do not create other instances of object r
		// Function solve(...) must be recursive, don't implement other recursive helper functions
		r.check();

		// TODO
		String foo = "";
		
		if (n==2){
			foo = foo + start + "->" + end;
			
		} else {
				
			
			
			
				foo = foo + solve(n-1, start, mid, end, r) //1
					      + solve(n-1, start, end, mid, r) //2
				          + solve(n-1, end, start, mid, r); //2
				          
				if (n%2==0){
				foo = foo + solve(n-1, start, mid, end, r) //1
				          + solve(n-1, mid, end, start, r) //3
				          + solve(n-1, mid, start, end, r); //3
				          }
				else{
				foo = foo + solve(n-1, mid, mid, start, r) //1
			          + solve(n-1, mid, end, start, r) //3
			          + solve(n-1, mid, start, end, r); //3
				}
				          
				          
		           foo = foo + solve(n-1, start, mid, end, r); 
				          
//				          + solve(n-1, start, mid, end, r) //1
//					      + solve(n-1, start, end, mid, r) //2
//				          + solve(n-1, end, start, mid, r); //2
			
		
		}
		return foo;
	}

	// Don't delete!! Tests will fail otherwise
	public abstract void check();
}