public abstract class Merge {

	// Don't delete!! Tests will fail otherwise
	public Merge() {
	}

	/**
	 * @param ns Integer array being merged
	 * @param i Start index
	 * @param r Only for test purposes. Ignore it!
	 * @return String containing merged output
	 */
	public static String merge(int[] ns, int i, Merge r) {
		// Don't delete!! Tests will fail otherwise
		// Pass object r to other function calls of merge (e.g. for recursion). Do not create other instances of object r
		// Function merge(...) must be recursive, don't implement other recursive helper functions
		r.check();

		// TODO
		int n = ns[i];
						

		if (ns.length >= 3 && i < ns.length - 1){
			
			if(ns[i] == ns[i+1]){
									
				while (i < ns.length - 2 && ns[i] == ns[i+1]){
					n = n * ns[i+1];
					
					i = i+1;
				}
				
				
			} 
		
			return   n + " " + merge(ns, i+1, r);
		}
		
		return "" + n;
			
		
			
		
		
	
	}

	// Don't delete!! Tests will fail otherwise
	public abstract void check();
	
//	public static void main(String[] args)
//	{
//		int[] input = new int[] { 5, 5, 5, 6 };
//		
//		String solution = Merge.merge(input, 0, null);	
//	}
	
}