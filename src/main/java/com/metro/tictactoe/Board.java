package com.metro.tictactoe;

public class Board {

	private int size;
	private String boardPrintedLimits;
	private char[][] board;
	private Position lastPlayed;

	public Board(int size) {
		boardPrintedLimits = "-";
		this.size = size;
		board = new char[size][size];
		initializeBoard();
		calculatePrintedLimits(size);
	}

	private void calculatePrintedLimits(int size) {

		for (int i = 0; i < size; i++) {

			this.boardPrintedLimits = this.boardPrintedLimits + "----";

		}
	}

	public void initializeBoard() {

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				board[i][j] = '-';

			}
		}
	}

	public void printBoard() {

		System.out.println(boardPrintedLimits);

		for (int i = 0; i < size; i++) {

			System.out.print("| ");

			for (int j = 0; j < size; j++) {

				System.out.print(board[i][j] + " | ");

			}

			System.out.println();

			System.out.println(boardPrintedLimits);

		}
	}

	public boolean mark(Position pos, Player player) {

		if (pos.row < 0 || pos.row >= size || pos.col < 0 || pos.col >= size) {
			System.out.println(pos.printPosition() +" is off the board");
			return false;
		}

		if (player == null) {

			System.out.println("cannot mark null player");
			return false;
		}

		if (board[pos.row][pos.col] != '-') {

			return false;

		} else {
			board[pos.row][pos.col] = player.symbol;
			setLastPlayed(pos);
			return true;
		}
	}

	public Position getLastPlayed() {
		return lastPlayed;
	}

	public void setLastPlayed(Position lastPlayed) {
		this.lastPlayed = lastPlayed;
	}

	public int getSize() {
		return size;
	}

	public char[][] getBoard() {
		return board;
	}

	public boolean checkFullBoard() {

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				if (board[i][j] == '-') {
					return false;
				}
			}
		}

		return true;
	}

	

}
