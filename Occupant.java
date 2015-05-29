
import java.util.Scanner;

/**
 * Filename: Occupant.java
 *
 * Description: An abstract class that creates the location of the Explorer and other objects.
 *
 * @author Pauras Swami
 *
 * @version Program 5
 *
 */
public abstract class Occupant implements DelimitedTextIO
{

   private Square locOccupant;

   public Occupant()
   {
   }

   public Occupant(Square start)
   {
      this.locOccupant = start;
   }

   public Square location()
   {
      return locOccupant;
   }

   public void moveTo(Square newLoc)
   {
      this.locOccupant = newLoc;
   }

   public String toText(char delimiter)
   {
      return getClass().getName()
              + delimiter
              + location().row()
              + delimiter
              + location().col();

   }
}
