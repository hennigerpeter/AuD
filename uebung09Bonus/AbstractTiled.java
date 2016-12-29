public abstract class AbstractTiled {
	protected final int rows;
	protected final int columns;
	private final AtomicTile[][] tiles;

	private AbstractTiled(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.tiles = new AtomicTile[rows][columns];
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				tiles[row][column] = AtomicTile.RESERVED;
			}
		}
	}

	protected AbstractTiled(int rows, int columns, double densityEmpty) {
		this(rows, columns);
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (Math.random() <= densityEmpty) {
					tiles[row][column] = AtomicTile.EMPTY;
				}
			}
		}
	}

	protected AbstractTiled(AtomicTile[][] tiles) {
		this(tiles.length, getMaxColumns(tiles));
		for (int row = 0; tiles != null && row < tiles.length; row++) {
			for (int column = 0; tiles[row] != null && column < tiles[row].length; column++) {
				this.tiles[row][column] = tiles[row][column];
			}
		}
	}

	protected AbstractTiled(AbstractTiled abstractTiled) {
		this(abstractTiled.tiles);
	}

	protected final AtomicTile getTile(int row, int column) {
		if (row >= 0 && row < rows && column >= 0 && column < columns) {
			return tiles[row][column];
		} else {
			return AtomicTile.RESERVED;
		}
	}

	protected void print() {
		print(tiles);
	}

	protected static final void print(AtomicTile[][] tiles) {
		for (AtomicTile[] row : tiles) {
			System.out.print("      ");
			for (AtomicTile tile : row) {
				System.out.print(tile);
			}
			System.out.println();
		}
	}

	private static final int getMaxColumns(AtomicTile[][] tiles) {
		int columns = 0;
		for (AtomicTile[] row : tiles) {
			columns = columns < row.length ? row.length : columns;			
		}
		return columns;
	}
}