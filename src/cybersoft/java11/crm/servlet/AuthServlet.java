package cybersoft.java11.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java11.crm.model.User;

@WebServlet(name = "authServlet", urlPatterns = {
		"/login",
		"/logout",
		"/register"
})



public class AuthServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/auth/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			User user = biz.login(email, password);
			if(user!=null) {
				HttpSession session = req.getSession();
				session.setAttribute("userId", "" + user.getId());
				session.setMaxInactiveInterval(30);
				resp.sendRedirect(req.getContextPath() + "/home");
			}else
			{
				req.getRequestDispatcher("/WEB-INF/auth/login.jsp");
			}
			System.out.println(email + " " + password);
			break;

		default:
			break;
		}
	}
}
