/*
 * TCSS 143 Fall2015
 * Teacher David S. 
 * Assign_2.java
 * Oct 13. 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Calculates matrices and prints them to a file. 
 * @author sahmad
 * @version Fall2015
 */
public class Assign_2 {

  /**
   *  Main method to execute whole code.
   * @param theArgs
   */
	
   public static void main(String[] theArgs) {
       Scanner input = null; // For file input
       //PrintStream output = null; // For file output
        
       boolean filesOk = false; // Checks for files to be accessed
       int[][] theA = null; // Declaring the 4 arrays for operations
       int[][] theB = null;
       int[][] theC = null;  
       int[][] theD = null;

       // Opens file for input and reads for output
       try {
         input = new Scanner(new File("/UW/CS/TCSS143/JavaWorkSpace/Assignment2/in2a.txt"));
         PrintStream outFile = new PrintStream(new File("out.txt"));
         outFile.println(ArrayMath.arrayMultiply(theA, theB));
         outFile.close();
         
         
         filesOk = true;
         }
       catch (FileNotFoundException e) {
         System.out.println("Can't open file - " + e);
         }
       
       if (filesOk) {
         theA = get2DArray(input);
         theB = get2DArray(input);
         theC = get2DArray(input);
         theD = get2DArray(input);
         
         // Sanity check for what is in the array and if right
         System.out.println(Arrays.deepToString(theA));
         System.out.println(Arrays.deepToString(theB));
         System.out.println(Arrays.deepToString(theC));
         System.out.println(Arrays.deepToString(theD));
         System.err.println(Arrays.deepEquals(theA, theB));

         // Calling to ArrayMath.java for operation results
         // Declaring arrays for final results
         int[][] sum = ArrayMath.arrayAddition(theA, theB);
         System.out.print(Arrays.deepToString(sum));
         
         int[][] sub = ArrayMath.arraySubtraction(theA, theB);
         int[][] mul = ArrayMath.arrayMultiply(theA, theB);
         }        
      
   }
   

   /**
   * get2DArray reads input file then creates 2D array
   * from the file.
   * 
   * @param input is a Scanner to input the file
   *
   * @return a 2D integer array filled with input values
   */

   public static int[][] get2DArray(Scanner theIn) {
      int rowSize = theIn.nextInt(); // Takes the first 2 numbers
      int colSize = theIn.nextInt(); 
      int[][] a = new int[rowSize][colSize]; 

      // For loops that add integers to arrays
      for (int i = 0; i < a.length; i++) {
         for (int k = 0; k < a[i].length && theIn.hasNextInt(); k++) {
            a[i][k] = theIn.nextInt();
         }
      }
      return a; // Returns value to main method that was called from        
   }   
   		
}

