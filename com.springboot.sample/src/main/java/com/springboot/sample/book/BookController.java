package com.springboot.sample.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
//	@Autowired
//	private BookMockService bookMockService;
	
	@Autowired
	private BookDBSerivce bookDBService;

	@RequestMapping("/books")
	public List<Book> getBooks() {
//		return bookMockService.getAllBooks();
		return bookDBService.getAllBooks();
	}
	
	@RequestMapping("/books/{isbn}")
	public Book getBook(@PathVariable String isbn) {
//		return bookMockService.getBook(isbn);
		return bookDBService.getBook(isbn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public void addBook(@RequestBody Book book) {
//		bookMockService.addBook(book);
		bookDBService.addBook(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/books/{isbn}")
	public void updateBook(@PathVariable String isbn, @RequestBody Book book) {
//		bookMockService.updateBook(isbn, book);
		bookDBService.updateBook(book);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{isbn}")
	public void removeBook(@PathVariable String isbn) {
//		return bookMockService.removeBook(isbn);
		bookDBService.removeBook(isbn);
	}
	
}
