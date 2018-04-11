package com.metro.tictactoe;

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
	
	
}
