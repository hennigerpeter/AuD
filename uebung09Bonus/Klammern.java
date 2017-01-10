
import java.util.*;

public class Klammern {

	static List<String> mylist = new ArrayList<String>();

	public static List<String> klammern(String input) {

		mylist.add(input);
		mylist.add(klammeraussen(input));

		for (int i = 1; i < input.length(); i++) {
			String string1 = input.substring(0, i) + klammeraussen(input.substring(i));
			String string2 = klammeraussen(input.substring(0, i)) + input.substring(i);

			if (valid(string1))
				mylist.add(string1);
			if (valid(string2))
				mylist.add(string2);
			
			for (int j = 0; j < string1.length(); j++) {
				String string3 = string1.substring(0, j) + klammeraussen(string1.substring(j));
				String string4 = klammeraussen(string1.substring(0, j)) + string1.substring(j, string1.length());

				if (valid(string3))
					mylist.add(string3);
				if (valid(klammeraussen(string3)))
					mylist.add(klammeraussen(string3));
				if (valid(string4))
					mylist.add(string4);
				if (valid(klammeraussen(string4)))
					mylist.add(klammeraussen(string4));
			}

			for (int k = 0; k < string2.length(); k++) {
				String string3 = string2.substring(0, k) + klammeraussen(string2.substring(k));
				String string4 = klammeraussen(string2.substring(0, k)) + string2.substring(k, string2.length());

				if (valid(string3))
					mylist.add(string3);
				if (valid(string4))
					mylist.add(string4);

			}
		}

		System.out.println(mylist.toString());
		return mylist;
	}

	private static boolean valid(String input) {

		// filter: ((a))
		for (int i = 0; i < input.length(); i++)
			if (input.charAt(i) == '(')
				if (input.charAt(i + 1) == '(')
					if (input.charAt(i + 3) == ')')
						if (input.charAt(i + 4) == ')')
							return false;

		// Keine Eintraege mit nutzlosen Klammern
		if (!input.contains("()"))
			if(!input.contains(")))"))
				if(!input.contains("((("))
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

}
