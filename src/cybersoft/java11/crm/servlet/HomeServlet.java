package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;

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
		Cookie cookie = new Cookie("name","tuanphan91");
		cookie.setMaxAge(20);
		resp.addCookie(cookie);
		
		//Get Current session from request
		HttpSession currentSession = req.getSession();
		System.out.println(currentSession.getAttribute("logged user"));
		if(currentSession.getAttribute("logged user")==null) {
			// set attribute to current session
		currentSession.setAttribute("logged user", "tuanphan91");
			// set max time to wait for another request from client
		currentSession.setMaxInactiveInterval(20);
		}
		
		
		//Cookie anotherCookie = new Cookie("lastAccess", Calendar.getInstance().toString());
		//anotherCookie.setMaxAge(60*60*24*30);
		//resp.addCookie(anotherCookie);
		boolean databaseCheckResult = biz.checkHealth();
		if(databaseCheckResult)
			resp.getWriter().append("Connection to database has been made successfully.");
		else
			resp.getWriter().append("Connection to database has been made unsuccessfully.");
	}
}
