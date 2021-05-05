package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java11.crm.biz.HomeBiz;

@WebServlet(name = "homeServlet", urlPatterns = {
		"/health"
})
public class HomeServlet extends HttpServlet {
	private HomeBiz biz;
	
	@Override
	public void init() throws ServletException {
		// TODO: init HomeBiz
		super.init();
		biz = new HomeBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: check database health
		Cookie cookie = new Cookie("user", "tuanphan91");
		cookie.setMaxAge(20);
		resp.addCookie(cookie);
		
		// session
		HttpSession cursession = req.getSession();
		if (cursession.getAttribute("logged User") == null) {
			cursession.setAttribute("logged User", "tuanphan91");
			cursession.setMaxInactiveInterval(20);
		}
		
		
		boolean databaseCheckResult = biz.checkHealth();
		if(databaseCheckResult)
			resp.getWriter().append("Connection to database has been made successfully.");
		else
			resp.getWriter().append("Connection to database has been made unsuccessfully.");
	}
}
