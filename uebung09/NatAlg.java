
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

		return a;
	}

	// Primfaktorzerlegung im Nat-Raum (aufsteigend sortiert!)
	public static EleList<Nat> pfz(Nat a) {

		return new EleList<Nat>();
	}

	private static EleList<Nat> pfzH(Nat a, Nat b) {
		EleList<Nat> list = new EleList<Nat>();
		return list;

	}
}