package com.ekart.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ekart.DAL.ProductsDAO;

@WebServlet("/getNoOfpages")
public class NoOfProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String url = request.getPathInfo();
		int categoryId;
		try {
			categoryId = Integer.parseInt(request.getParameter("categoryId"));
		} catch (Exception e) {
			categoryId = 0;
		}
		HttpSession httpSession = request.getSession();
		ProductsDAO productsDAO = (ProductsDAO) httpSession.getAttribute("productsDAO");
		if (productsDAO == null) {
			productsDAO = new ProductsDAO();
			httpSession.setAttribute("productsDAO", productsDAO);
		}
		int noOfPages;
		if (categoryId != 0) {
			noOfPages = (int) Math.ceil(productsDAO.getNoOfProductsByCategory(categoryId) / 12.0);

		} else {
			noOfPages = (int) Math.ceil(productsDAO.getNoOfProducts() / 12.0);
		}
		response.getWriter().write("{\"pages\":" + noOfPages + "}");
	}

}
