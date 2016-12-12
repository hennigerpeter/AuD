import static org.junit.Assert.*;
import org.junit.*;

public class GeometriePublicTest {

	@Test(timeout = 666)
	public void testUmfangRegelmaessigesVieleck_PUBLIC_TEST() {
		double expected = 34.2497889972;
		double actual = Geometrie.umfangRegelmaessigesVieleck(42, 0.815_4711_666d);
		assertEquals("Geometrie.umfangRegelmaessigesVieleck(42, 0.815_4711_666) => " + expected, expected, actual, 1e-10);
	}

	@Test(timeout = 666)
	public void testUmfangKreis_PUBLIC_TEST() {
		double expected = 29600.598480185705;
		double actual = Geometrie.umfangKreis(4711.0815_666d);
		assertEquals("Geometrie.umfangKreis(4711.0815_666) => " + expected, expected, actual, 1e-10);
	}

	@Test(timeout = 666)
	public void testFlaecheTrapez_PUBLIC_TEST() {
		double expected = 1022.384025;
		double actual = Geometrie.flaecheTrapez(47.11d, 0.815d, 42.666d);
		assertEquals("Geometrie.flaecheTrapez(47.11, 0.815, 42.666) => " + expected, expected, actual, 1e-10);
	}

	@Test(timeout = 666)
	public void testVolumenPyramide_PUBLIC_TEST() {
		double expected = 314205296.645631103282;
		double actual = Geometrie.volumenPyramide(4711.0815666d, 42.4711d);
		assertEquals("Geometrie.volumenPyramide(4711.0815666, 42.4711) => " + expected, expected, actual, 1e-10);
	}

	@Test(timeout = 666)
	public void testFlaechePyramide_PUBLIC_TEST() {
		double expected = 398322.7522031411;
		double actual = Geometrie.flaechePyramide(42.0815d, 4711.666d);
		assertEquals("Geometrie.flaechePyramide(42.0815d, 4711.666d) => " + expected, expected, actual, 1e-10);
	}

	@Test(timeout = 666)
	public void testVolumenKugel_PUBLIC_TEST() {
		double expected = 312150.2619916804;
		double actual = Geometrie.volumenKugel(42.0815_4711_666);
		assertEquals("Geometrie.volumenKugel(42.0815_4711_666) => " + expected, expected, actual, 1e-10);
	}

	@Test(timeout = 666)
	public void testFlaecheVieleck7_PUBLIC_TEST() {
		double expected = 6d;
		double actual = Geometrie.flaecheVieleck8(0, 0, 0, 3, 1, 3, 1, 2, 2, 2, 2, 1, 3, 1, 3, 0);
		assertEquals("Geometrie.flaecheVieleck8(0, 0, 0, 3, 1, 3, 1, 2, 2, 2, 2, 1, 3, 1, 3, 0) => " + expected, expected, actual, 1e-10);
	}

	@Test(timeout = 666)
	public void testTypDesDreiecks_PUBLIC_TEST() {
		int expected = 3;
		int actual = Geometrie.typDesDreiecks(42, 42, 42);
		assertEquals("Geometrie.typDesDreiecks(42, 42, 42) => " + expected, expected, actual, 1e-10);
	}
}