package com.ekart.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/removeProduct")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession httpSession = request.getSession();
		Map<Integer, Integer> cartMap = (Map<Integer, Integer>) httpSession.getAttribute("cartMap");
		if (cartMap == null) {
			cartMap = new HashMap<Integer, Integer>();
		}
		int pid = Integer.parseInt(request.getParameter("pid"));
		Integer quantity = cartMap.get(pid);
		if (quantity != null && quantity > 1) {
			cartMap.put(pid, quantity - 1);
		}
		if (quantity != null && quantity == 1) {
			cartMap.remove(pid);
		}
		httpSession.setAttribute("cartMap", cartMap);
		response.getWriter().write("{\"status\":true}");
		System.out.println(cartMap);
	}
}
