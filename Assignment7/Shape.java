/*
 * Shape.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment7 
 */
/**
 * This is an interface that has 2 abstract methods, and
 * passes the responsibility of implementing the compareTo
 * method to the class that implements Shape
 * 
 * @author sahmad
 * @version Fall2015
 *
 */
public interface Shape extends Comparable<Shape> {

	/**
	 * 
	 * @return Calculated Area
	 */
	public double calculateArea(); // This abstract method
	// is implemented at the
	// concrete level.

	/**
	 * 
	 * @return Copied shape
	 * 
	 */
	public Shape copyShape(); // also implemented at the
	// concrete level.
}
