package com.cybage.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductserviceImp;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{
		ProductService productService=new ProductserviceImp();
		PrintWriter out=response.getWriter();
		out.write("<html><body><form method='post'>");
		out.write("<h2>Edit Product</h2><hr/><br>");
		out.write("<b>Product Name:  </b><input type='text' name='id' value='"+request.getParameter("id")+"' disabled><br><br>");

		out.write("<b>Product Name:  </b><input type='text' name='pname' value='"+request.getParameter("name")+"' required><br><br>");
		out.write("<b>Product Price: </b><input type='number' name='pprice' value='"+request.getParameter("price")+"' required>");
		out.write("<button type='submit'>Update</button>");
		out.write("</form></body></html>");
    String pid=request.getParameter("id");
	String name=request.getParameter("pname");
	String price=request.getParameter("pprice");
	int id;
	int pprice;
	if(pid!=null && price!=null) {
	id=Integer.parseInt(pid);
	pprice=Integer.parseInt(price);
	System.out.println(id+" "+price);
	
		Product product=new Product(id, name,pprice);
		productService.editProduct(product);
		System.out.println("updated ....!!");
		response.sendRedirect("/ProductMVC/productServlet");
	}
	
	}
	@Override
	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{
		doGet(request, response);
	}
}
