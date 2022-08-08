package com.cybage.service;

import java.util.List;

import com.cybage.dao.ProductDAO;
import com.cybage.dao.ProductDAOImp;
import com.cybage.model.Product;

public class ProductserviceImp implements ProductService {

	ProductDAO dao=new ProductDAOImp();
	public Product getProductById(int productId) {

		return dao.getProductById(productId);

	}

	public boolean addProduct(Product product) {

	return	dao.addProduct(product);
	}

	public List<Product> getAllProduct() {

		return dao.getAllProduct();

	}

	public void deleteProduct(int productId) {

		dao.deleteProduct(productId);

	}

	@Override
	public void editProduct(Product product) {
		dao.editProduct(product);
		
	}

}
