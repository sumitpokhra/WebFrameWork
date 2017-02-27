package com.framework.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.entity.User;
import com.framework.service.RegisterService;
import com.framework.serviceImpl.RegisterServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegisterService register = new RegisterServiceImpl();
	RequestDispatcher requestDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		try {
			User user = new User();
			user.setFirstName(request.getParameter("firstname"));
			user.setMiddleName(request.getParameter("middlename"));
			user.setLastName(request.getParameter("lastname"));
			user.setUserName(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			user.setMobileNo(request.getParameter("mobile"));
			user.setAddress(request.getParameter("address"));
			user.setPassword(request.getParameter("password"));
			if (register.register(user)) {
				requestDispatcher = request.getRequestDispatcher("registerSuccess.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMsg", "! Unexpected Error Please try again");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", "! Unexpected Error Please try again");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
