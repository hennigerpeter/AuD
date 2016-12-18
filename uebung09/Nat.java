public abstract class Nat {
	// ===== OPS: PRIMARY CONS =============================================================
	public static Nat zero() {
		return zero;
	}

	public static Nat succ(Nat n) {
		return new Nat(n) {
		};
	}

	// ===== OPS: SECONDARY CONS =============================================================
	public static Nat add(Nat x, Nat y) {
		return x == zero ? y : succ(add(pred(x), y));
	}

	public static Nat sub(Nat x, Nat y) {
		return x == zero ? zero : y == zero ? x : sub(pred(x), pred(y));
	}

	public static Nat mul(Nat x, Nat y) {
		return x == zero ? zero : add(y, mul(pred(x), y));
	}

	public static Nat div(Nat x, Nat y) {
		return sub(y, x) != zero ? zero : add(succ(zero), div(sub(x, y), y));
	}

	// ===== HMI ==============================================================
	@Override
	public String toString() {
		return this == zero ? "z" : "S" + pred(this);
	}

	// ===== INTERNALS ========================================================
	private static final Nat zero = new Nat(null) {
	}; // internal marker object for zero

	private final Nat p; // internal predecessor

	private Nat(Nat n) { // internal constructor
		this.p = n;
	}

	private static Nat pred(Nat n) { // internal projection
		return n == zero ? zero : n.p;
	}
}