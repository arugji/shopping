package com.app.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.ListDetails;
import com.app.entity.ListItem;
import com.app.entity.Shopper;
import com.app.helper.ListDetailsHelper;
import com.app.helper.ListItemHelper;
import com.app.helper.ShopperHelper;

/**
 * Servlet implementation class SaveListData
 */
@WebServlet("/SaveListData")
public class SaveListData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopperHelper shopperHelper = new ShopperHelper();
	private ListDetailsHelper listDetailsHelper = new ListDetailsHelper();
	private ListItemHelper listItemHelper = new ListItemHelper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveListData() {
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
		String id = request.getParameter("shoperId");
		String name = request.getParameter("name");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		Shopper obj = shopperHelper.searchById(Long.parseLong(id));
		ListDetails ld = new ListDetails();
		ld.setListName(name);
		ld.setShopper(obj);

		LocalDate date;
		try {
			date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			date = LocalDate.now();
		}

		ld.setTripDate(date);

		String[] selectedItems = request.getParameterValues("allItemsToAdd");

		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListItem c = listItemHelper.searchById(Long.parseLong(selectedItems[i]));
				ld.getListOfItems().add(c);
			}
		}

		listDetailsHelper.insertListDetails(ld);
		getServletContext().getRequestDispatcher("/ViewAllNameServlet").forward(request, response);
	}

}
