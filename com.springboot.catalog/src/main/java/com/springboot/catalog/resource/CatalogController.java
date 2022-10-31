package com.springboot.catalog.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.catalog.model.Catalog;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

	@Autowired
	private CatalogService catalogService;

	@RequestMapping("")
	public List<Catalog> getCatalogs() {
		return catalogService.getCatalogs();
	}
	
	@RequestMapping("/{userId}")
	public List<Catalog> getCatalog(@PathVariable String userId) {
		return catalogService.getCatalog(userId);
	}

}
