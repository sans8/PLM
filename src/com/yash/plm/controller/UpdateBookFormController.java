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
@WebServlet("/UpdateBookFormController")
public class UpdateBookFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempIsbn= String.valueOf(request.getAttribute("selectedIsbn"));
		Long isbn = Long.parseLong(tempIsbn);
		Book book = null;
		BookService bookservice = new BookServiceImpl();
		try {
			book = bookservice.find(isbn);
			request.setAttribute("book",book);
		} catch (BookException e) {
			System.out.println(e.getMessage());
		}
		getServletContext().getRequestDispatcher("/view/UpdateBook.jsp").forward(request,response);
	}
}
