/**
 * Filename: DrawableMonster.java
 *
 * Description: Draws the monster
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public class DrawableMonster extends Monster implements Drawable
{
   public DrawableMonster(Maze maze)
   {
      super(maze);
   }
   public DrawableMonster(Maze maze, long seed)
   {
      super(maze, seed);
   }
   public DrawableMonster(Maze maze, Square location)
   {
      super(maze, location);
   }
   public void draw()
   {
      
   }
}
