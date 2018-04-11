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

@RunWith(SpringRunner.class)
@SpringBootTest
public class TictactoeApplicationTests {

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
	public void testBoardInitialized() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals(gameBoard.getBoard()[i][j], '-');
			}
		}
		assertEquals(gameBoard.getSize(), 3);
		assertEquals(gameBoard.checkFullBoard(), false);
	}

	@Test
	public void getMarkOffBoard() {
		assertEquals(gameBoard.mark(new Position(-1, -1), players.get(0)), false);
		assertEquals(gameBoard.mark(new Position(1000, 1), players.get(0)), false);
		assertEquals(gameBoard.mark(new Position(1, 1000), players.get(0)), false);
	}

	@Test
	public void getMarkOnBoard() {
		assertEquals(gameBoard.mark(new Position(1, 1), players.get(0)), true);
	}

	@Test
	public void getMarkedTwice() {
		gameBoard.mark(new Position(1, 1), players.get(0));
		assertEquals(gameBoard.mark(new Position(1, 1), players.get(0)), false);
	}



}
