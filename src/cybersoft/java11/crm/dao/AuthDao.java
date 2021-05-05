package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.User;

public class AuthDao {
public User login (String email, String password) throws SQLException {
	User user = null;
	String query = "select id, email, password, fullname, role_id \n" +
			"from user \n" +
			"where email = ? and password = ? ; \n" ;
	Connection connection = MySqlConnection.getConnection();
	try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			user = new User();
			user.setId(resultSet.getInt("id"));
			user.setEmail(email);
			user.setFullname(resultSet.getString("fullname"));
			user.setPhone(resultSet.getString("phone"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("error in select query");
		e.printStackTrace();
	}finally {
		connection.close();
	}
	
	return null;
}
}
