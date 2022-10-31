package com.springboot.bookapp.book;

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

	@RequestMapping("/categories/{categoryId}/books")
	public List<Book> getBooks(@PathVariable String categoryId) {
		return bookDBService.getAllBooks(categoryId);
	}

	@RequestMapping("/categories/{categoryId}/books/{isbn}")
	public Book getBook(@PathVariable String categoryId, @PathVariable String isbn) {
//		return bookMockService.getBook(isbn);
		return bookDBService.getBook(categoryId, isbn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/categories/{categoryId}/books")
	public void addBook(@PathVariable String categoryId, @RequestBody Book book) {
//		bookMockService.addBook(book);
		bookDBService.addBook(categoryId, book);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/categories/{categoryId}/books/{isbn}")
	public void updateBook(@PathVariable String categoryId, @PathVariable String isbn, @RequestBody Book book) {
//		bookMockService.updateBook(isbn, book);
		bookDBService.updateBook(categoryId, isbn, book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/categories/{categoryId}/books/{isbn}")
	public void removeBook(@PathVariable String categoryId, @PathVariable String isbn) {
//		return bookMockService.removeBook(isbn);
		bookDBService.removeBook(categoryId, isbn);
	}

}
