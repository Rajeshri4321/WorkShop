package com.cybage.service;

import java.util.List;

import com.cybage.model.Product;

public interface ProductService {
	Product getProductById(int productId);
	boolean addProduct(Product product);
	List<Product> getAllProduct();
	void deleteProduct(int productId);
    void editProduct(Product product);
}
