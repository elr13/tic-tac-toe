package com.metro.tictactoe.game;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.metro.tictactoe.components.Board;
import com.metro.tictactoe.components.Player;
import com.metro.tictactoe.components.Position;

@Component
public class Game {

    @Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private Board gameBoard;

	@Autowired
	private List<Player> players;

	private int currentPlayer = 0;

	private Scanner sc = new Scanner(System.in);

	private boolean winner = false;
	private boolean draw = false;

	@Scheduled(fixedDelay = 1000)
	public void run() throws IOException {
		GameState gameState = new GameState();
		printRules();
		gameBoard.printBoard();
		while (!winner && !draw) {

			nextPlayer();
			Player player = players.get(currentPlayer);

			move(player);
			winner = gameState.checkWin(player, gameBoard);
			draw = gameState.checkDraw(gameBoard);

			gameBoard.printBoard();
		}
		
		String replay = parseReplayAnswer();
		
		if (replay.equals("n")) {
			System.exit(0);
		}
		prepareReplay();
	}

	private void prepareReplay() {

		gameBoard.initializeBoard();
		winner = false;
		draw = false;
	}



	private void move(Player player) {
		
		if (player.isIA()) {
			moveIa(player);

		} else {
			moveHuman(player);
		}

		System.out.println("Player " + player.getSymbol() + " played " + gameBoard.getLastPlayed().printPosition());

	}

	void moveHuman(Player player) {

		System.out.println("Player " + player.getSymbol() + ", please enter next positions:");
		boolean played = false;

		while (!played) {

			String str = sc.next();
			played = parseNextPositions(str, player);
			if (!played) {
				System.out.println("Enter valid positions.");
			}

		}

	}
	
	Boolean parseNextPositions(String input, Player player) {

		String[] posInput = input.split(",");

		if (posInput.length != 2) {
			printInstructions();
			return false;

		}

		int row, col;
		try {

			row = Integer.parseInt(posInput[0]) - 1;
			col = Integer.parseInt(posInput[1]) - 1;

		} catch (NumberFormatException e) {

			printInstructions();
			return false;

		}
		return gameBoard.mark(new Position(row, col), player);
	}

	private void moveIa(Player player) {

		int row = ThreadLocalRandom.current().nextInt(1, gameBoard.getSize());
		int col = ThreadLocalRandom.current().nextInt(1, gameBoard.getSize());

		boolean retry = gameBoard.mark(new Position(row, col), player);
		
		if (!retry) {
			moveIa(player);
		}
	}

	private void nextPlayer() {

		currentPlayer++;
		if (currentPlayer == 3) {
			currentPlayer = 0;
		}
	}

	private void printRules() {
		System.out.println("Tic-tac-toe is for 3 players, " + players.get(0).getSymbol() + ", " + players.get(1).getSymbol()
				+ " and " + players.get(2).getSymbol() + ", who take turns marking the spaces in a " + gameBoard.getSize() + "×"
				+ gameBoard.getSize()
				+ " grid. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game.\\n");
		printInstructions();
	}

	private void printInstructions() {

		System.out.println("The next position should be provided in a row,colomn format like 3,2.");

	}

	private String parseReplayAnswer() {

		System.out.println("Would you like to play a new game? y/n");
		
		String answer = sc.next();
		if(!answer.equals("y") && !answer.equals("n")) {
			return parseReplayAnswer();
			
		}
		
		return answer;
	}
	
}
