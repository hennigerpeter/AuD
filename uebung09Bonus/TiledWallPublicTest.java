import static org.junit.Assert.*;
import org.junit.*;

public class TiledWallPublicTest {
	// ================================================================================

	// ================================================================================
	protected static final AtomicTile[] d = { //
			AtomicTile.PATTERN[0x4], //
			AtomicTile.PATTERN[0x28], //
			AtomicTile.PATTERN[0x5], //
			AtomicTile.PATTERN[0x0] //
	}, e = { AtomicTile.EMPTY };

	// -------------------- Normal wall --------------------
	@Test(timeout = 15_000)
	public void normalDeterministicMixedWallWithNiceTilesGivesAtLeastOneSolution() {
		AtomicTile[][] designWall = new AtomicTile[5][6];
		for (int row = 0; row < designWall.length; row++) {
			for (int column = 0; column < designWall[row].length; column++) {
				designWall[row][column] = AtomicTile.EMPTY;
			}
		}
		designWall[0][0] = AtomicTile.RESERVED;
		designWall[3][1] = AtomicTile.RESERVED;
		designWall[3][5] = AtomicTile.RESERVED;
		designWall[0][5] = AtomicTile.RESERVED;
		designWall[1][4] = AtomicTile.RESERVED;
		TiledWall tiledWall = new TiledWall(designWall);
		DesignTile[] designTiles = { //
				new DesignTile(new AtomicTile[][] { //
						{ d[0] } //
				}), //
				new DesignTile(new AtomicTile[][] { //
						{ e[0], d[1], e[0] }, //
						{ d[1], d[1], d[1] }, //
						{ e[0], d[1], e[0] } //
				}), //
				new DesignTile(new AtomicTile[][] { //
						{ e[0], d[2], d[2], d[2] }, //
						{ d[2], d[2], d[2], e[0] }, //
						{ e[0], d[2], d[2], d[2] } //
				}), //
				new DesignTile(new AtomicTile[][] { //
						{ d[3], e[0], e[0] }, //
						{ d[3], d[3], e[0] }, //
						{ d[3], e[0], e[0] }, //
						{ d[3], d[3], d[3] } //
				}) //
		};
		System.out.println("\u2623 \u27A2\u27A2\u27A2 The wall before tiling:");
		tiledWall.printEmpty();
		System.out.println("\u2714 \u27A2\u27A2\u27A2 The tiles available:");
		for (DesignTile designTile : designTiles) {
			designTile.print();
			System.out.println("     \u2702----------");
		}
		System.out.println("\u2620 \u27A2\u27A2\u27A2 My best-effort design:");
		long timeStart = System.currentTimeMillis();
		tiledWall.stickTiles(designTiles);
		long timeEnd = System.currentTimeMillis();
		tiledWall.printTiled();
		System.out.println("\u270E \u27A2\u27A2\u27A2 Length of my tiles list: " + (tiledWall.stickyTiles == null ? "\u2620" : tiledWall.stickyTiles.length));
		System.out.println("\u231A \u27A2\u27A2\u27A2 Time consumed: " + (timeEnd - timeStart) + " ms");
		assertNotNull("The normal wall has not been tiled, though it would have been possible.", tiledWall.stickyTiles);
		assertTrue("There should be at least one solution for the normal wall with at most 7 tiles.", tiledWall.stickyTiles.length <= 7);
		checkOriginalWallIsNotModified(designWall, tiledWall);
		checkTilingIsCoveringPerfectly(tiledWall);
		checkTiles(designTiles, tiledWall.stickyTiles);
	}

	@Test(timeout = 16_000)
	public void ATTENTION_PUBLIC_ANTI_CHEAT_TEST_MAKE_IT_WORK_OR_YOU_WILL_GET_NO_POINTS_AT_ALL__andByTheWayThereIsAlsoAnAdditionalSecretAntiCheatTest_muhahaha() {
		for (int i = 0; i < 42; i += 2) {
			ATTENTION_PUBLIC_ANTI_CHEAT_TEST_MAKE_IT_WORK_OR_YOU_WILL_GET_NO_POINTS_AT_ALL__andByTheWayThereIsAlsoAnAdditionalSecretAntiCheatTest_muhahaha_helper();
		}
	}

