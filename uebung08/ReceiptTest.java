public class ReceiptTest {
	/*
	 * TODO: Write the code to trigger the different failures in Receipt.. Trigger ONLY ONE Exception per Method. There are no more than 10
	 * different failure conditions to be found. (you need at least 9 to get full points)
	 */

	// NegativeArraySizeException
	public static void triggerException1() {
		// TODO
		int nulltest = Integer.MIN_VALUE;
		Receipt test = new Receipt(nulltest);
	}
	
	// ArrayIndexOutOfBoundsException
	public static void triggerException2() {
		// TODO
		int nulltest = 0;
		Receipt test = new Receipt(nulltest);
		test.register("", "");
	}

	// NumberFormatException
	public static void triggerException3() {
		// TODO
		int nulltest = 4;
		Receipt test = new Receipt(nulltest);
		test.register("", "");
	}

	// ArrayIndexOutOfBoundsException
	public static void triggerException4() {
		// TODO
		int nulltest = 4;
		Receipt test = new Receipt(nulltest);
		test.register("                                                               ", "                                                               ");
		String tes2 = test.getLastProduct();
	}

	// NullPointerException
	public static void triggerException5() {
		// TODO
		int nulltest = 4;
		Receipt test = new Receipt(nulltest);
		test.register("                                                               ", "                                                               ");
		int i = test.sum();
	}

	public static void triggerException6() {
		// TODO
		int nulltest = 4;
		Receipt test = new Receipt(nulltest);
		int bla = Integer.MAX_VALUE;
		test.register("Schnitzel", "9999999999999999999999999" );
		int i = test.sum();
	}

	public static void triggerException7() {
		// TODO
	}

	public static void triggerException8() {
		// TODO
	}

	public static void triggerException9() {
		// TODO
	}
}
