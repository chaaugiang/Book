package controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.BookDbHelper;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet(description = "Controller for reading the books table", urlPatterns = { "/index.jsp", "/read" })
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create a dbHelper object
		BookDbHelper bdb = new BookDbHelper();

		// Get the html table from the dbHelper object
		ResultSet results = bdb.doReadAll();
		String table = bdb.getHTMLTable(results);

		// pass execution control to read.jsp along with the table
		String author = request.getParameter("author");
		request.setAttribute("table", table);
		request.setAttribute("author", author); // Add this line to pass the author parameter
		String url = "/read.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
