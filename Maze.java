
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Filename: Maze.java
 *
 * Description: Class that contains all the logic to model a Maze with Treasures, Monsters, 
 *              and an Explorer.
 *
 * @author Pauras Swami 
 * 
 * @version Program 5
 * 
 */

public class Maze
{
   // named constants

   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
   // instance variables
   private Square[][] maze;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   
   public Maze(Square[][] maze, int rows, int cols)
   {
      // DONE - initialize the maze, rows, and cols instance variables
      
      this.maze = maze;
      this.rows = rows;
      this.cols = cols;

      // DONE - create the empty ArrayList of RandomOccupants
      this.randOccupants = new ArrayList<RandomOccupant>();
   }
   public Maze()
   {
      this.randOccupants = new ArrayList<RandomOccupant>();
   }
   // QUERIES
   public Square getSquare(int row, int col)
   {
      return maze[row][col];
   }

   public int rows()
   {
      return rows;
   }

   public int cols()
   {
      return cols;
   }

   public String explorerName()
   {
      return explorer.name();
   }

   public Explorer getExplorer()
   {
      return explorer;
   }

   // DONE - Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index)
   {
      return randOccupants.get(index);
   }

   public int getNumRandOccupants()
   {
      return randOccupants.size();
   }

   // COMMANDS
   // DONE - implement the following method
   public void addRandomOccupant(RandomOccupant ro)
   {
      randOccupants.add(ro);
   }

   public void setExplorer(Explorer e)
   {
      explorer = e;
   }

   public void explorerMove(int key)
   {
      explorer.move(key);
   }

   public void randMove()
   {
      // MAYBE - instruct each object in the RandomOccupant to move
      for (int i = 0; i < randOccupants.size(); i++)
      {
         getRandomOccupant(i).move();
      }

   }

   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN. If not, check each maze occupant, if it
    * is a Monster and it is in the same location as the Explorer, return MONSTER_WIN. Note that you
    * can use == to check locations, do you know why? Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;

