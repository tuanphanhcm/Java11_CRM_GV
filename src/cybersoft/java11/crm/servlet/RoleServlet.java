package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.crm.biz.RoleBiz;
import cybersoft.java11.crm.model.Role;
import cybersoft.java11.crm.utils.JspPathConst;
import cybersoft.java11.crm.utils.UrlConst;

@WebServlet(name = "roleServlet", urlPatterns = {
		UrlConst.ROLE_DASHBOARD,
		UrlConst.ROLE_ADD,
		UrlConst.ROLE_UPDATE,
		UrlConst.ROLE_DELETE
})
public class RoleServlet extends HttpServlet {
	private RoleBiz biz;
	
	@Override
	public void init() throws ServletException {
		// TODO: init RoleBiz
		super.init();
		biz = new RoleBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = req.getServletPath();
		
		switch (path) {
			case UrlConst.ROLE_DASHBOARD:
				List<Role> listRole = biz.findAll();
				
				req.setAttribute("roles", listRole);
				
				req.getRequestDispatcher(JspPathConst.ROLE_DASHBOARD).forward(req, resp);
				break;
			case UrlConst.ROLE_ADD:
				req.getRequestDispatcher(JspPathConst.ROLE_ADD).forward(req, resp);
				break;
			case UrlConst.ROLE_UPDATE:
				int id = Integer.parseInt(req.getParameter("id"));
				
				Role willBeUpdatedRole = biz.findById(id);
				
				req.setAttribute("role", willBeUpdatedRole);
				
				req.getRequestDispatcher(JspPathConst.ROLE_UPDATE).forward(req, resp);
				break;
			case UrlConst.ROLE_DELETE:
				int willBeDeletedId = Integer.parseInt(req.getParameter("id"));
				
				biz.deleteById(willBeDeletedId);
				
				resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
				break;

		default:
			break;
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		
		switch (path) {
			case UrlConst.ROLE_DASHBOARD:
				
				break;
			case UrlConst.ROLE_ADD:
				String roleName = req.getParameter("role-name");
				String roleDescription = req.getParameter("role-description");
				
				if(roleName == null || roleName.equals("")) {
					req.setAttribute("msg", "Role name can't be empty.");
					req.getRequestDispatcher(JspPathConst.ROLE_ADD).forward(req, resp);
				} else {
					Role newRole = new Role();
					newRole.setName(roleName);
					newRole.setDescription(roleDescription);
					
					biz.add(newRole);
					
					resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
				}
				
				break;
			case UrlConst.ROLE_UPDATE:
				String name = req.getParameter("role-name");
				String description = req.getParameter("role-description");
				int id = Integer.parseInt(req.getParameter("role-id"));
				
				if(name == null || name.equals("")) {
					req.setAttribute("msg", "Role name can't be empty.");
					
					Role needToFixRole = new Role();
					
					needToFixRole.setId(id);
					needToFixRole.setDescription(description);
					
					req.setAttribute("role", needToFixRole);
					
					req.getRequestDispatcher(JspPathConst.ROLE_UPDATE).forward(req, resp);
				} else {
					Role updateRole = new Role();
					updateRole.setName(name);
					updateRole.setDescription(description);
					
					biz.update(id, updateRole);
					
					resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
				}
				
				break;
			case UrlConst.ROLE_DELETE:
				
				break;

		default:
			break;
		}
	}
}
