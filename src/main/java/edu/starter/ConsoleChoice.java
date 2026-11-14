package edu.starter;
import java.util.Scanner;
/** Optional small UI utility; never put battle rules here. */
public final class ConsoleChoice {
 private ConsoleChoice(){}
 /**
  * @pre in != null; in is open; min <= max.
  * @post Consumes one line if available and returns its trimmed integer value
  *       when it parses as an int in [min, max]; otherwise returns -1.
  * @post If no line is available, returns -1 without consuming input.
  */
 public static int read(Scanner in, int min, int max){
  if(!in.hasNextLine())return -1;
  try {int v=Integer.parseInt(in.nextLine().trim());return v>=min&&v<=max?v:-1;}
  catch(NumberFormatException ex){return -1;}
 }
}
