public class Solver {
	public static int countFirstTrue;
	public static int countFirstFalse;
	public static int countLoopRun;
	public static int countSecondTrue;
	public static int countSecondFalse;

	public static void reset() {
		countFirstTrue = 0;
		countFirstFalse = 0;
		countLoopRun = 0;
		countSecondTrue = 0;
		countSecondFalse = 0;
	}

	public static void firstTrue() {
		++countFirstTrue;
	}

	public static void firstFalse() {
		++countFirstFalse;
	}

	public static void loopRun() {
		++countLoopRun;
	}

	public static void secondTrue() {
		++countSecondTrue;
	}

	public static void secondFalse() {
		++countSecondFalse;
	}

	public static int solve(int x, int y) {
		if (x < 0 || x >= 10 || y < 0 || y >= 10) {
			firstTrue();
			return -1;
		} else {
			firstFalse();
			while (y != 0) {
				loopRun();
				int t = y;
				y = x % y;
				x = t;
			}
			if (x == 3) {
				secondTrue();
				return -2;
			} else {
				secondFalse();
				return y;
			}
		}
	}
}
