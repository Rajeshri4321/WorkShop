package com.cybage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductserviceImp;

@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productservice = new ProductserviceImp();

	public AddProductController() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Add product
		if (request.getParameter("productId") != null) {
			int productid = Integer.parseInt(request.getParameter("productId"));
			String pname = request.getParameter("productName");
			System.out.println(pname);
			int price = Integer.parseInt(request.getParameter("productPrice"));
			Product product = new Product(productid, pname, price);
			productservice.addProduct(product);
			System.out.println("product added succefully");
			response.sendRedirect("/ProductMVC/productServlet");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
