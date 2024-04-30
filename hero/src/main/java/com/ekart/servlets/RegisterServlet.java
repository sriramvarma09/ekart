package com.ekart.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ekart.DAL.ProductsDAO;
import com.ekart.models.User;

@WebServlet("/createUser")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("register");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession();
		ProductsDAO productsDAO = (ProductsDAO) httpSession.getAttribute("productsDAO");
		if (productsDAO == null) {
			productsDAO = new ProductsDAO();
			httpSession.setAttribute("productsDAO", productsDAO);
		}
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		boolean result = productsDAO.createUser(new User(username, email, password));
		if (result) {
			resp.getWriter().write("{ \"success\": true}");
		} else {
			resp.getWriter().write("{ \"success\": false}");
		}

	}

}
