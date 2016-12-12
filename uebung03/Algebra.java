public class Algebra {
	public static long[][] primfaktorzerlegung(long n) {
		long[][] result1 = { {}, {} };
		
		if (n == 1L)
			return result1;
		
		// Maximal moegliche Primfaktoren anhand der Entropie berechnen
		int maxStellen = (int)(Math.log(n)/Math.log(2)); 
		
		long basis = 0L;
		
		
		long[] z0 = new long[maxStellen]; //Basis
		long[] z1 = new long[maxStellen]; //Exponent
		
		long[] primzahlen = {97, 89, 83, 79, 73, 71, 67, 61, 59, 53, 47, 43, 41, 37, 31, 29, 23, 19, 17, 13, 11, 7, 5, 3, 2};
		int arrPos = 0;
		for (int i=0; i<primzahlen.length; i++){
			long exponent = 1L;
			while (n % primzahlen[i] == 0 && n != 0L){
				basis = primzahlen[i];
				
				z0[arrPos] = basis;
				z1[arrPos] = exponent;
				//n /= Math.pow(basis,exponent);
				//for(int x = 1; x < exponent; x++){
					n = n / basis;
				//}
				exponent++;
				
				}
			if (z0[arrPos] != 0){
				
				
				arrPos++;
			}
			
		}
		
		
		
		// Anzahl der Primfaktoren ermitteln
		
		int anzahl = 0;
		for (int j = 0; j < z0.length; j++){
			if (z0[j] > 1){
				anzahl = anzahl +1;
			}
		}
			
		
		long[] z2 = new long[anzahl];
		long[] z3 = new long[anzahl];
		
		for(int l = 0; l < anzahl; l++){
			z2[l] = z0[anzahl - 1 - l];
			z3[l] = z1[anzahl - 1 - l];
		}
		
		long[][] result2 = { z2, z3 };
		
		return result2;
	}

		

	public static long ggT(long[][] aPFZ, long[][] bPFZ) {
		
		long res = 1L;
		
		for (int i = 0; i <= aPFZ.length; i++){
			
			
			for (int j = 0; j <= bPFZ.length + 1; j++){
				
				if (aPFZ[0][i] == bPFZ[0][j]){
					if (aPFZ[1][i] <= bPFZ[1][j]){
						res = res * (long)Math.pow(aPFZ[0][i],aPFZ[1][i]);
					} else {
						res = res * (long)Math.pow(bPFZ[0][j],bPFZ[1][j]);
						
					}
				}
			}
			
		}
		
		
		return res;
		
		
	}

	public static long kgV(long a, long b) {
		
		
		long[][] aPFZ = primfaktorzerlegung(a);
		long[][] bPFZ = primfaktorzerlegung(b);
		
        long res = 1L;
		
		for (int i = 0; i < aPFZ[0].length; i++){
			
			boolean nichtEnthalten = true;
			for (int j = 0; j < bPFZ[0].length; j++){
				
				if (aPFZ[0][i] == bPFZ[0][j]){
					if (aPFZ[1][i] >= bPFZ[1][j]){
						res = res * (long)Math.pow(aPFZ[0][i],aPFZ[1][i]);
						nichtEnthalten = false;
					} else {
						res = res * (long)Math.pow(bPFZ[0][j],bPFZ[1][j]);
						nichtEnthalten = false;
					}
				}
					
					
			}
			if (nichtEnthalten){
				res = res * (long)Math.pow(aPFZ[0][i],aPFZ[1][i]);
			}
				
		}
		
		
		
		
		for (int l = 0; l < bPFZ[0].length; l++){
			
			boolean nichtEnthalten2 = true;
			for (int m = 0; m < aPFZ[0].length; m++){
				
				if (bPFZ[0][l] == aPFZ[0][m]){
					if (bPFZ[1][l] >= aPFZ[1][m]){
						
						nichtEnthalten2 = false;
					} else {
						
						nichtEnthalten2 = false;
					}
				}
					
					
			}
			if (nichtEnthalten2){
				res = res * (long)Math.pow(bPFZ[0][l],bPFZ[1][l]);
			}
		
			
		}
		return res;
	}
	/*
	public static void main (String[] args){
		
		
		//long actual = Algebra.kgV(12, 18);
		long actual = Algebra.kgV(6, 9);
	*/
	}
	