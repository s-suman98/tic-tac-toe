package org.com.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.com.Strategy.WinningStrategyI;
import org.com.enu.GameStatus;
import org.com.enu.Symbol;
import org.com.exception.InvalidGameStateException;
import org.com.exception.InvalidMoveException;
import org.com.model.Cell;
import org.com.model.Player;

import java.util.List;


@Data
@Setter
@Builder
public class Game {

   private String name ;
   
   private  Board board ; //owns board

   private  List< Player > players; //uses player

  private  int  currentPlayerTurn;
  
  private  GameStatus gameStatus; //uses game status

  private WinningStrategyI winningstrategy; // uses it




private void switchPlayer(){
	
	int next=(currentPlayerTurn+1)%players.size ();
	this.currentPlayerTurn=next;
	
}
  
  
  public GameStatus makeMove(int cr,int cc){
	  
	   if(this.gameStatus!=GameStatus.IN_PROGRESS){
		   throw new InvalidGameStateException ("Game has alredy finshed/drawn");
	   }
	   
	   if( !board.insideBoundry (cr, cc) ){
		   throw  new InvalidMoveException ("Move cant be outside the board");
	   }
	   
	   if( !board.isEmpty (cr, cc) ){
		   throw new InvalidMoveException ("You can't fill on alredy placed sympbol");
	   }
	   
	   Cell cell=new Cell (cr*board.getSize()+cc,players.get(currentPlayerTurn).getSymbol ());
	   
	    board.placeSymbol (cr, cc,cell);
		
		if(winningstrategy.hasWon (board,cr,cc)){
			Symbol symbol=players.get(currentPlayerTurn).getSymbol();
			if(symbol==Symbol.X){
				this.gameStatus=GameStatus.WINNER_X;
				return GameStatus.WINNER_X;
			}
			this.gameStatus=GameStatus.WINNER_O;
			return GameStatus.WINNER_O;
		}
		
		if(board.isFull ()){
			this.gameStatus = GameStatus.DRAW;
			return GameStatus.DRAW;
		}
		
		switchPlayer ();
		
		
		return GameStatus.IN_PROGRESS;
		
  }
  
  
  
  
  
  
}
