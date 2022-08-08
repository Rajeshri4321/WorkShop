package com.cybage.pms;

import java.util.List;
import java.util.Scanner;

import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductserviceImp;

public class ProductMain {

	public static void main(String[] args) {
		ProductService productService = new ProductserviceImp();
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				System.out.println("****** Welcome*****\n");

				System.out.println("1.Add Product");
				System.out.println("2.Get All Products");
				System.out.println("3.Delete Product by id");
				System.out.println("0.Exit");

				System.out.println("Enter Choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				
				case 1:
					System.out.print("Enter Product ID: ");
					int id = sc.nextInt();
					System.out.print("Enter Product Name: ");
					String name = sc.next();
					System.out.print("Enter Product Price: ");
					double price = sc.nextDouble();
					Product product = new Product(id, name, price);
					productService.addProduct(product);
					break;

				case 2:
					productService = new ProductserviceImp();
					List<Product> products = productService.getAllProduct();
					for (Product p : products) {
						System.out.println(p);
					}
					break;
				
				case 3:
					System.out.println("Enter Product Id to delete:");
					int productIdToDelete = sc.nextInt();
					productService.deleteProduct(productIdToDelete);
					System.out.println("Prodcut with id= " + productIdToDelete + " deleted");
					break;
				
				case 0:
					System.exit(0);
					break;

				
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