	private static final java.util.Random DICE = new java.util.Random(4711_0815_666L);

	private void ATTENTION_PUBLIC_ANTI_CHEAT_TEST_MAKE_IT_WORK_OR_YOU_WILL_GET_NO_POINTS_AT_ALL__andByTheWayThereIsAlsoAnAdditionalSecretAntiCheatTest_muhahaha_helper() {
		System.out.println("-\u2700-\u2701-\u2702-\u2703-\u2704-\u2700-\u2701-\u2702-\u2703-\u2704-\u2700-\u2701-\u2702-\u2703-\u2704-\u2700-\u2701-\u2702-\u2703-\u2704-");
		boolean withSolution = DICE.nextBoolean();
		int size = 8 + 4 * DICE.nextInt(3);
		int deltaX1 = DICE.nextInt(4), deltaY1 = DICE.nextInt(4), deltaX2 = DICE.nextInt(4), deltaY2 = DICE.nextInt(4), failX = DICE.nextInt(size), failY = DICE.nextInt(size);
		AtomicTile[][] designWall = new AtomicTile[size][size];
		for (int row = 0; row < designWall.length; row++) {
			for (int column = 0; column < designWall[row].length; column++) {
				if (row % 4 == deltaX1 && column % 4 == deltaY1 || row % 4 == deltaX2 && column % 4 == deltaY2) {
					designWall[row][column] = AtomicTile.RESERVED;
				} else {
					designWall[row][column] = AtomicTile.EMPTY;
				}
			}
		}
		if (!withSolution) {
			if (designWall[failX][failY] == AtomicTile.EMPTY) {
				designWall[failX][failY] = AtomicTile.RESERVED;
			} else if (designWall[(failX) % size][(failY + 1) % size] == AtomicTile.EMPTY) {
				designWall[(failX) % size][(failY + 1) % size] = AtomicTile.RESERVED;
			} else if (designWall[(failX + 1) % size][(failY) % size] == AtomicTile.EMPTY) {
				designWall[(failX + 1) % size][(failY) % size] = AtomicTile.RESERVED;
			} else {
				designWall[(failX + 1) % size][(failY + 1) % size] = AtomicTile.RESERVED;
			}
		}
		TiledWall tiledWall = new TiledWall(designWall);
		AtomicTile[][] atomicTiles = { //
				{ d[1], d[1], d[1], d[1] }, //
				{ d[1], d[1], d[1], d[1] }, //
				{ d[1], d[1], d[1], d[1] }, //
				{ d[1], d[1], d[1], d[1] } //
		};
		atomicTiles[deltaX1][deltaY1] = e[0];
		atomicTiles[deltaX2][deltaY2] = e[0];
		DesignTile[] designTiles = { new DesignTile(atomicTiles) };
		System.out.println("\u2623 \u27A2\u27A2\u27A2 The wall before tiling:");
		tiledWall.printEmpty();
		System.out.println("\u2714 \u27A2\u27A2\u27A2 The tiles available:");
		for (DesignTile designTile : designTiles) {
			designTile.print();
			System.out.println("     \u2702----------");
		}
		System.out.println("\u2620 \u27A2\u27A2\u27A2 My best-effort design:");
		long timeStart = System.currentTimeMillis();
		tiledWall.stickTiles(designTiles);
		long timeEnd = System.currentTimeMillis();
		tiledWall.printTiled();
		System.out.println("\u270E \u27A2\u27A2\u27A2 Length of my tiles list: " + (tiledWall.stickyTiles == null ? "\u2620" : tiledWall.stickyTiles.length));
		System.out.println("\u231A \u27A2\u27A2\u27A2 Time consumed: " + (timeEnd - timeStart) + " ms");
		if (withSolution) {
			assertNotNull("The wall has not been tiled, though it would have been possible.", tiledWall.stickyTiles);
			assertTrue("There should be at least one solution for the wall of " + size + "x" + size + " with at most " + (size * size / 4) + " tiles.", tiledWall.stickyTiles.length <= (size * size / 4));
			checkOriginalWallIsNotModified(designWall, tiledWall);
			checkTilingIsCoveringPerfectly(tiledWall);
			checkTiles(designTiles, tiledWall.stickyTiles);
		} else {
			assertNull("The wall has been tiled, though it should not be possible.", tiledWall.stickyTiles);
		}
	}

