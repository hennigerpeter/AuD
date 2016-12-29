public final class AtomicTile {
	public static final AtomicTile EMPTY = new AtomicTile(new String(new int[]{0x1F006}, 0, 1));
	public static final AtomicTile RESERVED = new AtomicTile(new String(new int[]{0x1F02B}, 0, 1));
	public static final AtomicTile[] PATTERN = new AtomicTile[0x2A];
	static {
		int[] codePoints = new int[1];
		for (int i = 0; i < PATTERN.length; i++) {
			codePoints[0] = 0x1F000 + i + (i < 6 ? 0 : 1);
			PATTERN[i] = new AtomicTile(new String(codePoints, 0, 1));
		}
	}

	private final String pattern;

	private AtomicTile(String pattern) {
		this.pattern = pattern;
	}

	public String toString() {
		return pattern+" ";
	}
}