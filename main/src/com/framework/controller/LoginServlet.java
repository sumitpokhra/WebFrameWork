package com.framework.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.framework.entity.User;
import com.framework.service.LoginService;
import com.framework.serviceImpl.LoginServiceImpl;
import com.framework.utils.DbConnection;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher;
	LoginService login = new LoginServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			user.setUserName(username);
			user.setPassword(password);
			System.out.println(username + "   " + password);
			HttpSession httpSession = null;
			  if (login.validateCredentials(user) && DbConnection.getConnection() != null) {
				httpSession = request.getSession();
				httpSession.setAttribute("userName", user.getUserName());
				requestDispatcher = request.getRequestDispatcher("user.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMsg", "! Invalid UserName or Password or Connection Failed Please check Database Connectivity");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Throwable theException) {
			request.setAttribute("errorMsg", "! Unexpected Error Please try again");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
