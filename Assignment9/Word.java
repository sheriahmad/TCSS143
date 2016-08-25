/*
 * Word.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment8 
 */

import java.util.*;

/**
 * Word is object class which defines a word by its original
 * form and its canonical form. words are inherently ordered
 * by their canonical form ascending alphabetically
 * 
 * @author sahmad
 * @version Fall2015
 */

public class Word implements Comparable<Word> {
	/**
	 * private String myWord.
	 */
	private String myWord;
	
	/**
	 * Private String MyCanonical 
	 */
	private String myCanonical;

	/**
	 * this constructor assigns myWord and calls
	 * makeCanonical to create myCanonical
	 *
	 * @param theWord
	 **/
	
	public Word(String theWord) {
		myWord = theWord;

		char[] wordChars = theWord.toCharArray();
		makeCanonical(wordChars);
		myCanonical = new String(wordChars);
	}

	/**
	 * this method will find the canonical form of the
	 * passed array list of char. It operates using the
	 * merge sort algorithm by recursively splitting the
	 * array in half then sorting those half into a
	 * resulting array.
	 *
	 * @param tehChars
	 **/

	private final void makeCanonical(char[] theChars) {
		// BASE CASE: if length =< 1
		if (theChars.length > 1) {
			char[] left = Arrays.copyOfRange(theChars, 0,
					theChars.length / 2);

			char[] right = Arrays.copyOfRange(theChars,
					theChars.length / 2, theChars.length);

			// recursively call makeCat
			makeCanonical(left);
			makeCanonical(right);

			// merge the two halves together
			merge(theChars, left, right);
		}
	}

	/**
	 * this method handles merging the two halves of the
	 * char array from makeCanonical into sorted order.
	 *
	 * @param result
	 * @param theLeft
	 * @param theRight
	 *
	 **/

	private final void merge(char[] theResult, char[] theLeft,
			char[] theRight) {
		int i1 = 0; // left array index
		int i2 = 0; // right array index

		for (int i = 0; i < theResult.length; i++) {
			if (i2 >= theRight.length || (i1 < theLeft.length
					&& theLeft[i1] <= theRight[i2])) {
				theResult[i] = theLeft[i1]; // take from
				// left
				i1++;
			} else {
				theResult[i] = theRight[i2];
				i2++;
			}
		}
	}

	/**
	 * getMyWord method retrieves myWord.
	 *
	 * @return myWord
	 *
	 **/

	public String getMyWord() {
		return myWord;
	}

	/**
	 * getMyCanonical retrieves Canonical form.
	 *
	 * @return myCanonical
	 *
	 **/

	public String getMyCanonical() {
		return myCanonical;
	}

	/**
	 * compareTo method compares this objects Canonical form
	 * to the others Canonical form ascending alphabetically
	 *
	 * @param theOther
	 * @return myCanonical.compareTo
	 *
	 **/

	public int compareTo(Word theOther) {
		return myCanonical.compareTo(theOther.getMyCanonical());
	}

	/**
	 * toString simply returns the word objects original
	 * word field.
	 * 
	 * @return myWord
	 **/

	public String toString() {
		return myWord;
	}
}