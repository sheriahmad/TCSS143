/*
 * ComareByOriginal.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment9 
 */
import java.util.Comparator;

/**
 * CompareByOriginal is a comparator for Word objects which
 * sorts based on the words original form descending
 * alphabetically
 * 
 * @author sahmad
 * @version Fall2015
 */
public class CompareByOriginal implements Comparator<Word> {
	/**
	 * compare is a comparator which compares word objects
	 * alphabetically descending
	 * 
	 * @param theFirst
	 * @param theSecond
	 * @return theSecond.getMyWord().compareTo(
	 *         theFirst.getMyWord())
	 */
	public int compare(Word theFirst, Word theSecond) {
		return theSecond.getMyWord().compareTo(theFirst.getMyWord());
	}
}