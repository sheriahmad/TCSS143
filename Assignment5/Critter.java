/*
 * Critter.java
 * TCSS142
 * Instructor: David Schuessler
 */

/**
 * Interface. Describes what methods to be implemented by
 * Critter subclasses and includes several constants.
 * 
 * @author sahmad
 * @version Fall2015
 * 
 */
public interface Critter {
	final int NORTH = 0;
	final int WEST = 1;
	final int SOUTH = 2;
	final int EAST = 3;
	final int CENTER = 4;

	/**
	 * char.
	 * 
	 * @return char
	 */
	public char getChar();

	/**
	 * initiates motion of the object.
	 * 
	 * @param theInfo
	 * @return move direction.
	 */
	public int getMove(CritterInfo theInfo);

}
