
import java.util.Scanner;

/**
 * Filename: Treasure.java
 *
 * Description: Creates the location of the treasure, allows it to be found.
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public class Treasure extends RandomOccupant
{
   private boolean found; //whether or not the treasure has been found by the Explorer
   
   public Treasure(Maze maze)
   {
      super(maze);
      this.found = false;

     // this.location().setTreasure(this);
   }
   public Treasure(Maze maze, long seed)
   {
      super(maze, seed);

      this.location().setTreasure(this);
   }
   public Treasure(Maze maze, Square location)
   {
      super(maze, location);

      this.location().setTreasure(this);
   }
   
   public boolean found()
   {
      return this.found;
   }
   public void setFound()
   {
      this.found = true;
   }
   
   @Override
   public void move()
   {
      
   }
   
   @Override
   public void moveTo(Square newLoc)
   {
      if(this.location() == null)
      {
         super.moveTo(newLoc);
         
         newLoc.setTreasure(this);
      }
   }
   
   public String toText(char delimiter)
   {
      return super.toText(delimiter) + delimiter + found();
   }
   
   public void toObject(Scanner input)
   {

      super.toObject(input);

      this.found = input.nextBoolean();

   }
}
