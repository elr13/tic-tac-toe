package com.metro.tictactoe;

public class GameState {
	
	public GameState() {
		super();
	}
	
	public boolean checkWin(Player player, Board boardGame) {

		char[][] board = boardGame.getBoard();
		char symbol = player.symbol;
		int x = boardGame.getLastPlayed().row;
		int y = boardGame.getLastPlayed().col;
		int n = boardGame.getSize();

		// check verticals
		int sumWin = 0;
		for (int i = 0; i < n; i++) {
			if (board[x][i] != symbol) {
				sumWin = 0;
				continue;
			}
			sumWin++;
			if (sumWin == 3) {
				callWinner(player);
				return true;
			}
		}

		// check horizontals
		sumWin = 0;
		for (int i = 0; i < n; i++) {
			if (board[i][y] != symbol) {
				sumWin = 0;
				continue;
			}
			sumWin++;
			if (sumWin == 3) {
				callWinner(player);
				return true;
			}
		}

		if (checkDiagonals(x, y, n, symbol, board, player) >= 3) {
			callWinner(player);
			return true;
		}
		if (checkAntiDiagonals(x, y, n, symbol, board, player) >= 3) {
			callWinner(player);
			return true;
		}
		return false;
	}

	private Integer checkDiagonals(int x, int y, int n, char symbol, char[][] board, Player player) {
		int sumWin = 1;
		for (int i = 1; i < n; i++) {
			// if still on board
			if (x + i < n && y + i < n) {
				if (board[x + i][y + i] == symbol) {
					sumWin++;
				} else {
					break;
				}
			} else {
				break;
			}

		}
		for (int i = 1; i < n; i++) {
			// if still on board
			if (x - i >= 0 && y - i >= 0) {
				if (board[x - i][y - i] == symbol) {
					sumWin++;
				} else {
					break;
				}
			}
		}
		return sumWin;
	}

	private Integer checkAntiDiagonals(int x, int y, int n, char symbol, char[][] board, Player player) {

		int sumWin = 1;
		for (int i = 1; i < n; i++) {
			// if still on board bellow
			if (x + i < n && y - i >= 0) {
				if (board[x + i][y - i] == symbol) {
					sumWin++;
				} else {
					break;
				}
			} else {
				break;
			}

		}
		for (int i = 1; i < n; i++) {
			// if still on board above
			if (x - i >= 0 && y + i < n) {
				if (board[x - i][y + i] == symbol) {
					sumWin++;
				} else {
					break;
				}
			}
		}
		return sumWin;
	}

	public boolean checkDraw(Board gameBoard) {
		if (gameBoard.checkFullBoard()) {
			System.out.println("The board is full, game is over. ");
			return true;
		}
		return false;
	}

	private void callWinner(Player player) {
		System.out.println("Player " + player.symbol + " wins!");

	}
}
