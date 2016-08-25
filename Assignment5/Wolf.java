/*
 * Wolf.java
 * TCSS142
 * Instructor: David Schuessler
 */

/**
 * Because they are pack animals, their movement is somewhat
 * consistent and is done in parallel with all wolves.
 * However, they tend to travel in straight directions for
 * some time before changing.
 * 
 * @author sahmad
 * @version Fall2015
 */
public class Wolf extends AbstractCritter {
	private static int myDirection;
	private static int myCount;
	private static boolean myFirst;
	private static int myTarget;
	private static int arraysize;
	private int[] directionarray = { EAST, NORTH, WEST, SOUTH };

	/**
	 * Calls the super constructor passing it an UPPERCASE
	 * W: ‘W’ char to initialize the super’s instance field.
	 * Initialize the 4 fields to the values mentioned
	 * above. define object wolf.
	 * 
	 * @param theChar
	 */
	public Wolf(char theChar) {

		super('W');
		myDirection = EAST;
		myCount = 0;
		myFirst = true;
		myTarget = 1;
		arraysize = 1;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implements the super getMove method
	 * 
	 * @param theInfo
	 * @return move direction
	 */
	public int getMove(CritterInfo theInfo) {
		// TODO Auto-generated method stub

		int direction;
		direction = myDirection;
		myCount++;
		if (myCount == myTarget) {
			myFirst = !myFirst;
			// myCount = 0;
			myDirection = directionarray[arraysize];
			arraysize++;
			if (arraysize == 4) {
				arraysize = 0;
			}
		}

		return direction;
	}
}
