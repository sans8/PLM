package com.yash.plm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.plm.model.Book;
import com.yash.plm.service.BookService;
import com.yash.plm.serviceimpl.BookServiceImpl;

/**
 * Servlet implementation class ListBookController
 */
@WebServlet("/ListBookController")
public class ListBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookservice = new BookServiceImpl();
		List<Book> books=null;
		books=bookservice.showBookList();
		request.setAttribute("books", books);
		getServletContext().getRequestDispatcher("/view/ListBooks.jsp").forward(request, response);
	}
}
