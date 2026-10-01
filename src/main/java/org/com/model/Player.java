package org.com.model;

import lombok.Data;
import org.com.enu.Symbol;

@Data
public class Player {
 private int id;
  private String name;
  private  Symbol symbol;  // uses symbol
}
