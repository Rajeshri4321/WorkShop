package com.cybage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.service.ProductService;
import com.cybage.service.ProductserviceImp;

/**
 * Servlet implementation class deletProduct
 */
@WebServlet("/deleteProduct")
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  ProductService productservice  = new ProductserviceImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pid=request.getParameter("id");
		
		System.out.println("pid: "+pid);
	  int id= Integer.parseInt(pid);
	  System.out.println("id"+id);
	 
		 productservice.deleteProduct(id);
		 System.out.println("product deleted succesfully");
		
		 response.sendRedirect("/ProductMVC/productServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
