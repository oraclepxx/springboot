package com.springboot.sample.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDBSerivce {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		Iterable<Book> all = bookRepository.findAll();
		for (Book b : all) {
			books.add(b);
		}

		return books;
	}

	public Book getBook(String isbn) {
		return bookRepository.findById(isbn).get();
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public void removeBook(String isbn) {
		bookRepository.deleteById(isbn);
	}

}
