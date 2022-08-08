package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Product;

public class ProductDAOImp implements ProductDAO {

	public Product getProductById(int productId) {
		Connection connection = JDBCUtility.getConncetion();
		Product product = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id=?");
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();

			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			double price = resultSet.getInt(3);
			product = new Product(id, name, price);
			connection.close();
			return product;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return product;
	}

	public void addProduct(Product product) {
		Connection connection = JDBCUtility.getConncetion();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into product values(?,?,?)");
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.execute();
			connection.close();
			System.out.println("product inserted successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Product> getAllProduct() {
		Connection connection = JDBCUtility.getConncetion();
		List<Product> products = new ArrayList();

		Product product = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from product");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int price = resultSet.getInt(3);
				product = new Product(id, name, price);
				products.add(product);

			}
			connection.close();
			return products;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return products;

	}

	public void deleteProduct(int productId) {
		Connection connection = JDBCUtility.getConncetion();
		Product product = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?");
			preparedStatement.setInt(1, productId);
			boolean isDeleted = preparedStatement.execute();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
