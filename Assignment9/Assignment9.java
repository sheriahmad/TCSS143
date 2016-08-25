/*
 * Assignment9.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment9
 */

import java.util.*;
import java.io.*;

/**
 * This is the main driver program that reads the file and
 * then arranges and sorts word objects into AnagramFamilies
 * and outputs in the output file.
 * 
 * @author sahmad
 * @version Fall2015
 */

public class Assignment9 {

	/**
	 * Main is the driver program to test word and
	 * AnagramFamily objects from input file.
	 * 
	 * @param theArgs
	 **/
	
	public static void main(String theArgs[]) {
		Scanner input = null;
		PrintStream output = null;
		String inFileName = "words.txt";
		String outFileName = "out9.txt";
		boolean fileOk = false;

		try {
			input = new Scanner(new File(inFileName));
			output = new PrintStream(new File(outFileName));
			fileOk = true;
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open file " + e);
		}

		// body of program if file is read
		if (fileOk) {
			LinkedList<Word> words = new LinkedList<Word>();
			// iterator creates and adds word objects to
			// words

			while (input.hasNext()) {
				words.add(new Word(input.next()));
			}

			// sorts words alphabetically canotically
			Collections.sort(words);

			// this LinkedList stores the content of
			// unique AnagramFamilies for construction
			LinkedList<Word> aFamily = new LinkedList<Word>();

			// this LinkedList stores anagram families
			LinkedList<AnagramFamily> families = new LinkedList<AnagramFamily>();

			// iterator for traversing words
			ListIterator<Word> iterator = words.listIterator();

			while (iterator.hasNext()) {
				Word test = iterator.next();
				aFamily.add(test);

				if (iterator.hasNext()) {
					getFamily(aFamily, iterator, test);
				}

				Collections.sort(aFamily, new CompareByOriginal());
				families.add(new AnagramFamily(aFamily));
				aFamily.clear();
			}

			Collections.sort(families, new CompareAnagramSize());
			output.println("Top 5 largest families:");
			for (int i = 0; i < 5; i++) {
				output.println(families.get(i));
			}
			output.println();

			output.println("All the families of size 8:");
			for (AnagramFamily f : families) {
				if (f.getMyCount() == 8) {
					output.println(f);
				}
			}

			input.close();
			output.close();
		}
	}

	/**
	 * getFamily is a recursive method which continues down
	 * a list of Word objects until the next word object is
	 * not the same as the current object based on its
	 * Canonical form and adds all similar objects to a
	 * result LinkedList.
	 * 
	 * @param theFamily
	 * @param theIterator
	 * @param thePrevious
	 */

	public static void getFamily(LinkedList<Word> theFamily,
			ListIterator<Word> theIterator, Word thePrevious) {

		Word test = theIterator.next();
		if (thePrevious.compareTo(test) == 0) {
			theFamily.add(test);

			if (theIterator.hasNext()) {
				getFamily(theFamily, theIterator, test);
			}
		}

		else {

			theIterator.previous();
		}
	}
}