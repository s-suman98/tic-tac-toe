package org.com.Strategy;

import org.com.entity.Board;

public interface WinningStrategyI {

   boolean hasWon(Board board,int lastRow,int lastCol);
   
}
