
/*
 * Turtle.java
 * Sheheyrar Ahmad
 * Instructor David Schuessler
 * Fall 2015
 */
import java.util.Random;

/**
 * Turtle Class. they will only move 1/3 as many times as
 * all other Critters (excluding the Stone, of course, which
 * doesn’t move at all). The Turtle getMove method can
 * return a direction of CENTER as needed, which will keep
 * it from moving.
 * 
 * @author sahmad
 * @version Fall2015
 *
 */
public class Turtle extends AbstractCritter {

	private static int FirstGroupMove[];
	private static int SecondGroupMove[] = new int[11];
	private static boolean booleanrandom;
	private static int move;
	Random getRandom = new Random();
	Random booleanRandom = new Random();

	/**
	 * Calls the super constructor passing it an UPPERCASE
	 * T: ‘T’ char to initialize the super’s instance field.
	 * Initialize all necessary instance fields of this
	 * class
	 */
	public Turtle() {
		super('T');
		booleanrandom = true;
		// move = 0;
		for (int i = 0; i < 13; i++) {
			if (i >= 0 && i < 2) {
				FirstGroupMove[i] = NORTH;
			}
			if (i > 1 && i < 4) {
				FirstGroupMove[i] = EAST;
			}
			if (i == 4) {
				FirstGroupMove[i] = SOUTH;
			}
			if (i > 4 && i < 8) {
				FirstGroupMove[i] = WEST;
			}
			if (i > 7 && i <= 12) {
				FirstGroupMove[i] = CENTER;
			}
		}

		for (int i = 0; i < 11; i++) {
			if (i >= 0 && i < 4) {
				SecondGroupMove[i] = SOUTH;
			}
			if (i > 3 && i < 6) {
				SecondGroupMove[i] = WEST;
			}
			if (i > 5 && i < 8) {
				SecondGroupMove[i] = NORTH;
			}
			if (i > 7 && i <= 10) {
				FirstGroupMove[i] = EAST;
			}
		}
	}

	// TODO Auto-generated constructor stub

	/**
	 * Implements the super getMove method:
	 * 
	 * @pram theInfo
	 * @return move direction
	 */
	public int getMove(CritterInfo theInfo) {
		// TODO Auto-generated method stub
		booleanrandom = booleanRandom.nextBoolean();
		if (booleanrandom == true) {
			move = FirstGroupMove[getRandom.nextInt(13)];
		} else {
			move = SecondGroupMove[getRandom.nextInt(11)];
		}
		return move;
	}
}
