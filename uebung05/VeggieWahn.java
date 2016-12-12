public class VeggieWahn {
	public static long essen(int v, int g) {
		
		long[][] table = new long[v+1][g+1];
		
		return 2L * getW(v,g, table);
			
			
		
	}

	private static long getW(int v, int g, long[][] table) {
				
		// Lookup
		if (table[v][g] != 0){
			return table[v][g];
		}
		
		long W = 0L;
		
		// Basisfaelle
		if (v == g || v == 1){
			W = 1L;
		} else {
		
			W = getW(v-1,g-1, table) + v * getW(v,g-1, table);
		}
		
		// Memoization
		table[v][g] = W;
		
		return W;
		
	}
	
}