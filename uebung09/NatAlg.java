public class NatAlg {
	
	// Klausurfragen
	// warum muessen die Methoden static sein?
	
	
	// Modulo-Operator im Nat-Raum
	public Nat mod(Nat a, Nat b){
		
		Nat erg = Nat.div(a, b);
		erg = Nat.mul(erg, b);
		erg = Nat.sub(a, erg);
		
		return erg;
	}
	
	// < im Nat-Raum: zero b = false and succ(zero)b = true!
	public static Nat lt(Nat a, Nat b){
		
		return Nat.sub(a, b);
	}
	
	// "=" im Nat-Raum: zero b = false and succ(zero)b = true! 
	public static Nat eq(Nat a, Nat b){
		
		return a;
	}
	
	// ">" im Nat-Raum: zerob = false and succ(zero)b = true! 
	public static Nat gt(Nat a, Nat b){
		
		return Nat.sub(a, b);
	}
	
	// ggT im Nat Raum 
	public static Nat gcd(Nat a, Nat b){
	
		return a;
	}
	
	// kgV im Nat Raum
	public static Nat lcm(Nat a, Nat b){
	
		return a;
	}

	// Primfaktorzerlegung im Nat-Raum (aufsteigend sortiert!)
	public static EleList<Nat> pfz(Nat a){
		
		return new EleList<Nat>();
	}
}