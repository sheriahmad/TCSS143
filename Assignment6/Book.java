
/*
 * Book.java
 * TCSS 143 Fall 2015
 * Instructor:  David Schuessler
 * Assignment6 
 */
import java.util.ArrayList;

/**
 * The Book class has a field for the title and an ArrayList
 * field for the author(s) (because many books have multiple
 * authors, an ArrayList to hold them seems a logical
 * choice). The Book class also supplies various methods for
 * operations on Books, described shortly.
 * 
 * @author sahmad
 * @version Fall2015
 */

public class Book implements Comparable<Book> {
	
	/** 
	 * Stores the name of the book. 
	 */
	private String title;
	
	/**
	 * Stores the name of the authors. 
	 */
	private ArrayList<String> authors;

	/**
	 * simply throw a new IllegalArgumentException(), if
	 * either argument is invalid (null, empty string,
	 * etc.). If valid arguments, this constructor should
	 * set both fields.
	 * 
	 * @param theTitle
	 * @param theAuthors
	 */
	public Book(final String theTitle,
			final ArrayList<String> theAuthors) {
		title = theTitle;
		authors = theAuthors;

		if (theTitle == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		if (theTitle.length() == 0) {
			throw new IllegalArgumentException(
					"Title cannot be empty.");
		}
		if (theTitle.trim().length() == 0) {
			throw new IllegalArgumentException(
					"Title cannot contains spaces only");
		}
		if (theAuthors == null) {
			throw new IllegalArgumentException(
					"Author list cannot be null.");
		}
		if (theAuthors.size() == 0) {
			throw new IllegalArgumentException(
					"Author list cannot be empty.");
		}
	}

	/**
	 * Returns the book title
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns the ArrayList of authors.
	 * 
	 * @return authors
	 */
	public ArrayList<String> getAuthors() {
		return authors;
	}

	/**
	 * Returns a String representation of the title and each
	 * author for a single Book ONLY. This is because a Book
	 * object is just that, a single Book.
	 */
	public String toString() {
		String string = "\"" + title + ",\" by ";

		for (int i = 0; i < authors.size(); i++) {
			if (i > 0)
				string = string + "; ";
			string = string + authors.get(i);
		}
		return string;
	}

	/**
	 * Here, the titles will be compared, i.e. the implied
	 * parameter’s title field with the “theOther” title
	 * field. However, in the event there a multiple titles
	 * that are actually different books (i.e. the books are
	 * not the same but, have the same title), you should
	 * then compare the author(s) names for order. In this
	 * case you need only compare the first author of each
	 * book (our test data will not have two equal titles
	 * with equal authors).
	 * 
	 * @param theOther
	 * @return title.comparteTo(theOther.title) 
	 */
	public int compareTo(final Book theOther) {
		return title.compareTo(theOther.title);
	}

	/**
	 * Implemented as a correct equals method (see chapter
	 * 9). Once the instance of is correctly identified and
	 * the appropriate cast is applied, equals should
	 * compare both the title and the name ArrayList for
	 * equality and return the result.
	 * 
	 * @param theOther
	 * @return result
	 */
	public boolean equals(final Object theOther) {
		if (theOther instanceof Book) {
			if (compareTo((Book) theOther) == 0) {
				return true;
			}
		}
		return false;
	}
}
