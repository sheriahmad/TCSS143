
/*
 * LibraryDriver.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment6 
 */
import java.util.*;
import java.io.*;

/**
 * Fully test all the methods of both classes using both
 * valid and invalid data. The data (books and the authors)
 * will be read from two different input files named
 * “LibraryIn1.txt” and “LibraryIn2.txt.”
 * 
 * @author sahmad
 * @version Fall2015
 */

public class LibraryDriver {
	/**
	 * Main method of the program. 
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {
		Scanner inputFile = null;
		PrintStream outputFile = null;
		try {
			inputFile = new Scanner(new File("LibraryIn1.txt"));
			outputFile = new PrintStream(new File("LibraryOut.txt"));
		} catch (Exception e) {
			System.out.println("Difficulties opening the file! " + e);
			System.exit(1);
		}

		// @SuppressWarnings("unused")
		ArrayList<String> authors = new ArrayList<String>();
		ArrayList<Book> books = new ArrayList<Book>();

		while (inputFile.hasNext()) {
			// Read title
			String bookTitle = inputFile.nextLine();
			// Read author(s)
			String bookAuthors = inputFile.nextLine();
			// Insert title & author(s)into a book
			Book book = new Book(bookTitle, getAuthors(bookAuthors));
			// Add this book to the ArrayList<Book> of books
			books.add(book);
		}

		// Instantiate a Library object filled with the
		// books read thus far
		Library lib = new Library(books);

		// and write the contents of the library to the
		// output file
		outputFile.println("\nPRINTS INITIAL BOOK LIST:");
		outputFile.println(lib.toString());

		// Sort the current contents of the library
		lib.sort();

		// and write the contents of the sorted library to
		// the output file
		outputFile.println("\nPRINTS SORTED BOOK LIST:");
		outputFile.println(lib.toString());

		// Close the first input file and open the second
		// input file.
		// Read the titles and authors from the second input
		// file,
		// add them to the library, and write the contents
		// of the
		// library to the output file.
		inputFile.close();

		try {
			inputFile = new Scanner(new File("LibraryIn1.txt"));
		} catch (Exception e) {
			System.out.println("Difficulties opening the file! " + e);
			System.exit(1);
		}

		while (inputFile.hasNext()) {
			// Read title
			String bookTitle = inputFile.nextLine();
			// Read author(s)
			String bookAuthors = inputFile.nextLine();
			// Insert title & author(s)into a book
			Book book = new Book(bookTitle, getAuthors(bookAuthors));
			// Add this book to the ArrayList<Book> of books
			lib.add(book);
		}

		outputFile.println("\nPRINTS WITH NEW BOOKS UNSORTED:");
		outputFile.println(lib.toString());
		// . . . etc.

		// Sort the library and write it to the output file
		lib.sort();
		outputFile.println("\nPRINTS ALL SORTED BOOK LIST:");
		outputFile.println(lib.toString());

		// The following tests the findTitles method, i.e.
		// test
		// the findTitles method by passing ìAcer Dumplingî
		// and
		// then ìThe Bluffî:

		// Write only the "Acer Dumpling" books to the
		// output file
		Library AcerDumplings = new Library(
				lib.findTitles("Acer Dumpling"));
		outputFile.println("\nPRINTS ALL \"ACER DUMPLING\"s:");
		outputFile.println(AcerDumplings.toString());

		// Write only the "The Bluff" books to the output
		// file
		Library TheBluffs = new Library(lib.findTitles("The Bluff"));
		outputFile.println("\nPRINTS ALL \"THE BLUFF\"s:");
		outputFile.println(TheBluffs.toString());

		// Close all open files and end main.
		inputFile.close();
		outputFile.close();
	}

	/**
	 * separates author names and returns an ArrayList
	 * <String> containing the author names
	 * 
	 * @param theAuthors
	 * @return
	 */
	public static ArrayList<String> getAuthors(String theAuthors) {

		// @SuppressWarnings("resource")
		Scanner scanner = new Scanner(theAuthors).useDelimiter("[*]");
		ArrayList<String> authors = new ArrayList<String>();

		if (scanner.hasNext()) {
			while (scanner.hasNext()) {
				authors.add(scanner.next());
			}
		} else {
			authors.add(theAuthors);
		}
		return authors;
	}
}