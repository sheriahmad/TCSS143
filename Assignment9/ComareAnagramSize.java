/*
 * ComareAnagramSize.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment9 
 */

import java.util.Comparator;

/**
 * CompareAnagramSize is a comparator for AnagramFamily
 * objects which sorts based on the number of words in a
 * given AnagramFamily, largest first.
 * 
 * @author sahmad
 * @version Fall2015
 */

public class CompareAnagramSize implements Comparator<AnagramFamily> {

	/**
	 * this comparator compares two anagram families,
	 * families with more objects considered ahead.
	 *
	 * @param theThis
	 * @param theOther
	 * @return theOther.getMyCount() - theThis.getMyCount()
	 **/

	public int compare(AnagramFamily theThis, AnagramFamily theOther) {
		return theOther.getMyCount() - theThis.getMyCount();
	}
}