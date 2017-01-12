
import java.util.*;

public class Entklammern {

	public static EntklammernAbstrakterKnoten entklammern(String s) {

		// Parameter Validation
		if (s == "" || s == null)
			throw new IllegalArgumentException();

		// Variables
		int offeneKlammer = 0;
		String currentOhneKlammer = "";
		String currentInKlammer = "";

		List<EntklammernAbstrakterKnoten> kinder = new LinkedList<EntklammernAbstrakterKnoten>();
		EntklammernAbstrakterKnoten BlattMitKnoten = null;
		EntklammernAbstrakterKnoten Knoten = null;
		// Parser
		for (char c : s.toCharArray()) {

			if (c == ')') {
				if (offeneKlammer == 0)
					throw new IllegalArgumentException();

				// Fall: "(AUD)" erhaelt einen eigenen Knoten
				BlattMitKnoten = new EntklammernBlatt(currentInKlammer);
				Knoten = new EntklammernKnoten(BlattMitKnoten);
				kinder.add(Knoten);

				// Fuer die weitere Verarbeitung
				currentInKlammer = "";
				currentOhneKlammer = "";
				offeneKlammer--;
			}

			else if (c == '(') {

				// Fall: "AUD" erhaelt keinen eigenen Knoten, das Blatt wird
				// direkt angehaengt
				if (offeneKlammer == 0) {
					if (currentOhneKlammer != "") {
						EntklammernAbstrakterKnoten BlattOhneKnoten = new EntklammernBlatt(currentOhneKlammer);
						kinder.add(BlattOhneKnoten);
					}
				}

				currentOhneKlammer = "";
				offeneKlammer++;
			} else {
				currentInKlammer = currentInKlammer + c;
				currentOhneKlammer = currentOhneKlammer + c;
			}
		}
		// Fall: Am Ende kam noch ein String ohne Klammern
		if (currentOhneKlammer != "") {
			EntklammernAbstrakterKnoten BlattOhneKnoten = new EntklammernBlatt(currentOhneKlammer);
			kinder.add(BlattOhneKnoten);
		}

		// Beispiel: "(AuD)PFP"
		// Knoten mit neuem Blatt erzeugen
		// EntklammernAbstrakterKnoten blattLinks = new EntklammernBlatt("AuD");
		// EntklammernAbstrakterKnoten blattRechts = new
		// EntklammernBlatt("PFP");
		// EntklammernAbstrakterKnoten knotenLinks = new
		// EntklammernKnoten(blattLinks);

		// List<EntklammernAbstrakterKnoten> kinder = new LinkedList<>();
		// kinder.add(knotenLinks);
		// kinder.add(blattRechts);

		// Build Result
		EntklammernAbstrakterKnoten Stamm = new EntklammernMischKnoten(kinder);

//		if (Stamm.kinder().size() == 1) {
//			if (Stamm.kinder().get(0).kinder().size() == 0)
//				return Stamm.kinder().get(0);
//		}

		return Stamm;
	}

	// public static void main(String[] args) {
	// EntklammernAbstrakterKnoten test = entklammern("(AUD)PFP");
	// System.out.println(test.toString());
	// }
}