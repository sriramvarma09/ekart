package com.ekart.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ekart.DAL.ProductsDAO;
import com.ekart.models.Address;
import com.ekart.models.Order;
import com.ekart.models.Product;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("previousUrl", request.getRequestURI());
		Map<Integer, Integer> cartMap = (Map<Integer, Integer>) httpSession.getAttribute("cartMap");
		ProductsDAO productsDAO = (ProductsDAO) httpSession.getAttribute("productsDAO");
		if (productsDAO == null) {
			productsDAO = new ProductsDAO();
			httpSession.setAttribute("productsDAO", productsDAO);
		}
		List<Product> products;
		if (cartMap == null) {
			products = productsDAO.getProducts(new ArrayList<>());
		} else {
			products = productsDAO.getProducts(new ArrayList<>(cartMap.keySet()));

		}
		request.setAttribute("cartMap", cartMap);
		boolean result = productsDAO.addressFilled((String) httpSession.getAttribute("USERNAME"));
		if (result) {
			Address address = productsDAO.getAddressByUserId((String) httpSession.getAttribute("USERNAME"));
			Order order = productsDAO.createOrder((String) httpSession.getAttribute("USERNAME"), products, cartMap);
			System.out.println(order + " in checkourservlet");
			request.setAttribute("order", order);
			request.setAttribute("products", products);
			request.setAttribute("address", address);

			request.getRequestDispatcher("Checkout.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("AddressForm.jsp").forward(request, response);
		}

		request.setAttribute("products", products);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
