
import java.util.Scanner;


/**
 * Filename: Square.java
 *
 * Description: Creates a square of size 50. Also creates walls, sets the treasure, and Current 
 *              View of the Explorer
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public class Square implements DelimitedTextIO
{
   public static final int SQUARE_SIZE = 50;
   public static final int UP = 0;
   public static final int RIGHT = 1;
   public static final int DOWN = 2;
   public static final int LEFT = 3;
   
   private boolean[] sqWalls;
   private boolean  sqSeen; //whether the Square has been sqSeen or not
   private boolean CurrentView; //whether the Square is currently in view or not
   //private int sqSize[][];
   private int row;
   private int col;
   private Treasure treasure;
   
   public Square(boolean up, boolean right, boolean down, boolean left, int row, int col)
   {
      this.sqWalls = new boolean[]{up, left, down , right};
      //this.sqSize = new int[row][col];
      this.row = row;
      this.col = col;
      this.sqSeen = false;
      this.CurrentView = false;
      this.treasure = null;
   }
   public Square(int row, int col)
   {
      this.row = row;
      this.col = col;
      
   }
   
   //QUERIES
   public boolean seen()
   {
      return this.sqSeen;
   }
   public boolean inView()
   {
      return this.CurrentView;
   }
   public int row()
   {
      return this.row;
   }
   public int col()
   {
      return this.col;
   }
   public Treasure treasure()
   {
      return this.treasure;
   }
   public boolean wall(int direction)
   {
      if(direction == UP)
      {
         return sqWalls[0];
      }
      else if(direction == LEFT)
      {
         return sqWalls[1];
      }
      else if(direction == DOWN)
      {
         return sqWalls[2];
      }
      else if(direction == RIGHT)
      {
         return sqWalls[3];
      }
      else
      {
         return false;
      }
   }
   public int x()
   {
      int x = 0;
      
      x = col()* SQUARE_SIZE;
  
      return x;
   }
   public int y()
   {
      int y = 0;
      
      y = row()* SQUARE_SIZE;
  
      return y;
   }
   public void setInView(boolean inView)
   {
      if(inView == true)
      {
         sqSeen = true;
         CurrentView = true;
      }
      else
      {
         CurrentView = false;
      }
   }
   public void setTreasure(Treasure t)
   {
      this.treasure = t;
   }
   public void enter()
   {
      if(treasure == null)
      {
         
      }
      else
      {
         setTreasure(treasure);
         treasure.setFound();
      }
   }
   
   //Implemention
   public String toText(char delimiter)
   {

      return getClass().getName() + delimiter
              + this.row + delimiter
              + this.col + delimiter
              + this.sqWalls[UP] + delimiter
              + this.sqWalls[LEFT]+ delimiter
              + this.sqWalls[DOWN] + delimiter
              + this.sqWalls[RIGHT] + delimiter
              + this.sqSeen + delimiter
              + this.CurrentView;

   }

   public void toObject(Scanner input)
   {

         boolean Wup = input.nextBoolean();
         boolean Wright = input.nextBoolean();
         boolean Wdown = input.nextBoolean();
         boolean Wleft = input.nextBoolean();
         boolean seenNew = input.nextBoolean();
         boolean inViewnew = input.nextBoolean();

         this.sqWalls = new boolean[]{Wup, Wleft, Wdown , Wright};
         
         this.sqSeen = seenNew;

         this.CurrentView = inViewnew;
         
   }
}