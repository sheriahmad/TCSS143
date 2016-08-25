/*
 * AbstractCritter.java
 * CSS142
 * Instructor: David Schuessler
 */

/**
 * Declares an Instance variable that all subclasses must
 * have, a constructor to initialize the instance variable,
 * and implements the getChar method (this way this method
 * is only implemented once and to be inherited by all
 * Critter subclasses).
 * 
 * @author sahmad
 *
 */
public abstract class AbstractCritter implements Critter {
	/**
	 * A private char field to hold the single character
	 * which represents a particular Critter and is used for
	 * display on the Critter Environment Grid (fancy name
	 * for what you see in the JPanel of the GUI).
	 * 
	 */
	private char myCritterName;

	/**
	 * Assigns theChar to the Instance Field (This has to be
	 * called by all subclasses to set the correct character
	 * for the class).
	 * 
	 * @param theChar
	 */
	public AbstractCritter(final char theChar) {
		myCritterName = theChar;
	}

	/**
	 * Returns the Instance Field
	 * 
	 * @return myCritterName
	 */
	public char getChar() {
		return myCritterName;
	}
}
