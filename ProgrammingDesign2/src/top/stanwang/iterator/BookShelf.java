package top.stanwang.iterator;

import java.util.List;

public class BookShelf implements Aggregate {

	private List<Book> bookList;	
	
	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
	
	public int getLength() {
		return bookList.size();
	}
	
	public Book getBookAt(int index) {
		return bookList.get(index);
	}
	
	public void appendBook(Book book) {
		bookList.add(book);
	}

}
