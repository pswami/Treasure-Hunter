/**
 * Filename: MazeReadException.java
 *
 * Description: 
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public class MazeReadException extends Exception
{
   private String l;
   private int lineNum;
   public MazeReadException(String message, String line, int lineNumber)
   {
      super(message);
      this.l = line;
      this.lineNum = lineNumber;
   }
   public String getLine()
   {
      return this.l;
   }
   public int getLineNum()
   {
      return this.lineNum;
   }
}
