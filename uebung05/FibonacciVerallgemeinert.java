public class FibonacciVerallgemeinert {
	public static double fibonacciVerallgemeinert(double a, double b, int c, int n) {
		
		double[] table = new double[n+1];
				
		return fibHelper(a,b,c,n,table);
		
	}
	
	
	public static double fibHelper(double a, double b, int c, int n, double[] table) {
	
		// Lookup
		if (table[n] != (double)0)
			return table[n];
		
		else{

			// Basisfall 1
			if ( 0 <= n && n < c){
				table[n] = n;
				return table[n];
			}
			
			// Basisfall 2
			if ( n>=c && n%2==0){
				table[n] = a * fibHelper(a,b,c,n-1,table) + fibHelper(a,b,c,n-c,table);
				return table[n];
			}
			
			table[n] =  b * fibHelper(a,b,c,n-1,table) + fibHelper(a,b,c,n-c,table);
			return table[n];
		}
	}
}