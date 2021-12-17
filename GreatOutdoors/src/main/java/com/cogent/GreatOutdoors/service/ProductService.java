package com.cogent.GreatOutdoors.service;

import java.util.List;

import com.cogent.GreatOutdoors.dto.Product;

public interface ProductService {
	public String addProduct(Product p);
	public List<Product> getProductById(int id);
	public String updateProduct(int id, Product p);
	public String deleteProductById(int id);
	public List<Product> getAllProducts();
	public String deleteAllproducts();
	public List<Product> getProductsByCategory(String Category);
}
