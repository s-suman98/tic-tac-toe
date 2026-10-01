package org.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.com.enu.Symbol;


@Data
@AllArgsConstructor
public class Cell {

  private int id;
   private  Symbol symbol; //owns symbol
	
}
