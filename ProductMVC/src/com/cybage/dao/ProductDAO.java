package com.cybage.dao;

import java.util.List;

import com.cybage.model.Product;

public interface ProductDAO {
	Product getProductById(int productId);
	boolean addProduct(Product product);
	List<Product> getAllProduct();
	void deleteProduct(int productId);
	void editProduct(Product product);

}
