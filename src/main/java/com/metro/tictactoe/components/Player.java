package com.metro.tictactoe.components;

public class Player {

	int position;
	char symbol;
	boolean isIA;
	
	public Player(int position, char symbol, boolean isIA) {
		this.position = position;
		this.symbol = symbol;
		this.isIA = isIA;

	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public boolean isIA() {
		return isIA;
	}

	public void setIA(boolean isIA) {
		this.isIA = isIA;
	}
	
}
