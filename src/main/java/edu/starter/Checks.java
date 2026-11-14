package edu.starter;
/** Optional assertions for verifying state in early workshops. */
public final class Checks {
 private Checks(){}
 /**
  * @pre No requirements; message may be null.
  * @post Returns normally if condition is true; otherwise throws AssertionError
  *       using message as its detail. No application state is changed.
  */
 public static void that(boolean condition,String message){if(!condition)throw new AssertionError(message);}
 /**
  * @pre min <= max.
  * @post result == max(min, min(max, value)); min <= result <= max.
  */
 public static int within(int value,int min,int max){return Math.max(min,Math.min(max,value));}
}
