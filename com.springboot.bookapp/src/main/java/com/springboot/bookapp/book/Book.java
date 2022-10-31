package com.springboot.bookapp.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.springboot.bookapp.category.Category;

@Entity
public class Book {

	@Id
	private String isbn;
	private String name;
	private String author;

	@ManyToOne
	private Category category;

	public Book() {
	}

	public Book(String isbn, String name, String author, Category category) {
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.category = category;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
