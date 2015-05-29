
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * Filename: Explorer.java
 *
 * Description: Class that contains the Explorer's ability to move
 *
 * @author Pauras Swami
 *
 * @version Program 5
 *
 */
public class Explorer extends Occupant
{

   private String name;
   private Maze m; //a reference to Maz, to locate itself and move about the Maze
   
   
   public Explorer(Square location, Maze maze, String name)
   {
      super(location);
      this.m = maze;
      this.name = name;

      maze.lookAround(location);
   }
   public Explorer(Maze maze)
   {
      this.m = maze;
   }

   public String name()
   {
      return name;
   }

   public void move(int key)
   {
      int row = location().row();
      int col = location().col();

      int dir = 0;

      if (key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP)
      {
         dir = Square.UP;

         if (location().wall(dir) == false)
         {
            //move UP
            moveTo(m.getSquare(row - 1, col));
         }
         else
         {
         }
      }
      if ((key == KeyEvent.VK_LEFT) || key == KeyEvent.VK_KP_LEFT)
      {
         dir = Square.LEFT;

         if (location().wall(dir) == false)
         {
            //move LEFT
            moveTo(m.getSquare(row, col - 1));
         }
         else
         {
         }
      }
      if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN)
      {
         dir = Square.DOWN;

         if (location().wall(dir) == false)
         {
            //move DOWN
            moveTo(m.getSquare(row + 1, col));
         }
         else
         {
         }
      }
      if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT)
      {
         dir = Square.RIGHT;

         if (location().wall(dir) == false)
         {
            //move RIGHT
            moveTo(m.getSquare(row, col + 1));
         }
         else
         {
         }
      }
   }
   public void moveTo(Square s)
   {
      super.moveTo(s);

      s.enter();
      m.lookAround(s);
   }
   public String toText(char delimiter)
   {
      return  super.toText(delimiter) + delimiter + this.name;
   }
   
   public void toObject(Scanner input)
   {
      //super.toObject(input);
      this.moveTo(m.getSquare(input.nextInt(), input.nextInt()));
      this.name = input.next();
   }
}