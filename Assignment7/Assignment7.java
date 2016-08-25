
/*
 * Assignment7.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment7 
 */
import java.io.*;
import java.util.*;

/**
 * This is the test driver class that will include main.
 * This program MUST read a file named in7.txt and generate
 * an output file named out7.txt.
 * 
 * @author sahmad
 * @version Fall2015
 */
public class Assignment7 {
	
	/**
	 * This is the test driver class that will include main.
	 * This program MUST read a file named in7.txt and
	 * generate an output file named out7.txt. The in7.txt
	 * file must be created by you based on formatting
	 * described shortly.
	 * 
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {

		List<Shape> myList = new ArrayList<Shape>();
		try {
			Scanner inputFile = new Scanner(new File("in7.txt"));
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();

				try {
					Shape element = getShape(line);

					if (element != null)
						myList.add(element);

				} catch (NumberFormatException ex) {
				} catch (IllegalArgumentException ex) {
					System.err.println(ex.getMessage());
				}
			}
			inputFile.close();

			PrintStream outputFile = new PrintStream(
					new File("out7.txt"));

			outputFile.println("\nOriginal List[unsorted]:");

			for (Shape element : myList)
				outputFile.println(element.toString());

			outputFile.println("\nCopied List[sorted]:");

			for (Shape element : getSortedList(myList))
				outputFile.println(element.toString());

			outputFile.println("\nOriginal List[unsorted]:");

			for (Shape element : myList)
				outputFile.println(element.toString());

			outputFile.close();
		} catch (IOException ex) {
		}
	}

	/**
	 * Your method for input should receive an already
	 * instantiated Scanner to the input file and the
	 * already instantiated LinkedList of Shape (this will
	 * be filled inside the method and return, via the
	 * parameter, to main). This method should also return a
	 * List of Shape (as an ArrayList) which contains all
	 * the values of the LinkedList described above (this
	 * should be used as the List to be sorted).
	 * 
	 * @param line
	 * @return values
	 * @throws NumberFormatException
	 * @throws IllegalArgumentException
	 */
	private static Shape getShape(String line)
			throws NumberFormatException, IllegalArgumentException {
		String[] data = line.split(" ");
		double[] values = new double[data.length];

		for (int i = 0; i < data.length; i++) {
			values[i] = Double.parseDouble(data[i]);
		}

		switch (values.length) {
		case 1:
			return new Circle(values[0]);
		case 2:
			return new Rectangle(values[0], values[1]);
		case 3:
			return new Triangle(values[0], values[1], values[2]);
		}
		return null;
	}

	/**
	 * Return a copied ArrayList of the original input
	 * LinkedList to a new list in main named copyList.
	 * Output the original list to display all the shapes
	 * and their area (pass it to the output method). Sort
	 * copyList in ascending order by the shapes’ area
	 * (using Collections Class static sort method) 
	 * Display copyList in the sorted order (pass it to the
	 * output method). Output the original list to display
	 * the original order (pass it to the output method)
	 * 
	 * @param myList
	 * @return newList
	 */
	private static List<Shape> getSortedList(List<Shape> myList) {
		// List<Shape> myList = new LinkedList<Shape>( );
		List<Shape> newList = new ArrayList<Shape>();
		for (Shape element : myList) {
			Shape s = element.copyShape();
			newList.add(s);
		}
		Collections.sort(newList);
		return newList;
	}
}