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
	
	// ArrayIndexOutOfBoundsException: ARRAY_BOUNDS_MINUS
	public static void triggerException2() {
		// TODO
		int nulltest = 0;
		Receipt test = new Receipt(nulltest);
		test.register("abc", "4");
	}

	// NumberFormatException bei Parse.Int
	public static void triggerException3() {
		// TODO
		int nulltest = 4;
		Receipt test = new Receipt(nulltest);
		test.register("", "");
	}

	// ArrayIndexOutOfBoundsException: ARRAY_BOUNDS_PLUS
	public static void triggerException4() {
		// TODO
		int nrOfItems = 2;
		Receipt receipt = new Receipt(nrOfItems);
		receipt.register("Schnitzel", "7");
		receipt.register("Pommes", "2");
		receipt.register("Schaeuferle", "10");
	
	}

	// NullPointerException: NPE_INTARRAY (13)
	public static void triggerException5() {
		// TODO
		int nulltest = 4;
		Receipt test = new Receipt(nulltest);
		test.register("                                                               ", "                                                               ");
		int i = test.sum();
	}

	// Out of Memory
	public static void triggerException6() {
		// TODO
		int nrOfItems = Integer.MAX_VALUE;
		Receipt receipt = new Receipt(nrOfItems);
		for (int i=0; i<nrOfItems;i++){
			receipt.register("Schnitzel", "7");
		}
		
	}

	public static void triggerException7() {
		// TODO
		//NullPointerException bei sum() 29
		int nrOfItems = 5;
		Receipt receipt = new Receipt(nrOfItems);
		receipt.register("Schnitzel", "7");
		receipt.register("Pommes", "1");
		int i = receipt.sum();
	}

	// ArrayIndexOutOfBoundsException MINUS
	public static void triggerException8() {
		// ArrayIndexOutOfBoundsException
		int nulltest = 4;
		Receipt test = new Receipt(nulltest);
		test.register("                                                               ", "                                                               ");
		String tes2 = test.getLastProduct();
	}

	// ArithmeticException: Es wird durch 0 geteilt
	public static void triggerException9() {
		// TODO
		int nulltest = 4;
		Receipt test = new Receipt(nulltest);
		test.register("                                                               ", "                                                               ");
		int tes2 = test.average();
	}
}
