
/*
 * Mouse.java
 * TCSS142
 * Instructor: David Schuessler
 */
import java.util.Random;

/**
 * Mice move in a zigzag (right-left-right-left, etc.)
 * motion. Their overall direction then is NORTH-WEST-NORTH-
 * WEST, or WEST-SOUTH-WEST-SOUTH, or SOUTH-EAST... etc..
 * The general direction of this zigzag motion should be
 * chosen at random intervals. How you go about
 * accomplishing this will be up to you but, try to maintain
 * a specific direction for some time Mouse Class.
 * 
 * @author sahmad
 * @version Fall2015
 *
 */
public class Mouse extends AbstractCritter {

	private static final int[] allDirections = { NORTH, SOUTH, EAST,
			WEST };
	private static final Random myRandom = new Random();

	private final int myTarget = 16;
	private int myCount = 0;
	private int firstDirection;
	private int secondDirection;

	/**
	 * Calls the super constructor passing it an UPPERCASE
	 * M: ‘M’ char to initialize the super’s instance field.
	 * Initialize all other Mouse class instance fields.
	 * 
	 */

	public Mouse() {
		super('M');
		randomizeDirection();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implements the super getMove method:
	 * 
	 * @return move direction.
	 */

	public int getMove(CritterInfo info) {
		myCount++;
		if (myCount == myTarget) {
			randomizeDirection();
			myCount = 0;
		}
		return myCount % 2 == 0 ? firstDirection : secondDirection;
	}

	/**
	 * Randomize the direction.
	 */
	private void randomizeDirection() {
		// TODO Auto-generated method stub
		int index = myRandom.nextInt(4);
		firstDirection = allDirections[index];
		int offset = 2 - ((index / 2) * 2);
		secondDirection = allDirections[offset + myRandom.nextInt(2)];
	}

}
