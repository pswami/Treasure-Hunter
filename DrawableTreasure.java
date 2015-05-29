/**
 * Filename: DrawableTreasure.java
 *
 * Description: Draws the Treasure
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public class DrawableTreasure extends Treasure implements Drawable
{
   public DrawableTreasure(Maze maze)
   {
      super(maze);
   }
   public DrawableTreasure(Maze maze, long seed)
   {
      super(maze, seed);
   }
   public DrawableTreasure(Maze maze, Square location)
   {
      super(maze, location);
   }
   public void draw()
   {
      
   }
}
