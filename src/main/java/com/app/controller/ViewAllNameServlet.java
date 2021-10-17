package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.Shopper;
import com.app.helper.ShopperHelper;

/**
 * arugji CIS175 fall 2021 Oct 5
 */
@WebServlet("/ViewAllNameServlet")
public class ViewAllNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopperHelper shopperHelper = new ShopperHelper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Shopper> list = shopperHelper.showAllShoppers();
		request.setAttribute("list", list);
		String path = "/list.jsp";
		if (list.isEmpty()) {
			path = "/index.jsp";
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
