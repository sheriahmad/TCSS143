
/*
 * Triangle.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment7 
 */
import java.text.DecimalFormat;

/**
 * Throws an IllegalArgumentException when a method argument
 * is used to set any of the sides of the triangle to values
 * that are <= 0 AND if the longest side is >= to the sum of
 * the remaining sides. Supply an appropriate error message
 * in the parameter list
 * 
 * @author sahmad
 * @version Fall2015
 *
 */

public class Triangle extends AbstractShape implements Shape {

	/**
	 * SideA
	 */
	private double mySideA;
	/**
	 * SideB
	 */
	private double mySideB;
	/**
	 * SideC
	 */
	private double mySideC;
	/**
	 * Private ID
	 */
	private static int myID = 1;
	// calls this(1.0, 1.0, 1.0);

	/**
	 * Calls 1.0
	 */
	public Triangle() {
		this(1.0, 1.0, 1.0);
	}

	/**
	 * 
	 * @param theSideA
	 * @param theSideB
	 * @param theSideC
	 */
	// calls super with "Triangle" and myID incremented
	public Triangle(final double theSideA, final double theSideB,
			final double theSideC) {
		super("Triangle" + myID);

		if (theSideA <= 0 || theSideB <= 0 || theSideC <= 0)
			throw new IllegalArgumentException(
					"ERROR! Negative or 0 value can't be applied to a triangle.");

		if (theSideA >= theSideB + theSideC
				|| theSideB >= theSideA + theSideC
				|| theSideC >= theSideA + theSideB)
			throw new IllegalArgumentException(
					"ERROR! Not a Triangle. Longest side too long.");

		setSideA(theSideA);
		setSideB(theSideB);
		setSideC(theSideC);
		myID++;
	}

	/**
	 * 
	 * @param theSideA
	 */

	public void setSideA(final double theSideA) {
		mySideA = theSideA;
	}

	/**
	 * 
	 * @param theSideB
	 */
	public void setSideB(final double theSideB) {
		mySideB = theSideB;
	}

	/**
	 * 
	 * @param theSideC
	 */

	public void setSideC(final double theSideC) {
		mySideC = theSideC;
	}

	/**
	 * @return Calculated area
	 */
	public double calculateArea() {
		double p = (mySideA + mySideB + mySideC) / 2;
		return Math.sqrt(
				p * (p - mySideA) * (p - mySideB) * (p - mySideC));
	}

	// Returns a reference to a new Triangle with the same
	// field
	// values as the implied parameter (defensive copy).
	/**
	 * @return newT
	 */
	public final Shape copyShape() {
		Triangle newT = new Triangle();
		newT.mySideA = mySideA;
		newT.mySideB = mySideB;
		newT.mySideC = mySideC;
		return newT;
	}

	/**
	 * @return toString
	 */

	public String toString() {
		DecimalFormat fmt = new DecimalFormat("0.00");
		return getName() + " [SideA: " + fmt.format(mySideA)
		+ ", SideB:" + fmt.format(mySideB) + ", SideC:"
		+ fmt.format(mySideC) + "] Area: "
		+ fmt.format(calculateArea());
	}
}
