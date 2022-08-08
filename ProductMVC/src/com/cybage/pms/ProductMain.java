package com.cybage.pms;

import java.util.List;
import java.util.Scanner;

import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductserviceImp;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductService productService;
		while(true)
		{
			System.out.println("******** Welcome to Core JAVA Workshop*******");
			System.out.println("Select Operation From Following...!!");
			System.out.println("1.Add Product");
			System.out.println("2.Get All Product");
			System.out.println("3.Delete Product by id");
			System.out.println("4.Get Product by id");
			System.out.println("5.Quit from application");
			System.out.println("****************************");
			System.out.println("Enter Choice: ");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:System.out.println("Enter Product ID:");
			int id=sc.nextInt();
			System.out.println("Enter Product Name:");
			String name=sc.next();
			System.out.println("Enter Product Price");
			int price=sc.nextInt();
			Product product=new Product(id, name, price);
			productService=new ProductserviceImp();
			productService.addProduct(product);
			break;

			case 2:
				productService=new ProductserviceImp();
				List<Product> products=productService.getAllProduct();
				for(Product p:products)
				{
					System.out.println(p);
				}

				break;
			case 3:
				productService=new ProductserviceImp();
				List<Product> plist=productService.getAllProduct();
				for(Product p:plist)
				{
					System.out.println(p);
				}
				System.out.println("\nEnter Product Id to delete:");
				int id1=sc.nextInt();
				
				productService.deleteProduct(id1);
				
				break;
			case 4:
				System.out.println("Enter Product Id to show details:");
				int id2=sc.nextInt();
				productService=new ProductserviceImp();
				Product p=productService.getProductById(id2);
				System.out.println(p);
				break;
			case 5:
                      System.exit(0);
				break;

			default:
				break;
			}

		}

	}

}
