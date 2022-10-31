package com.springboot.bookapp.book;

import org.springframework.stereotype.Service;

@Service
public class BookMockService {
	
//	private List<Book> books = new ArrayList<Book>(Arrays.asList(
//		new Book("1111", "Sprint Framework tutorial", "M.J"), 
//		new Book("2222", "Sprint Boot tutorial", "Hook"),
//		new Book("3333", "Thinking in Java", "Eyes"), 
//		new Book("4444", "Java in action", "None"),
//		new Book("5555", "JDK in action", "Wa")
//	));
//	
//	public List<Book> getAllBooks() {
//		return books;
//	}
//	
//	public Book getBook(String isbn) {
//		return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().get();
//	}
//	
//	public void addBook(Book book) {
//		books.add(book);
//	}
//	
//	public void updateBook(String isbn, Book book) {
//		Book bk = books.stream().filter(b -> isbn.equals(b.getIsbn())).findFirst().get();
//		bk.setAuthor(book.getAuthor());
//		bk.setName(book.getName());
//	}
//	
//	public boolean removeBook(String isbn) {
//		return books.remove(books.stream().filter(b -> isbn.equals(b.getIsbn())).findFirst().get());
//	}

}
