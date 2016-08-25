/*
 * Stone.java
 * TCSS142
 * Instructor: David Schuessler
 */

/**
 * Several Stone objects are placed on the simulation grid
 * during the initial instantiation and remain stationary
 * throughout the simulation. All but one Critter dies when
 * crashing into a Stone. Frog never moves to where a Stone
 * is and waits until it moves elsewhere. Stone Class
 * 
 * @author sahmad
 * @version Fall2015
 * 
 *
 */
public class Stone extends AbstractCritter {

	/**
	 * Calls the super constructor passing it an UPPERCASE
	 * S: ‘S’ char to initialize the super’s instance field.
	 */
	public Stone() {
		super('S');
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implements the super getMove method:
	 * 
	 * @param theInfo
	 * @return CENTER
	 */
	public int getMove(CritterInfo theinfo) {
		return CENTER;
	}
}
