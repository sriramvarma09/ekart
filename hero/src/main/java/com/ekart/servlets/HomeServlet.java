package com.ekart.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ekart.DAL.ProductsDAO;
import com.ekart.models.ProductCategory;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("previousUrl", request.getRequestURI());
		ProductsDAO productsDAO = (ProductsDAO) httpSession.getAttribute("productsDAO");
		if (productsDAO == null) {
			productsDAO = new ProductsDAO();
			httpSession.setAttribute("productsDAO", productsDAO);
		}
		List<ProductCategory> allCategories = productsDAO.getAllCategories();
		request.setAttribute("allCategories", allCategories);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
