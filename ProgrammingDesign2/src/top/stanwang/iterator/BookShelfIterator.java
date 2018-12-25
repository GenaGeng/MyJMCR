package top.stanwang.iterator;

public class BookShelfIterator implements Iterator {

	private int pointer;
	private BookShelf bookShelf;
	
	public BookShelfIterator(BookShelf bookShelf) {
		pointer = 0;
		this.bookShelf = bookShelf;
	}
	
	@Override
	public Object next() {
		pointer++;
		return bookShelf.getBookAt(pointer-1);
	}

	@Override
	public boolean hasNext() {
		return pointer < bookShelf.getLength();		
	}

}
