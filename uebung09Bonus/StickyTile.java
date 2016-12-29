public final class StickyTile extends DesignTile {
	public final int row;
	public final int column;

	public StickyTile(int row, int column, DesignTile designTile) {
		super(designTile);
		this.row = row;
		this.column = column;
	}
}