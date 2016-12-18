import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class UnimodaleSuchePublicTest {

	// ==================== Datentypen und Vergleicher ====================
	private static class LongDing {
		protected Long ding;

		private LongDing(Long ding) {
			this.ding = ding;
		}

		@Override
		public String toString() {
			return null;
		}
	}

	private static class LongDingComparable extends LongDing implements Comparable<LongDingComparable> {
		private LongDingComparable(Long ding) {
			super(ding);
		}

		@Override
		public int compareTo(LongDingComparable that) {
			return this.ding.compareTo(that.ding);
		}
	}

	private static class LongDingComparator extends LongDing {
		private LongDingComparator(Long ding) {
			super(ding);
		}
	}

	private static final Comparator<LongDingComparator> CLDC = new Comparator<LongDingComparator>() {
		@Override
		public int compare(LongDingComparator that, LongDingComparator other) {
			return that.ding.compareTo(other.ding);
		}
	};

	// ==================== Liste(n) ====================
	private static class UnimodaleListeLongDing<T> implements UnimodaleListe<T> {
		private ArrayList<T> alld = new ArrayList<>();

		private static UnimodaleListeLongDing<LongDingComparator> createComparator(int... dings) {
			UnimodaleListeLongDing<LongDingComparator> ulld = new UnimodaleListeLongDing<LongDingComparator>();
			for (int ding : dings) {
				ulld.alld.add(new LongDingComparator(Long.valueOf(ding)));
			}
			return ulld;
		}

		private static UnimodaleListeLongDing<LongDingComparable> createComparable(int... dings) {
			UnimodaleListeLongDing<LongDingComparable> ulld = new UnimodaleListeLongDing<LongDingComparable>();
			for (int ding : dings) {
				ulld.alld.add(new LongDingComparable(Long.valueOf(ding)));
			}
			return ulld;
		}

		@Override
		public T hole(int index) {
			StackTraceElement[] st = Thread.currentThread().getStackTrace();
			assertTrue("Die Anzahl der (rekursiven) Aufrufe stimmt nicht (der Stacktrace ist zu kurz).", st.length >= 2);
			assertEquals("Der vorletzte Aufruf sollten an uns gehen...", "hole", st[1].getMethodName());
			int rZneu = 0;
			for (StackTraceElement ste : st) {
				if (ste.getClassName().equals("UnimodaleSuche") && ste.getMethodName().equals("suche")) {
					rZneu++;
				}
			}
			rZ = rZ > rZneu ? rZ : rZneu;
			zZ++;
			return index < alld.size() ? alld.get(index) : null;
		}

		private long zZ = 0, rZ = 0; // Zugriffszaehler, Rekursionstiefenzaehler
	};

	// ==================== ALLGEMEINER ZENTRALER TEST ====================
	private void test_suche__CLASSIC(int expected, Comparator<LongDingComparator> c, int... dings) {
		UnimodaleListeLongDing<LongDingComparable> ulldComparable = UnimodaleListeLongDing.createComparable(dings);
		UnimodaleListeLongDing<LongDingComparator> ulldComparator = UnimodaleListeLongDing.createComparator(dings);
		String dingsString = "Liste: " + Arrays.toString(dings);
		dingsString = dingsString.length() <= 100 ? dingsString : dingsString.substring(0, 42) + "##...##" + dingsString.substring(dingsString.length() - 42);
		String sut = c == null ? "UnimodaleSuche_Comparable" : "UnimodaleSuche_Comparator";
		LongDing max = c == null ? UnimodaleSuche.suche(ulldComparable, 0, dings.length - 1) : UnimodaleSuche.suche(ulldComparator, 0, dings.length - 1, c);
		int o = 0, oRmin = 0, oZ = 0, oRmax = 0; // Laufzeiten i.S.v. Anzahl Listenzugriffe und Rekursionstiefen in O(log(n))
		long zZ = c == null ? ulldComparable.zZ : ulldComparator.zZ;
		long rZ = c == null ? ulldComparable.rZ : ulldComparator.rZ;
		if (dings.length <= 0) {
			assertNull(sut + "(" + dingsString + ") gibt faelschlich NICHT null zurueck!", max);
		} else {
			assertNotNull(sut + "(" + dingsString + ") gibt faelschlich null zurueck!", max);
			assertEquals(sut + "(" + dingsString + ") gibt falschen Wert zurueck!", Long.valueOf(expected), max.ding);
			o = (int) (Math.log(dings.length) / Math.log(2)); // !!! O(log(n)) !!!
			oZ = 2 * (o + 1);
			oRmin = o / 2;
			oRmax = o + 1;
		}
		assertTrue(sut + "(" + dingsString + ") hat falsche \"O-Laufzeit\"! IST: " + zZ + " vs. SOLL: # <=" + oZ, zZ <= oZ);
		assertTrue(sut + "(" + dingsString + ") hat falsche Rekursionstiefe! IST: " + rZ + " vs. SOLL: " + oRmin + "<= # <=" + oRmax, oRmin <= rZ && rZ <= oRmax);
	}

	// ==================== ANTI_CHEAT_SALTED_TEST ====================
	private void test_suche__ANTI_CHEAT_SALTED(int splitPos, Comparator<LongDingComparator> c, int[] primes) {
		for (int pass = 1; pass <= 3; pass++) {
			int antiCheatSaltedSplitPos = splitPos + ((int) (666 * Math.random())) - 333;
			int antiCheatSaltedExpectedSalt = 666 + (int) (4711 * Math.random());
			int[] bentPrimes = bendPrimes(primes, antiCheatSaltedSplitPos);
			bentPrimes[antiCheatSaltedSplitPos] += antiCheatSaltedExpectedSalt;
			int expected = bentPrimes[antiCheatSaltedSplitPos];
			test_suche__CLASSIC(expected, c, bentPrimes);
		}
	}

	private static final int[] computePrimes(int amount) {
		boolean isPrime;
		int[] primes = new int[amount];
		primes[0] = primes[amount - 1] = 2;
		for (int i = 1; i < amount; i++) {
			primes[i] = primes[i - 1];
			do {
				isPrime = true;
				primes[i]++;
				for (int p = 0; p < i && isPrime; p++) {
					isPrime = primes[i] % primes[p] != 0;
				}
			} while (!isPrime);
		}
		return primes;
	}

	private static final int[] PRIMES__10_000 = computePrimes(10_000);
	private static final int[] PRIMES__100_000 = computePrimes(100_000);

	private static final int[] bendPrimes(int[] primes, int splitPos) {
		int[] bentPrimes = new int[primes.length];
		for (int i = 0; i < primes.length - 1; i++) {
			if (0 <= splitPos - i) {
				bentPrimes[splitPos - i] = primes[primes.length - 1 - i];
			}
			if (splitPos + i < bentPrimes.length) {
				bentPrimes[splitPos + i] = primes[primes.length - 1 - i];
			}
		}
		return bentPrimes;
	}

	// ==================== TEST - Comparable ====================
	@Test(timeout = 666)
	public void test_suche_Comparable__Beispiel_Aufgabenblatt_MitAntiCheatSalt_und_ArgCheck__PUBLIC_TEST() {
		test_suche__CLASSIC(37, null, 13, 17, 19, 23, 29, 31, 37, 7, 5);
		// ANTI-CHEAT-SALT:
		test_suche__ANTI_CHEAT_SALTED(5_000, null, PRIMES__10_000);
		// ARG-CHECK:
		assertNull("CHECK YOUR ARGUMENTS! Loesung gibt faelschlich NICHT null zurueck!", UnimodaleSuche.suche(null, 1, 42));
		UnimodaleListeLongDing<LongDingComparable> ulldComparable = UnimodaleListeLongDing.createComparable(13, 17, 19, 23, 29, 31, 37, 7, 5);
		for (int von = -7; von <= 7; von++) {
			for (int bis = -7; bis < 0 || bis < von; bis++) {
				assertNull("CHECK YOUR ARGUMENTS! Loesung gibt faelschlich NICHT null zurueck!", UnimodaleSuche.suche(ulldComparable, von, bis));
			}
		}
	}

	@Test(timeout = 666)
	public void test_suche_Comparable__666_PRIMES_10_000__PUBLIC_TEST() {
		test_suche__ANTI_CHEAT_SALTED(666, null, PRIMES__10_000);
	}

	@Test(timeout = 666)
	public void test_suche_Comparable__6_666_PRIMES_10_000__PUBLIC_TEST() {
		test_suche__ANTI_CHEAT_SALTED(6_666, null, PRIMES__10_000);
	}

	@Test(timeout = 6666)
	public void test_suche_Comparable__4711_PRIMES_100_000__PUBLIC_TEST() {
		test_suche__ANTI_CHEAT_SALTED(4_711, null, PRIMES__100_000);
	}

	@Test(timeout = 6666)
	public void test_suche_Comparable__7_0815_PRIMES_100_000__PUBLIC_TEST() {
		test_suche__ANTI_CHEAT_SALTED(70_815, null, PRIMES__100_000);
	}

	// ==================== TEST - Comparator ====================
	@Test(timeout = 666)
	public void test_suche_Comparator__Beispiel_Aufgabenblatt_MitAntiCheatSalt_und_ArgCheck__PUBLIC_TEST() {
		test_suche__CLASSIC(37, CLDC, 13, 17, 19, 23, 29, 31, 37, 7, 5);
		// ANTI-CHEAT-SALT:
		test_suche__ANTI_CHEAT_SALTED(5_000, CLDC, PRIMES__10_000);
		// ARG-CHECK:
		assertNull("CHECK YOUR ARGUMENTS! Loesung gibt faelschlich NICHT null zurueck!", UnimodaleSuche.suche(null, 1, 42, CLDC));
		UnimodaleListeLongDing<LongDingComparator> ulldComparator = UnimodaleListeLongDing.createComparator(13, 17, 19, 23, 29, 31, 37, 7, 5);
		for (int von = -7; von <= 7; von++) {
			for (int bis = -7; bis < 0 || bis < von; bis++) {
				assertNull("CHECK YOUR ARGUMENTS! Loesung gibt faelschlich NICHT null zurueck!", UnimodaleSuche.suche(ulldComparator, von, bis, CLDC));
			}
		}
	}

	@Test(timeout = 666)
	public void test_suche_Comparator__666_PRIMES_10_000__PUBLIC_TEST() {
		test_suche__ANTI_CHEAT_SALTED(666, CLDC, PRIMES__10_000);
	}

	@Test(timeout = 666)
	public void test_suche_Comparator__6_666_PRIMES_10_000__PUBLIC_TEST() {
		test_suche__ANTI_CHEAT_SALTED(6_666, CLDC, PRIMES__10_000);
	}

	@Test(timeout = 6666)
	public void test_suche_Comparator__4711_PRIMES_100_000__PUBLIC_TEST() {
		test_suche__ANTI_CHEAT_SALTED(4_711, CLDC, PRIMES__100_000);
	}

	@Test(timeout = 6666)
	public void test_suche_Comparator__7_0815_PRIMES_100_000__PUBLIC_TEST() {
		test_suche__ANTI_CHEAT_SALTED(70_815, CLDC, PRIMES__100_000);
	}

	// ==================== main ====================
	// nothing to do ;) - please do nothing here:
	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar $(ls * | grep PublicTest.class | sed s/.class//)

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}