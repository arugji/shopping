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
 * arugji CIS175 fall 2021 Oct 5
 */
@WebServlet("/SaveData")
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopperHelper shopperHelper = new ShopperHelper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveData() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		long id = Long.parseLong(request.getParameter("id"));

		Shopper obj = shopperHelper.searchById(id);

		if (id > 0) {
			obj.setShopperName(name);
			shopperHelper.updateShopper(obj);
		} else {
			obj = new Shopper();
			obj.setShopperName(name);
			shopperHelper.insertShopper(obj);
		}
		getServletContext().getRequestDispatcher("/ViewAllNameServlet").forward(request, response);
	}

}
