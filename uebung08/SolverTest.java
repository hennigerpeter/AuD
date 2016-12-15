public class SolverTest {
	public static void test0() {
		// TODO: One solve() call, which triggers one firstFalse call and one secondTrue call
		Solver solv = new Solver();
		solv.solve(3, 6);
	}

	public static void test1() {
		// TODO: One solve() call, which triggers one firstTrue call
		Solver solv = new Solver();
		solv.solve(10, 0);
	}

	public static void test2() {
		// TODO: One solve() call, which triggers one firstFalse call and one secondFalse call
		Solver solv = new Solver();
		solv.solve(3, 1);
	}

	public static void test3() {
		// TODO: One solve() call, which triggers one firstFalse call, two or more loopRun calls and one secondFalse call
		Solver solv = new Solver();
		solv.solve(8, 3);
	}

	public static void test4() {
		// TODO: One solve() call, which triggers one firstFalse call, one loopRun call and one secondTrue call
		Solver solv = new Solver();
		solv.solve(6, 3);
	}

	public static void test5() {
		// TODO: One solve() call, which triggers one firstFalse call, two or more loopRun calls and one secondTrue call
		Solver solv = new Solver();
		solv.solve(9, 6);
	}

	public static void test6() {
		// TODO: One solve() call, which triggers one firstFalse call, one loopRun call and one secondFalse call
		Solver solv = new Solver();
		solv.solve(8, 4);
	}
}
