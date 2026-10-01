package org.com.entity;

import lombok.Data;
import lombok.Getter;
import org.com.enu.Symbol;
import org.com.model.Cell;

@Data
@Getter
public class Board {

private int size;
private Cell[][] cells;   // Owns cells

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
}

public boolean isFull () {
	for ( int i = 0; i < size; i++ ) {
		for ( int j = 0; j < size; j++ ) {
			if ( cells[ i ][ j ].getSymbol () == Symbol.E ) {
				return false;
			}
		}
	}
	return true;
	
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

public void placeSymbol (int cr, int cc, Cell cell) {
	cells[ cr ][ cc ] = cell;
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
	for ( int c = 1; c < this.size; c++ ) {
		if ( cells[ r ][ c ].getSymbol () != symbol ) {
			return false;
		}
	}
	return true;
	
}

public boolean isAllSameInCol (int c) {
	Symbol symbol = cells[ 0 ][ c ].getSymbol ();
	if ( symbol == Symbol.E ) {
		return false;
	}
	for ( int r = 1; r < this.size; r++ ) {
		if ( cells[ r ][ c ].getSymbol () != symbol ) {
			return false;
		}
	}
	return true;
}


public boolean isAllMainDiagonalSame () {
	Symbol symbol = cells[ 0 ][ 0 ].getSymbol ();
	if ( symbol == Symbol.E ) {
		return false;
	}
	for ( int i = 0; i < this.size; i++ ) {
		for ( int j = 0; j < this.size; j++ ) {
			if ( i == j && cells[ i ][ j ].getSymbol () != symbol ) {
				return false;
			}
		}
	}
	return true;
}

public boolean isAllSecDiagonalSame () {
	Symbol symbol = cells[ 0 ][ this.size - 1 ].getSymbol ();
	if ( symbol == Symbol.E ) {
		return false;
	}
	for ( int i = 0; i < this.size; i++ ) {
		for ( int j = 0; j < this.size; j++ ) {
			if ( (i + j == this.size - 1) && cells[ i ][ j ].getSymbol () != symbol ) {
				return false;
			}
		}
	}
	return true;
}
}
