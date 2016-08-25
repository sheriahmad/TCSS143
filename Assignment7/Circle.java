
/*
 * Circle.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment7 
 */
import java.text.DecimalFormat;

/**
 * throws an IllegalArgumentException when a method argument
 * that is <= 0 is used to set the radius and supply an
 * appropriate error message in the parameter list
 * 
 * @author sahmad
 * @version Fall2015
 *
 */

public class Circle extends AbstractShape {
	/**
	 * field myRedius
	 */
	private double myRadius;
	/**
	 * int myID
	 */
	private static int myID = 1;

	/**
	 * calls this(1.0);
	 */
	public Circle() {
		this(1.0);
	}

	/**
	 * 
	 * @param theRadius
	 */
	public Circle(final double theRadius) {
		super("Circle" + myID);
		if (theRadius <= 0)
			throw new IllegalArgumentException(
					"ERROR! Negative or 0 value can't be applied to a circle radius");

		setRadius(theRadius);
		myID++;
	}

	/**
	 * 
	 * @param theRadius
	 */

	public void setRadius(final double theRadius) {
		myRadius = theRadius;
	}

	/**
	 * @return calculated area
	 */
	public double calculateArea() {
		return myRadius * myRadius * Math.PI;
	}

	/**
	 * @return newC
	 */
	public final Shape copyShape() {
		Circle newC = new Circle();
		newC.myRadius = myRadius;
		return newC;
	}

	/**
	 * @return toString
	 */
	public String toString() {
		DecimalFormat fmt = new DecimalFormat("0.00");
		return getName() + " [Radius: " + fmt.format(myRadius)
		+ "] Area: " + fmt.format(calculateArea());
	}
}