
public final class TiledWall extends AbstractWall {
	public TiledWall(int rows, int columns, double densityEmpty) {
		super(rows, columns, densityEmpty);
	}

	protected TiledWall(AtomicTile[][] design) {
		super(design);
	}

	@Override
	public void stickTiles(DesignTile[] designTiles) {
		
	}
}
