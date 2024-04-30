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
import com.ekart.models.Product;
import com.google.gson.Gson;

@WebServlet("/getProducts/*")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String url = request.getPathInfo();
		int pageNo = Integer.parseInt(url.split("/")[1]);
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
		List<Product> products;
		if (categoryId != 0) {
			products = productsDAO.getProductsByCategory(pageNo, categoryId);

		} else {
			products = productsDAO.getProducts(pageNo);
		}
		String json = new Gson().toJson(products);
		response.getWriter().write(json);

	}

}
