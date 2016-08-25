/*
 * Frog.java
 * TCSS142
 * Instructor: David Schuessler
 */

/**
 * The movement of a frog is a bit less complicated than
 * some of our other Critters. Frogs never jump into Stones
 * and thus, never die unless encountering another Critter.
 * Generally, a frog will continue in the same direction
 * unless a counter (one of the fields) is zero. If the
 * counter is zero then a random value should be chosen (in
 * this case, use the Math.random() which returns a double
 * in the range of 0..1.0 (1.0 exclusive). If the result is
 * < 0.25, your direction field should be set to NORTH, else
 * if < 0.5, go SOUTH, < .75, go EAST otherwise go WEST
 * (Remember, this change of direction only occurs when the
 * counter is zero).
 * 
 * @author sahmad
 * @version Fall2015
 *
 */
public class Frog extends AbstractCritter {

	private static int myCount;
	private static int myDirection;
	private static double random;
	private static int result;

	/**
	 * Calls the super constructor passing it an UPPERCASE
	 * F: ‘F’ char to initialize the super’s instance field.
	 * myDirection: Initialized to CENTER. myCount:
	 * Initialized to 0.
	 */
	public Frog() {
		super('F');
		myCount = 0;
		myDirection = CENTER;
		random = 0.0;
		result = 0;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implements the super getMove method:
	 * 
	 * @param theInfo
	 * @return moveDirction
	 */
	@Override
	public int getMove(CritterInfo theInfo) {

		// TODO Auto-generated method stub
		if (myCount == 0) {
			random = Math.random();
			if (random < 0.25) {
				myDirection = NORTH;
			} else if (random > 0.25 && random < 0.50) {
				myDirection = SOUTH;
			} else if (random > 0.50 && random < 0.75) {
				myDirection = EAST;
			} else {
				myDirection = WEST;
			}
			myCount++;
			if (myDirection == 3) {
				myDirection = 0;
			}
			if (theInfo.getNeighbor(myDirection) == 'S') {
				result = CENTER;
			} else {
				result = myDirection;
			}
		}
		return result;
	}

}
