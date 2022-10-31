package com.springboot.bookapp.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDBService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		Iterable<Category> iter = categoryRepository.findAll();
		for (Category category : iter) {
			categories.add(category);
		}

		return categories;
	}

	public Category getCategory(String id) {
		return categoryRepository.findById(id).get();
	}

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	public void updateCategory(Category category, String id) {
		Category cg = categoryRepository.findById(id).get();
		if (cg != null) {
			cg.setName(category.getName());
			cg.setDescription(category.getDescription());
		}
		categoryRepository.save(cg);
	}

	public void removeCategory(String id) {
		categoryRepository.deleteById(id);
	}
}
