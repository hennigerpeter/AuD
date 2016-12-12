public class Receipt {
	protected static final int MAX_PRODUCT_LENGTH = 20;
	protected String[] products;
	protected Integer[] prices;
	protected int savedProducts;

	public Receipt(int max) {
		products = new String[max];
		prices = new Integer[max];
	}

	public void register(String prod, String price) {
		if (prod.length() > MAX_PRODUCT_LENGTH) {
			return;
		}

		products[savedProducts] = prod;
		prices[savedProducts] = Integer.parseInt(price);
		savedProducts++;
	}

	public String getLastProduct() {
		return products[savedProducts - 1];
	}

	public int sum() {
		int sum = 0;
		for (int i = 0; i < prices.length; i++) {
			sum += prices[i];
		}
		return sum;
	}

	public int average() {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < savedProducts; i++) {
			sum += prices[i];
			count++;
		}
		return sum / count;
	}
}