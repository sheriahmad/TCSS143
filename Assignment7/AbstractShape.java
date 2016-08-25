/*
 * AbstractShape.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment7 
 */

/**
 * This class should contain an instance field to store the
 * name of each object. The constructor which sets this
 * field should receive the name and a number to be
 * concatenated to the name and then stored in the name
 * field.
 * 
 * @author sahmad
 * @version Fall2015
 *
 */
public abstract class AbstractShape implements Shape {
	/**
	 * private string myName
	 */
	private String myName;

	/**
	 * 
	 * @param theName
	 */
	public AbstractShape(String theName) {
		this.myName = theName;
	}

	/**
	 * @param from
	 *            return 0
	 */
	public int compareTo(Shape from) {
		double thisArea = calculateArea();
		double fromArea = from.calculateArea();

		if (thisArea > fromArea) {
			return 1;
		}

		else if (thisArea < fromArea) {
			return -1;
		} else
			return 0;
	}

	/**
	 * 
	 * @return returns the name field data
	 */
	public String getName() {
		return myName;
	}
}
