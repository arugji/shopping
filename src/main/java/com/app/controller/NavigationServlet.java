package com.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.Shopper;
import com.app.helper.ShopperHelper;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopperHelper shopperHelper = new ShopperHelper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("btn-op");
		String path = "/ViewAllNameServlet";

		if (act.equals("delete")) {
			String id = request.getParameter("id");
			if (id != null && !id.trim().isEmpty()) {
				Shopper obj = shopperHelper.searchById(Long.parseLong(id));
				shopperHelper.deleteShopperHelper(obj);
			} else {
				path = "/error.jsp";
			}
		} else if (act.equals("edit")) {
			path = "/edit.jsp";
			String id = request.getParameter("id");
			if (id != null && !id.trim().isEmpty()) {
				Shopper obj = shopperHelper.searchById(Long.parseLong(id));
				request.setAttribute("sh", obj);
			} else {
				path = "/error.jsp";
			}
		} else if (act.equals("add")) {
			path = "/index.jsp";
		} else if (act.equals("add-list-details")) {
			String id = request.getParameter("id");
			if (id != null && !id.trim().isEmpty()) {
				path = "/ViewListDetails";
			} else {
				path = "/error.jsp";
			}
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
