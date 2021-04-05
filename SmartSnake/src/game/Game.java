package game;

import java.util.Timer;
import java.util.TimerTask;

import snake.State;

public class Game {
	private Board board;

	public Game(String name, int rowSize, int colSize) {
		board = new Design(name, rowSize, colSize).getBoard();
		play(new State(rowSize, colSize));
	}

	private void play(State state) {
		board.draw(state);
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				state.nextState();
				board.draw(state);
			}
		};
		new Timer().schedule(task, 1000, 10);
	}
}
