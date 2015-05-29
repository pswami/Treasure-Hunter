/**
 * Filename: DrawableSquare.java
 *
 * Description: Draws the Square areas of the maze
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public class DrawableSquare extends Square implements Drawable
{
   public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col)
   {
      super(up, right, down, left, row, col);
   }
   public void draw()
   {

   }
}
