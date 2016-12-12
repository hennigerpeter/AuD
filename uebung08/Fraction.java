public class Fraction {

	private long numerator;
	private long denominator;

	private static long ggT(long a, long b) {
		if (b == 0)
			return a;
		return ggT(b, a % b);
	}

	public Fraction(long numerator, long denominator) {
		
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return "[ " + numerator + " / " + denominator + " ]";
	}

	public void simplify() {
		// TODO
		
		Fraction blub = new Fraction(getNumerator(), getDenominator());
		long ggT = ggT(blub.getDenominator(), blub.getNumerator());
		
		this.denominator /= ggT;
		this.numerator  /= ggT;
		
		if(numerator < 0 && denominator < 0){
			this.numerator = Math.abs(this.numerator);
			this.denominator = Math.abs(this.denominator);
		} else if (denominator < 0 || numerator < 0){
			this.denominator = Math.abs(denominator);
			this.numerator = Math.abs(numerator) * -1L;
		}
	}

	public Fraction mul(Fraction other) {
		// TODO
		
		try {
			Fraction blrb = new Fraction(other.getNumerator(), other.getDenominator());
			
			blrb.denominator *= getDenominator();
			blrb.numerator *= getNumerator();

			blrb.simplify();
			
			return blrb;
			
		} catch (NullPointerException exc) {
			IllegalArgumentException exc2 = new IllegalArgumentException();
			throw exc2;
		} 
		
	}

	public Fraction div(Fraction other) {
		// TODO
		try {
			
			Fraction plauz = new Fraction(this.getNumerator(), this.getDenominator());
	
			plauz.numerator *= other.getDenominator();
			plauz.denominator *= other.getNumerator(); 
	
			plauz.simplify();
	
			return plauz;
		
		} catch (NullPointerException exc) {
			IllegalArgumentException exc2 = new IllegalArgumentException();
			throw exc2;
		} 
	}

	public Fraction add(Fraction other) {
		// TODO
		
		try {
			Fraction flurp = new Fraction(other.getNumerator(), other.getDenominator());
			Fraction maa = new Fraction(getNumerator(), getDenominator());
	
			// Brueche erweitern
			flurp.denominator *= maa.getDenominator();
			flurp.numerator *= maa.getDenominator();
	
			maa.denominator *= flurp.getDenominator();
			maa.numerator *= flurp.getDenominator();
			
			// Brueche addieren
			flurp.numerator += maa.getNumerator();
			flurp.simplify();
	
			return flurp;
		} catch (NullPointerException exc) {
			IllegalArgumentException exc2 = new IllegalArgumentException();
			throw exc2;
		} 
	}

	public Fraction sub(Fraction other) {
		// TODO
		try {
			
		
			Fraction flurp = new Fraction(other.getNumerator(), other.getDenominator());
			Fraction maa = new Fraction(getNumerator(), getDenominator());
	
			// Brueche erweitern
			flurp.denominator *= maa.getDenominator();
			flurp.numerator *= maa.getDenominator();
	
			maa.denominator *= flurp.getDenominator();
			maa.numerator *= flurp.getDenominator();
			
			// Brueche addieren
			maa.numerator -= flurp.getNumerator();
			maa.simplify();
	
			return maa;
			
		} catch (NullPointerException exc) {
			IllegalArgumentException exc2 = new IllegalArgumentException();
			throw exc2;
	} 
	}

	public int compareTo(Fraction other) {
		// TODO
		try {
			
			Fraction temp = new Fraction(getNumerator(), getDenominator());
			Fraction comp = new Fraction(other.getNumerator(), other.getDenominator());
			
			temp.simplify();
			comp.simplify();
	
			long t = temp.getNumerator() / temp.getDenominator();
			long c = comp.getNumerator() / comp.getDenominator();
	
			if (t==c)
				return 0;
			if (c<t)
				return -1;
			
			return 1;
		} catch (NullPointerException exc) {
			IllegalArgumentException exc2 = new IllegalArgumentException();
			throw exc2;
		} 
	}

	public boolean isNonNegative() {
		// TODO
		Fraction temp = new Fraction(getNumerator(), getDenominator());
		temp.simplify();

		if (temp.numerator < 0)
			return false;

		return true;
	}
}
