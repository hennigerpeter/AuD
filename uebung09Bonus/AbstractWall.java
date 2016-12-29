public abstract class AbstractWall extends AbstractTiled {
	public StickyTile[] stickyTiles = null;

	protected AbstractWall(int rows, int columns, double densityEmpty) {
		super(rows, columns, densityEmpty);
	}

	protected AbstractWall(AtomicTile[][] design) {
		super(design);
	}

	public abstract void stickTiles(DesignTile[] designTiles);

	public final void printEmpty() {
		super.print();
	}

	public final void printTiled() {
		print(createTiledWall());
	}

	public final AtomicTile[][] createTiledWall() {
		AtomicTile[][] tiledWall = new AtomicTile[rows][columns];
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				tiledWall[row][column] = getTile(row, column);
			}
		}
		AtomicTile stickyAtomicTile;
		if (stickyTiles != null) {
			for (StickyTile stickyTile : stickyTiles) {
				for (int row = 0; stickyTile != null && row < stickyTile.rows; row++) {
					for (int column = 0; column < stickyTile.columns; column++) {
						stickyAtomicTile = stickyTile.getTile(row, column);
						if (stickyAtomicTile != null && stickyAtomicTile != AtomicTile.EMPTY && stickyAtomicTile != AtomicTile.RESERVED) {
							if (tiledWall[stickyTile.row+row][stickyTile.column+column] != AtomicTile.EMPTY) {
								throw new IllegalArgumentException("\nTried to place " + stickyAtomicTile + " at row "+(stickyTile.row+row) + " in column "+(stickyTile.column+column) + " but there was already something very sticky: " + tiledWall[stickyTile.row+row][stickyTile.column+column]);
							} else {
								tiledWall[stickyTile.row+row][stickyTile.column+column] = stickyAtomicTile;
							}
						}
					}
				}
			}
		}
		return tiledWall;
	}
}