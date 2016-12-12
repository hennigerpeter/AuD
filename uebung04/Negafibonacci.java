public abstract class Negafibonacci {

	// Don't delete!! Tests will fail otherwise
	public Negafibonacci() {
	}

	/**
	 * @param n Variable n, signed integer
	 * @param r Only for test purposes. Ignore it!
	 * @return Solution for F(n)
	 */
	public static int solve(int n, Negafibonacci r) {
		// Don't delete!! Tests will fail otherwise
		// Pass object r to other function calls of solve (e.g. for recursion). Do not create other instances of object r
		// Function solve(...) must be recursive, don't implement other recursive helper functions
		r.check();

		// TODO
		
		if (n==0)
			return 0;
		
		if (n==1 || n==2)
			return 1;
		
		if (n<0)
			return (int)Math.pow(-1,Math.abs(n)+1) * solve(Math.abs(n),r);

		
		return solve(n - 2, r) + solve(n - 1, r);
				
				
				
				
	
	}

	// Don't delete!! Tests will fail otherwise
	public abstract void check();
}