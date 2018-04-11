package com.metro.tictactoe;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metro.tictactoe.components.Board;
import com.metro.tictactoe.components.Player;
import com.metro.tictactoe.components.Position;
import com.metro.tictactoe.game.Game;
import com.metro.tictactoe.game.GameState;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WinTests {
	Board gameBoard;
	List<Player> players;
	Game game;
	

	@Before
	public void setup() {
		gameBoard = new Board(3);
		players = new ArrayList<>();
		players.add(new Player(2, 'X', false));
		players.add(new Player(3, 'O', true));
	}
	@Test
	public void noWin() {
		GameState gameStauts = new GameState();
		gameBoard.mark(new Position(1, 1), players.get(0));
		assertEquals(gameStauts.checkWin(players.get(0), gameBoard), false);
	}

	@Test
	public void diagonalWin() {
		GameState gameStauts = new GameState();

		gameBoard.mark(new Position(0, 0), players.get(0));
		gameBoard.mark(new Position(1, 1), players.get(0));
		gameBoard.mark(new Position(2, 2), players.get(0));
		
		assertEquals(gameStauts.checkWin(players.get(0), gameBoard), true);
	}

	@Test
	public void antiDiagonalWin() {
		GameState gameStauts = new GameState();

		gameBoard.mark(new Position(0, 2), players.get(0));
		gameBoard.mark(new Position(1, 1), players.get(0));
		gameBoard.mark(new Position(2, 0), players.get(0));
		
		assertEquals(gameStauts.checkWin(players.get(0), gameBoard), true);
	}

	@Test
	public void verticalWin() {
		GameState gameStauts = new GameState();

		gameBoard.mark(new Position(0, 0), players.get(0));
		gameBoard.mark(new Position(0, 1), players.get(0));
		gameBoard.mark(new Position(0, 2), players.get(0));
		
		assertEquals(gameStauts.checkWin(players.get(0), gameBoard), true);
	}

	@Test
	public void horizontalWin() {
		GameState gameStauts = new GameState();

		gameBoard.mark(new Position(0, 0), players.get(0));
		gameBoard.mark(new Position(1, 0), players.get(0));
		gameBoard.mark(new Position(2, 0), players.get(0));
		
		assertEquals(gameStauts.checkWin(players.get(0), gameBoard), true);
	}

	@Test
	public void draw() {
		GameState gameStauts = new GameState();

		gameBoard.mark(new Position(0, 0), players.get(0));
		gameBoard.mark(new Position(1, 0), players.get(1));
		gameBoard.mark(new Position(2, 0), players.get(0));
		gameBoard.mark(new Position(0, 1), players.get(1));
		gameBoard.mark(new Position(1, 1), players.get(1));
		gameBoard.mark(new Position(2, 1), players.get(0));
		gameBoard.mark(new Position(0, 2), players.get(0));
		gameBoard.mark(new Position(1, 2), players.get(1));
		gameBoard.mark(new Position(2, 2), players.get(1));
		
		assertEquals(gameStauts.checkDraw(gameBoard), true);
	}

}
