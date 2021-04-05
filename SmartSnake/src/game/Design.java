package game;

import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Design {
	private Board board;

	public Design(String name, int rowSize, int colSize) {
		Frame frame = new Frame(name);
		board = new Board();
		frame.add(board);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(960, 540);
		frame.setResizable(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				board.init(rowSize, colSize, board.getHeight(), board.getWidth());
			}
		});
		board.init(rowSize, colSize, board.getHeight(), board.getWidth());
	}

	public Board getBoard() {
		return board;
	}
}
