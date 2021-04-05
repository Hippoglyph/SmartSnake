package snake;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class State {

	private final int rowSize;
	private final int colSize;
	private Snake snake;
	private Cell food;
	private Random rng = new Random();

	public State(int rowSize, int colSize) {
		this.rowSize = rowSize;
		this.colSize = colSize;
		generateNew();
	}

	public void generateNew() {
		snake = new Snake(rowSize, colSize, Arrays.asList(new Cell(0, 1), new Cell(0, 0)));
		generateFood();
	}

	private void generateFood() {
		int row = rng.nextInt(rowSize);
		int col = rng.nextInt(colSize);
		food = new Cell(row, col);
	}

	public List<Cell> getSnakeBody() {
		return snake.getBody();
	}

	public Cell getFood() {
		return food;
	}

	public boolean nextState() {
		boolean moveWasLegal;
		if (food.getRowPos() > snake.getHead().getRowPos()) {
			moveWasLegal = snake.moveSouth();
		} else if (food.getRowPos() < snake.getHead().getRowPos()) {
			moveWasLegal = snake.moveNorth();
		} else if (food.getColPos() > snake.getHead().getColPos()) {
			moveWasLegal = snake.moveEast();
		} else {
			moveWasLegal = snake.moveWest();
		}
		if (moveWasLegal) {
			if (snake.getHead().equals(food)) {
				snake.grow();
				generateFood();
			}
		}
		return moveWasLegal;
	}
}
