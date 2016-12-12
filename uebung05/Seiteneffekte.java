public class Seiteneffekte {


public static final long[] FLUECHTIGES_FINALES_FELD = { 0, 0, 0 };

public static void aendere_etwas(long etwas){
	etwas = etwas + 42;
}

public static void aendere_etwas_anderes(long[] etwas_anderes){
	etwas_anderes[1] = etwas_anderes[1] + 42;
}

public static void aendere_alles() {
	
	long etwas = 47;
	aendere_etwas(etwas);
	System.out.println("etwas = " + etwas);
	
	long anderes = 11;
	aendere_etwas(anderes);
	System.out.println("anderes = " + anderes);
	
	long[] etwas_anderes = {0, 8, 15};
	aendere_etwas_anderes(etwas_anderes);
	System.out.println("etwas_anderes = " + java.util.Arrays.toString(etwas_anderes));
	
	long[] anderes_etwas = {0, 8, 15};
	aendere_etwas_anderes(anderes_etwas);
	System.out.println("anderes_etwas = " + java.util.Arrays.toString(anderes_etwas));
	
	long[] aber_was = {6, 6, 6};
	aendere_etwas(aber_was[1]);
	System.out.println("aber_was = " + java.util.Arrays.toString(aber_was));
	
	long a = 47, u = 11, d = 666;
	long[] aud = {a, u, d};
	aendere_etwas_anderes(aud);
	System.out.println("a = " + a + ", u = " + u + ", d = " + d);
//	
//	a = a +15;
//	System.out.println("a = " + a + ", u = " + u + ", d = " + d);
	
	aendere_etwas_anderes(FLUECHTIGES_FINALES_FELD);
	System.out.println("FLUECHTIGES_FINALES_FELD = " + java.util.Arrays.toString(FLUECHTIGES_FINALES_FELD));
}


public static void main (String[] args){
	Seiteneffekte.aendere_alles();
}

}
