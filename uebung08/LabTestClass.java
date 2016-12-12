//package fau.exercises.kw50;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class LabTestClass extends JPanel implements ActionListener{
	
	private static Point startPosition = new Point(9, 9);
	private static Point endPosition = new Point(9, 7);

	private final static boolean[][] walls = new boolean[][] {
			new boolean[] { true, true, true, true, true, true, true, true, true, true, true, true, true },
			new boolean[] { true, false, false, false, false, false, false, false, true, false, false, false, true },
			new boolean[] { true, false, true, true, true, true, true, false, true, false, true, false, true },
			new boolean[] { true, false, false, false, false, false, true, false, false, false, true, false, true },
			new boolean[] { true, true, true, true, true, false, true, true, true, true, true, false, true },
			new boolean[] { true, false, false, false, true, false, false, false, true, false, false, false, true },
			new boolean[] { true, false, true, false, true, true, true, false, true, false, true, true, true },
			new boolean[] { true, false, true, false, false, false, true, false, true, false, false, false, true },
			new boolean[] { true, false, true, true, true, false, true, false, true, true, true, false, true },
			new boolean[] { true, false, true, false, false, false, true, false, true, false, true, false, true },
			new boolean[] { true, false, true, true, true, true, true, true, true, false, true, false, true },
			new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, true },
			new boolean[] { true, true, true, true, true, true, true, true, true, true, true, true, true }, };
			
	
	private static Lab lab;
	private static LabRat rat;
	static Timer timer;
	
	public static void main(String[] args) {
		

		lab = new Lab(startPosition, endPosition, walls);
		rat = new LabRat(lab);

		LabTestClass labTestClass = new LabTestClass(lab,rat);
		labTestClass.show();
		
		LabRatSolver.solve(rat);

	}

	public LabTestClass(Lab lab,LabRat rat) {
		handleNewLab(lab);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
				
				}
			}
		});
		
		timer = new Timer(100, this);
		timer.start();
	}

	public void show() {
		JFrame frame = new JFrame("lab2d");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520, 520);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	private void handleNewLab(Lab lab) {
		this.lab = lab;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int offset = 10;
		int cellSizeW = (width - 2 * offset) / lab.getWidth();
		int cellSizeH = (height - 2 * offset) / lab.getHeight();
		int cellSize = cellSizeW < cellSizeH ? cellSizeW : cellSizeH;
		int xPos = offset;
		int yPos = offset;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		
		for (int y = 0; y < lab.getWidth(); y++) {
			for (int x = 0; x < lab.getHeight(); x++){
				
				g.setColor(Color.BLACK);
				if (lab.checkWall(x, y)) g.fillRect(xPos + 1, yPos + 1, cellSize, cellSize);
				
				g.setColor(Color.YELLOW);
				if (((y==lab.getStartPosition().y)&&x==lab.getStartPosition().x)) g.fillRect(xPos + 1, yPos + 1, cellSize, cellSize);

				g.setColor(Color.GREEN);
				if (((y==lab.getEndPosition().y)&&x==lab.getEndPosition().x)) g.fillRect(xPos + 1, yPos + 1, cellSize, cellSize);

				
				if (((y==rat.getCurrentPosition().y)&&x==rat.getCurrentPosition().x)) {
					
					g.setColor(Color.GRAY);
					// Draw Rat
					g.fillRect(xPos + 1 + cellSize / 4, yPos + 1 + cellSize/4, cellSize/2, cellSize/2);
					
					g.setColor(Color.BLACK);
					
					switch (rat.getCurrentDirection()){
						case LabRat.NORTH:  g.drawOval(xPos + 1 + cellSize / 2 - cellSize / 6,   yPos + 1 + cellSize / 6, cellSize / 4, cellSize / 4); break;
						case LabRat.SOUTH:  g.drawOval(xPos + 1 + cellSize / 2 - cellSize / 6,   yPos + 1 + cellSize / 2, cellSize / 4, cellSize / 4); break;
						case LabRat.EAST:   g.drawOval(xPos + 1 + cellSize / 2 + cellSize / 8,   yPos + 1 + cellSize / 3, cellSize / 4, cellSize / 4);  break;
						case LabRat.WEST:   g.drawOval(xPos + 1 + cellSize / 6,                  yPos + 1 + cellSize / 3, cellSize / 4, cellSize / 4); break;
					}
					
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
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource()==timer){	
		      repaint();
		    }
		
	}

}
