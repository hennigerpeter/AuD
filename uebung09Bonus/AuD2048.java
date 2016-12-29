// ***** DO NEITHER MODIFY NOR EVEN TRY TO UNDERSTAND THE CODE BELOW ***** //
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * This class contains the front-end (GUI) for 2048 games. <br/>
 * For a general description of the game please refer to: {@link <a href="http://de.wikipedia.org/wiki/2048_(Computerspiel)">2048</a>}. <br/>
 * <br/>
 * 
 * @author John Doe
 * @version 1.0, 05/16/14
 */
public final class AuD2048 {
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable t) {
		}
	}

	private AuD2048() {
	}

	/**
	 * Happy hunger games!
	 * 
	 * @param args
	 *            command line arguments, possibly denoting the game logic and the size of the game board
	 *            <ul>
	 *            <li>the first argument is the name of the game logic to be played (defaults to "AuD2048LogicNormalGame" if not provided at all or empty string)</li>
	 *            <li>the second argument is the height of the game board (defaults to 4 if not provided at all or outside legal range)</li>
	 *            <li>the third argument is the width of the game board (defaults to the height if not provided at all or outside legal range)</li>
	 *            </ul>
	 */
	public static void main(String[] args) {
		new AuD2048Frame(args);
	}

	@SuppressWarnings("serial")
	private static final class AuD2048Frame extends JFrame implements ActionListener, KeyListener {
		private static final String FRAME_TITLE = "AuD-2048";

		private AuD2048Logic logic;
		private int rows, cols;
		private JLabel[][] gameBoardGUI;
		private JPanel controlPanel;
		private JPanel gameBoardPanel;
		private JButton restart;
		private JButton quit;

		private AuD2048Frame(String[] args) {
			super(FRAME_TITLE);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			String logicName = (args.length > 0 && args[0].length() != 0) ? args[0] : "AuD2048LogicNormalGame";
			logic = AuD2048Logic.loadLogic(logicName);
			if (logic == null) {
				System.out.println("Could not load requested logic: " + logicName);
			}
			try {
				rows = Integer.parseInt(args[1]);
				if (rows < 2 || rows > 45) {
					rows = 4;
				}
			} catch (Throwable t) {
				rows = 4;
			}
			try {
				cols = Integer.parseInt(args[2]);
				if (cols < 2 || cols > 45) {
					cols = rows;
				}
			} catch (Throwable t) {
				cols = rows;
			}
			logic.initializeLogic(rows, cols);
			createGUI();
			startNewGame();
			pack();
			setVisible(true);
		}

		private void createGUI() {
			controlPanel = new JPanel();
			controlPanel.setLayout(new GridLayout(1, 2));
			restart = new JButton("New", UIManager.getIcon("FileView.fileIcon"));
			restart.setFocusable(false);
			restart.addActionListener(this);
			controlPanel.add(restart);
			quit = new JButton("Quit", UIManager.getIcon("OptionPane.errorIcon"));
			quit.setFocusable(false);
			quit.addActionListener(this);
			controlPanel.add(quit);
			gameBoardPanel = new JPanel();
			int panelWidth = 666, panelHeight = 666;
			if (rows < cols) {
				panelHeight = panelWidth * rows / cols;
			} else {
				panelWidth = panelHeight * cols / rows;
			}
			gameBoardPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
			gameBoardPanel.setLayout(new GridLayout(rows, cols));
			gameBoardGUI = new JLabel[rows][cols];
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					gameBoardGUI[r][c] = new AuD2048Label();
					gameBoardPanel.add(gameBoardGUI[r][c]);
				}
			}
			GridBagLayout gridBagLayout = new GridBagLayout();
			GridBagConstraints gridBagConstraints;
			getContentPane().setLayout(gridBagLayout);
			gridBagConstraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0);
			gridBagLayout.setConstraints(controlPanel, gridBagConstraints);
			getContentPane().add(controlPanel);
			gridBagConstraints = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
			gridBagLayout.setConstraints(gameBoardPanel, gridBagConstraints);
			getContentPane().add(gameBoardPanel);
			addKeyListener(this);
		}

		private void startNewGame() {
			logic.startNewGame();
			updateGameBoard();
		}

		private void updateGameBoard() {
			long[][] gameBoard = logic.getGameBoard();
			long max = 1;
			for (long[] row : gameBoard) {
				for (long cell : row) {
					if (cell > max) {
						max = cell;
					}
				}
			}
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (gameBoard[r][c] < 0) {
						gameBoardGUI[r][c].setText("");
						gameBoardGUI[r][c].setBackground(Color.DARK_GRAY);
					} else if (gameBoard[r][c] == 0) {
						gameBoardGUI[r][c].setText("");
						gameBoardGUI[r][c].setBackground(Color.WHITE);
					} else {
						gameBoardGUI[r][c].setText("" + gameBoard[r][c]);
						int red = 255;
						int green = 255 - Math.min(Math.max((int) (gameBoard[r][c] * 90 / max), 0), 90);
						int blue = 255 - Math.min(Math.max((int) (gameBoard[r][c] * 255 / max), 0), 255);
						gameBoardGUI[r][c].setBackground(new Color(red, green, blue));
					}
				}
			}
			getRootPane().invalidate();
			setTitle(FRAME_TITLE + " (" + logic.toString() + ")" + " - Score: " + logic.getScore());
		}

		@Override
		public synchronized void actionPerformed(ActionEvent e) {
			if (e != null && e.getSource() == restart) {
				startNewGame();
			} else if (e != null && e.getSource() == quit) {
				System.exit(0);
			}
		}

		@Override
		public synchronized void keyReleased(KeyEvent e) {
			if (e != null && e.getSource() == this) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					logic.move(Direction.UP);
					break;
				case KeyEvent.VK_DOWN:
					logic.move(Direction.DOWN);
					break;
				case KeyEvent.VK_LEFT:
					logic.move(Direction.LEFT);
					break;
				case KeyEvent.VK_RIGHT:
					logic.move(Direction.RIGHT);
					break;
				}
				updateGameBoard();
				if (logic.hasWinner()) {
					JOptionPane.showMessageDialog(this, "Congratulations!" + "\n" + "Your score: " + logic.getScore(), logic.toString(), JOptionPane.INFORMATION_MESSAGE);
					startNewGame();
				} else if (logic.isGameOver()) {
					JOptionPane.showMessageDialog(this, "Game over!" + "\n" + "Your score: " + logic.getScore(), logic.toString(), JOptionPane.ERROR_MESSAGE);
					startNewGame();
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// just ignore
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// just ignore
		}
	}

	@SuppressWarnings("serial")
	private static final class AuD2048Label extends JLabel {
		private static final EtchedBorder RAISED = new EtchedBorder(EtchedBorder.RAISED);
		private static final EtchedBorder LOWERED = new EtchedBorder(EtchedBorder.LOWERED);

		AuD2048Label() {
			super("", JLabel.CENTER);
			setOpaque(true);
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Font font = getFont();
			String text = getText();
			if (text == null || text.length() == 0) {
				setFont(new Font(font.getName(), Font.PLAIN, 3));
				setBorder(LOWERED);
			} else {
				setBorder(RAISED);
				Rectangle interiorRectangle = RAISED.getInteriorRectangle(this, 0, 0, getWidth(), getHeight());
				int interiorWidth = (int) interiorRectangle.getWidth();
				int interiorHeight = (int) interiorRectangle.getHeight();
				int stringWidth = getFontMetrics(font).stringWidth(text);
				double widthRatio = (double) interiorWidth / (double) stringWidth;
				int newFontSize = (int) (font.getSize() * widthRatio);
				int fontSizeToUse = Math.min(newFontSize, interiorHeight);
				setFont(new Font(font.getName(), Font.PLAIN, fontSizeToUse));
			}
		}
	}
}