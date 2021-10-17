package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.ListItem;
import com.app.entity.Shopper;
import com.app.helper.ListItemHelper;
import com.app.helper.ShopperHelper;

/**
 * Servlet implementation class ViewListDetails
 */
@WebServlet("/ViewListDetails")
public class ViewListDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopperHelper shopperHelper = new ShopperHelper();
	private ListItemHelper listItemHelper = new ListItemHelper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Shopper obj = shopperHelper.searchById(Long.parseLong(id));
		request.setAttribute("name", obj.getShopperName());
		request.setAttribute("id", id);

		List<ListItem> itemList = listItemHelper.showAllList();
		request.setAttribute("itemList", itemList);

		getServletContext().getRequestDispatcher("/add-list.jsp").forward(request, response);
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
