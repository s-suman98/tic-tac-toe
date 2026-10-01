package org.com.Strategy;

import org.com.entity.Board;

public class SimpleStartegy implements  WinningStrategyI {

@Override
public boolean hasWon (Board board,int lastRow,int lastCol) {
	return board.isAllMainDiagonalSame ()||board.isAllSecDiagonalSame ()||board.isAllSameInCol (lastCol)||board.isAllSameInRow (lastRow);
	
}
}
