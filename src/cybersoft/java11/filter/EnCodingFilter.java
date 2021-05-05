package cybersoft.java11.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter (urlPatterns = "/*")
public class EnCodingFilter implements Filter {
	private int requestSeq =1;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// set charset encoding for req and resp
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		System.out.println("Received request");
		System.out.println("Acess time: " + requestSeq++);
		chain.doFilter(request, response);
		System.out.println("get respone");
		
	}

}
