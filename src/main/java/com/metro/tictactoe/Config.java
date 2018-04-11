package com.metro.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Value("${size:3}")
	int size;
	
	@Value("${human.player1.symbol:O}")
	char firstPlayerSymbol;
	
	@Value("${human.player2.symbol:X}")
	char secondPlayerSymbol;
	
	@Value("${computer.symbol:I}")
	char computerSymbol;

	@Bean
	public Board board() throws Exception {
		checkSize();
		return new Board(size);
	}
	
	@Bean
	public List<Player> players(){
		
		List<Player> players = new ArrayList<>();
		
		players.add(new Player(1, firstPlayerSymbol, false));
		players.add(new Player(2, secondPlayerSymbol, false));
		players.add(new Player(3, computerSymbol, true));
		
		long seed = System.nanoTime();
		Collections.shuffle(players, new Random(seed));
		
		return players;
	}
	
	private void checkSize() throws Exception {
		if(size < 3 || size > 10) {
			throw new IllegalArgumentException("wrong board size");
		}
	}

}
