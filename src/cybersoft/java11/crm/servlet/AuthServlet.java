package cybersoft.java11.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet (name = "authServlet", urlPatterns = { "/login", "/logout", "/register"})
public class AuthServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String servletPath = req.getServletPath();
	req.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println( email + password);
	}
}
