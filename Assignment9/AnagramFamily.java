/*
 * AnagramFamily.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment9 
 */

import java.util.*;

/**
 * AnagramFamily is an object class that is made up of a
 * LinkList and common canonical form of words.
 * 
 * @author sahmad
 * @version Fall2015
 *
 */

public class AnagramFamily {
	
	/**
	 * Private LinkedList of myWords
	 */
	private LinkedList<Word> myWords;
	
	/**
	 * Private integer myCount
	 */
	private int myCount;

	/**
	 * this constructor accepts a list containing a sorted
	 * anagram family, adds the elements of that list to the
	 * myWords field, sorts myWords, and calculates the
	 * number of words in the list
	 *
	 * @param theFamily
	 * 
	 **/
	public AnagramFamily(List<Word> theFamily) {
		myCount = 0;
		myWords = new LinkedList<Word>();

		ListIterator<Word> iterator = theFamily.listIterator();

		while (iterator.hasNext()) {
			myWords.add(iterator.next());
			myCount++;
		}

		Collections.sort(myWords, new CompareByOriginal());
	}

	/**
	 * getMyCount() returns this objects # of words.
	 *
	 * @return myCount
	 **/

	public int getMyCount() {
		return myCount;
	}

	/**
	 * toString returns the string representation of a list
	 * with all of myWords original word forms to identify
	 * its containing word objects.
	 *
	 * @return myWords.toString()
	 *
	 **/

	public String toString() {
		return myWords.toString();
	}
}