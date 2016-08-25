/*
 * Programming8.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment8
 */

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * The purpose of this programming project is to demonstrate
 * the functionality of Recursion while reviewing such
 * things as the use of Sets (here only a single Set will be
 * implemented), String manipulation, file I/O using the
 * Scanner class for the input file.This program is to read
 * all the words contained in the input file, one at a time
 * recursively until no words remain.
 * 
 * @author sahmad
 * @version Fall2015
 */
public class Programming8 {

	static Set<String> set = new TreeSet<String>();

	/**
	 * To do this main calls a recursive method named
	 * getWordsString which is passed a Scanner to a File
	 * object and a single character. getWordsString will
	 * read all the words in the file and return a String
	 * containing all words from the input file that contain
	 * a single given character. Keep in mind, this string
	 * must have a single space inserted between each word.
	 * 
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {
		// Driver variables.
		Scanner inputFile = null;
		PrintStream outputFile = null;

		// Open input and output file.
		try {
			inputFile = new Scanner(new File("In8.txt"));
			outputFile = new PrintStream(new File("out8.txt"));
		} catch (Exception e) {
			System.out.println(
					"There was an issue opening " + "files. " + e);
			System.exit(1);
		}

		// Get Set.
		Set<String> wordsSet = getWordSet(
				getWordsString(inputFile, 'a'));
		wordsSet.remove("");
		outputFile.println(wordsSet);
	}

	/**
	 * Recursively read all the words contained in the input
	 * file and return a String containing only the words
	 * found in the file that contain a given char (The
	 * words within this String will be separated by a
	 * space)
	 * @param theFile
	 * @param theC
	 * @return
	 */
	public static String getWordsString(final Scanner theFile,
			final char theC) {

		if (theFile.hasNext()) {
			String word = theFile.next();
			if (hasCharacter(word, theC)) {
				// Calling recursively
				return word + " " + getWordsString(theFile, theC);
			} else {
				// Calling recursively
				return getWordsString(theFile, theC);
			}
		}
		return "";
	}

	/**
	 * Recursively scan the characters within a received
	 * word to see if it contains a given char and return
	 * true if it does, false otherwise.
	 * 
	 * @param theS
	 * @param theC
	 * @return boolean(false)
	 */
	public static Boolean hasCharacter(final String theS,
			final char theC) {

		if (theS.length() > 0) {

			char finalChar = theS.charAt(theS.length() - 1);
			char compareChar = theC;

			if (finalChar >= 'A' && finalChar <= 'Z') {
				finalChar = (char) (finalChar + 32);
			}

			if (compareChar >= 'A' && compareChar <= 'Z') {
				compareChar = (char) (compareChar + 32);
			}

			if (finalChar == compareChar) {
				return true;
			} else {
				// Calling recursively
				return hasCharacter(
						theS.substring(0, theS.length() - 1), theC);
			}
		}

		return false;
	}

	/**
	 * Recursively scan the words in a received String where
	 * each word is separated by a space and placing each
	 * word into a Set (TreeSet) which is returned to the
	 * calling program once all the words have been scanned.
	 * 
	 * @param theS
	 * @return resultSet
	 */
	public static Set<String> getWordSet(final String theS) {
		// Create set to hold the elements of the string.
		Set<String> resultSet = new TreeSet<String>();

		if (theS.indexOf(' ') != -1) {

			resultSet.add(theS.substring(0, theS.indexOf(' ')));

			resultSet.addAll(
					getWordSet(theS.substring(theS.indexOf(' ') + 1)));
		} else {
			resultSet.add(theS);
		}
		return resultSet;
	}
}
