
import java.util.Random;
import java.util.Scanner;

/**
 * Filename: Monster.java
 *
 * Description: Monster class that extends RandomOccupant so it can be placed randomly.
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public class Monster extends RandomOccupant
{
   public Monster(Maze maze)
   {
      super(maze);
   }
   public Monster(Maze maze, long seed)
   {
      super(maze, seed);
   }
   public Monster(Maze maze, Square location)
   {
      super(maze, location);
   }
}
