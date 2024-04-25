package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.BookDbHelper;
import model.Book;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new book to the database", urlPatterns = { "/addBook" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// NEVER make database changes via a GET request.
		// You don't want a web crawler accidentally modifying your data!
		throw new RuntimeException();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the data
		// TODO: Add error checking!
	    String title = request.getParameter("title");
	    String author = request.getParameter("author");
	    int pages = Integer.parseInt(request.getParameter("pages"));
	
		// set up a book object
	    Book book = new Book();
	    book.setTitle(title);
	    book.setAuthor(author);
	    book.setPages(pages);
	    
		// set up an dbHelper object
	    BookDbHelper bdb = new BookDbHelper();
	    
		// pass the book to addQuery to add to the database
	    bdb.doAdd(book);
	    
		// pass execution control to the ReadServlet
	    String url = "/read";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
