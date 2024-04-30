package com.ekart.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addProduct")
public class AddToCartServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("Init invoked");

	}

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
		if (quantity == null)
			cartMap.put(pid, 1);
		else {
			cartMap.put(pid, quantity + 1);
		}
		httpSession.setAttribute("cartMap", cartMap);
		response.getWriter().write("{\"status\":true}");
		System.out.println(cartMap);
	}

}
