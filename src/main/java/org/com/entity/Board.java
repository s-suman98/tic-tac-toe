package org.com.entity;

import lombok.Data;
import lombok.Getter;
import org.com.enu.Symbol;
import org.com.model.Cell;


@Getter
public class Board {

private final int size;
private final Cell[][] cells;   // Owns cells


private int[] rowCount;   //effective
private int[] colCount;   //effective
private int totalCount;    //total filled count

private int mainDiagonalCount;
private int crossDiagonalCOunt;


 public Board (int size) {
	this.size = size;
	cells = new Cell[ size ][ size ];
	int k = 1;
	for ( int i = 0; i < this.size; i++ ) {
		for ( int j = 0; j < this.size; j++ ) {
			cells[ i ][ j ] = new Cell (k, Symbol.E);
			k++;
		}
	}
	
	
	this.rowCount=new int[this.size];
    this.colCount=new int[this.size];
}

public boolean isFull () {
	 return this.size*this.size==totalCount;
	
}

public boolean insideBoundry (int cr, int cc) {
	if ( cr < 0 || cc < 0 || cr >= this.size || cc >= this.size ) {
		return false;
	}
	return true;
}

public boolean isEmpty (int cr, int cc) {
	return cells[ cr ][ cc ].getSymbol () == Symbol.E;
}

public boolean isValid (int cr, int cc) {
	if ( !this.insideBoundry (cr, cc) ) {
		return false;
	}
	if ( !this.isEmpty (cr, cc) ) {
		return false;
	}
	return true;
}

public void placeSymbol(int cr, int cc, Cell cell) {
	cells[cr][cc] = cell;
	totalCount++;
	
	int value = cell.getSymbol() == Symbol.X ? 1 : -1;
	
	rowCount[cr] += value;
	colCount[cc] += value;
	
	if (cr == cc) {
		mainDiagonalCount += value;
	}
	
	if (cr + cc == size - 1) {
		crossDiagonalCOunt += value;
	}
}

public void printBoard () {
	for ( int i = 0; i < this.size; i++ ) {
		for ( int j = 0; j < this.size; j++ ) {
			System.out.print (cells[ i ][ j ].getSymbol () + " ");
		}
		System.out.println ();
	}
}

public boolean isAllSameInRow (int r) {
	Symbol symbol = cells[ r ][ 0 ].getSymbol ();
	if ( symbol == Symbol.E ) {
		return false;
	}
	
	return Math.abs(rowCount[r])==this.size;
	
}

public boolean isAllSameInCol (int c) {
	Symbol symbol = cells[ 0 ][ c ].getSymbol ();
	if ( symbol == Symbol.E ) {
		return false;
	}
	return Math.abs(colCount[c])==this.size;
}


public boolean isAllMainDiagonalSame () {
	Symbol symbol = cells[ 0 ][ 0 ].getSymbol ();
	if ( symbol == Symbol.E ) {
		return false;
	}
	   return this.mainDiagonalCount==this.size;
}

public boolean isAllSecDiagonalSame () {
	Symbol symbol = cells[ 0 ][ this.size - 1 ].getSymbol ();
	if ( symbol == Symbol.E ) {
		return false;
	}
	
	return this.crossDiagonalCOunt==this.size;
}
}
