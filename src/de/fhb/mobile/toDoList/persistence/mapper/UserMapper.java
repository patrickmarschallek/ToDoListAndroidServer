/**
 * 
 */
package de.fhb.mobile.toDoList.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.fhb.mobile.toDoList.entity.User;

/**
 * @author Patrick
 *
 */
public class UserMapper {
	/**
	 * map a single Object
	 * 
	 * @param result
	 * @return User from database
	 * @throws SQLException
	 */
	public static User mapToEntity(ResultSet result) throws SQLException {
		User user = new User();
		while(result.next()){
			user.setId(result.getInt("id"));
			user.setUsername(result.getString("username"));
			user.setPassword("");
		}
		return user;
	}

	/**
	 * map a list object
	 * 
	 * @param result
	 * @return a user list
	 * @throws SQLException
	 */
	public static List<User> mapToEntityList(ResultSet result) throws SQLException {
		List<User> userList = new ArrayList<User>();
		
		while(result.next()){
			User user = new User();
			user.setId(result.getInt("id"));
			user.setUsername(result.getString("username"));
			user.setPassword("");
			userList.add(user);
		}
		return userList;
	}
}