
public class ReceiptImproved {
	protected static final int MAX_PRODUCT_LENGTH = 20;
	protected String[] products;
	protected Integer[] prices;
	protected int savedProducts;

	public ReceiptImproved(int max) {
		//TODO
		if (max <= 0)
			throw new IllegalArgumentException ("param max must be >0");
		
		products = new String[max];
		prices = new Integer[max];
		
	}

	public void register(String prod, String price) {
		//TODO
		if (prod == null)
			throw new NullPointerException("param prod is null");
		if (price == null)
			throw new NullPointerException("param price is null");
	
		if (prod.length() > MAX_PRODUCT_LENGTH) 
			throw new IllegalArgumentException("max length for prod.length is 20") ;
		
		try {
			products[savedProducts] = prod;
			prices[savedProducts] = Integer.parseInt(price);
			savedProducts++;
		} catch (NumberFormatException enumber) {
			throw new IllegalArgumentException("could not parse string price.");
		} catch (ArrayIndexOutOfBoundsException earray) {
			throw new RuntimeException("Product could not be registered. The Arrays product and price are already completely filled.");
		}
	}

	public String getLastProduct() {
		//TODO
		if (savedProducts <= 0)
			throw new RuntimeException("There must be at least one registered Product on the Receipt, in order to get the last Product."); 
				
		return products[savedProducts - 1];
	}

	public int sum() {
		//TODO
		if (savedProducts <= 0)
			throw new RuntimeException("There must be at least one registered Product on the Receipt, in order to get the sum of all prices."); 
		if (savedProducts != prices.length)
			throw new RuntimeException("Not every registered product has a price. The sum would not be correct.");
		
		int sum = 0;
		for (int i = 0; i < prices.length; i++) {
			sum += prices[i];
		}
		
		return sum;
	}

	public int average() {
		//TODO
		if (savedProducts <= 0)
			throw new RuntimeException("There must be at least one registered Product on the Receipt, in order to get the average of all prices."); 
		
		int sum = 0;
		int count = 0;
		for (int i = 0; i < savedProducts; i++) {
			sum += prices[i];
			count++;
		}
		return sum / count;
	}
}