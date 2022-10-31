package com.springboot.bookapp.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@Autowired
	private CategoryDBService categoryService;

	@RequestMapping("/categories")
	public List<Category> getCategories() {
		return categoryService.getAllCategories();
	}

	@RequestMapping("/categories/{id}")
	public Category getCategory(@PathVariable String id) {
		return categoryService.getCategory(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/categories")
	public void addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/categories/{id}")
	public void updateCategory(@RequestBody Category category, @PathVariable String id) {
		categoryService.updateCategory(category, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
	public void removeCategory(@PathVariable String id) {
		categoryService.removeCategory(id);
	}

}
