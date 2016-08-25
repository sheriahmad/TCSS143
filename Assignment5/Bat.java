
/*
 * Bat.java
 * TCSS142
 * Instructor: David Schuessler
 */
import java.util.Random;

/**
 * Bats have rather erratic behavior as they flutter about
 * catching flying insects. Their direction appears random,
 * flying in one of the 4 constant directions (CENTER is not
 * an option since they can’t really hover).
 * 
 * @author sahmad
 * @version Fall2015
 * 
 */

public class Bat extends AbstractCritter {

	Random myRandom = new Random();
	private static int batDirection;

	/**
	 * Calls the super constructor passing it an uppercase
	 * B: ‘B’ char to initialize the super’s instance field.
	 */
	public Bat() {
		super('B');
		// batDirection = 0;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implements the super getMove method:
	 * 
	 * @param theInfo
	 * @return batDirection.
	 */
	public int getMove(CritterInfo theInfo) {
		batDirection = myRandom.nextInt(4);
		if (batDirection == 0) {
			return NORTH;
		}
		if (batDirection == 1) {
			return WEST;
		}
		if (batDirection == 2) {
			return SOUTH;
		}
		if (batDirection == 3) {
			return EAST;
		} else {
			return CENTER;
		}
	}
}
