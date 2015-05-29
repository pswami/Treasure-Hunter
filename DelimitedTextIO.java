
import java.util.Scanner;
 /**
 * Filename: DelimitedTextIO.java
 *
 * Description: String Conversion and Reversion
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */
public interface DelimitedTextIO
{
//   //This method returns a String containing all the data of the implementing class as text and 
//   with each element separated by the provided delimiter.
   public String toText(char delimiter);
   
//   This method uses the provided Scanner input to parse delimited text representing the data for 
//   the implementing class and initializes the objects instance variables with the parsed values. 
//   The delimiter to use must be specified for the Scanner input before calling this method. 
   public void toObject(Scanner input);
}
