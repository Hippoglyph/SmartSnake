package snake;

import java.util.Objects;

public class Cell {
	int posRow;
	int posCol;

	public Cell(int row, int col) {
		set(row, col);
	}

	public Cell(Cell cell) {
		set(cell);
	}

	public void set(int row, int col) {
		setRowPos(row);
		setColPos(col);
	}

	public void set(Cell cell) {
		set(cell.getRowPos(), cell.getColPos());
	}

	public void setRowPos(int row) {
		this.posRow = row;
	}

	public void setColPos(int col) {
		this.posCol = col;
	}

	public int getRowPos() {
		return posRow;
	}

	public int getColPos() {
		return posCol;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (!(other instanceof Cell))
			return false;
		Cell otherCell = (Cell) other;
		return Objects.equals(otherCell.posCol, posCol) && Objects.equals(otherCell.posRow, posRow);
	}
}
