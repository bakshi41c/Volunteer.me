package me.volunteer.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.volunteer.credentials.LoginController;
import me.volunteer.database.RemoteDbConnector;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    RemoteDbConnector rdc;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }
    
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		rdc = new RemoteDbConnector();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equals("null")){
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else if (action.equals("login")){
			
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			
			if (request.getSession().getAttribute("userId") != null){
				request.getRequestDispatcher("/loginresult.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			
		}else if (action.equals("register")){
			
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = rdc.getConnection();
		
		String action = request.getParameter("action");
		
		if (action.equals("dologin")){
			
			String email = (String) request.getParameter("email");
			String password = (String) request.getParameter("password");
						
			
			if (true == LoginController.checkCredentials(email, password, connection)){
				request.getSession().setAttribute("email", email);
				request.getRequestDispatcher("/loginresult.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "Incorrect Login or Password");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}else if (action.equals("logout")){
			request.getSession().invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
	}

}