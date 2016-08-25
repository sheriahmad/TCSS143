
/*
 * Library.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment6 
 */
import java.util.ArrayList;
import java.util.Collections;

/**
 * Stores a collection (ArrayList) of books. This class also
 * can perform various operations on the collection.
 * 
 * @author sahmad
 * @version Fall2015
 *
 */

public class Library {
	/**
	 * This holds all the Book objects in the library.
	 */
	private ArrayList<Book> books;

	/**
	 * Creates a Library with an empty ArrayList of books.
	 * 
	 * @param theOther
	 */
	public Library(final ArrayList<Book> theOther) {
		books = new ArrayList<Book>();
		for (Book book : theOther)
			books.add(book);
	}

	/**
	 * First checks for null or empty Strings and calls the
	 * appropriate exception. Otherwise it adds the Book
	 * argument to the end of the library ArrayList.
	 * 
	 * @param theBook
	 * @return books.add(theBook) 
	 */
	public boolean add(final Book theBook) {

		if (theBook == null)
			throw new IllegalArgumentException("Book cannot be null");
		return books.add(theBook);
	}

	/**
	 * Generates an ArrayList of all books which have titles
	 * that match (exactly) with the passed argument and
	 * returns this list to the calling program. The String
	 * compareTo method is useful here.
	 * 
	 * @param theTitle
	 * @return booksWithTitle 
	 */
	public ArrayList<Book> findTitles(final String theTitle) {
		ArrayList<Book> booksWithTitle = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getTitle().compareTo(theTitle) == 0)
				booksWithTitle.add(book);
		}

		return booksWithTitle;
	}

	/**
	 * Sorts the library’s book ArrayList in ascending order
	 * according to the title field
	 */
	public void sort() {
		Collections.sort(books);
	}

	/**
	 * returns a properly formatted String representation of
	 * all the books in the library
	 * 
	 * @return lib
	 */
	public String toString() {
		String lib = "";
		for (int i = 0; i < books.size(); i++) {
			if (i > 0)
				lib += "\n";
			lib += books.get(i).toString();
		}

		return lib;
	}
}