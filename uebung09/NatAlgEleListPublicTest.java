import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;

public class NatAlgEleListPublicTest {

	// ==================== define some Nats... ====================
	private static final Nat[] n;
	static {
		n = new Nat[666];
		n[0] = Nat.zero();
		for (int i = 1; i < n.length; i++) {
			n[i] = Nat.succ(n[i - 1]);
		}
	}

	// ==================== Intestines: EleList ====================
	@Test(timeout = 666)
	public void test_EleList_intestines_THIS_TEST_IS_VERY_IMPORTANT_IF_IT_FAILS_THEN_YOU_WILL_GET_NO_POINTS_AT_ALL() {
		try {
			Class<?> clazz = Class.forName("EleList");
			assertFalse("Ist keine Klasse sondern eine Annotation.", clazz.isAnnotation());
			assertFalse("Ist keine Klasse sondern ein Enum.", clazz.isEnum());
			assertFalse("Ist keine Klasse sondern ein Interface.", clazz.isInterface());
			assertFalse("Ist faelschlicherweise >abstract<", Modifier.isAbstract(clazz.getModifiers()));
			assertEquals("Darf keine Schnittstelle implementieren.", 0, clazz.getInterfaces().length);
			assertEquals("Muss direkt von Object erben.", Object.class, clazz.getSuperclass());
			assertEquals("Hat falsche Anzahl an anderen Schweinereien.", 0, clazz.getDeclaredAnnotations().length);
			assertEquals("Hat falsche Anzahl an anderen Innereien.", 0, clazz.getDeclaredClasses().length);
			assertEquals("Hat falsche Anzahl an Konstruktoren.", 1, clazz.getDeclaredConstructors().length);
			assertEquals("Hat falsche Anzahl an Attributen.", 2, clazz.getDeclaredFields().length);
			assertEquals("Hat falsche Anzahl an Methoden.", 4, clazz.getDeclaredMethods().length);
			Constructor<?> constructor = clazz.getDeclaredConstructor(); // default cons!
			assertNotNull("Konstruktor inkl. -parameter: inkorrekt", constructor);
			assertTrue("Konstruktor inkl. -parameter: Sichtbarkeit ist nicht >public<", Modifier.isPublic(constructor.getModifiers()));
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				assertTrue(field + " - Feld: Sichtbarkeit ist nicht >private<", Modifier.isPrivate(field.getModifiers()));
				assertFalse(field + " - Feld: Ist kein Instanzattribut", Modifier.isStatic(field.getModifiers()));
			}
			assertTrue("Felder haben falschen Typ: eines muss EleList sein.", fields[0].getType().equals(EleList.class) || fields[1].getType().equals(EleList.class));
			assertTrue("Felder haben falschen Typ: eines muss generisch (wg. type erasure dann Object) sein.", fields[0].getType().equals(Object.class) || fields[1].getType().equals(Object.class));
			for (Method method : clazz.getDeclaredMethods()) {
				assertTrue(method + " - Methode: Sichtbarkeit ist nicht >public<", Modifier.isPublic(method.getModifiers()));
				assertTrue(method + " - Methode: Ist faelschlicherweise Instanzmethode.", Modifier.isStatic(method.getModifiers()));
				assertFalse(method + " - Methode: Ist faelschlicherweise >abstract<", Modifier.isAbstract(method.getModifiers()));
				switch (method.getName()) {
				case "create":
					assertEquals(method + " - Methode: Hat falsche Anzahl Parameter.", 0, method.getParameterTypes().length);
					assertEquals(method + " - Methode: Hat falsche Anzahl Parameter.", 0, method.getParameterTypes().length);
					assertEquals(method + " - Methode: Rueckgabetyp ist falsch.", EleList.class, method.getReturnType());
					break;
				case "add":
					assertEquals(method + " - Methode: Hat falsche Anzahl Parameter.", 2, method.getParameterTypes().length);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", EleList.class, method.getParameterTypes()[0]);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", Object.class, method.getParameterTypes()[1]); // generic type => type erasure!
					assertEquals(method + " - Methode: Rueckgabetyp ist falsch.", EleList.class, method.getReturnType());
					break;
				case "head":
					assertEquals(method + " - Methode: Hat falsche Anzahl Parameter.", 1, method.getParameterTypes().length);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", EleList.class, method.getParameterTypes()[0]);
					assertEquals(method + " - Methode: Rueckgabetyp ist falsch.", Object.class, method.getReturnType()); // generic type => type erasure!
					break;
				case "tail":
					assertEquals(method + " - Methode: Hat falsche Anzahl Parameter.", 1, method.getParameterTypes().length);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", EleList.class, method.getParameterTypes()[0]);
					assertEquals(method + " - Methode: Rueckgabetyp ist falsch.", EleList.class, method.getReturnType());
					break;
				default:
					fail("Unbekannte Methode: " + method);
				}
			}
		} catch (ClassNotFoundException e) {
			fail("Klasse nicht gefunden: " + e.getMessage());
		} catch (NoSuchMethodException e) {
			fail("Konstruktor oder Methoden nicht gefunden oder inkorrekt: " + e.getMessage());
		}
	}

	// ==================== Intestines: NatAlg ====================
	@Test(timeout = 666)
	public void test_NatAlg_intestines_THIS_TEST_IS_VERY_IMPORTANT_IF_IT_FAILS_THEN_YOU_WILL_GET_NO_POINTS_AT_ALL() {
		try {
			Class<?> clazz = Class.forName("NatAlg");
			assertFalse("Ist keine Klasse sondern eine Annotation.", clazz.isAnnotation());
			assertFalse("Ist keine Klasse sondern ein Enum.", clazz.isEnum());
			assertFalse("Ist keine Klasse sondern ein Interface.", clazz.isInterface());
			assertFalse("Ist faelschlicherweise >abstract<", Modifier.isAbstract(clazz.getModifiers()));
			assertEquals("Darf keine Schnittstelle implementieren.", 0, clazz.getInterfaces().length);
			assertEquals("Muss direkt von Object erben.", Object.class, clazz.getSuperclass());
			assertEquals("Hat falsche Anzahl an anderen Schweinereien.", 0, clazz.getDeclaredAnnotations().length);
			assertEquals("Hat falsche Anzahl an anderen Innereien.", 0, clazz.getDeclaredClasses().length);
			assertEquals("Hat falsche Anzahl an Konstruktoren.", 1, clazz.getDeclaredConstructors().length);
			if (clazz.getDeclaredFields().length == 1) {
				assertEquals("Hat unerwartete Attribute.", "$assertionsDisabled", clazz.getDeclaredFields()[0].getName());
			} else {
				assertEquals("Hat falsche Anzahl an Attributen.", 0, clazz.getDeclaredFields().length);
			}
			assertEquals("Hat falsche Anzahl an Methoden.", 8, clazz.getDeclaredMethods().length);
			Constructor<?> constructor = clazz.getDeclaredConstructor(); // default cons!
			assertNotNull("Konstruktor inkl. -parameter: inkorrekt", constructor);
			assertTrue("Konstruktor inkl. -parameter: Sichtbarkeit ist nicht >public<", Modifier.isPublic(constructor.getModifiers()));
			for (Method method : clazz.getDeclaredMethods()) {
				assertTrue(method + " - Methode: Ist faelschlicherweise Instanzmethode.", Modifier.isStatic(method.getModifiers()));
				assertFalse(method + " - Methode: Ist faelschlicherweise >abstract<", Modifier.isAbstract(method.getModifiers()));
				if (method.getName().equals("pfz")) {
					assertTrue(method + " - Methode: Sichtbarkeit ist nicht >public<", Modifier.isPublic(method.getModifiers()));
					assertEquals(method + " - Methode: Hat falsche Anzahl Parameter.", 1, method.getParameterTypes().length);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", Nat.class, method.getParameterTypes()[0]);
					assertEquals(method + " - Methode: Rueckgabetyp ist falsch.", EleList.class, method.getReturnType());
				} else if (method.getName().equals("pfzH")) {
					assertTrue(method + " - Methode: Sichtbarkeit ist nicht >private<", Modifier.isPrivate(method.getModifiers()));
					assertEquals(method + " - Methode: Hat falsche Anzahl Parameter.", 2, method.getParameterTypes().length);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", Nat.class, method.getParameterTypes()[0]);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", Nat.class, method.getParameterTypes()[1]);
					assertEquals(method + " - Methode: Rueckgabetyp ist falsch.", EleList.class, method.getReturnType());
				} else {
					assertTrue(method + " - Methode: Sichtbarkeit ist nicht >public<", Modifier.isPublic(method.getModifiers()));
					assertEquals(method + " - Methode: Hat falsche Anzahl Parameter.", 2, method.getParameterTypes().length);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", Nat.class, method.getParameterTypes()[0]);
					assertSame(method + " - Methode: Hat falsche Parametertypen.", Nat.class, method.getParameterTypes()[1]);
					assertEquals(method + " - Methode: Rueckgabetyp ist falsch.", Nat.class, method.getReturnType());
				}
			}
		} catch (ClassNotFoundException e) {
			fail("Klasse nicht gefunden: " + e.getMessage());
		} catch (NoSuchMethodException e) {
			fail("Konstruktor oder Methoden nicht gefunden oder inkorrekt: " + e.getMessage());
		}
	}

	// ==================== EleList ====================
	@Test(timeout = 666)
	public void test_EleList_head_tail_of_null_or_new_EleList__PUBLIC_TEST() {
		assertNull("head von null muss null sein.", EleList.head(null));
		assertNull("tail von null muss null sein.", EleList.tail(null));
		EleList<Nat> els = new EleList<Nat>();
		Nat head = EleList.head(els);
		EleList<Nat> tail = EleList.tail(els);
		assertNull("head von leerer EleList muss null sein.", head);
		assertNull("tail von leerer EleList muss null sein.", tail);
	}

	@Test(timeout = 666)
	public void test_EleList_nonempty_EleList__PUBLIC_TEST() {
		EleList<String> els0 = new EleList<String>();
		EleList<String> els1a = EleList.add(els0, "AuD");
		EleList<String> els1b = EleList.add(els0, "PFP");
		EleList<String> els2a = EleList.add(els1a, "FAUL");
		EleList<String> els2b = EleList.add(els1b, "FAIL");
		EleList<String> els1x = EleList.tail(els2a);
		EleList<String> els1y = EleList.tail(els2b);
		EleList<String> els0x = EleList.tail(els1x);
		EleList<String> els0y = EleList.tail(els1y);
		String head2a = EleList.head(els2a);
		String head2b = EleList.head(els2b);
		assertNotNull("add, head oder tail (oder alles!?) ist fehlerhaft.", head2a);
		assertNotNull("add, head oder tail (oder alles!?) ist fehlerhaft.", head2b);
		assertEquals("add, head oder tail (oder alles!?) ist fehlerhaft.", "FAUL", EleList.head(els2a));
		assertEquals("add, head oder tail (oder alles!?) ist fehlerhaft.", "FAIL", EleList.head(els2b));
		assertEquals("add, head oder tail (oder alles!?) ist fehlerhaft.", "AuD", EleList.head(els1a));
		assertEquals("add, head oder tail (oder alles!?) ist fehlerhaft.", "PFP", EleList.head(els1b));
		assertEquals("add, head oder tail (oder alles!?) ist fehlerhaft.", "AuD", EleList.head(els1x));
		assertEquals("add, head oder tail (oder alles!?) ist fehlerhaft.", "PFP", EleList.head(els1y));
		assertNull("head von leerer EleList muss null sein.", EleList.head(els0));
		assertNull("tail von leerer EleList muss null sein.", EleList.tail(els0));
		assertNull("head von leerer EleList muss null sein.", EleList.head(els0x));
		assertNull("tail von leerer EleList muss null sein.", EleList.tail(els0y));
	}

	// ==================== NatAlg.mod ====================
	@Test(timeout = 666)
	public void test_NatAlg_mod__42_mod_7_is_0__and__42_mod_9_is_6__PUBLIC_TEST() {
		assertSame("NatAlg.mod(n[42], n[7])", n[0], NatAlg.mod(n[42], n[7]));
		assertSame("Nat.sub(n[6], NatAlg.mod(n[42], n[9]))", n[0], Nat.sub(n[6], NatAlg.mod(n[42], n[9])));
		assertSame("Nat.sub(NatAlg.mod(n[42], n[9]), n[6])", n[0], Nat.sub(NatAlg.mod(n[42], n[9]), n[6]));
	}

	// ==================== NatAlg.lt ====================
	@Test(timeout = 666)
	public void test_NatAlg_eq__42_lt_69_is_1__and__69_lt_42_is_0__PUBLIC_TEST() {
		assertSame("Nat.sub(n[1], NatAlg.lt(n[42], n[69]))", n[0], Nat.sub(n[1], NatAlg.lt(n[42], n[69])));
		assertSame("Nat.sub(NatAlg.lt(n[42], n[69]), n[1])", n[0], Nat.sub(NatAlg.lt(n[42], n[69]), n[1]));
		assertSame("NatAlg.lt(n[69], n[42])", n[0], NatAlg.lt(n[69], n[42]));
	}

	// ==================== NatAlg.eq ====================
	@Test(timeout = 666)
	public void test_NatAlg_eq__3p5_eq_8__and__8_eq_3p5__PUBLIC_TEST() {
		assertSame("Nat.sub(n[1], NatAlg.eq(Nat.add(n[3], n[5]), n[8]))", n[0], Nat.sub(n[1], NatAlg.eq(Nat.add(n[3], n[5]), n[8])));
		assertSame("Nat.sub(NatAlg.eq(Nat.add(n[3], n[5]), n[8]), n[1])", n[0], Nat.sub(NatAlg.eq(Nat.add(n[3], n[5]), n[8]), n[1]));
		assertSame("Nat.sub(n[1], NatAlg.eq(n[8], Nat.add(n[3], n[5])))", n[0], Nat.sub(n[1], NatAlg.eq(n[8], Nat.add(n[3], n[5]))));
		assertSame("Nat.sub(NatAlg.eq(n[8], Nat.add(n[3], n[5])), n[1])", n[0], Nat.sub(NatAlg.eq(n[8], Nat.add(n[3], n[5])), n[1]));
	}

	// ==================== NatAlg.gt ====================
	@Test(timeout = 666)
	public void test_NatAlg_eq__42_gt_69_is_0__and__69_gt_42_is_1__PUBLIC_TEST() {
		assertSame("NatAlg.gt(n[42], n[69])", n[0], NatAlg.gt(n[42], n[69]));
		assertSame("Nat.sub(n[1], NatAlg.gt(n[69], n[42]))", n[0], Nat.sub(n[1], NatAlg.gt(n[69], n[42])));
		assertSame("Nat.sub(NatAlg.gt(n[69], n[42]), n[1])", n[0], Nat.sub(NatAlg.gt(n[69], n[42]), n[1]));
	}

	// ==================== NatAlg.gcd ====================
	@Test(timeout = 666)
	public void test_NatAlg_gcd__42_gcd_105_is_21__and__105_gcd_42_is_21__PUBLIC_TEST() {
		assertSame("Nat.sub(n[21], NatAlg.gcd(n[42], n[105]))", n[0], Nat.sub(n[21], NatAlg.gcd(n[42], n[105])));
		assertSame("Nat.sub(NatAlg.gcd(n[42], n[105]), n[21])", n[0], Nat.sub(NatAlg.gcd(n[42], n[105]), n[21]));
		assertSame("Nat.sub(n[21], NatAlg.gcd(n[105], n[42]))", n[0], Nat.sub(n[21], NatAlg.gcd(n[105], n[42])));
		assertSame("Nat.sub(NatAlg.gcd(n[105], n[42]), n[21])", n[0], Nat.sub(NatAlg.gcd(n[105], n[42]), n[21]));
	}

	// ==================== NatAlg.lcm ====================
	@Test(timeout = 666)
	public void test_NatAlg_lcm__21_lcm_15_is_105__and__15_lcm_21_is_105__PUBLIC_TEST() {
		assertSame("Nat.sub(n[105], NatAlg.lcm(n[21], n[15]))", n[0], Nat.sub(n[105], NatAlg.lcm(n[21], n[15])));
		assertSame("Nat.sub(NatAlg.lcm(n[21], n[15]), n[105])", n[0], Nat.sub(NatAlg.lcm(n[21], n[15]), n[105]));
		assertSame("Nat.sub(n[105], NatAlg.lcm(n[15], n[21]))", n[0], Nat.sub(n[105], NatAlg.lcm(n[15], n[21])));
		assertSame("Nat.sub(NatAlg.lcm(n[15], n[21]), n[105])", n[0], Nat.sub(NatAlg.lcm(n[15], n[21]), n[105]));
	}

	// ==================== NatAlgEleList ====================
	@Test(timeout = 666)
	public void test_NatAlgEleList__PUBLIC_TEST() {
		Nat head;
		EleList<Nat> pfz = NatAlg.pfz(n[360]); // 360 = 2*2*2 * 3*3 * 5
		assertNotNull(pfz);
		head = EleList.head(pfz);
		assertNotNull(head);
		assertSame("pfz(360) = \">2<*2*2 * 3*3 * 5\"", n[0], Nat.sub(n[2], head));
		assertSame("pfz(360) = \">2<*2*2 * 3*3 * 5\"", n[0], Nat.sub(head, n[2]));
		pfz = EleList.tail(pfz);
		assertNotNull(pfz);
		head = EleList.head(pfz);
		assertNotNull(head);
		assertSame("pfz(360) = \"2*>2<*2 * 3*3 * 5\"", n[0], Nat.sub(n[2], head));
		assertSame("pfz(360) = \"2*>2<*2 * 3*3 * 5\"", n[0], Nat.sub(head, n[2]));
		pfz = EleList.tail(pfz);
		assertNotNull(pfz);
		head = EleList.head(pfz);
		assertNotNull(head);
		assertSame("pfz(360) = \"2*2*>2< * 3*3 * 5\"", n[0], Nat.sub(n[2], head));
		assertSame("pfz(360) = \"2*2*>2< * 3*3 * 5\"", n[0], Nat.sub(head, n[2]));
		pfz = EleList.tail(pfz);
		assertNotNull(pfz);
		head = EleList.head(pfz);
		assertNotNull(head);
		assertSame("pfz(360) = \"2*2*2 * >3<*3 * 5\"", n[0], Nat.sub(n[3], head));
		assertSame("pfz(360) = \"2*2*2 * >3<*3 * 5\"", n[0], Nat.sub(head, n[3]));
		pfz = EleList.tail(pfz);
		assertNotNull(pfz);
		head = EleList.head(pfz);
		assertNotNull(head);
		assertSame("pfz(360) = \"2*2*2 * 3*>3< * 5\"", n[0], Nat.sub(n[3], head));
		assertSame("pfz(360) = \"2*2*2 * 3*>3< * 5\"", n[0], Nat.sub(head, n[3]));
		pfz = EleList.tail(pfz);
		assertNotNull(pfz);
		head = EleList.head(pfz);
		assertNotNull(head);
		assertSame("pfz(360) = \"2*2*2 * 3*3 * 5\"", n[0], Nat.sub(n[5], head));
		assertSame("pfz(360) = \"2*2*2 * 3*3 * >5<\"", n[0], Nat.sub(head, n[5]));
		pfz = EleList.tail(pfz);
		assertNotNull(pfz);
		head = EleList.head(pfz);
		assertNull(head);
		pfz = EleList.tail(pfz);
		assertNull(pfz);
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