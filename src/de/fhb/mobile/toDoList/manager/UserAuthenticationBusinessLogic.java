/**
 * 
 */
package de.fhb.mobile.toDoList.manager;

import java.sql.SQLException;

import de.fhb.mobile.toDoList.entity.User;
import de.fhb.mobile.toDoList.persistence.UserDao;

/**
 * @author Patrick
 * 
 */
public class UserAuthenticationBusinessLogic {

	private UserDao userDao;

	/**
	 * construct dataAccess.
	 * 
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public UserAuthenticationBusinessLogic() throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		this.userDao = new UserDao();
	}

	/**
	 * authenticate a user and if it not exist a user than persist them.
	 * 
	 * @param user
	 * @return true if you are autheticatd.
	 * @throws SQLException 
	 */
	public boolean authenticate(User user) throws SQLException {
		User loggedIn = this.userDao.findByCredentials(user.getUsername(), user.getPassword());
		if(loggedIn.getId() != 0)
			return true;
		else{
			User newUser = this.userDao.findByUsername(user.getUsername());
			if(newUser.getId() == 0){
				this.userDao.persist(user);
				return true;
			}else
				return false;
		}
	}

	public User findUser(String username, String password) throws SQLException {
		return this.userDao.findByCredentials(username,password);
	}

}
