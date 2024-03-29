package me.volunteer.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.volunteer.credentials.LoginSecurity;
import me.volunteer.database.DbAdapter;
import me.volunteer.database.RemoteDbConnector;
import me.volunteer.entity.Organization;
import me.volunteer.entity.User;

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
		
		Connection connection = rdc.getConnection();
		
		DbAdapter dba = new DbAdapter(rdc.getConnection());
		
		String action = request.getParameter("action");
		
		String email = (String) request.getSession().getAttribute("email");
		String org = (String) request.getSession().getAttribute("org");
		
		if (action.equals("null")){
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else if (action.equals("login")){
			
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			
			if (email != null){
				request.getRequestDispatcher("/loginresult.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			
		}else if (action.equals("register")){
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else if (action.equals("orgregister")){
			request.getRequestDispatcher("/orgregister.jsp").forward(request, response);
		}else if (action.equals("userdetails")){
			
			if (email != null){
				
				if (org.equals("true")){
					
				}else{
					request.setAttribute("user", dba.getUser(email));
					request.getRequestDispatcher("/userdetails.jsp").forward(request, response);
				}
				
			}else{
				request.setAttribute("email", "");
				request.setAttribute("password", "");
				request.setAttribute("message", "");
				
			}
			
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = rdc.getConnection();
		
		DbAdapter dba = new DbAdapter(rdc.getConnection());
		
		String action = request.getParameter("action");
		
		if (action.equals("dologin")){
			
			String email = (String) request.getParameter("email");
			String password = (String) request.getParameter("password");
			String org = (String) request.getParameter("organization");
			
			if (org == null || org.length() == 0){
				if (true == LoginSecurity.checkCredentialsUser(email, password, connection)){
					request.getSession().setAttribute("email", email);
					request.getSession().setAttribute("org", "false");
					User user = dba.getUser(email);
					request.setAttribute("user",user);
					//throw new NullPointerException("Name" + user.getName() + user.getId());
					request.getRequestDispatcher("/userdetails.jsp").forward(request, response);
				}
			}else{
				
				if (true == LoginSecurity.checkCredentialsOrg(email, password, connection)){
					request.getSession().setAttribute("email", email);
					request.getSession().setAttribute("org", "true");
					request.getRequestDispatcher("/loginresult.jsp").forward(request, response);
				}
				
			}
			
			request.setAttribute("message", "Incorrect Login or Password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			
			
		}else if (action.equals("logout")){
			request.getSession().invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		
			
		}else if (action.equals("createuser")){
			String name = (String) request.getParameter("name");
			String email = (String) request.getParameter("email");
			String password = (String) request.getParameter("password");
			
			User user = new User (email,LoginSecurity.hashPassword(password),name);
			dba.createUser(user);
			
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("org", "false");
			request.getRequestDispatcher("/loginresult.jsp").forward(request, response);
			
		}else if (action.equals("createorg")){
			String name = (String) request.getParameter("name");
			String email = (String) request.getParameter("email");
			String password = (String) request.getParameter("password");
			String address = (String) request.getParameter("address");
			String phone = (String) request.getParameter("phone");
			String about = (String) request.getParameter("about");
			
 			Organization org = new Organization(name, email, phone, address, about, null, LoginSecurity.hashPassword(password));
			dba.createOrganization(org);
			
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("org", "true");

		}
	}

}
