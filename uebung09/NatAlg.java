
public class NatAlg {

	// Klausurfragen
	// warum muessen die Methoden static sein?

	// Modulo-Operator im Nat-Raum
	public static Nat mod(Nat a, Nat b) {

		Nat erg = Nat.div(a, b);
		erg = Nat.mul(erg, b);
		erg = Nat.sub(a, erg);

		return erg;
	}

	// < im Nat-Raum: zero b = false and succ(zero)b = true!
	public static Nat lt(Nat a, Nat b) {

		if (Nat.sub(a, b).equals(Nat.zero()))
			return Nat.succ(Nat.zero());

		return Nat.zero();
	}

	// "=" im Nat-Raum: zero b = false and succ(zero)b = true!
	public static Nat eq(Nat a, Nat b) {

		if (Nat.sub(a, b).equals(Nat.zero()) && Nat.sub(b, a).equals(Nat.zero()))
			return Nat.succ(Nat.zero());

		return Nat.zero();
	}

	// ">" im Nat-Raum: zero b = false and succ(zero)b = true!
	public static Nat gt(Nat a, Nat b) {

		if (Nat.sub(a, b).equals(Nat.zero()))
			return Nat.zero();

		return Nat.succ(Nat.zero());
	}

	// ggT im Nat Raum
	public static Nat gcd(Nat a, Nat b) {

		if (b.equals(Nat.zero())) {
			return b;
		}
		while (!b.equals(Nat.zero())) {
			if (!NatAlg.gt(a, b).equals(Nat.zero()))
				a = Nat.sub(a, b);
			else
				b = Nat.sub(b, a);
		}
		return a;

	}

	// kgV im Nat Raum
	public static Nat lcm(Nat a, Nat b) {

		return Nat.div(Nat.mul(a, b), gcd(a, b));
	}

	// Primfaktorzerlegung im Nat-Raum (aufsteigend sortiert!)
	public static EleList<Nat> pfz(Nat a) {

		Nat b = Nat.succ(Nat.succ(Nat.zero()));
		return pfzH(a, b);
	}

	private static EleList<Nat> pfzH(Nat a, Nat b) {

		// Es existieren zwei Basisfaelle:
		// 1 = Nat.succ(Nat.zero());
		// 0 = Nat.zero();
		// In beiden Faellen wird eine leere Liste zurueck gegeben
		if (Nat.sub(a, Nat.succ(Nat.zero())).equals(Nat.zero()))
			return new EleList<Nat>();

		// Ist die Zahl ohne Rest teilbar, ist sie Bestandtteil der Loesung
		if (mod(a, b).equals(Nat.zero())) {

			EleList<Nat> result = EleList.add(pfzH(Nat.div(a, b), b), b);
			if (result != null)
				return result;
		}

		// Ist die Zahl nur mit Rest teilbar, wird die Suche fortgesetzt
		return pfzH(a, Nat.succ(b));

	}
}