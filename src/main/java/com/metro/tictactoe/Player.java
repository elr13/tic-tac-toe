package com.metro.tictactoe;

public class Player {

	int position;
	char symbol;
	boolean isIA;
	
	public Player(int position, char symbol, boolean isIA) {
		this.position = position;
		this.symbol = symbol;
		this.isIA = isIA;
	}
}
