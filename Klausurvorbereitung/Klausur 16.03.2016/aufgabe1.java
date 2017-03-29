public class aufgabe1 {

	static String s1 = "";
	static String s2 = "";

	// 1) Wirft Fehler
	// boolean istNull = null.equals(s1);

	public static void main(String[] args) {

		// 2) Kein Fehler
		if (s1 == s2)
			System.out.println("sind gleich");

		// 3) Wirft Fehler
		boolean b = s1.charAt(s1.length()) == s2.charAt(0);

		// 4) Kein Fehler
		int i = s1.toUpperCase().indexOf("null");
	}

}