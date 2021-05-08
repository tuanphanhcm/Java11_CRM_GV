package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.Role;

public class RoleDao {
 public boolean addRole (Role role) throws SQLException {
	 
	 String query = "select * from CRM.role; \n" +
			 " insert into role ( id, name, description) \n" +
			 " values ( ?, ?, ?)";
	 Connection connection = MySqlConnection.getConnection();
	 try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, role.getId());
		statement.setString(2, role.getName());
		statement.setString(3, role.getDescription());
		
		ResultSet result = statement.executeQuery();
		
		while (result.next()) 
			return true;
		} catch (SQLException e) {
		System.out.println("Error in select query.");
		e.printStackTrace();
	} finally {
		connection.close();
	} return true; 
}
 public boolean deleteRole (Role role) throws SQLException {
	 
	 String query = "select * from CRM.role; \n" +
			 " delete from role \n" +
			 " where role_id = ?";
	 Connection connection = MySqlConnection.getConnection();
	 try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, role.getId());
		ResultSet result = statement.executeQuery();
		
		while (result.next()) 
			return true;
		} catch (SQLException e) {
		System.out.println("Error in select query.");
		e.printStackTrace();
	} finally {
		connection.close();
	} return true;
}
}