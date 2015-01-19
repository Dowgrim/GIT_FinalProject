package zuul.rooms;

import java.util.ArrayList;
import java.util.List;
import zuul.student.Book;

/**
 * @author Cindy Najjar
 */
public class Library extends Room {

	private List<Book> books = new ArrayList<>();
	
	/**
	 * Adds the three books to the library when it's created
	 * @param description
	 */
	public Library(String description) {
		super(description);
		books.add(new Book("POOBook"));	
		books.add(new Book("C++"));
		books.add(new Book("Algo"));
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	/**
	 * Checks if the library is open or not
	 * @return a boolean
	 */
	public boolean openLibrary() {
    	boolean isOpen;
    	int opened = (int)(Math.random() * 5); // We say that there is one chance 
    	if (opened == 0) {			  // on five that the library is opened
    		isOpen = true;
    	} else {
    		isOpen = false;
    	}
    	return isOpen;
    }
}
