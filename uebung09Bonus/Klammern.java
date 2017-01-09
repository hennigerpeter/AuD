
import java.util.*;

public class Klammern {

	static List<String> mylist = new ArrayList<String>();

	public static List<String> klammern(String input) {
		/*
		 * mylist.add(input); mylist.add(klammeraussen(input));
		 * 
		 * for (int i = 1; i < input.length(); i++) { String string1 =
		 * input.substring(0, i) + klammeraussen(input.substring(i)); String
		 * string2 = klammeraussen(input.substring(0, i)) + input.substring(i,
		 * input.length());
		 * 
		 * for (int j = 1; j < string1.length(); j++) { String string3 =
		 * string1.substring(0, j) + klammeraussen(string1.substring(j)); String
		 * string4 = klammeraussen(string1.substring(0, j)) +
		 * string1.substring(j, string1.length());
		 * 
		 * if (valid(string3)) mylist.add(string3); if (valid(string4))
		 * mylist.add(string4);
		 * 
		 * }
		 * 
		 * for (int k = 1; k < string2.length(); k++) { String string3 =
		 * string2.substring(0, k) + klammeraussen(string2.substring(k)); String
		 * string4 = klammeraussen(string2.substring(0, k)) +
		 * string2.substring(k, string2.length());
		 * 
		 * if (valid(string3)) mylist.add(string3); if (valid(string4))
		 * mylist.add(string4);
		 * 
		 * } }
		 */
		stringDurchballern(input);
		System.out.println(mylist.toString());
		return mylist;
	}

	private static boolean valid(String input) {

		// Keine Eintraege mit nutzlosen Klammern
		if (!input.contains("()"))
			// Keine Eintraege welche bereits in der Liste enthalten sind
			if (!mylist.contains(input))
				return true;

		return false;

	}

	private static String klammeraussen(String input) {
		return "(" + input + ")";
	}

	/*
	 * 
	 * "ab", "(a)b", "a(b)", "(ab)"
	 * 
	 * "((a)(b))", "(a)(b)", "((a)b)", "(a(b))"
	 */

	private static void stringDurchballern(String input) {

		/*
		 * Fuer jede Position im String soll es drei Moeglichkeiten geben:
		 * Klammer auf (bis zu zwei mal), Klammer zu, Tue Nichts
		 */
		int maxKlammerOffen = 2;
		int klammerOffen = getOffeneKlammern(input);
		int klammerZu = getGeschlosseneKlammern(input);

		for (int pos = 0; pos < input.length(); pos++) {

			if (klammerOffen == klammerZu) {
				if (valid(input))
					mylist.add(input);

			}

			if (klammerOffen > klammerZu) {
				String foo = klammerZu(input, pos);

				int klammerOffenfoo = getOffeneKlammern(foo);
				int klammerZufoo = getGeschlosseneKlammern(foo);

				if (klammerOffenfoo == klammerZufoo) {
					if (valid(foo))
						mylist.add(foo);

				}
			}

			if (klammerOffen < maxKlammerOffen) {
				String foo = klammerAuf(input, pos);

				int klammerOffenfoo = getOffeneKlammern(foo);
				int klammerZufoo = getGeschlosseneKlammern(foo);

				if (klammerOffenfoo == klammerZufoo) {
					if (valid(foo))
						mylist.add(foo);

				}
			}

		}

	}

	private static int getGeschlosseneKlammern(String input) {
		int count = 0;
		for (int pos = 0; pos < input.length(); pos++) {
			if (input.charAt(pos) == '(')
				count++;
		}
		return count;
	}

	private static int getOffeneKlammern(String input) {
		int count = 0;
		for (int pos = 0; pos < input.length(); pos++) {
			if (input.charAt(pos) == ')')
				count++;
		}
		return count;
	}

	private static String klammerAuf(String input, int pos) {
		String uno = input.substring(0, pos);
		String due = input.substring(pos);
		return uno + "(" + due;
	}

	private static String klammerZu(String input, int pos) {
		String uno = input.substring(0, pos);
		String due = input.substring(pos);
		return uno + ")" + due;
	}

	private static String tueNichts(String input, int pos) {
		return input;
	}

}
