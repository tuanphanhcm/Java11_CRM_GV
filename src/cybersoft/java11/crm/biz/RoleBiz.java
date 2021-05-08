package cybersoft.java11.crm.biz;

import cybersoft.java11.crm.dao.RoleDao;
import cybersoft.java11.crm.model.Role;

public class RoleBiz {
	RoleDao roleDao ;
public RoleBiz() {
	roleDao = new RoleDao();
}
public boolean addRole (Role role) {
	boolean result = false;
	
	try {
		result = roleDao.addRole(role);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result;			
}

public boolean deleteRole (Role role) {
	boolean result = false;
	
	try {
		result = roleDao.deleteRole(role);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result;			
}

public boolean updateRole (Role role) {
	boolean result = false;
	
	try {
		result = roleDao.deleteRole(role);
		result = roleDao.addRole(role);
		} catch (Exception e) {
		// TODO: handle exception
	}
	return result;			
}

}
