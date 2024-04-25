package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.BookDbHelper;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(description = "Deletes a record for a particular bookID", urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// NEVER make database changes via a GET request.
		// You don't want a web crawler accidentally deleting your data!
		throw new RuntimeException();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the bookID
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		// create a dbHelper object
		BookDbHelper bdb = new BookDbHelper();
		
		// use deleteQuery to delete the record
		bdb.doDelete(bookID);
		
		// Consider: We may wish to redirect to the "/read" page rather than forward.
		// What's the difference? A redirect creates a new HTTP request, and may be 
		// used to when reloading a URL is undesirable. (Do we want a user to be able to 
		// reload a delete page?)
		//
		// How would redirect code be different?
		//
		// See, e.g., http://stackoverflow.com/questions/2047122/requestdispatcher-interface-vs-sendredirect

		// pass execution on to the ReadServlet
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
