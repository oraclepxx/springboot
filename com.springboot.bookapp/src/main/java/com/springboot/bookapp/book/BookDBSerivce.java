package com.springboot.bookapp.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bookapp.category.Category;
import com.springboot.bookapp.category.CategoryRepository;

@Service
public class BookDBSerivce {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Book> getAllBooks(String categoryId) {
		List<Book> books = new ArrayList<Book>();
		Iterable<Book> all = bookRepository.findAll();
		for (Book b : all) {
			if (categoryId.equals(b.getCategory().getId())) {
				books.add(b);
			}
		}

		return books;
	}

	public Book getBook(String categoryId, String isbn) {
		List<Book> books = getAllBooks(categoryId);
		return books.stream().filter(t -> isbn.equals(t.getIsbn())).findFirst().get();
	}

	public void addBook(String categoryId, Book book) {
		Category category = categoryRepository.findById(categoryId).get();
		book.setCategory(category);
		bookRepository.save(book);
	}

	public void updateBook(String categoryId, String isbn, Book book) {
		Category category = categoryRepository.findById(categoryId).get();
		Book bk = bookRepository.findById(isbn).get();
		if (bk != null) {
			bk.setName(book.getName());
			bk.setAuthor(book.getAuthor());
			bk.setCategory(category);
		}
		bookRepository.save(bk);
	}

	public void removeBook(String categoryId, String isbn) {
		bookRepository.deleteById(isbn);
	}

}
