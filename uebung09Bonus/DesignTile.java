public class DesignTile extends AbstractTiled {
	public DesignTile(AtomicTile[][] design) {
		super(design);
	}

	protected DesignTile(AbstractTiled design) {
		super(design);
	}

	public StickyTile stickTo(int row, int column) {
		return new StickyTile(row, column, this);
	}
}