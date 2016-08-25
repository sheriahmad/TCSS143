
/*
 * Rectangle.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment7 
 */import java.text.DecimalFormat;

 /**
  * throws an IllegalArgumentException when method arguments
  * that are <= 0 are used to set the length and width
  * fields. Supply an appropriate error message in the
  * parameter list
  * 
  * @author sahmad
  * @version Fall2015
  */
 public class Rectangle extends AbstractShape {

	 /**
	  * double field myLenght
	  */
	 private double myLength;
	 /**
	  * double field myWidth
	  */
	 private double myWidth;
	 /**
	  * “static” int field shared by all Rectangle objects
	  */
	 private static int myID = 1;

	 // Beginning methods.
	 /**
	  * calls this(1.0, 1.0)
	  */
	 public Rectangle() {
		 this(1.0, 1.0);
	 }

	 // calls super with "Rectangle" and
	 // myID incremented.
	 /**
	  * myID incremented
	  * 
	  * @param theLength
	  * @param theWidth
	  */
	 public Rectangle(final double theLength, final double theWidth) {
		 super("Rectangle" + myID);

		 if (theLength <= 0 || theWidth <= 0)
			 throw new IllegalArgumentException(
					 "ERROR! Negative or 0 value(s) can't be applied to a rectangle.");
		 // myID--;

		 setLength(theLength);
		 setWidth(theWidth);
		 myID++;
	 }

	 /**
	  * 
	  * @param theLength
	  */
	 public void setLength(final double theLength) {
		 myLength = theLength;
	 }

	 /**
	  * 
	  * @param theWidth
	  */
	 public void setWidth(final double theWidth) {
		 myWidth = theWidth;
	 }

	 /**
	  * @return calculated area
	  */
	 public double calculateArea() {
		 return myLength * myWidth;
	 }

	 /**
	  * @return newR
	  */
	 public final Shape copyShape() {
		 Rectangle newR = new Rectangle();
		 newR.myLength = myLength;
		 newR.myWidth = myWidth;
		 return newR;
	 }

	 /**
	  * @return toString
	  */
	 public String toString() {
		 DecimalFormat fmt = new DecimalFormat("0.00");
		 return getName() + " [Length: " + fmt.format(myLength) + ", "
		 + "Width:" + fmt.format(myWidth) + "] Area: "
		 + fmt.format(calculateArea());
	 }
 }
