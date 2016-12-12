import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class HanoiPublicTest {

	@Test(timeout = 1000)
	public void testHanoi1() {
		checkHanoi(3, "A", "B", "C", "A->C A->B C->B A->C B->A B->C A->C");
	}

	@Test(timeout = 1000)
	public void testHanoi2() {
		checkHanoi(5, "A", "B", "C", "A->C A->B C->B A->C B->A B->C A->C A->B C->B C->A B->A C->B A->C "
				+ "A->B C->B A->C B->A B->C A->C B->A C->B C->A B->A B->C A->C A->B C->B A->C B->A B->C A->C");
	}

	private void checkHanoi(int n, String start, String mid, String end, String expectedSolution) {
		final List<String> stackTrace = new ArrayList<>();
		String solution = Hanoi.solve(n, start, mid, end, new Hanoi() {
			@Override
			public void check() {
				stackTrace.clear();
				for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
					stackTrace.add(ste.getMethodName());
				}
			}
		});

		assertTrue("check recursion", Collections.frequency(stackTrace, "solve") > 1 || n <= 1);
		assertEquals("solve(" + n + ", " + start + ", " + mid + ", " + end + ")",
				formatSolution(expectedSolution), formatSolution(solution));
	}

	private String formatSolution(String solution) {
		return solution.replaceAll("\\s+", "");
	}
}