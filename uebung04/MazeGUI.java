import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MazeGUI extends JPanel {

	public static boolean[][][] simpleMaze() {
		boolean[][][] l = new boolean[3][3][4];
		l[0][0][Maze.WEST] = true; // entry
		l[2][2][Maze.EAST] = true; // exit
		l[0][1][Maze.EAST] = l[0][2][Maze.WEST] = true; // 3
		l[0][0][Maze.SOUTH] = l[1][0][Maze.NORTH] = true; // 4
		l[0][1][Maze.SOUTH] = l[1][1][Maze.NORTH] = true; // 5
		l[1][0][Maze.EAST] = l[1][1][Maze.WEST] = true; // 6
		l[1][1][Maze.EAST] = l[1][2][Maze.WEST] = true; // 7
		l[1][1][Maze.SOUTH] = l[2][1][Maze.NORTH] = true; // 8
		l[1][2][Maze.SOUTH] = l[2][2][Maze.NORTH] = true; // 9
		l[2][0][Maze.EAST] = l[2][1][Maze.WEST] = true; // 10
		return l;
	}

	public static void main(String[] args) {
		new MazeGUI(new Maze(simpleMaze())).show();
	}

	private Maze maze;

	public MazeGUI(final Maze maze) {
		handleNewMaze(maze);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					handleNewMaze(MazeGenerator.generate(maze.getWidth(), maze.getHeight()));
				}
			}
		});
	}

	public void show() {
		JFrame frame = new JFrame("Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520, 520);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	private void handleNewMaze(Maze maze) {
		this.maze = maze;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int offset = 10;
		int cellSizeW = (width - 2 * offset) / maze.getWidth();
		int cellSizeH = (height - 2 * offset) / maze.getHeight();
		int cellSize = cellSizeW < cellSizeH ? cellSizeW : cellSizeH;
		int xPos = offset;
		int yPos = offset;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);

		boolean[][] deadEnds = maze.solveMaze();
		for (int i = 0; i < maze.getHeight(); i++) {
			for (int j = 0; j < maze.getWidth(); j++) {
				if (deadEnds != null && deadEnds[i][j]) {
					g.setColor(Color.ORANGE);
					g.fillRect(xPos + 1, yPos + 1, cellSize, cellSize);
				}
				g.setColor(Color.BLACK);
				if (!maze.maze[i][j][Maze.NORTH]) {
					g.drawLine(xPos, yPos, xPos + cellSize, yPos);
				}
				if (!maze.maze[i][j][Maze.EAST]) {
					g.drawLine(xPos + cellSize, yPos, xPos + cellSize, yPos + cellSize);
				}
				if (!maze.maze[i][j][Maze.SOUTH]) {
					g.drawLine(xPos, yPos + cellSize, xPos + cellSize, yPos + cellSize);
				}
				if (!maze.maze[i][j][Maze.WEST]) {
					g.drawLine(xPos, yPos, xPos, yPos + cellSize);
				}
				xPos += cellSize;
			}
			xPos = offset;
			yPos += cellSize;
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(520, 520);
	}
}
