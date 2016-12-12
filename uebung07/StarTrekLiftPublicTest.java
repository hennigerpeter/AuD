import static org.junit.Assert.*;
import org.junit.*;
//COPIED FROM SS15 6.1 TurboLift -> copy that one!
//TODO check that other classes also exist (and are not inner classes!)
public class StarTrekLiftPublicTest {
	public final static String EX_ID = "OOD - StarTrekLift";


	/**
	 * main.
	 * 
	 * to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
	 * to run on command line: java -cp .:/usr/share/java/junit4.jar StarTrekLiftPublicTest
	 */
	public static void main(String args[]) {
		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object(){}.getClass().getEnclosingClass().getSimpleName());
	}
	
	@Test(timeout = 1000)
	public void testClassStarTrekLiftPublic() {
		try {
			Class<?> clazz = Class.forName("StarTrekLift");
		} catch (ClassNotFoundException e) {
			fail("Klasse StarTrekLift nicht gefunden.");
		}
	}
}
