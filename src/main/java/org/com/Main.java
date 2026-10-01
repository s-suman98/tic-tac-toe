package org.com;

import org.com.Strategy.SimpleStartegy;
import org.com.entity.Board;
import org.com.entity.Game;
import org.com.enu.GameStatus;
import org.com.enu.Symbol;
import org.com.exception.InvalidMoveException;
import org.com.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
public static void main (String[] args) {
	
	
	Board board=new Board(3);
	
	 Player p1=new Player ();
	 p1.setId (1);;
	 p1.setName ("ANISH");
	 p1.setSymbol (Symbol.X);
	 
	 Player p2=new Player ();
	 p2.setId (2);
	 p2.setName ("SUMIT");
	 p2.setSymbol (Symbol.O);
	 
	 List<Player> players=new ArrayList<> ();
	 players.add(p1);
	 players.add(p2);
	 
	
	
	 Game game= Game.builder().name ("TIC TAC TOE GAME").board (board).gameStatus (GameStatus.IN_PROGRESS).players(players).currentPlayerTurn (0).winningstrategy (new SimpleStartegy ()).build ();
	 
	 
	 while(game.getGameStatus ()==GameStatus.IN_PROGRESS){
		 
		 System.out.println ("Player"+game.getPlayers ().get(game.getCurrentPlayerTurn ()).getSymbol () + "Turn");
		 
		 int currRow=new Random ().nextInt (game.getBoard ().getSize ());
		 int currCol=new Random ().nextInt (game.getBoard ().getSize ());
		 
		 System.out.println ("Turn ["+currRow+"|"+currCol+"]");
		 
		 try {
			 game.makeMove (currRow, currCol);
			 game.getBoard ().printBoard ();
			 
		 }catch(InvalidMoveException e){
			 System.out.println("INVALID MOVE"+e.getMessage ());
			 System.out.println ("Retry");
			 
		 }
		  
		 
	 }
	 
	 
	  if(game.getGameStatus ()==GameStatus.WINNER_O) {
		  System.out.println ("Player O have won the Game");
		  
	  }
	
	if(game.getGameStatus ()==GameStatus.WINNER_X) {
		System.out.println ("Player X have won the Game");
		
	}
	if(game.getGameStatus ()==GameStatus.DRAW) {
		System.out.println ("GAME DRAWN");
		
	}
	
	
}
}