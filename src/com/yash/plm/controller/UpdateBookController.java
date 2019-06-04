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
 * Servlet implementation class UpdateBookController
 */
@WebServlet("/UpdateBookController")
public class UpdateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookservice = new BookServiceImpl();
		Book book = new Book();
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setPrice(Float.parseFloat(request.getParameter("price")));
		book.setPublisher(request.getParameter("publisher"));
		book.setIsbn(Long.parseLong(request.getParameter("isbn")));
		try {
			bookservice.update(book);
		} catch (BookException e) {
			System.out.println(e.getMessage());
		}
		getServletContext().getRequestDispatcher("/ListBookController").forward(request, response);
	}

}
