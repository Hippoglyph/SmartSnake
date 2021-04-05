package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import snake.Cell;
import snake.State;

public class Board extends JPanel {
	private static final long serialVersionUID = 1L;
	private int cellHeight;
	private int cellWidth;

	private State currentState;

	private static final Color background = Color.BLACK;
	private static final Color snakeBodyColor = Color.GREEN;
	private static final Color foodColor = Color.RED;

	public void init(int rowSize, int colSize, int windowRowSize, int windowColSize) {
		this.cellHeight = windowRowSize / rowSize;
		this.cellWidth = windowColSize / colSize;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		setBackground(background);
		drawFood(g2d);
		drawSnake(g2d);
	}

	private void drawSnake(Graphics g) {
		g.setColor(snakeBodyColor);
		currentState.getSnakeBody()
				.forEach(c -> g.fillRect(c.getColPos() * cellWidth, c.getRowPos() * cellHeight, cellWidth, cellHeight));
	}

	private void drawFood(Graphics g) {
		g.setColor(foodColor);
		Cell food = currentState.getFood();
		g.fillRect(food.getColPos() * cellWidth, food.getRowPos() * cellHeight, cellWidth, cellHeight);
	}

	public void draw(State state) {
		if (state != null) {
			this.currentState = state;
			repaint();
		}
	}
}
