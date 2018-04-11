package com.metro.tictactoe.components;

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

	
	//calulate board border size
	private void calculatePrintedLimits(int size) {

		for (int i = 0; i < size; i++) {

			this.boardPrintedLimits = this.boardPrintedLimits + "----";

		}
	}

	//set default values to -
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

	//mark a cell with a char
	public boolean mark(Position pos, Player player) {
		//check if in the board
		if (pos.row < 0 || pos.row >= size || pos.col < 0 || pos.col >= size) {
			System.out.println(pos.printPosition() +" is off the board");
			return false;
		}

		if (player == null) {

			System.out.println("cannot mark null player");
			return false;
		}

		//check if free cell
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

	//check board is full
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
