
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;

/**
 * Filename: RandomOccupant.java
 *
 * Description: An abstract class that randomly places the treasure and the Monster
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public abstract class RandomOccupant extends Occupant
{

   private Random random = new Random(); //generate random #'s for movement and intial location
   private Maze locateSelf;

   public RandomOccupant(Maze maze)
   {
      super();
      this.locateSelf = maze;
      
      if(maze.rows() > 0 && maze.cols() > 0) 
      {
      int row = random.nextInt(maze.rows());
      int col = random.nextInt(maze.cols());
      
      moveTo(maze.getSquare(row, col));
      }
   }

   public RandomOccupant(Maze maze, long seed)
   {
      super();
      this.locateSelf = maze;
      random = new Random(seed);
      
      if(maze.rows() > 0 && maze.cols() > 0) 
      {
      int row = random.nextInt(maze.rows());
      int col = random.nextInt(maze.cols());
      
      moveTo(maze.getSquare(row, col));
      }
   }

   public RandomOccupant(Maze maze, Square location)
   {
      super(location);
      this.locateSelf = maze;
   }

   public void move()
   {
      
      int row = location().row();
      int col = location().col();
      
      int randomNumber = random.nextInt(4);

      while (location().wall(randomNumber) == true)
      {
         randomNumber = random.nextInt(4);
      }

      if (randomNumber == Square.UP)
      {
         //move UP
         moveTo(locateSelf.getSquare(row - 1, col));
      }
      else if ((randomNumber == Square.LEFT))
      {
         //move LEFT
         moveTo(locateSelf.getSquare(row, col - 1));
      }
      else if (randomNumber == Square.DOWN)
      {
         //move DOWN
         moveTo(locateSelf.getSquare(row + 1, col));
      }
      else if (randomNumber == Square.RIGHT)
      {
         //move RIGHT
         moveTo(locateSelf.getSquare(row, col + 1));
      }
   }
   public void toObject(Scanner input)
   {
       super.moveTo(locateSelf.getSquare(input.nextInt(), input.nextInt()));
   }
}