      //MAYBE
      if (foundAllTreasures() == true)
      {
         return EXPLORER_WIN;
      }
      for (int i = 0; i < getNumRandOccupants(); i++)
      {
         if (getRandomOccupant(i) instanceof Monster)
         {
            if (getExplorer().location() == getRandomOccupant(i).location())
            {
               return MONSTER_WIN;
            }
         }
      }
      return status;

   }

   private boolean foundAllTreasures()
   {
      boolean foundAll = true;

      // CHANGE - search through all the occupants to see if the Treasures have been found.  Return false if
      //        - there is a Treasure that hasn't been found.
      for (int i = 0; i < getNumRandOccupants(); i++)
      {
         if(getRandomOccupant(i) instanceof Treasure)
         {
            if (getRandomOccupant(i).location().treasure().found() == false)
            {
               return false;
            }
         }
      }
      return foundAll;
   }

   public void lookAround(Square s)
   {

      // Clear what was previously in view
      resetInView();

      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);

      // CHANGE - Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
      //        - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.

  
      if (s.wall(Square.UP) == false)
      {
         getSquare(s.row() - 1, s.col()).setInView(true); //UP

         if (getSquare(s.row() - 1, s.col()).wall(Square.RIGHT) == false)
         {
            getSquare(s.row() - 1, s.col() + 1).setInView(true);  
         }
         if (getSquare(s.row() - 1, s.col()).wall(Square.LEFT) == false)
         {
            getSquare(s.row() - 1, s.col() - 1).setInView(true);
         }
      }

      if (s.wall(Square.DOWN) == false)
      {
         getSquare(s.row() + 1, s.col()).setInView(true);

         if (getSquare(s.row() + 1, s.col()).wall(Square.RIGHT) == false)
         {
            getSquare(s.row() + 1, s.col() + 1).setInView(true);
         }
         if (getSquare(s.row() + 1, s.col()).wall(Square.LEFT) == false)
         {
            getSquare(s.row() + 1, s.col() - 1).setInView(true);
         }
      }

      if (s.wall(s.LEFT) == false)
      {
         getSquare(s.row(), s.col() - 1).setInView(true);

         if (getSquare(s.row(), s.col() - 1).wall(Square.UP) == false)
         {
            getSquare(s.row() - 1, s.col() - 1).setInView(true);
         }
         if (getSquare(s.row(), s.col() - 1).wall(Square.DOWN) == false)
         {
            getSquare(s.row() + 1, s.col() - 1).setInView(true);
         }
      }

      if (s.wall(Square.RIGHT) == false)
      {
         getSquare(s.row(), s.col() + 1).setInView(true);

         if (getSquare(s.row(), s.col() + 1).wall(Square.UP) == false)
         {
            getSquare(s.row() - 1, s.col() + 1).setInView(true);
         }
         if (getSquare(s.row(), s.col() + 1).wall(Square.DOWN) == false)
         {
            getSquare(s.row() + 1, s.col() + 1).setInView(true);
         }
      }
   }

   private void resetInView()
   {
      for (int i = 0; i < rows; i++)
      {
         for (int j = 0; j < cols; j++)
         {
            maze[i][j].setInView(false);
         }
      }
   }

   public void writeMazeToFile(String fileName) throws IOException
   {
      PrintStream export = new PrintStream(new File(fileName));
      //PrintWriter export = new PrintWriter(new File(fileName));
      char delimiter = ',';

      export.println(this.rows + "," + this.cols);
      
      for (int i = 0; i < rows; i++)
      {
         for (int j = 0; j < cols; j++)
         {
            export.println(getSquare(i, j).toText(delimiter));
         }
      }

      if(this.explorer != null)
      {
         export.println(this.explorer.toText(delimiter));
      }

      for (int r = 0; r < this.getNumRandOccupants(); r++)
      {
         export.println(getRandomOccupant(r).toText(delimiter));
      }
      
      export.close();
   }
   public void readMazeFromFile(String fileName) throws IOException,
                                                        FileNotFoundException,
                                                        MazeReadException
   {
      File input = new File(fileName);

      //Read EACH LINE
      Scanner readLines = new Scanner(input);
      readLines.useDelimiter(System.getProperty("line.separator"));

      int mazeR;
      int mazeC;
      int ln = 1;

      String mazeRC = readLines.next();
      Scanner parser = new Scanner(mazeRC);
      parser.useDelimiter(",");
      
      //MAZE READ
      if (parser.hasNextInt())
      {
         mazeR = parser.nextInt();
      }
      else
      {
         throw new MazeReadException("Rows and columns not specified.", mazeRC, ln);
      }
      if (parser.hasNextInt())
      {
         mazeC = parser.nextInt();
      }
      else
      {
         throw new MazeReadException("Rows and columns not specified.", mazeRC, ln);
      }

      this.maze = new Square[mazeR][mazeC];
      this.rows = mazeR;
      this.cols = mazeC;

      //READ SQUARES AND OCCUPANTS
      while (readLines.hasNext())
      {
         ln++;
         mazeRC = readLines.next();
         parser = new Scanner(mazeRC);
         parser.useDelimiter(",");
         String type;
         
         
         if (parser.hasNext())
         {
            type = parser.next();
         }
         else
         {
            throw new MazeReadException("Line format or other error.", mazeRC, ln);
         }
         //READ SQUAREs
         if (type.equals("Square"))
         {
            int Srow = parser.nextInt();
            int Scol = parser.nextInt();
            
            if (this.maze[Srow][Scol] != null)
            {
               throw new MazeReadException("Duplicate square.", mazeRC, ln);
            }
            try
            {
               this.maze[Srow][Scol] = new Square(Srow, Scol);
               this.maze[Srow][Scol].toObject(parser);
            }
            catch (Exception e)
            {
               throw new MazeReadException("Line format or other error.", mazeRC, ln);
            }
         }
         //READ Explorer
         else if (type.equals("Explorer"))
         {
            this.explorer = new Explorer(this);
            
            try
            {
               this.explorer.toObject(parser);
            }
            catch (Exception e)
            {
               throw new MazeReadException("Line format or other error.", mazeRC, ln);
            }
         }
         //READ MONSTER
         else if (type.equals("Monster"))
         {
            Monster m = new Monster(this);
            try
            {
               m.toObject(parser);
            }
            catch (Exception e)
            {
               throw new MazeReadException("Line format or other error.", mazeRC, ln);
            }
            this.addRandomOccupant(m);
         }
         //READ TREASURE
         else if (type.equals("Treasure"))
         {
            Treasure t = new Treasure(this);
            try
            {
               t.toObject(parser);
            }
            catch (Exception e)
            {
               throw new MazeReadException("Line format or other error.", mazeRC, ln);
            }
            this.addRandomOccupant(t);
         }
         else
         {
            throw new MazeReadException("Unknown type.", mazeRC, ln);
         }
      }
   }
}
