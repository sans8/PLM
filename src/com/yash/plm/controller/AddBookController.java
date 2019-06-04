	package com.yash.plm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.plm.exception.BookException;
import com.yash.plm.model.Book;
import com.yash.plm.service.BookService;
import com.yash.plm.serviceimpl.BookServiceImpl;

/**
 * Servlet implementation class AddBookController
 */
@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		Book book = null;
		try {
			book = bookService.find(Long.parseLong(request.getParameter("isbn")));
			request.setAttribute("errMsg", "Book with this isbn already exists");
			getServletContext().getRequestDispatcher("/view/AddBook.jsp").forward(request, response);
		} catch (BookException e1) {
			book = new Book();
			book.setTitle(request.getParameter("title"));
			book.setAuthor(request.getParameter("author"));
			book.setPrice(Float.parseFloat(request.getParameter("price")));
			book.setPublisher(request.getParameter("publisher"));
			book.setIsbn(Long.parseLong(request.getParameter("isbn")));
			try {
				bookService.addBook(book);
				
			} catch (BookException e) {
				System.out.println(e.getMessage());
			}
			getServletContext().getRequestDispatcher("/ListBookController").forward(request, response);
		}
		
		
	}

}