	// -------------------- helper --------------------
	protected final void checkOriginalWallIsNotModified(AtomicTile[][] designWall, TiledWall tiledWall) {
		assertEquals("The original wall has been changed illegally!", designWall.length, tiledWall.rows);
		for (int row = 0; row < tiledWall.rows; row++) {
			assertEquals("The original wall has been changed illegally!", designWall[row].length, tiledWall.columns);
			for (int column = 0; column < tiledWall.columns; column++) {
				assertEquals("The original wall has been changed illegally!", designWall[row][column], tiledWall.getTile(row, column));
			}
		}
	}

	protected final void checkTilingIsCoveringPerfectly(TiledWall tiledWall) {
		int rows = tiledWall.rows;
		int columns = tiledWall.columns;
		AtomicTile[][] re_tiledWall = new AtomicTile[rows][columns];
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				re_tiledWall[row][column] = tiledWall.getTile(row, column);
			}
		}
		AtomicTile stickyAtomicTile;
		assertNotNull("The wall has not been tiled, though it would have been possible (or we have an internal error in the test cases!).", tiledWall.stickyTiles);
		if (tiledWall.stickyTiles != null) {
			for (StickyTile stickyTile : tiledWall.stickyTiles) {
				assertNotNull("There shall be no null-tiles in here.", stickyTile);
				for (int row = 0; stickyTile != null && row < stickyTile.rows; row++) {
					for (int column = 0; column < stickyTile.columns; column++) {
						stickyAtomicTile = stickyTile.getTile(row, column);
						if (stickyAtomicTile != null && stickyAtomicTile != AtomicTile.EMPTY && stickyAtomicTile != AtomicTile.RESERVED) {
							assertEquals("Tiles shall neither overlap nor cover reserved parts!", AtomicTile.EMPTY, re_tiledWall[stickyTile.row + row][stickyTile.column + column]);
							re_tiledWall[stickyTile.row + row][stickyTile.column + column] = stickyAtomicTile;
						}
					}
				}
			}
		}
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				assertFalse("Tiles shall neither overlap nor cover reserved parts!", re_tiledWall[row][column] == AtomicTile.EMPTY);
				re_tiledWall[row][column] = tiledWall.getTile(row, column);
			}
		}
	}

	protected final void checkTiles(DesignTile[] designTiles, StickyTile[] stickyTiles) {
		assertNotNull("The wall has not been tiled, though it would have been possible (or we have an internal error in the test cases!).", stickyTiles);
		withNextStickyTile: for (StickyTile stickyTile : stickyTiles) {
			assertNotNull("There shall be no null-tiles in here.", stickyTile);
			for (DesignTile designTile : designTiles) {
				if (stickyTile.rows == designTile.rows && stickyTile.columns == designTile.columns) {
					boolean atomicTilesMatch = true;
					Y_U_NO_MATCH: for (int row = 0; row < designTile.rows; row++) {
						for (int column = 0; column < designTile.columns; column++) {
							if (stickyTile.getTile(row, column) != designTile.getTile(row, column)) {
								atomicTilesMatch = false;
								break Y_U_NO_MATCH;
							}
						}
					}
					if (atomicTilesMatch) {
						continue withNextStickyTile;
					}
				}
			}
			fail("Could not find a designTile matching the stickyTile sticked to the wall... Don't fake results!");
		}
	}

	// ==================== main ====================
	// nothing to do ;) - please do nothing here:
	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar $(ls * | grep PublicTest.class | sed s/.class//)

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}