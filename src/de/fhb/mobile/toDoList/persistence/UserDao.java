/**
 * 
 */
package de.fhb.mobile.toDoList.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import de.fhb.mobile.toDoList.entity.User;
import de.fhb.mobile.toDoList.persistence.mapper.UserMapper;

/**
 * @author Patrick
 * 
 */
public class UserDao extends PersistenceDao<User> {

	private static final String TABLE = "user";

	/**
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public UserDao() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public User find(User entity) throws SQLException {
		return this.findById(entity.getId());
	}

	@Override
	public User findAll() throws SQLException {
		String query = "SELECT * FROM " + TABLE;
		PreparedStatement find = this.connection.prepareStatement(query);
		return UserMapper.mapToEntity(find.executeQuery());
	}

	@Override
	public void delete(User entity) throws SQLException {
		String query = "DELETE FROM " + TABLE + " c WHERE c.id = ?";
		PreparedStatement delete = this.connection.prepareStatement(query);
		delete.setInt(1, entity.getId());
		delete.execute();
	}

	@Override
	public void persist(User entity) throws SQLException {
		String query = "INSERT INTO " + TABLE + " (`username`,`password`) VALUES (?,?)";
		PreparedStatement persist = this.connection.prepareStatement(query);
		persist.setString(1, entity.getUsername());
		persist.setString(2, entity.getPassword());
		persist.executeUpdate();
	}

	@Override
	public void update(User entity) throws SQLException {
		System.out.println(entity);
		String query = "UPDATE " + TABLE
				+ " u SET username = ? ,password = ? WHERE u.id = ?)";
		PreparedStatement update = this.connection.prepareStatement(query);
		update.setString(1, entity.getUsername());
		update.setString(2, entity.getPassword());
		update.setInt(3, entity.getId());
		update.executeUpdate();
	}

	/**
	 * find an user with given id in database.
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public User findById(int id) throws SQLException {
		String query = "SELECT * FROM " + TABLE + " u WHERE u.id = ?";
		PreparedStatement find = this.connection.prepareStatement(query);
		find.setInt(1, id);
		return UserMapper.mapToEntity(find.executeQuery());
	}

	/**
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public User findByUsername(String username) throws SQLException {
		String query = "SELECT * FROM " + TABLE + " u WHERE u.username = ?";
		PreparedStatement find = this.connection.prepareStatement(query);
		find.setString(1, username);
		return UserMapper.mapToEntity(find.executeQuery());
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User findByCredentials(String username, String password) throws SQLException {
		String query = "SELECT * FROM " + TABLE + " u WHERE u.username = ? AND u.password = ?";
		PreparedStatement find = this.connection.prepareStatement(query);
		find.setString(1, username);
		find.setString(2, password);
		return UserMapper.mapToEntity(find.executeQuery());
	}

}
