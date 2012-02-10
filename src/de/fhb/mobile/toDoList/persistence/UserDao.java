/**
 * 
 */
package de.fhb.mobile.toDoList.persistence;

import java.sql.SQLException;

import de.fhb.mobile.toDoList.entity.User;

/**
 * @author Patrick
 *
 */
public class UserDao extends PersistenceDao<User> {

	/**
	 * 
	 * @throws SQLException
	 */
	protected UserDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public User find(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persist(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

	public User findById(int int1) {
		// TODO Auto-generated method stub
		return null;
	}

}
