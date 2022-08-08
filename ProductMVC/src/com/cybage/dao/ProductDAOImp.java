package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.mysql.cj.jdbc.JdbcConnection;
import com.cybage.Utility.JDBCUtility;
import com.cybage.model.Product;

public class ProductDAOImp implements ProductDAO {
	
	public Product getProductById(int productId) {
		Connection connection=JDBCUtility.getConncetion();
		Product product = null;
	   try {
		PreparedStatement preparedStatement=  connection.prepareStatement("select * from product where id=?");
	           preparedStatement.setInt(1,productId );
	     ResultSet resultSet=preparedStatement.executeQuery();
	        while(resultSet.next())
	        {
	        	   int id=  resultSet.getInt(1);
	        	  String name= resultSet.getString(2);
	              int price=   resultSet.getInt(3);
	              product=new Product(id, name, price);
	              connection.close();
	              return product;
	        }
	   } catch (SQLException e) {
		
		e.printStackTrace();
	}
    return product;
	}

	public boolean addProduct(Product product) {
		Connection connection=JDBCUtility.getConncetion();
		try {
		PreparedStatement preparedStatement=connection.prepareStatement("insert into product values(?,?,?)");
			  preparedStatement.setInt(1, product.getId());
			  preparedStatement.setString(2, product.getName());
			  preparedStatement.setInt(3, product.getPrice());
			  preparedStatement.execute();
			  connection.close();
			  System.out.println("product inserted successfully");
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public List<Product> getAllProduct() {
		Connection connection=JDBCUtility.getConncetion();
		List<Product> products=new ArrayList<>();
		
		Product product = null;
		   try {
			PreparedStatement preparedStatement=  connection.prepareStatement("select * from product");
		          
		     ResultSet resultSet=preparedStatement.executeQuery();
		          
		     while(resultSet.next()) {
		        	   int id=  resultSet.getInt(1);
		        	  String name= resultSet.getString(2);
		              int price=   resultSet.getInt(3);
		              product=new Product(id, name, price);
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
		Connection connection=JDBCUtility.getConncetion();
		Product product = null;
		   try {
			PreparedStatement preparedStatement=  connection.prepareStatement("delete from product where id=?");
		           preparedStatement.setInt(1,productId );
		     boolean isDeleted=preparedStatement.execute();
		          
//		        	 if(isDeleted)
//		        	 {
//		        		 System.out.println("Product deleted successfully");
//		        	 }
//		        	 else
//		        	 {
//		        		 System.out.println("product not present in product table");
//		        	 }
		              connection.close();
		             
		   } catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void editProduct(Product product) {
		Connection connection=JDBCUtility.getConncetion();
		System.out.println(product);
		   try {
			PreparedStatement preparedStatement=  connection.prepareStatement("update product set name=?, price=? where id=?");
		           preparedStatement.setInt(3,product.getId() );
		           preparedStatement.setString(1,product.getName());
		           preparedStatement.setInt(2,product.getPrice());
			         
		     int count=preparedStatement.executeUpdate();
		      if(count==1)
		      {
		    	  System.out.println("product updated succesfully");
		      }
		      if(count==0) {
		    	  System.out.println("product not updated");
		      }
		         // preparedStatement.close();
		              connection.close();
		             
		   } catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
