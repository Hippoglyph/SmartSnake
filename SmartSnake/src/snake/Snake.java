package snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
	private final int maxRow;
	private final int maxCol;

	private List<Cell> body;

	public Snake(int maxRow, int maxCol, List<Cell> initBody) {
		this.maxRow = maxRow;
		this.maxCol = maxCol;
		this.body = new ArrayList<>(initBody);
	}

	public List<Cell> getBody() {
		return body;
	}

	public void grow() {
		body.add(new Cell(getTail()));
	}

	public boolean moveEast() {
		return move(1, 0);
	}

	public boolean moveNorth() {
		return move(0, -1);
	}

	public boolean moveWest() {
		return move(-1, 0);
	}

	public boolean moveSouth() {
		return move(0, 1);
	}

	private boolean move(int xDir, int yDir) {
		xDir = clamp01(xDir);
		yDir = clamp01(yDir);
		if (!legalCheck(xDir, yDir))
			return false;

		for (int i = body.size() - 1; i > 0; i--) {
			Cell currentCell = body.get(i);
			Cell nextCell = body.get(i - 1);
			currentCell.set(nextCell);
		}

		Cell head = getHead();

		head.setRowPos(head.getRowPos() + yDir);
		head.setColPos(head.getColPos() + xDir);

		return true;
	}

	private boolean legalCheck(int xDir, int yDir) {

		if (!boundaryCheck(xDir, yDir))
			return false;

		return true;
	}

	private boolean boundaryCheck(int xDir, int yDir) {
		if (getHead().getRowPos() + yDir < 0 || getHead().getRowPos() + yDir >= maxRow)
			return false;
		if (getHead().getColPos() + xDir < 0 || getHead().getColPos() + xDir >= maxCol)
			return false;

		return true;
	}

	public Cell getHead() {
		return body.get(0);
	}

	public int[] getDirection() {
		Cell head = getHead();
		Cell neck = body.get(1);
		if (head.getRowPos() == neck.getRowPos()) {
			if (head.getColPos() > neck.getColPos()) {
				return new int[] { 0, 1 };
			} else {
				return new int[] { 0, -1 };
			}
		} else {
			if (head.getRowPos() > neck.getRowPos()) {
				return new int[] { -1, 0 };
			} else {
				return new int[] { 1, 0 };
			}
		}
	}

	private Cell getTail() {
		return body.get(body.size() - 1);
	}

	private int clamp01(int in) {
		return Math.min(1, Math.max(-1, in));
	}
}
