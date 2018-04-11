package com.metro.tictactoe.components;

public class Position {

	int row;
	int col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public String printPosition() {
		int row,col;
		row = this.row +1 ;
		col = this.col +1;
		return "("+row+","+col+")";
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
}
