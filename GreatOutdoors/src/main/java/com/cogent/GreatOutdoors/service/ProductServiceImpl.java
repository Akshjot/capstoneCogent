package com.cogent.GreatOutdoors.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.GreatOutdoors.dto.Product;
import com.cogent.GreatOutdoors.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public String addProduct(Product p) {
		// TODO Auto-generated method stub
		productRepository.save(p);
		return "Saved product";
	}

	@Override
	public List<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		List<Product> plist = new ArrayList<Product>();
		plist.add(productRepository.findById(id).get());
		return plist;
	}

	@Override
	public String updateProduct(int id, Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProductById(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		return "Deleted product";
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> pList = new ArrayList<Product>();
		pList = productRepository.findAll();
		return pList;
	}

	@Override
	public String deleteAllproducts() {
		// TODO Auto-generated method stub
		productRepository.deleteAll();
		return "Deleted all products";
	}

	@Override
	public List<Product> getProductsByCategory(String Category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(Category);
	}

}
